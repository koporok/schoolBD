package com.example.school.table;

public class TableStudents {
    private int StudentsId;
    private String StudentName;
    private String StudentDate;
    private int StudentYaer;
    private String StudentTelephone;
    private int GroupId_Student;
    private String StudentLogin;

    private int GroupId;
    private String GroupName;
    private int GroupMinAge;
    private int GroupMaxAge;
    private int GroupNumberStudents;
    private int CoachId_Group;

    public TableStudents(int studentsId, String studentName, String studentDate, int studentYaer,
                         String studentTelephone, int groupId_Student, String studentLogin,
                         int groupId, String groupName, int groupMinAge, int groupMaxAge,
                         int groupNumberStudents, int coachId_Group) {
        StudentsId = studentsId;
        StudentName = studentName;
        StudentDate = studentDate;
        StudentYaer = studentYaer;
        StudentTelephone = studentTelephone;
        GroupId_Student = groupId_Student;
        StudentLogin = studentLogin;
        GroupId = groupId;
        GroupName = groupName;
        GroupMinAge = groupMinAge;
        GroupMaxAge = groupMaxAge;
        GroupNumberStudents = groupNumberStudents;
        CoachId_Group = coachId_Group;
    }

    public int getStudentsId() {
        return StudentsId;
    }

    public void setStudentsId(int studentsId) {
        StudentsId = studentsId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentDate() {
        return StudentDate;
    }

    public void setStudentDate(String studentDate) {
        StudentDate = studentDate;
    }

    public int getStudentYaer() {
        return StudentYaer;
    }

    public void setStudentYaer(int studentYaer) {
        StudentYaer = studentYaer;
    }

    public String getStudentTelephone() {
        return StudentTelephone;
    }

    public void setStudentTelephone(String studentTelephone) {
        StudentTelephone = studentTelephone;
    }

    public int getGroupId_Student() {
        return GroupId_Student;
    }

    public void setGroupId_Student(int groupId_Student) {
        GroupId_Student = groupId_Student;
    }

    public String getStudentLogin() {
        return StudentLogin;
    }

    public void setStudentLogin(String studentLogin) {
        StudentLogin = studentLogin;
    }

    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int groupId) {
        GroupId = groupId;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public int getGroupMinAge() {
        return GroupMinAge;
    }

    public void setGroupMinAge(int groupMinAge) {
        GroupMinAge = groupMinAge;
    }

    public int getGroupMaxAge() {
        return GroupMaxAge;
    }

    public void setGroupMaxAge(int groupMaxAge) {
        GroupMaxAge = groupMaxAge;
    }

    public int getGroupNumberStudents() {
        return GroupNumberStudents;
    }

    public void setGroupNumberStudents(int groupNumberStudents) {
        GroupNumberStudents = groupNumberStudents;
    }

    public int getCoachId_Group() {
        return CoachId_Group;
    }

    public void setCoachId_Group(int coachId_Group) {
        CoachId_Group = coachId_Group;
    }
}
