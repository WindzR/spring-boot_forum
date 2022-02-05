package ru.bodins.forum.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id")
    private Author author;

    public Comment() {
    }

    public static Comment of(String comment, Date created, Author author) {
        Comment cmnt = new Comment();
        cmnt.comment = comment;
        cmnt.created = created;
        cmnt.author = author;
        return cmnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Comment comment1 = (Comment) o;
        return id == comment1.id && comment.equals(comment1.comment)
                && Objects.equals(created, comment1.created)
                && author.equals(comment1.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, author);
    }

    @Override
    public String toString() {
        return "Comment{"
                + "id=" + id
                + ", comment='" + comment + '\''
                + ", created=" + created
                + ", author=" + author
                + '}';
    }
}
