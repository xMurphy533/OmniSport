package pl.uwm.sportclub.model;

import utils.ConsoleColors;

import java.time.LocalDate;

public class Member extends User{
    private String discipline;
    private boolean membershipStatus;
    private LocalDate membershipExpiryDate;

    public Member(int id, String firstName, String lastName, String email, LocalDate dateOfBirth, String discipline, boolean membershipStatus, LocalDate membershipExpiryDate) {
        super(id, firstName, lastName, email, dateOfBirth);
        this.discipline = discipline;
        this.membershipStatus = membershipStatus;
        this.membershipExpiryDate = membershipExpiryDate;
    }

    public Member() {
        super(0, "unkown", "unkown", "unkown@", LocalDate.now());
        this.discipline = "unkown";
        this.membershipStatus = false;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public boolean isMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(boolean membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public LocalDate getMembershipExpiryDate() {
        return membershipExpiryDate;
    }

    public void setMembershipExpiryDate(LocalDate membershipExpiryDate) {
        if(!membershipExpiryDate.isBefore(LocalDate.now()))
            this.membershipExpiryDate = membershipExpiryDate;
        throw new IllegalArgumentException("This date does not exist yet");
    }

    @Override
    public String toString() {
        String answer;
        if(isMembershipStatus())
            answer = "YES";
        else
            answer = "NO";
        return  super.toString() + "\n" +
                ConsoleColors.RED + ConsoleColors.BOLD + "Discipline: " + ConsoleColors.RESET + getDiscipline() + "\n" +
                ConsoleColors.BLUE + ConsoleColors.BOLD + "Has current membership status? " + ConsoleColors.RESET + answer;
    }
}
