package com.example.school.classes;

import java.util.Date;

public class Schedule {
    private int GroupId_Schedule;
    private Date LessonDate;
    private String LessonTime;
    private int Coachid_Schedule;

    public Schedule(int groupId_Schedule, Date lessonDate, String lessonTime, int coachid_Schedule) {
        GroupId_Schedule = groupId_Schedule;
        LessonDate = lessonDate;
        LessonTime = lessonTime;
        Coachid_Schedule = coachid_Schedule;
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
}
