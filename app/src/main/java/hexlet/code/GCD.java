package hexlet.code;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {

    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MAX_NUMBER = 100;

    public static void run() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS][2];
        Random random = new Random();

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int number1 = random.nextInt(MAX_NUMBER) + 1;
            int number2 = random.nextInt(MAX_NUMBER) + 1;

            questionsAndAnswers[i][0] = number1 + " " + number2;
            questionsAndAnswers[i][1] = String.valueOf(gcd(number1, number2));
        }

        Engine.runGame(DESCRIPTION, questionsAndAnswers);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

