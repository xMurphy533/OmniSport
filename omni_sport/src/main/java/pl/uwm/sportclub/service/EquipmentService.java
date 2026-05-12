package pl.uwm.sportclub.service;

import pl.uwm.sportclub.manager.EquipmentRepository;
import pl.uwm.sportclub.manager.MemberRepository;
import pl.uwm.sportclub.model.Equipment;
import pl.uwm.sportclub.model.Member;

import java.util.ArrayList;
import java.util.List;

public class EquipmentService {
    private final EquipmentRepository equipmentRepository;
    private MemberRepository memberRepository;

    public EquipmentService(EquipmentRepository equipmentRepository, MemberRepository memberRepository) {
        this.equipmentRepository = equipmentRepository;
        this.memberRepository = memberRepository;
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

    public void rentEquipment(int eqID, int memberID)
    {
        if(eqID < 0 || memberID < 0)
        {
            throw new IllegalArgumentException("ID can't be negative");
        }
        Equipment eqToRent = equipmentRepository.findById(eqID);
        if(eqToRent == null)
        {
            throw new IllegalArgumentException("There's no equipment with your ID");
        }
        if(!eqToRent.isAvailable())
        {
            throw new IllegalStateException("Equipment is already rented");
        }
        Member member = memberRepository.findById(memberID);
        if(member == null)
        {
            throw new IllegalArgumentException("Member not found.");
        }
        eqToRent.setAvailable(false);
        eqToRent.setRenterId(memberID);
        System.out.println("Successfully rended: " + eqToRent.getName() + " to " + member.getFirstName() + " " + member.getLastName());
    }

    public void returnEquipment(int id)
    {
        Equipment eqToReturn = equipmentRepository.findById(id);
        if(eqToReturn == null)
        {
            throw new IllegalArgumentException("There's no equipment with your ID");
        }
        if(eqToReturn.isAvailable())
        {
            throw new IllegalStateException("Equipment is in the reception");
        }
        eqToReturn.setAvailable(true);
        eqToReturn.setRenterId(-1);
        System.out.println("Successfully returned: " + eqToReturn.getName());
    }

}
