package pl.uwm.sportclub.model;

import pl.uwm.sportclub.core.Identifiable;

public class Equipment implements Identifiable {
    private int id;
    private String name;
    private String type;
    private boolean isAvailable;

    public Equipment(int id, String name, String type) {
        if(id < 0)
            this.id = 0;
        this.id = id;
        if(name == null)
            this.name = "";
        this.name = name;
        if(type == null)
            this.type = "";
        this.type = type;
        this.isAvailable = true;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0)
            throw new IllegalArgumentException("ID must be higher than 0");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null)
            throw new IllegalArgumentException("Name can't be null");
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type == null)
            throw new IllegalArgumentException("Type can't be null");
        this.type = type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
