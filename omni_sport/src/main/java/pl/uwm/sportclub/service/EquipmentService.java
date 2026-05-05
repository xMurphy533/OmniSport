package pl.uwm.sportclub.service;

import pl.uwm.sportclub.manager.EquipmentRepository;
import pl.uwm.sportclub.model.Equipment;

import java.util.List;

public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public boolean isAvailable(int id)
    {
        if(equipmentRepository.getAllItems().isEmpty())
            throw new IllegalArgumentException("There's no equipment in repository");

        Equipment equipment = equipmentRepository.findById(id);
        return equipment != null;
    }

    public void addEquipment(Equipment equipment)
    {
        if(equipment.getName().isEmpty())
            throw new IllegalArgumentException("Equipment must have name");
        equipmentRepository.add(equipment);
        System.out.println("Successfully added " + equipment.getName());
    }

    public void removeEquipment(int id)
    {
        Equipment equipment = equipmentRepository.findById(id);
        if(equipment == null)
        {
            throw new IllegalArgumentException("There's no equipment with that ID");
        }
        equipmentRepository.removeById(id);
        System.out.println("Successfully removed " + equipment.getName());
    }
}
