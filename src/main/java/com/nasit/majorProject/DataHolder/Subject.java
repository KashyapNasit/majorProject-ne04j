package com.nasit.majorProject.DataHolder;

public class Subject {
    private String courseName;
    private String credits;
    private String professor;

    public String getCourseName() {
        return courseName;
    }

    public Subject setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public String getCredits() {
        return credits;
    }

    public Subject setCredits(String credits) {
        this.credits = credits;
        return this;
    }

    public String getProfessor() {
        return professor;
    }

    public Subject setProfessor(String professor) {
        this.professor = professor;
        return this;
    }
}
