package pl.uwm.sportclub.model;

import utils.ConsoleColors;

import java.time.LocalDate;

public class Coach extends User{
    private String section;

    public Coach(int id, String firstName, String lastName, String email, LocalDate dateOfBirth, String section) {
        super(id, firstName, lastName, email, dateOfBirth);
        this.section = section;
    }
    public Coach()
    {
        super(0, "unkown", "unkown", "unkown@", LocalDate.now());
        this.section = "unkown";
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
    @Override
    public String toString() {
        return super.toString() + "\n" +
                ConsoleColors.RED + ConsoleColors.BOLD + "Section: " + ConsoleColors.RESET + getSection();
    }
}
