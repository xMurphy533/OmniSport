package pl.uwm.sportclub.service;

import org.junit.jupiter.api.Test;
import pl.uwm.sportclub.manager.EquipmentRepository;
import pl.uwm.sportclub.model.Equipment;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentServiceTest {

    @Test
    void isAvailable_shouldReturnTrueIfEquipmentIsAvailableInRepository() {
        //GIVEN
        EquipmentRepository equipmentRepository = new EquipmentRepository();
        EquipmentService equipmentService = new EquipmentService(equipmentRepository);
        equipmentRepository.add(new Equipment(1, "Kettlebell", "gym equipment"));

        //WHEN
        boolean result = equipmentService.isAvailable(1);

        //THEN
        assertTrue(result, "OmniSport should return true if equipment with the same ID in isAvailable function argument is in repository.");
    }

    @Test
    void isAvailable_shouldReturnFalseIfEquipmentIsNotAvailableInRepository() {
        //GIVEN
        EquipmentRepository equipmentRepository = new EquipmentRepository();
        EquipmentService equipmentService = new EquipmentService(equipmentRepository);
        equipmentRepository.add(new Equipment(1, "Kettlebell", "gym equipment"));

        //WHEN
        boolean result = equipmentService.isAvailable(2);

        //THEN
        assertFalse(result, "OmniSport should return false if equipment with the same ID in isAvailable function argument isn't in repository.");
    }

    @Test
    void addEquipment_shouldAddNewEquipmentObjectToRepository() {
        //GIVEN
        EquipmentRepository equipmentRepository = new EquipmentRepository();
        EquipmentService equipmentService = new EquipmentService(equipmentRepository);

        //WHEN
        equipmentService.addEquipment(new Equipment(1, "Mat", "Fitness"));

        //THEN
        int count = equipmentService.countAvailableEquipment();
        assertEquals(1, count, "Omni Sport should count 1 equipment");
    }

    @Test
    void removeEquipment_shouldRemoveExistingInRepositoryEquipment() {
        //GIVEN
        EquipmentRepository equipmentRepository = new EquipmentRepository();
        EquipmentService equipmentService = new EquipmentService(equipmentRepository);
        equipmentService.addEquipment(new Equipment(1, "Mat", "Fitness"));

        //WHEN
        equipmentService.removeEquipment(1);

        //THEN
        int repoSize = equipmentRepository.getAllItems().size();
        assertEquals(0, repoSize, "OmniSport's equipment repository should have one less object after remove equipment");
    }

    @Test
    void removeEquipment_shouldThrowExceptionWhenRepoIsNull() {
        //GIVEN
        EquipmentRepository equipmentRepository = new EquipmentRepository();
        EquipmentService equipmentService = new EquipmentService(equipmentRepository);

        //WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> {
            equipmentService.removeEquipment(1);
        }, "Should throw exception if repo is null");
    }

    @Test
    void updateEquipmentName_shouldShangeNameOfEquipment() {
        //GIVEN
        EquipmentRepository equipmentRepository = new EquipmentRepository();
        EquipmentService equipmentService = new EquipmentService(equipmentRepository);
        equipmentService.addEquipment(new Equipment(1, "Football boots", "Shoes"));

        //WHEN
        equipmentService.updateEquipmentName(1, "Bike boots");

        //THEN
        assertEquals("Bike boots", equipmentRepository.findById(1).getName(), "OmniSport should change name of equipment");
    }

    @Test
    void updateEquipmentName_shouldThrowExceptionWhenIdIsNegativeNumber() {
        //GIVEN
        EquipmentRepository equipmentRepository = new EquipmentRepository();
        EquipmentService equipmentService = new EquipmentService(equipmentRepository);
        equipmentService.addEquipment(new Equipment(1, "Football boots", "Shoes"));

        //WHEN & THEN
        assertThrows(IllegalArgumentException.class, () ->
        {
            equipmentService.updateEquipmentName(-1, "Bike boots");
        }, "Should throw exception when ID is a negative number");
    }

    @Test
    void updateEquipmentName_shouldThrowExceptionWhenNameIsNull() {
        //GIVEN
        EquipmentRepository equipmentRepository = new EquipmentRepository();
        EquipmentService equipmentService = new EquipmentService(equipmentRepository);
        equipmentService.addEquipment(new Equipment(1, "Football boots", "Shoes"));

        //WHEN & THEN
        assertThrows(IllegalArgumentException.class, () ->
        {
            equipmentService.updateEquipmentName(1, "");
        }, "Should throw exception when name is null");
    }
}