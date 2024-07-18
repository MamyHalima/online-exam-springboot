package com.exam.examination.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exams")
public class ExamModel {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question1;

    @Column(nullable = false)
    private String question2;

    @Column(nullable = false)
    private String question3;

    //  @ManyToOne
    // @JoinColumn(name = "user_id")
    // private User user;

    // Constructors, getters, and setters

    public ExamModel() {
    }

    public ExamModel(String question1, String question2, String question3) {
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }
}