package pl.uwm.sportclub.app;

import pl.uwm.sportclub.model.User;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(1, "Nikodem", "Kaczmarczyk", "nikodemkaczmarczyk48@gmail.com", LocalDate.of(2005, 3, 19));
        System.out.println(u1.toString());
    }
}
