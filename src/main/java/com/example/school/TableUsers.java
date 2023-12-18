package com.example.school;

public class TableUsers {
    private int UserId;
    private String UsersFIO;
    private String UsersDate;
    private int UsersYear;
    private String UsersTelephone;
    private int groupid;
    private String StudentsLogin;
    private int groupid1;
    private String group_name;
    private String min_age;
    private String max_age;
    private String max_students;
    private String coachid;

    public TableUsers(int userId, String usersFIO, String usersDate, int usersYear, String usersTelephone, int groupid, String studentsLogin, int groupid1, String group_name, String min_age, String max_age, String max_students, String coachid) {
        UserId = userId;
        UsersFIO = usersFIO;
        UsersDate = usersDate;
        UsersYear = usersYear;
        UsersTelephone = usersTelephone;
        this.groupid = groupid;
        StudentsLogin = studentsLogin;
        this.groupid1 = groupid1;
        this.group_name = group_name;
        this.min_age = min_age;
        this.max_age = max_age;
        this.max_students = max_students;
        this.coachid = coachid;
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

    public int getGroupid1() {
        return groupid1;
    }

    public void setGroupid1(int groupid1) {
        this.groupid1 = groupid1;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getMin_age() {
        return min_age;
    }

    public void setMin_age(String min_age) {
        this.min_age = min_age;
    }

    public String getMax_age() {
        return max_age;
    }

    public void setMax_age(String max_age) {
        this.max_age = max_age;
    }

    public String getMax_students() {
        return max_students;
    }

    public void setMax_students(String max_students) {
        this.max_students = max_students;
    }

    public String getCoachid() {
        return coachid;
    }

    public void setCoachid(String coachid) {
        this.coachid = coachid;
    }
}
