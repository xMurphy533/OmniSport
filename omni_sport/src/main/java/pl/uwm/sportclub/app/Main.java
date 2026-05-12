package pl.uwm.sportclub.app;

import pl.uwm.sportclub.manager.AdminRepository;
import pl.uwm.sportclub.manager.CoachRepository;
import pl.uwm.sportclub.manager.EquipmentRepository;
import pl.uwm.sportclub.manager.MemberRepository;
import pl.uwm.sportclub.service.CoachService;
import pl.uwm.sportclub.service.EquipmentService;
import pl.uwm.sportclub.service.MemberService;
import pl.uwm.sportclub.ui.ManagerMenu;
import pl.uwm.sportclub.ui.ReceptionMenu;
import utils.ConsoleColors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //=== DATA ===
        EquipmentRepository equipmentRepository = new EquipmentRepository();
        CoachRepository coachRepository = new CoachRepository();
        MemberRepository memberRepository = new MemberRepository();
        AdminRepository adminRepository = new AdminRepository();

        //=== SERVICES ===
        EquipmentService equipmentService = new EquipmentService(equipmentRepository, memberRepository);
        CoachService coachService = new CoachService(coachRepository);
        MemberService memberService = new MemberService(memberRepository);

        //=== UTILS ===
        Scanner globalScanner = new Scanner(System.in);


        // === MENU INITIALIZATION ===
        ManagerMenu managerMenu = new ManagerMenu(coachService, equipmentService, globalScanner);
        ReceptionMenu receptionMenu = new ReceptionMenu(memberService);

        boolean systemRunning = true;
        while(systemRunning)
        {
            System.out.println(ConsoleColors.BOLD + "===" + ConsoleColors.RESET +
                    ConsoleColors.RED + ConsoleColors.BOLD + " OMNI"  + ConsoleColors.RESET +
                    ConsoleColors.CYAN + ConsoleColors.BOLD + " SPORT" + ConsoleColors.RESET +
                    ConsoleColors.BOLD + "===" + ConsoleColors.RESET);
            System.out.println("1. Reception Panel");
            System.out.println("2. Manager Panel");
            System.out.println("0. Exit System");
            System.out.println("Please select your role: ");

            String choice = globalScanner.nextLine();

            switch (choice)
            {
                case "1":
                    receptionMenu.start();
                    break;
                case "2":
                    managerMenu.start();
                    break;
                case "0":
                    System.out.println("Shutting down Omni Sport. Goodbye!");
                    systemRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        globalScanner.close();
    }
}
