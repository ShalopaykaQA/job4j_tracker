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

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

}
