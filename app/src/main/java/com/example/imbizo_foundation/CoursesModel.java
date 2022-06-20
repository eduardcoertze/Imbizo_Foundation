package com.example.imbizo_foundation;

public class CoursesModel {

    String courseName;
    String courseTime;
    String courseRating;
    int image;

    public CoursesModel(String courseName, String courseTime,
                        String courseRating, int image) {
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.courseRating = courseRating;
        this.image = image;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public String getCourseRating() {
        return courseRating;
    }

    public int getImage() {
        return image;
    }
}
