package pl.uwm.sportclub.manager;

import pl.uwm.sportclub.core.Identifiable;
import pl.uwm.sportclub.model.User;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository <T extends Identifiable> {
    protected List<T> items = new ArrayList<>();

    public void add(T item)
    {
        if(item != null)
        {
            items.add(item);
        }
        else
            throw new IllegalArgumentException("Item can't be 'null'");
    }

    public List<T> getAllItems()
    {
        System.out.println(getClass().getSimpleName());
        return items;
    }

    public T findById(int id)
    {
        for(T item : items)
        {
            if(item.getId() == id)
            {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id)
    {
        items.removeIf(item -> item.getId() == id);
    }
}
