package com.example.imbizo_foundation;

public class CoursesModel {

    String courseName;
    String courseTime;
    String imageURL;



    public CoursesModel(String courseName, String courseTime, String imageURl) {
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.imageURL = imageURl;
    }

    public CoursesModel() {
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public void setImageURl(String imageURl) {
        this.imageURL = imageURl;
    }

    public String getImageURl() {
        return imageURL;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseTime() {
        return courseTime;
    }


}
