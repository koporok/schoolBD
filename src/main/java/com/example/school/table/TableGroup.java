package com.example.school.table;

public class TableGroup {
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

    public TableGroup(int groupId, String groupName,
                      int groupMinAge, int groupMaxAge, int groupNumberStudents, int coachId_Group,
                      int coachId, String coachFIO, String coachTelephone, String coachLogin) {
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
