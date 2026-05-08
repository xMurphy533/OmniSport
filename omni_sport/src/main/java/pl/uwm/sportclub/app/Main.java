package pl.uwm.sportclub.app;


import pl.uwm.sportclub.manager.CoachRepository;
import pl.uwm.sportclub.manager.EquipmentRepository;
import pl.uwm.sportclub.model.Equipment;
import pl.uwm.sportclub.service.CoachService;
import pl.uwm.sportclub.service.EquipmentService;
import pl.uwm.sportclub.ui.ManagerMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoachRepository coachRepository = new CoachRepository();
        CoachService coachService = new CoachService(coachRepository);
        EquipmentRepository equipmentRepository = new EquipmentRepository();
        EquipmentService equipmentService = new EquipmentService(equipmentRepository);
        Scanner scanner = new Scanner(System.in);
        ManagerMenu managerMenu = new ManagerMenu(coachService, equipmentService, scanner);
        managerMenu.start();
    }
}
