package pl.uwm.sportclub.manager;

import pl.uwm.sportclub.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> users = new ArrayList<>();
    public void addUser(User user)
    {
        if(user != null)
        {
            users.add(user);
        }
        else
            throw new IllegalArgumentException("User can't be 'null'");
    }
    public List<User> getUsers()
    {
        return users;
    }
    public User findById(int id)
    {
        for(User u : users)
        {
            if(u.getId() == id)
            {
                return u;
            }
        }
        return null;
    }

    public void removeById(int id)
    {
        users.removeIf(user -> user.getId() == id);
    }
}
