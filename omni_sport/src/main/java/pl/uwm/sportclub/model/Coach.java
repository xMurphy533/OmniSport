package pl.uwm.sportclub.model;

import java.time.LocalDate;

public class Coach extends User{
    private String section;

    public Coach(int id, String firstName, String lastName, String email, LocalDate dateOfBirth, String section) {
        super(id, firstName, lastName, email, dateOfBirth);
        this.section = section;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
