package pl.uwm.sportclub.manager;

import pl.uwm.sportclub.model.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository extends BaseRepository<Admin>{
    public List<Admin> admins = new ArrayList<>();

}
