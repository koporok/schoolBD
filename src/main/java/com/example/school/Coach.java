package com.example.school;

public class Coach {
    private String CoachFIO;
    private String CoachTelephone;
    private String CoachLogin;

    public Coach(String coachFIO, String coachTelephone, String coachLogin) {
        this.CoachFIO = coachFIO;
        this.CoachTelephone = coachTelephone;
        this.CoachLogin = coachLogin;
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
