package pl.uwm.sportclub.service;

import pl.uwm.sportclub.manager.CoachRepository;
import pl.uwm.sportclub.model.Coach;
import utils.ConsoleColors;

import java.util.List;

public class CoachService {
    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository)
    {
        this.coachRepository = coachRepository;
    }

    public void hireNewCoach(Coach newCoach)
    {
        if(newCoach == null || newCoach.getFirstName() == null)
        {
            throw new IllegalArgumentException("Error: Coach's data isn't complete");
        }
        coachRepository.add(newCoach);
        System.out.println("Success! New coach was hired - " + newCoach.getFirstName() + " " + newCoach.getLastName());
    }

    public void displayAllCoaches()
    {
        List<Coach> coaches = coachRepository.getAllItems();

        if(coaches.isEmpty())
        {
            throw new NullPointerException("There's no hired coaches");
        }
        System.out.println("=== LIST OF COACHES ===");
        for(Coach c : coaches)
        {
            System.out.println(ConsoleColors.RED + ConsoleColors.BOLD + "ID: " + ConsoleColors.RESET + c.getId() +
                    ConsoleColors.BLUE + ConsoleColors.BOLD + "First name: " + ConsoleColors.RESET + c.getFirstName() +
                    ConsoleColors.CYAN + ConsoleColors.BOLD + "Last name: " + ConsoleColors.RESET + c.getLastName() +
                    ConsoleColors.GREEN + ConsoleColors.BOLD + "Section: " + ConsoleColors.RESET + c.getSection());
        }
    }

    public boolean verifyCoach(int id)
    {
        Coach coach = coachRepository.findById(id);

        if(coach == null)
        {
            System.out.println("There's no coach with that ID");
            return false;
        }

        System.out.println("Coach " + coach.getFirstName() + " " + coach.getLastName() + " verified successfully!");
        return true;
    }

    public void changeSection(int id, String newSection)
    {
        Coach coach = coachRepository.findById(id);

        if(newSection == null)
        {
            throw new IllegalArgumentException("No new section provided");
        }

        if(coach == null)
        {
            throw new IllegalArgumentException("There's no coach with that ID");
        }

        String oldSection = coach.getSection();
        coach.setSection(newSection);

        System.out.println("Success! " + coach.getFirstName() + " " + coach.getLastName() + " changed section from " + oldSection + " to " + newSection);
    }
}
