package pl.uwm.sportclub.model;

import utils.ConsoleColors;

import java.time.LocalDate;

public class Admin extends User{
    private String adminLevel;
    private LocalDate lastAuditDate;

    public Admin(int id, String firstName, String lastName, String email, LocalDate dateOfBirth, String adminLevel, LocalDate lastAuditDate) {
        super(id, firstName, lastName, email, dateOfBirth);
        this.adminLevel = adminLevel;
        this.lastAuditDate = lastAuditDate;
    }
    public Admin(){
        super(0, "unkown", "unkown", "unkown@", LocalDate.now());
        this.adminLevel = "unkown";
        this.lastAuditDate = LocalDate.now();
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    public LocalDate getLastAuditDate() {
        return lastAuditDate;
    }

    public void setLastAuditDate(LocalDate lastAuditDate) {
        this.lastAuditDate = lastAuditDate;
    }
    @Override
    public String toString() {
        return super.toString() + "\n" +
                ConsoleColors.RED + ConsoleColors.BOLD + "Admin level: " + ConsoleColors.RESET + getAdminLevel() + "\n" +
                ConsoleColors.BLUE + ConsoleColors.BOLD + "Last audit date: " + ConsoleColors.RESET + getLastAuditDate();
    }
}
