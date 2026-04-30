package pl.uwm.sportclub.manager;

import pl.uwm.sportclub.model.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository extends BaseRepository<Coach>{
    public List<Coach> coaches = new ArrayList<>();

    public List<Coach> findByLastName(String lastName)
    {
        List<Coach> foundItems = new ArrayList<>();
        for(Coach c : coaches)
        {
            if(c.getLastName().equalsIgnoreCase(lastName))
            {
                foundItems.add(c);
            }
        }
        return foundItems;
    }
}
