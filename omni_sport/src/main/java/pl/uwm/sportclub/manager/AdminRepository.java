package pl.uwm.sportclub.manager;

import pl.uwm.sportclub.model.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    public List<Admin> admins = new ArrayList<>();
    public void addAdmin(Admin admin)
    {
        if(admin != null)
        {
            admins.add(admin);
        }
        else
            throw new IllegalArgumentException("Admin can't be 'null'");
    }
    public List<Admin> getAdmins()
    {
        return admins;
    }

    public Admin findById(int id)
    {
        for(Admin a : admins)
        {
            if(a.getId() == id)
            {
                return a;
            }
        }
        return null;
    }

    public void deleteById(int id)
    {
        admins.removeIf(admin -> admin.getId() == id);
    }
}
