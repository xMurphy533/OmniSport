package pl.uwm.sportclub.model;

import java.time.LocalDate;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;

    public User(int id, String firstName, String lastName, String email, LocalDate dateOfBirth) {
        if(id < 0)
            this.id = 0;
        this.id = id;
        if(firstName == null)
            this.firstName = "";
        this.firstName = firstName;
        if(lastName == null)
            this.lastName = "";
        this.lastName = lastName;
        if(email == null)
            this.email = "";
        this.email = email;
        if(dateOfBirth.isEqual(null))
            this.dateOfBirth = LocalDate.of(2000, 1, 1);
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0)
            this.id = 0;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null)
            this.firstName = "";
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null)
            this.lastName = "";
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null)
            this.email = "";
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        if(dateOfBirth.isEqual(null))
            this.dateOfBirth = LocalDate.of(2000, 1, 1);
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
