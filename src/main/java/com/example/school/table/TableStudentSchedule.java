package com.example.school.table;

import java.util.Date;

public class TableStudentSchedule {

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


    public TableStudentSchedule(int scheduleID, int groupId_Schedule, Date lessonDate, String lessonTime, int coachid_Schedule, int groupId,
                                String groupName, int groupMinAge, int groupMaxAge, int groupNumberStudents, int coachId_Group) {
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
}
