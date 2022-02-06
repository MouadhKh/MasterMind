import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static int selectedMode;

    private static void codeMakerMode(Scanner sc, String[] colors) {
        System.out.println("Colors that could be combined:\n");
        IntStream.rangeClosed(1, 6).forEach(i -> {
                    System.out.println(i + "." + colors[i]);
                }
        );
        String userGuess = "";
        CodeMaker codeMaker = new CodeMaker();
        do {
            System.out.println("Give your guess(4 Colors):");
            userGuess = sc.nextLine();
        } while (!ColorCombination.isValid(userGuess));
        int guessAttemptNumber = 0;
        while (!codeMaker.isGuessCorrect(userGuess)) {
            System.out.println(guessAttemptNumber + ".Guess Evaluation: " + codeMaker.evaluate(userGuess));
            System.out.println("Guess again: ");
            userGuess = sc.nextLine();
        }
        System.out.println("You guessed it right after" + guessAttemptNumber + " attempts");
        // Display interface again
        main(null);
    }

    private static void modeSelection(Scanner sc) {
        do {
            try {
                Runtime.getRuntime().exec("cls");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\t\tWelcome to MasterMind\t\n");
            System.out.println("Choose your playmode:\n" +
                    "1-CodeBreaker\t\t2-CodeMaker");
            selectedMode = sc.nextInt();
        } while (selectedMode != 1 && selectedMode != 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            String[] colors = (String[]) Arrays.stream(Colors.values())
                    .map(Enum::name)
                    .toArray();
            modeSelection(sc);
            if (selectedMode == 2) {
                codeMakerMode(sc, colors);
            } else if (selectedMode == 1) {
                //TODO
            }
            System.out.println("Press q to quit");
        } while (!sc.nextLine().equals("q"));
    }

}
