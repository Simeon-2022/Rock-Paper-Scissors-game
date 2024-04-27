import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";
    private static final String EXIT = "Exiting";
    private static final String INVALID = "Invalid Input. Try Again...";
    private static final int seed = 3;

    public static void main(String[] args) {

        Map<String, String> rock = new LinkedHashMap<>();
        Map<String, String> paper = new LinkedHashMap<>();
        Map<String, String> scissors = new LinkedHashMap<>();
        loadGameRules(rock, paper, scissors);

        do {
            int[] scorePlayer = new int[10];
            int[] scoreComputer = new int[10];

            int gamesCount = 0;
            do {
                gamesCount++;
                displayOptions(gamesCount);

                String playerMove = returnPlayerChoice(gamesCount);

                if (playerMove.equals(EXIT)) {
                    System.out.println("exiting...");
                    return;
                }

                System.out.println("You chose \"" + playerMove + "\"!");

                String computerMove = returnComputerChoice();

                System.out.printf("The computer chose \"%s\"!%n", computerMove);

                displayResult(playerMove, computerMove, rock, paper, scissors);

            } while (gamesCount < 10);

            //TODO print scores

        } while (gameRestart().equalsIgnoreCase("y"));

    }

    public static String gameRestart() {
        System.out.print("Play another round? : [y]es or press any key.. -> ");
        return new Scanner(System.in).nextLine();

    }

    public static void loadGameRules(Map<String, String> rock, Map<String, String> paper, Map<String, String> scissors) {
        rock.put("rock", "This game is a draw!");
        rock.put("paper", "You lose :(");
        rock.put("scissors", "You win :)");

        paper.put("paper", "This game is a draw!");
        paper.put("scissors", "You lose :(");
        paper.put("rock", "You win :)");


        scissors.put("scissors", "This game is a draw!");
        scissors.put("rock", "You lose :(");
        scissors.put("paper", "You win :)");

    }

    public static String returnPlayerChoice(int gameCounter) {
        String playerMove = returnHumanChoice();
        while (playerMove.equals(INVALID)) {

            System.out.println(playerMove + "\n");
            displayOptions(gameCounter);
            playerMove = returnHumanChoice();

        }
        return playerMove;
    }

    public static void displayResult(String playerMove, String computerMove, Map<String, String> rock, Map<String, String> paper, Map<String, String> scissors) {
        switch (playerMove) {
            case ROCK -> {
                int wdqw = 0;

                System.out.printf("%s%n", rock.get(computerMove.toLowerCase()));
            }
            case PAPER -> System.out.printf("%s%n", paper.get(computerMove.toLowerCase()));
            case SCISSORS -> System.out.printf("%s%n", scissors.get(computerMove.toLowerCase()));
        }
    }

    public static void displayOptions(int gameCounter) {

        System.out.printf("Game %d of 10. Choose [r]ock, [p]aper, [s]cissors, [e]xit: ", gameCounter);
        // System.out.print("Your choice -> ");
    }

    public static String returnComputerChoice() {
        String[] computerChoice = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int computerRandomNumber = random.nextInt(seed);
        return computerChoice[computerRandomNumber];
    }

    public static String returnHumanChoice() {
        String choice = new Scanner(System.in).nextLine().toLowerCase();

        choice = switch (choice) {
            case "r", "rock" -> ROCK;
            case "p", "paper" -> PAPER;
            case "s", "scissors" -> SCISSORS;
            case "e", "exit" -> EXIT;
            default -> INVALID;
        };
        return choice;
    }
}
