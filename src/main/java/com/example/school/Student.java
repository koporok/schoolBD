package com.example.school;

public class Student {
    private String StudentsFIO;
    private String StudentsDate;
    private int StudentsYear;
    private String StudentsTelephone;
    private int IDgroups;
    private String StudentsLogin;

    public Student() {

    }

    public Student(String studentsFIO, String studentsDate, int studentsYear, String studentsTelephone, int IDgroups, String studentsLogin) {
        StudentsFIO = studentsFIO;
        StudentsDate = studentsDate;
        StudentsYear = studentsYear;
        StudentsTelephone = studentsTelephone;
        this.IDgroups = IDgroups;
        StudentsLogin = studentsLogin;
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

    public int getIDgroups() {
        return IDgroups;
    }

    public void setIDgroups(int IDgroups) {
        this.IDgroups = IDgroups;
    }

    public String getStudentsLogin() {
        return StudentsLogin;
    }

    public void setStudentsLogin(String studentsLogin) {
        StudentsLogin = studentsLogin;
    }
}
