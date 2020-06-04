package com.mzl.bean;

/**
 * @ClassName :   Score
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/4 10:23
 * @Version: 1.0
 */
public class Score {

    private String studentId;
    private String courseId;
    private String score;
    private String term;

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Score{" +
                "studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", score='" + score + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}
