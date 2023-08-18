package com.prosoft.model;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "title", nullable = false)
    private String title;

    public Book() { }

    public Book(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
