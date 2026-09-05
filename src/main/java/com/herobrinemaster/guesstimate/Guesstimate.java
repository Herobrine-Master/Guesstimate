package com.herobrinemaster.guesstimate;

import java.util.Scanner;

import static com.herobrinemaster.guesstimate.GuesstimateUtils.shuffleQuestionsAndAnswers;
import static com.herobrinemaster.guesstimate.GuesstimateUtils.sortedIdx;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

public class Guesstimate {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[] QUESTIONS = createQuestions();
    private static final int[] ANSWERS = createAnswers();

    public static void main(String[] args) {
        System.out.println("Hello and welcome to Guesstimate!");

        System.out.println("Please enter the number of players:");
        int playerNumber = parseInt(SCANNER.nextLine());

        System.out.println("Please enter the number of questions.");
        int questionNumber = parseInt(SCANNER.nextLine());

        int[] totalScores = new int[playerNumber];
        String[] playerNames = inputPlayerNames(playerNumber);

        shuffleQuestionsAndAnswers(QUESTIONS, ANSWERS);

        for (int i = 0; i < questionNumber; i++)
            playRound(i, playerNames, totalScores);

        findBestPlayer(playerNames, totalScores);
    }

    private static void findBestPlayer(String[] playerNames, int[] totalScores) {
        int bestPlayerScore = 0;
        int bestPlayerIdx = -1;
        for (int i = 0; i < playerNames.length; i++) {
            if (totalScores[i] > bestPlayerScore) {
                bestPlayerScore = totalScores[i];
                bestPlayerIdx = i;
            }
        }
        System.out.println("\nThe Winner is... " + playerNames[bestPlayerIdx] + "!!!");
    }

    private static String[] inputPlayerNames(int playerNumber) {
        String[] playerNames = new String[playerNumber];
        for (int i = 0; i < playerNumber; i++) {
            System.out.println("Please enter the name for player " + (i + 1));
            playerNames[i] = SCANNER.nextLine();
        }
        return playerNames;
    }

    private static void playRound(int i, String[] playerNames, int[] totalScores) {
        System.out.println("\nThe question is: " + QUESTIONS[i]);

        int playerNumber = playerNames.length;
        int[] diffs = new int[playerNumber];

        for (int j = 0; j < playerNumber; j++) {
            int playerAnswer = getPlayerAnswer(playerNames[j]);
            diffs[j] = abs(ANSWERS[i] - playerAnswer);
        }
        int[] playerIdxSortedByDiff = sortedIdx(diffs);

        System.out.println("The correct answer is: " + ANSWERS[i]);

        computeScores(playerIdxSortedByDiff, playerNames, diffs, totalScores);
    }

    private static int getPlayerAnswer(String playerName) {
        while (true) {
            System.out.println(playerName + ", your answer: ");
            String input = SCANNER.nextLine();
            try {
                return parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(input + " is not an integer! Try again.");
            }
        }
    }

    private static void computeScores(int[] playerIdxSortedByDiff, String[] playerNames, int[] diffs, int[] totalScores) {
        System.out.println("Scores:");
        System.out.printf("%-20s | %-15s | %-12s%n", "Player", "This Question", "Total");
        System.out.println("---------------------+----------------+--------------");

        int score = 0, prevScore = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (i > 0 && diffs[playerIdxSortedByDiff[i]] == diffs[playerIdxSortedByDiff[i - 1]]) {
                score = prevScore;
            } else {
                score = playerNames.length - i;
                prevScore = score;
            }
            totalScores[playerIdxSortedByDiff[i]] += score;

            System.out.printf("%-20s | %-15d | %-12d%n",
                    playerNames[playerIdxSortedByDiff[i]],
                    score,
                    totalScores[playerIdxSortedByDiff[i]]);
        }
    }

    private static String[] createQuestions() {
        String[] questions = new String[20];

        questions[0] = "What is the radius of Earth in kilometers?";
        questions[1] = "What is the height of Mount Everest in meters?";
        questions[2] = "How many elements are in the periodic table?";
        questions[3] = "How many planets are in our solar system?";
        questions[4] = "How many sides does a hexagon have?";
        questions[5] = "How many keys are on a standard piano?";
        questions[6] = "How many Meters long is the Great Wall of China?";
        questions[7] = "How many centimeters are in one meter?";
        questions[8] = "What is the deepest point in the ocean in meters?";
        questions[9] = "How many bones are in an adult human body?";
        questions[10] = "How many countries are in Africa?";
        questions[11] = "How many squares are on a standard chessboard?";
        questions[12] = "What is the boiling point of water in Celsius?";
        questions[13] = "How many sides does an octagon have?";
        questions[14] = "How many letters are in the English alphabet?";
        questions[15] = "How many teeth does a typical adult human have?";
        questions[16] = "How many chambers does the human heart have?";
        questions[17] = "What is the freezing point of water in Celsius?";
        questions[18] = "How many kilometers wide is the Grand Canyon at its widest point?";
        questions[19] = "How many continents are there?";

        return questions;
    }

    private static int[] createAnswers() {
        int[] answers = new int[20];

        answers[0] = 6371;
        answers[1] = 8849;
        answers[2] = 118;
        answers[3] = 8;
        answers[4] = 6;
        answers[5] = 88;
        answers[6] = 21196;
        answers[7] = 100;
        answers[8] = 11034;
        answers[9] = 206;
        answers[10] = 54;
        answers[11] = 64;
        answers[12] = 100;
        answers[13] = 8;
        answers[14] = 26;
        answers[15] = 32;
        answers[16] = 4;
        answers[17] = 0;
        answers[18] = 29;
        answers[19] = 7;

        return answers;
    }

}