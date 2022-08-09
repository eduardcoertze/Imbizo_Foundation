package com.example.imbizo_foundation;

public class CourseContentModel {

    String CourseContentName;

    public CourseContentModel() {
    }

    public CourseContentModel(String courseContentName) {
        CourseContentName = courseContentName;
    }

    public String getCourseContentName() {
        return CourseContentName;
    }

    public void setCourseContentName(String courseContentName) {
        CourseContentName = courseContentName;
    }
}
