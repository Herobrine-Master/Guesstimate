package com.herobrinemaster.guesstimate;

import java.util.Random;
import static java.util.Comparator.comparing;
import static java.util.stream.IntStream.range;

public class GuesstimateUtils {

    public static void shuffleQuestionsAndAnswers(String[] questions, int[] answers) {
        Random random = new Random();
        for (int i = questions.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            // Swap questions
            String tempQuestion = questions[i];
            questions[i] = questions[j];
            questions[j] = tempQuestion;

            // Swap answers at the same positions
            int tempAnswer = answers[i];
            answers[i] = answers[j];
            answers[j] = tempAnswer;
        }
    }

    public static int[] sortedIdx(int[] values) {
        return range(0, values.length)
                .boxed()
                .sorted(comparing(idx -> values[idx]))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}