import java.util.ArrayList;
import java.util.Arrays; // Import Arrays class from java.util package

public class Battleship {
    private String name; // Name of the battleship
    private ArrayList<String> locations; // List of coordinates where the battleship is located

    // Constructor to initialize the battleship's name and locations
    public Battleship(String name, ArrayList<String> locations) {
        this.name = name;
        this.locations = locations;
    }

    // Getter method to retrieve the battleship's name
    public String getName() {
        return name;
    }

    // Getter method to retrieve the battleship's locations
    public ArrayList<String> getLocations() {
        return locations;
    }

    // Method to check if a given guess matches any of the battleship's locations
    public boolean checkGuess(String guess) {
        return locations.contains(guess); // Return true if the guess matches any location
    }
}
