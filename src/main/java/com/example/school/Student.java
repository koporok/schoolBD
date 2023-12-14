package com.example.school;

public class Student {
    private String StudentsFIO;
    private String StudentsDate;
    private int StudentsYear;
    private String StudentsTelephone;
    private String StudentsGroupNumber;
    private String StudentsLogin;

    public Student() {

    }

    public Student(String studentsFIO, String studentsDate, int studentsYear, String studentsTelephone, String studentsGroupNumber, String studentsLogin) {
        this.StudentsFIO = studentsFIO;
        this.StudentsDate = studentsDate;
        this.StudentsYear = studentsYear;
        this.StudentsTelephone = studentsTelephone;
        this.StudentsGroupNumber = studentsGroupNumber;
        this.StudentsLogin = studentsLogin;
    }

    public String getStudentsFIO() {
        return StudentsFIO;
    }

    public void setStudentsFIO(String studentsFIO) {
        StudentsFIO = studentsFIO;
    }

    public String getStudentsDate() {
        return StudentsDate;
    }

    public void setStudentsDate(String studentsDate) {
        StudentsDate = studentsDate;
    }

    public int getStudentsYear() {
        return StudentsYear;
    }

    public void setStudentsYear(int studentsYear) {
        StudentsYear = studentsYear;
    }

    public String getStudentsTelephone() {
        return StudentsTelephone;
    }

    public void setStudentsTelephone(String studentsTelephone) {
        StudentsTelephone = studentsTelephone;
    }

    public String getStudentsGroupNumber() {
        return StudentsGroupNumber;
    }

    public void setStudentsGroupNumber(String studentsGroupNumber) {
        StudentsGroupNumber = studentsGroupNumber;
    }

    public String getStudentsLogin() {
        return StudentsLogin;
    }

    public void setStudentsLogin(String studentsLogin) {
        StudentsLogin = studentsLogin;
    }
}
