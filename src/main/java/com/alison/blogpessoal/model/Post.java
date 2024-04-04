package com.alison.blogpessoal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "posts")
@Table(name = "posts")
@SequenceGenerator(name = "seq_posts", sequenceName = "seq_posts", allocationSize = 1, initialValue = 1)
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_posts")
    private Long id;

    private String title;

    private String author;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date timestamp;

    @Column(columnDefinition = "text")
    private String textpost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTextpost() {
        return textpost;
    }

    public void setTextpost(String textpost) {
        this.textpost = textpost;
    }
}
