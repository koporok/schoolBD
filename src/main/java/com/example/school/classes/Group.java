package com.example.school.classes;

public class Group {
    private String FIO;
    private int Number;
    private int MinAge;
    private int MaxAge;
    private int Coach;

    public Group(){}

    public Group(String FIO, int number, int minAge, int maxAge, int coach) {
        this.FIO = FIO;
        Number = number;
        MinAge = minAge;
        MaxAge = maxAge;
        Coach = coach;
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

    public int getCoach() {
        return Coach;
    }

    public void setCoach(int coach) {
        Coach = coach;
    }
}
