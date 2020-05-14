package com.spring.proverbApp.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "proverbs")
public class Proverbs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "proverb")
    private String proverb;


    @Column(name = "author")
    private String author;


    @Column(name = "proverbdetail")
    private String proverbDetail;

    @Column(name = "upvote")
    private int upVote;

    @Column(name = "downvote")
    private int downVote;


    @CreationTimestamp
    @Column(name = "datecreated")
    private Date dateCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProverb() {
        return proverb;
    }

    public void setProverb(String proverb) {
        this.proverb = proverb;
    }

    public String getProverbDetail() {
        return proverbDetail;
    }

    public void setProverbDetail(String proverbDetail) {
        this.proverbDetail = proverbDetail;
    }

    public int getUpVote() {
        return upVote;
    }

    public void setUpVote(int upVote) {
        this.upVote = upVote;
    }

    public int getDownVote() {
        return downVote;
    }

    public void setDownVote(int downVote) {
        this.downVote = downVote;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
