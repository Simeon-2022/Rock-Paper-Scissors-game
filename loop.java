import java.util.Scanner;
public class loop {


        public static void main(String[] args) {
            // Create and start a separate thread for the game loop
            Thread gameThread = new Thread(() -> {
                // Loop indefinitely
                int count = 1;
                while (true) {
                    // Print the current count
                    System.out.println("Count: " + count);
                    count = (count % 10) + 1; // Reset count to 1 if it reaches 10
                    try {
                        Thread.sleep(1000); // Wait for 1 second
                    } catch (InterruptedException e) {
                        // Thread interrupted, exit gracefully
                        System.out.println("Game loop interrupted, exiting.");
                        return;
                    }
                }
            });
            gameThread.start();

            // Wait for user input to stop the game loop
            System.out.println("Press any key to stop the game loop.");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine(); // Wait for user input

            // Interrupt the game loop thread
            gameThread.interrupt();
            try {
                // Wait for the game thread to finish
                gameThread.join();
            } catch (InterruptedException e) {
                // Main thread interrupted, exit gracefully
                System.out.println("Main thread interrupted, exiting.");
            }
            scanner.close();
        }
    }



