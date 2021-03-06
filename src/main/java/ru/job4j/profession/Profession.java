package ru.job4j.profession;

public class Profession {

    private String birthday;
    private String name;
    private String surname;
    private String education;

    public Profession(String birthday, String name, String surname, String education) {
        this.birthday = birthday;
        this.name = name;
        this.surname = surname;
        this.education = education;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
