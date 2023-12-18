package com.example.school;

public class TableCoach {
    private int CoachId;
    private String CoachFIO;
    private String CoachTelephone;
    private String CoachLogin;

    public TableCoach(int coachId, String coachFIO, String coachTelephone, String coachLogin) {
        CoachId = coachId;
        CoachFIO = coachFIO;
        CoachTelephone = coachTelephone;
        CoachLogin = coachLogin;
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
