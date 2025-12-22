
package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Calc {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int ROUNDS = 3;public static void run() {
        String[][] questionsAndAnswers = new String[ROUNDS][2];
        Random random = new Random();

        for (int i = 0; i < ROUNDS; i++) {
            int num1 = random.nextInt(20);
            int num2 = random.nextInt(20);
            char operation = getRandomOperation();

            String question = num1 + " " + operation + " " + num2;
            int result = calculate(num1, num2, operation);
            String correctAnswer = String.valueOf(result);

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.runGame(DESCRIPTION, questionsAndAnswers);
    }

    private static char getRandomOperation() {
        Random random = new Random();
        char[] operations = {'+', '-', '*'};
        int index = random.nextInt(operations.length);
        return operations[index];
    }

    private static int calculate(int num1, int num2, char operation) {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

}
