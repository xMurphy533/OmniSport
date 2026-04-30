package pl.uwm.sportclub.manager;

import pl.uwm.sportclub.model.Equipment;

import java.util.ArrayList;
import java.util.List;

public class EquipmentRepository extends BaseRepository<Equipment> {
    public List<Equipment> equipmentList = new ArrayList<>();
}
