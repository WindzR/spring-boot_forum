package ru.bodins.forum.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "post_comments",
        joinColumns = @JoinColumn(name = "post_id"),
        inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private Set<Comment> comments = new HashSet<>();

    public Post() {
    }

    public Post(int id, String name, String description) {
        Date date = new Date();
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = date;
    }

    public static Post of(String name) {
        Post post = new Post();
        post.name = name;
        return post;
    }

    public static Post of(String name, String description, Date created) {
        Post post = new Post();
        post.name = name;
        post.description = description;
        post.created = created;
        return post;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id
                && Objects.equals(name, post.name)
                && Objects.equals(description, post.description)
                && Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created);
    }

    @Override
    public String toString() {
        return "Post{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", description='" + description + '\''
                + ", created=" + created
                + ", comments=" + comments
                + '}';
    }
}
