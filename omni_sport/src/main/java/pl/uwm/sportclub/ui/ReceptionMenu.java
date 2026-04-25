package pl.uwm.sportclub.ui;

import pl.uwm.sportclub.model.Member;
import pl.uwm.sportclub.service.MemberService;

import java.time.LocalDate;
import java.util.Scanner;

public class ReceptionMenu {
    private final MemberService memberService;
    private final Scanner scanner;

    public ReceptionMenu(MemberService memberService)
    {
        this.memberService = memberService;
        this.scanner = new Scanner(System.in);
    }

    public void start()
    {
        boolean isRunning = true;
        while(isRunning)
        {
            System.out.println("=== OMNI SPORT - RECEPTION ===");
            System.out.println("1. Register new member");
            System.out.println("2. Check access");
            System.out.println("0. QUIT");
            System.out.println("Choose option: ");
            String choice = scanner.nextLine();
            switch(choice)
            {
                case "1":
                    registration();
                    break;
                case "2":
                    accessVerification();
                    break;
                case "0":
                    System.out.println("System is closing. Good bye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Unknown option. Please try again");
            }
        }
    }
    private void registration()
    {
        int id = 0;
        String firstName;
        String lastName;
        String email;
        int year = 2000;
        int month = 1;
        int day = 1;
        LocalDate dateOfBirth;
        String discipline;
        boolean memberStatus = true;
        LocalDate membershipExpiryDate = LocalDate.now().plusMonths(1);

        System.out.println("Welcome in registration module! Please enter data of new member.");

        id = getValidIntFromUser("ID: ");

        System.out.println("First name: ");
        firstName = scanner.nextLine();

        System.out.println("Last name: ");
        lastName = scanner.nextLine();

        System.out.println("E-mail address: ");
        email = scanner.nextLine();

        year = getValidIntFromUser("Year of birth: ");

        month = getValidIntFromUser("Month of birth: ");

        day = getValidIntFromUser("Day of birth: ");

        dateOfBirth = LocalDate.of(year, month, day);

        System.out.println("Discipline: ");
        discipline = scanner.nextLine();

        Member newMember = new Member(id, firstName, lastName, email, dateOfBirth, discipline, memberStatus, membershipExpiryDate);

        memberService.registerNewMember(newMember);
    }

    private void accessVerification()
    {
        System.out.println("Welcome in verification module!");
        boolean isValid = false;
        int id = 0;
        while(!isValid)
        {
            System.out.println("Please enter ID of member, whose access you want to verify: ");
            String identifyKey = scanner.nextLine();
            try{
                id = Integer.parseInt(identifyKey);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
            }
        }
        memberService.verifyAccess(id);
    }

    private int getValidIntFromUser(String input)
    {
        int result = 0;
        boolean isValid = false;
        while(!isValid)
        {
            System.out.println(input);
            String data = scanner.nextLine();
            try{
                result = Integer.parseInt(data);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
            }
        }
        return result;
    }
}
