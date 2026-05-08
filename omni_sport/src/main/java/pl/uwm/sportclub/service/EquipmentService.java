package pl.uwm.sportclub.service;

import pl.uwm.sportclub.manager.EquipmentRepository;
import pl.uwm.sportclub.model.Equipment;

import java.util.ArrayList;
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

    public void updateEquipmentName(int id, String name)
    {
        if(id < 0)
            throw new IllegalArgumentException("ID can't be a negative number");
        if(name.isEmpty())
        {
            throw new IllegalArgumentException("String can't be null");
        }

        Equipment equipment = equipmentRepository.findById(id);
        String oldName = equipment.getName();
        equipment.setName(name);
        String newName = equipment.getName();
        System.out.println("Successfully changed name of equipment from " + oldName + " to " + newName);
    }

    public List<Equipment> getAllAvailableEquipment()
    {
        List<Equipment> equipment = equipmentRepository.getAllItems();
        List<Equipment> allAvailableEquipment = new ArrayList<>();
        if(equipmentRepository.getAllItems().isEmpty())
            throw new IllegalArgumentException("There's no equipment in repository");
        for(Equipment e : equipment)
        {
            if(isAvailable(e.getId()))
                allAvailableEquipment.add(e);
        }
        return allAvailableEquipment;
    }

    public int countAvailableEquipment()
    {
        List<Equipment> equipment = equipmentRepository.getAllItems();
        int count = 0;
        for(Equipment e : equipment)
        {
            count++;
        }
        return count;
    }
}
