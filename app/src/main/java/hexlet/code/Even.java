package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {

    private static final int ROUNDS = 3;

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < ROUNDS; i++) {
            int number = random.nextInt(100);
            System.out.println("Question: " + number);
            System.out.println("Your answer: ");
            String answer = scanner.next().toLowerCase();

            String correctAnswer = isEven(number) ? "yes" : "no";

            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + "'.");
                System.out.println("Let's try again, " + name + "!");
                //scanner.close();
                return;
            }

            System.out.println("Correct!");
        }

        System.out.println("Congratulaitions, " + name + "!");
        //scanner.close();
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
