package Assignment5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database personDB = new Database();

        // Input info for DB by Scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("Input NAME, AGE, Status by spaces:");
        String input1 = scan.nextLine();
        String[] dbArguments = input1.split(" ");

        personDB.addPerson(dbArguments[0], dbArguments[1], Integer.parseInt(dbArguments[2]), dbArguments[3]);

        personDB.addPerson("Eric Thierry", 25, "Available");
        personDB.addPerson("Mark Larson", 23, "On a scene");
        personDB.addPerson("Max Cassell", 34, "Available");
        personDB.addPerson("Luis Torretto", 28, "On a scene");

        List<Person> peopleList = personDB.getPeople();
        System.out.println(peopleList);

        personDB.updatePerson(1, "Luis Torretto", 28, "Available");

        // Printing updated info
        peopleList = personDB.getPeople();
        System.out.println("Updated base: " + peopleList);


        //closing connection with DB for security, preventing connection leaks and freeing up resources

        personDB.closeConnection();
    }
}
