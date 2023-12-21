package com.example.school.table;

import java.util.Date;

public class TableStudentCoachClasses {
    private int AttendanceID;
    private int StudentsId_Attendance;
    private int ScheduleID_Attendance;
    private boolean AttendanceFlag;

    private int StudentsId;
    private String StudentName;
    private String StudentDate;
    private int StudentYaer;
    private String StudentTelephone;
    private int GroupId_Student;
    private String StudentLogin;

    private int ScheduleID;
    private int GroupId_Schedule;
    private Date LessonDate;
    private String LessonTime;
    private int Coachid_Schedule;

    private int GroupId;
    private String GroupName;
    private int GroupMinAge;
    private int GroupMaxAge;
    private int GroupNumberStudents;
    private int CoachId_Group;

    private int CoachId;
    private String CoachFIO;
    private String CoachTelephone;
    private String CoachLogin;

    public TableStudentCoachClasses(int attendanceID, int studentsId_Attendance, int scheduleID_Attendance,
                                    boolean attendanceFlag, int studentsId, String studentName, String studentDate,
                                    int studentYaer, String studentTelephone, int groupId_Student, String studentLogin,
                                    int scheduleID, int groupId_Schedule, Date lessonDate, String lessonTime, int coachid_Schedule,
                                    int groupId, String groupName, int groupMinAge, int groupMaxAge, int groupNumberStudents,
                                    int coachId_Group, int coachId, String coachFIO, String coachTelephone, String coachLogin) {
        AttendanceID = attendanceID;
        StudentsId_Attendance = studentsId_Attendance;
        ScheduleID_Attendance = scheduleID_Attendance;
        AttendanceFlag = attendanceFlag;
        StudentsId = studentsId;
        StudentName = studentName;
        StudentDate = studentDate;
        StudentYaer = studentYaer;
        StudentTelephone = studentTelephone;
        GroupId_Student = groupId_Student;
        StudentLogin = studentLogin;
        ScheduleID = scheduleID;
        GroupId_Schedule = groupId_Schedule;
        LessonDate = lessonDate;
        LessonTime = lessonTime;
        Coachid_Schedule = coachid_Schedule;
        GroupId = groupId;
        GroupName = groupName;
        GroupMinAge = groupMinAge;
        GroupMaxAge = groupMaxAge;
        GroupNumberStudents = groupNumberStudents;
        CoachId_Group = coachId_Group;
        CoachId = coachId;
        CoachFIO = coachFIO;
        CoachTelephone = coachTelephone;
        CoachLogin = coachLogin;
    }

    public int getAttendanceID() {
        return AttendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        AttendanceID = attendanceID;
    }

    public int getStudentsId_Attendance() {
        return StudentsId_Attendance;
    }

    public void setStudentsId_Attendance(int studentsId_Attendance) {
        StudentsId_Attendance = studentsId_Attendance;
    }

    public int getScheduleID_Attendance() {
        return ScheduleID_Attendance;
    }

    public void setScheduleID_Attendance(int scheduleID_Attendance) {
        ScheduleID_Attendance = scheduleID_Attendance;
    }

    public boolean isAttendanceFlag() {
        return AttendanceFlag;
    }

    public void setAttendanceFlag(boolean attendanceFlag) {
        AttendanceFlag = attendanceFlag;
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

    public int getScheduleID() {
        return ScheduleID;
    }

    public void setScheduleID(int scheduleID) {
        ScheduleID = scheduleID;
    }

    public int getGroupId_Schedule() {
        return GroupId_Schedule;
    }

    public void setGroupId_Schedule(int groupId_Schedule) {
        GroupId_Schedule = groupId_Schedule;
    }

    public Date getLessonDate() {
        return LessonDate;
    }

    public void setLessonDate(Date lessonDate) {
        LessonDate = lessonDate;
    }

    public String getLessonTime() {
        return LessonTime;
    }

    public void setLessonTime(String lessonTime) {
        LessonTime = lessonTime;
    }

    public int getCoachid_Schedule() {
        return Coachid_Schedule;
    }

    public void setCoachid_Schedule(int coachid_Schedule) {
        Coachid_Schedule = coachid_Schedule;
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

    public int getCoachId() {
        return CoachId;
    }

    public void setCoachId(int coachId) {
        CoachId = coachId;
    }

    public String getCoachFIO() {
        return CoachFIO;
    }

    public void setCoachFIO(String coachFIO) {
        CoachFIO = coachFIO;
    }

    public String getCoachTelephone() {
        return CoachTelephone;
    }

    public void setCoachTelephone(String coachTelephone) {
        CoachTelephone = coachTelephone;
    }

    public String getCoachLogin() {
        return CoachLogin;
    }

    public void setCoachLogin(String coachLogin) {
        CoachLogin = coachLogin;
    }
}
