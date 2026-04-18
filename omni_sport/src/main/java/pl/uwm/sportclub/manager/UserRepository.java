package pl.uwm.sportclub.manager;

import pl.uwm.sportclub.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository extends BaseRepository<User>{
    public List<User> users = new ArrayList<>();

}
