package ru.job4j.profession;

public class Doctor extends Profession {

    private String diagnose;
    private String medications;

    public Doctor(String birthday, String name, String surname, String education) {
        super(birthday, name, surname, education);
    }

    public String getDiagnose() {
        return diagnose;
    }

    public Doctor setDiagnose(String diagnose) {
        return this;
    }
    public String getAnalysis() {
        return medications;
    }

    public void setAnalysis(String analysis) {
        this.medications = analysis;
    }

}
