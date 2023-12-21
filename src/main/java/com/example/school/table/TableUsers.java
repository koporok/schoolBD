package com.example.school.table;

public class TableUsers {
    private int UserId;
    private String UsersFIO;
    private String UsersDate;
    private int UsersYear;
    private String UsersTelephone;
    private int groupid;
    private String StudentsLogin;

    public TableUsers(int userId, String usersFIO, String usersDate, int usersYear, String usersTelephone, int groupid, String studentsLogin) {
        UserId = userId;
        UsersFIO = usersFIO;
        UsersDate = usersDate;
        UsersYear = usersYear;
        UsersTelephone = usersTelephone;
        this.groupid = groupid;
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

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public String getStudentsLogin() {
        return StudentsLogin;
    }

    public void setStudentsLogin(String studentsLogin) {
        StudentsLogin = studentsLogin;
    }
}
