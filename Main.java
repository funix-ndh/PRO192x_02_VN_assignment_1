import java.util.Scanner;

class Main {

    // maximum range
    final static int max = 100;

    // report variables
    static int totalGames;
    static int totalGuesses;
    static double ratioGuessGame;
    static int bestGame = Integer.MAX_VALUE;

    public static void main(final String[] args) {
        play();
        report();
    }

    // gameplay
    private static void play() {
        final Scanner scanner = new Scanner(System.in);
        do {
            final int number = (int) (Math.random() * max + 1); // random number with range [0, max]
            System.out.println(); // blank line, for nice looking purpose
            System.out.println("I'm thinking of a number between 0 and " + max + "...");

            int guessNumber; // input from user
            int guessCnt = 0; // counter

            // play game until guess correct number
            do {
                System.out.print("Your guess? ");
                guessNumber = scanner.nextInt();
                if (number > guessNumber) {
                    System.out.println("It's higher.");
                } else if (number < guessNumber) {
                    System.out.println("It's lower.");
                }
                guessCnt += 1;
            } while (number != guessNumber);

            System.out.println("You got it right in " + guessCnt + " guess(es)!");
            System.out.print("Do you want to play again? ");

            // calculate report
            totalGames += 1;
            totalGuesses += guessCnt;
            ratioGuessGame = (double)totalGuesses / totalGames;
            bestGame = Math.min(bestGame, guessCnt);

        } while (isContinue(scanner));
    }

    // show report
    private static void report() {
        System.out.println(); // blank line, for nice looking purpose
        System.out.println("Overall result:");
        System.out.println("Total games   = " + totalGames);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.println("Guesses/games = " + String.format("%.1f", ratioGuessGame));
        System.out.println("Best games    = " + bestGame);
    }

    // check if user want to play more
    private static boolean isContinue(final Scanner scanner) {
        final String input = scanner.next().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }
}
