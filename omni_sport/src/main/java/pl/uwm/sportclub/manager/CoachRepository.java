package pl.uwm.sportclub.manager;

import pl.uwm.sportclub.model.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {
    public List<Coach> coaches = new ArrayList<>();

    public void addCoach(Coach coach)
    {
        if(coach != null)
        {
            coaches.add(coach);
        }
        else
            throw new IllegalArgumentException("Coach can't be 'null'");
    }

    public List<Coach> getCoaches()
    {
        return coaches;
    }

    public Coach findById(int id)
    {
        for(Coach c : coaches)
        {
            if(c.getId() == id)
            {
                return c;
            }
        }
        return null;
    }

    public void deleteById(int id)
    {
        coaches.removeIf(coach -> coach.getId() == id);
    }
}
