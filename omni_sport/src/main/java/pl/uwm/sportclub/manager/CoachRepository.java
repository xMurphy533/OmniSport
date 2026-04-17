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
}
