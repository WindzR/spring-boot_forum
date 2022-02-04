package ru.bodins.forum.model;

import java.util.Objects;

public class Author {

    private int id;

    private String name;

    public Author() {
    }

    public static Author of(int id, String name) {
        Author author = new Author();
        author.id = id;
        author.name = name;
        return author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return id == author.id && Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Author{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
