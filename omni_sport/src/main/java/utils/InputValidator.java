package utils;

import java.time.LocalDate;
import java.util.Scanner;

public class InputValidator {

    public static int getValidIntFromUser(String input)
    {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        boolean isValid = false;
        while(!isValid)
        {
            System.out.println(input);
            String data = scanner.nextLine();
            try{
                result = Integer.parseInt(data);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
            }
        }
        return result;
    }
}
