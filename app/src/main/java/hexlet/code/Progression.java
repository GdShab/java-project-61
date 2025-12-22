package hexlet.code;

import hexlet.code.Engine;

import java.util.Random;

public class Progression {

    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MAX_START = 20;
    private static final int MAX_STEP = 5;

    public static void run() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS][2];
        Random random = new Random();

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int progressionLength = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
            int start = random.nextInt(MAX_START) + 1;
            int step = random.nextInt(MAX_STEP) + 1;
            int hiddenIndex = random.nextInt(progressionLength);

            int[] progression = generateProgression(start, step, progressionLength);
            String correctAnswer = String.valueOf(progression[hiddenIndex]);
            String question = generateQuestion(progression, hiddenIndex);

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.run(DESCRIPTION, questionsAndAnswers);
    }

    private static int[] generateProgression(int start, int step, int length) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }
        return progression;
    }

    private static String generateQuestion(int[] progression, int hiddenIndex) {
        StringBuilder question = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                question.append(".. ");
            } else {
                question.append(progression[i]).append(" ");
            }
        }
        return question.toString().trim();
    }
}
