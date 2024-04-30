import java.util.Scanner;

public class loop2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        long elapsedTime;

        System.out.println("Press any key to stop the game loop.");

        // Loop indefinitely
        int count = 1;
        while (true) {
            // Print the current count
            System.out.println("Count: " + count);
            count = (count % 10) + 1; // Reset count to 1 if it reaches 10

            // Check if the user has pressed any key
            if (scanner.hasNextLine()) {
                // Stop the game loop if any key is pressed
                System.out.println("Stopping the game loop.");
                break;
            }

            // Calculate elapsed time
            elapsedTime = System.currentTimeMillis() - startTime;

            // Wait for 1 second before printing the next count
            while (elapsedTime < 1000) {
                elapsedTime = System.currentTimeMillis() - startTime;
            }
            startTime = System.currentTimeMillis(); // Reset start time
        }

        // Close the scanner
        scanner.close();
    }
}
