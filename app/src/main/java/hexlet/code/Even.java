
package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int ROUNDS = 3;public static void run() {
        String[][] questionsAndAnswers = new String[ROUNDS][2];
        Random random = new Random();

        for (int i = 0; i < ROUNDS; i++) {
            int number = random.nextInt(100);
            String question = String.valueOf(number);
            String correctAnswer = isEven(number) ? "yes" : "no";

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.runGame(DESCRIPTION, questionsAndAnswers);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

}

