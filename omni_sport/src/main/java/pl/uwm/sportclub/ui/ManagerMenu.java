package pl.uwm.sportclub.ui;

import pl.uwm.sportclub.model.Coach;
import pl.uwm.sportclub.model.Equipment;
import pl.uwm.sportclub.service.CoachService;
import pl.uwm.sportclub.service.EquipmentService;
import utils.ConsoleColors;
import utils.InputValidator;
import utils.InputValidator.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ManagerMenu {
    private CoachService coachService;
    private EquipmentService equipmentService;
    private Scanner scanner;

    public ManagerMenu(CoachService coachService, EquipmentService equipmentService, Scanner scanner) {
        this.coachService = coachService;
        this.equipmentService = equipmentService;
        this.scanner = scanner;
    }

    public void start()
    {
        boolean isRunning = true;
        while(isRunning)
        {
            System.out.println("=== OMNI SPORT MANAGER PANEL ===");
            System.out.println("1. Hire a new trainer");
            System.out.println("2. Add new equipment");
            System.out.println("3. Rent equipment");
            System.out.println("4. Return the equipment");
            System.out.println("0. Return to main menu");
            System.out.println("Please select one of the options above: ");

            String choice = scanner.nextLine();

            switch(choice)
            {
                case "1":
                    hireCoachLogic();
                    break;
                case "2":
                    addEquipmentLogic();
                    break;
                case "3":
                    rentEquipment();
                    break;
                case "4":
                    returnEquipment();
                    break;
                case "0":
                    System.out.println("Closing of manager panel. Goodbye");
                    isRunning = false;
            }
        }
    }

    private void hireCoachLogic()
    {
        int id = 0;
        String firstName;
        String lastName;
        String email;
        int year = 2000;
        int month = 1;
        int day = 1;
        String section;

        System.out.println("Welcome in hiring coach module! Please enter data of new coach.");

        id = InputValidator.getValidIntFromUser("ID: ");

        System.out.println("First name: ");
        firstName = scanner.nextLine();

        System.out.println("Last name: ");
        lastName = scanner.nextLine();

        System.out.println("E-mail address: ");
        email = scanner.nextLine();

        year = InputValidator.getValidIntFromUser("Year of birth: ");

        month = InputValidator.getValidIntFromUser("Month of birth: ");

        day = InputValidator.getValidIntFromUser("Day of birth: ");

        LocalDate dateOfBirth = LocalDate.of(year, month, day);

        System.out.println("Section: ");
        section = scanner.nextLine();
        Coach newCoach = new Coach(id, firstName, lastName, email, dateOfBirth, section);
        coachService.hireNewCoach(newCoach);
    }

    private void addEquipmentLogic()
    {
        System.out.println("=== ADDING EQUIPMENT ===");
        int id = 0;
        String name;
        String type;

        id = InputValidator.getValidIntFromUser("ID: ");

        System.out.println("Name: ");
        name = scanner.nextLine();

        System.out.println("Type: ");
        type = scanner.nextLine();

        Equipment newEquipment = new Equipment(id, name, type);

        equipmentService.addEquipment(newEquipment);
    }

    private void rentEquipment()
    {
        System.out.println("=== RENTING OF EQUIPMENT ===");
        int id = InputValidator.getPositiveIntFromUser("Enter ID of equipment you want to rent: ");
        int memberID = InputValidator.getPositiveIntFromUser("Enter ID of member, who rent equipment: ");
        try
        {
            equipmentService.rentEquipment(id, memberID);
        } catch (IllegalArgumentException | IllegalStateException e)
        {
            System.out.println(ConsoleColors.RED + ConsoleColors.BOLD + "DECLINE: " + ConsoleColors.RESET + e.getMessage());
        }
    }

    private void returnEquipment()
    {
        System.out.println("=== RETURNING OF EQUIPMENT ===");
        int id = InputValidator.getPositiveIntFromUser("Enter ID of equipment you want to return: ");
        try{
            equipmentService.returnEquipment(id);
        } catch(IllegalArgumentException | IllegalStateException e)
        {
            System.out.println(ConsoleColors.RED + ConsoleColors.BOLD + "DECLINE: " + ConsoleColors.RESET + e.getMessage());
        }
    }
}
