package com.example.school;

public class TableUsers {
    private int UserId;
    private String UsersFIO;
    private String UsersDate;
    private int UsersYear;
    private String UsersTelephone;
    private String StudentsGroupNumber;
    private String StudentsLogin;

    public TableUsers(int userId, String usersFIO, String usersDate, int usersYear, String usersTelephone, String studentsGroupNumber, String studentsLogin) {
        UserId = userId;
        UsersFIO = usersFIO;
        UsersDate = usersDate;
        UsersYear = usersYear;
        UsersTelephone = usersTelephone;
        StudentsGroupNumber = studentsGroupNumber;
        StudentsLogin = studentsLogin;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUsersFIO() {
        return UsersFIO;
    }

    public void setUsersFIO(String usersFIO) {
        UsersFIO = usersFIO;
    }

    public String getUsersDate() {
        return UsersDate;
    }

    public void setUsersDate(String usersDate) {
        UsersDate = usersDate;
    }

    public int getUsersYear() {
        return UsersYear;
    }

    public void setUsersYear(int usersYear) {
        UsersYear = usersYear;
    }

    public String getUsersTelephone() {
        return UsersTelephone;
    }

    public void setUsersTelephone(String usersTelephone) {
        UsersTelephone = usersTelephone;
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
