package ru.job4j.profession;

public class Doctor extends Profession {

    private String diagnose;
    private String medications;

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

    public Doctor(String diagnose, String analysis, String inspection) {
        this.diagnose = diagnose;
        this.medications = analysis;

    }
}
