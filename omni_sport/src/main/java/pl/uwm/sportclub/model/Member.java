package pl.uwm.sportclub.model;

import utils.ConsoleColors;

import java.time.LocalDate;

public class Member extends User{
    private String discipline;
    private boolean membershipStatus;

    public Member(int id, String firstName, String lastName, String email, LocalDate dateOfBirth, String discipline, boolean membershipStatus) {
        super(id, firstName, lastName, email, dateOfBirth);
        this.discipline = discipline;
        this.membershipStatus = membershipStatus;
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
