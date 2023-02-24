package com.prosoft.domain;

import java.time.Instant;
import java.time.MonthDay;

public class Story implements Comparable<Story> {
    private String title;
    private String content;
    private String author;
    private String category;
    private MonthDay dateStory;
    private Instant dateCreatedStory;
    public Story() { }
    public Story(String title, String content, String author, String category, MonthDay dateStory, Instant dateCreatedStory) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
        this.dateStory = dateStory;
        this.dateCreatedStory = dateCreatedStory;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public MonthDay getDateStory() {
        return dateStory;
    }
    public void setDateStory(MonthDay dateStory) {
        this.dateStory = dateStory;
    }
    public Instant getDateCreatedStory() {
        return dateCreatedStory;
    }
    public void setDateCreatedStory(Instant dateCreatedStory) {
        this.dateCreatedStory = dateCreatedStory;
    }
    @Override
    public int compareTo(Story other) {
        return dateStory.compareTo(other.dateStory);
    }
}
