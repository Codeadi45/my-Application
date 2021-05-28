package com.example.myapp;

public class putPDF {
    public String name;
    public String course;
    public String url,faculty;

    public putPDF() {
    }

    public putPDF(String name,String url,String course,String faculty) {
        this.name = name;
        this.url = url;
        this.course = course;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
