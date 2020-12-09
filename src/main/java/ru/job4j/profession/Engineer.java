package ru.job4j.profession;

public class Engineer extends Profession {

    private String designing;
    private String construction;

    public Engineer(String birthday, String name, String surname, String education) {
        super(birthday, name, surname, education);
    }

    public String getDesigning() {
        return designing;
    }

    public void setDesigning(String designing) {
        this.designing = designing;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;

    }
}
