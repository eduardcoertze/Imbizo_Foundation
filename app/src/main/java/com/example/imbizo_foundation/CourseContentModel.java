package com.example.imbizo_foundation;

public class CourseContentModel {

    String courseName;
    String courseDescription;
    String firstParagraphTitle;
    String firstParagraph;
    String secondParagraphTitle;
    String secondParagraph;
    String youtubeLink;

    public CourseContentModel(String courseName, String courseDescription, String firstParagraphTitle, String firstParagraph, String secondParagraphTitle, String secondParagraph, String youtubeLink) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.firstParagraphTitle = firstParagraphTitle;
        this.firstParagraph = firstParagraph;
        this.secondParagraphTitle = secondParagraphTitle;
        this.secondParagraph = secondParagraph;
        this.youtubeLink = youtubeLink;
    }

    public CourseContentModel() {
    }

    public String getFirstParagraphTitle() {
        return firstParagraphTitle;
    }

    public void setFirstParagraphTitle(String firstParagraphTitle) {
        this.firstParagraphTitle = firstParagraphTitle;
    }

    public String getSecondParagraphTitle() {
        return secondParagraphTitle;
    }

    public void setSecondParagraphTitle(String secondParagraphTitle) {
        this.secondParagraphTitle = secondParagraphTitle;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getFirstParagraph() {
        return firstParagraph;
    }

    public void setFirstParagraph(String firstParagraph) {
        this.firstParagraph = firstParagraph;
    }

    public String getSecondParagraph() {
        return secondParagraph;
    }

    public void setSecondParagraph(String secondParagraph) {
        this.secondParagraph = secondParagraph;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }
}
