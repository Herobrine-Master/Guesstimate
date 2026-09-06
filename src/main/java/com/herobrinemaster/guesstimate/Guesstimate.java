package com.herobrinemaster.guesstimate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.herobrinemaster.guesstimate.GuesstimateUtils.sortedIdx;
import static com.herobrinemaster.guesstimate.Questions.ANSWERS;
import static com.herobrinemaster.guesstimate.Questions.QUESTIONS;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.String.join;

public class Guesstimate {
    private static final Scanner SCANNER = new Scanner(System.in);

    static void main() {
        System.out.println("Hello and welcome to Guesstimate!");

        System.out.println("Please enter the number of players:");
        int playerNumber = parseInt(SCANNER.nextLine());

        System.out.println("Please enter the number of questions. Recommended: 10 to 15 questions.");
        int questionNumber = parseInt(SCANNER.nextLine());

        int[] totalScores = new int[playerNumber];
        String[] playerNames = inputPlayerNames(playerNumber);

        for (int i = 0; i < questionNumber; i++)
            playRound(i, playerNames, totalScores);

        findBestPlayer(playerNames, totalScores);
    }

    private static void findBestPlayer(String[] playerNames, int[] totalScores) {
        int bestPlayerScore = 0;
        List<String> bestPlayers = new ArrayList<>();
        for (int i = 0; i < playerNames.length; i++) {
            if (totalScores[i] > bestPlayerScore) {
                bestPlayerScore = totalScores[i];
            }
        }

        for (int i = 0; i < playerNames.length; i++) {
            if (bestPlayerScore == totalScores[i]) {
                bestPlayers.add(playerNames[i]);
            }
        }

        String winners = join(", ", bestPlayers);
        String suffix = bestPlayers.size() > 1 ? "s are" : " is";

        System.out.println("\nThe Winner" + suffix + "... " + winners +  "!!!");
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
}