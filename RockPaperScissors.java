import java.util.*;

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
            List<Integer> scorePlayer = new ArrayList<>();
            List<Integer> scoreComputer = new ArrayList<>();
            System.out.print("Enter your name: ");
            String namePlayer = new Scanner(System.in).nextLine();

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

                displayResult(playerMove, computerMove, rock, paper, scissors, scorePlayer, scoreComputer);

            } while (gamesCount < 10);

            //TODO print scores
            printFinalScore(gamesCount, namePlayer, scorePlayer, scoreComputer);
        } while (gameRestart().equalsIgnoreCase("y"));

    }

    public static void printFinalScore(int gameCounter, String namePlayer, List<Integer> scorePlayer1, List<Integer> scoreComputer) {

        if (namePlayer.isEmpty()) {
            namePlayer = "Player_1";
        }
        System.out.println("\nRound results:");

        String lines = "_".repeat(("|" + namePlayer + " v|s Computer|").length());

        System.out.printf("%s%n", lines);
        System.out.printf("|%s v|s Computer|%n", namePlayer);
        System.out.printf("%s%n", lines);
        int nameLength = namePlayer.length();
        String spaces = " ".repeat(nameLength - ("#_").length());

        for (int i = 1; i <= gameCounter; i++) {
            if (i == 10) {
                spaces = " ".repeat(nameLength - ("#_").length() - 1);
            }
            System.out.println("#_" + i + spaces + scorePlayer1.get(i - 1) + "<|>" + scoreComputer.get(i - 1));
            System.out.printf("%s%n", lines);
        }

        int totalScorePlayer = scorePlayer1.stream().mapToInt(Integer::intValue).sum();
        int totalScoreComputer = scoreComputer.stream().mapToInt(i -> Integer.parseInt(String.valueOf(i))).sum();

        if (totalScorePlayer > totalScoreComputer) {
            System.out.printf("%s won with %d!%n", namePlayer, totalScorePlayer);
            System.out.printf("%s lost with %d!%n", "Computer", totalScoreComputer);

        } else if (totalScorePlayer < totalScoreComputer) {
            System.out.printf("%s won with [%s] points!%n", "Computer", totalScoreComputer);
            System.out.printf("%s lost with [%s] points!%n", namePlayer, totalScorePlayer);

        } else {
            System.out.println("This round is a draw! This calls for a rematch!");
        }
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

            System.out.print(playerMove + "\n");
            displayOptions(gameCounter);
            playerMove = returnHumanChoice();

        }
        return playerMove;
    }

    public static void displayResult(String playerMove, String computerMove, Map<String,
            String> rock, Map<String, String> paper, Map<String, String> scissors,
                                     List<Integer> player1, List<Integer> computer) {
        String result = "";
        switch (playerMove) {
            case ROCK -> {
                result = rock.get(computerMove.toLowerCase());
                System.out.println(result);
            }
            case PAPER -> {
                result = paper.get(computerMove.toLowerCase());
                System.out.println(result);
            }
            case SCISSORS -> {
                result = scissors.get(computerMove.toLowerCase());
                System.out.println(result);
            }
        }

        if (result.equals("You win :)")) {
            player1.add(1);
            computer.add(0);
        } else if (result.equals("You lose :(")) {
            player1.add(0);
            computer.add(1);
        } else {
            player1.add(0);
            computer.add(0);
        }
    }


    public static void displayOptions(int gameCounter) {

        System.out.printf("%s%n", "-".repeat(("%nGame %d of 10. Choose [r]ock, [p]aper, [s]cissors, [e]xit: ").length()));

        System.out.printf("Game %d of 10. Choose [r]ock, [p]aper, [s]cissors, [e]xit: ", gameCounter);
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
