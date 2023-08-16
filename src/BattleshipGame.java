import java.util.ArrayList;
import java.util.Arrays; // import Arrays class from java.util package

public class BattleshipGame {
    private ArrayList<Battleship> battleships; // list to store battleships
    private GameHelper helper = new GameHelper(); // here we create an instance of GameHelper
    private int numOfGuesses = 0; // initialize the guess counter

    public void setUpGame() {
        battleships = new ArrayList<Battleship>(); // Initialize the battleships list
        // Create battleships and add them to the list
        battleships.add(new Battleship("BankOfAmerica", new ArrayList<>(Arrays.asList("a0", "a1", "a2"))));
        battleships.add(new Battleship("WellsFargo", new ArrayList<>(Arrays.asList("b3", "c3", "d3"))));
        battleships.add(new Battleship("Lowes", new ArrayList<>(Arrays.asList("c4", "c5", "c6"))));
    }

    public void startPlaying() {
        while (!battleships.isEmpty()) { // Keep playing until all battleships are sunk
            String userGuess = helper.getUserInput("Enter a guess"); // Get user's guess
            checkUserGuess(userGuess); // Check if the guess is a hit or miss
        }
        finishGame(); // Finish the game when all battleships are sunk
    }

    private void checkUserGuess(String guess) {
        numOfGuesses++; // increment
        for (Battleship battleship : battleships) {
            if (battleship.checkGuess(guess)) { // If checks if guess = battleship's location
                battleships.remove(battleship); // Remove the sunk battleship from the list
                System.out.println("Hit! You sunk " + battleship.getName()); // Print hit
                break; // Exit the loop after a hit is found
            } else {
                System.out.println("You missed Stinky"); // print miss
                break; // break the loop
            }
        }
    }

    private void finishGame() {
        System.out.println("All EPs are sunk! It took you " + numOfGuesses + " guesses.");
        // Print the game over message along with the number of guesses made
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame(); // Create a new BattleshipGame instance
        game.setUpGame(); // Set up the game by creating battleships
        game.startPlaying(); // Start playing the game
    }
}
