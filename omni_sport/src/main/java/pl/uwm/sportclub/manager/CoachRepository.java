package pl.uwm.sportclub.manager;

import pl.uwm.sportclub.model.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository extends BaseRepository<Coach>{
    public List<Coach> coaches = new ArrayList<>();

}
