package com.example.school;

public class Group {
    private String FIO;
    private int Number;
    private int MinAge;
    private int MaxAge;
    private String coach;

    public Group(String FIO, int number, int minAge, int maxAge, String coach) {
        this.FIO = FIO;
        Number = number;
        MinAge = minAge;
        MaxAge = maxAge;
        this.coach = coach;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public int getMinAge() {
        return MinAge;
    }

    public void setMinAge(int minAge) {
        MinAge = minAge;
    }

    public int getMaxAge() {
        return MaxAge;
    }

    public void setMaxAge(int maxAge) {
        MaxAge = maxAge;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }
}
