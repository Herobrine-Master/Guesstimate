package com.herobrinemaster.guesstimate;

import static com.herobrinemaster.guesstimate.GuesstimateUtils.shuffleQuestionsAndAnswers;

public class Questions {
    public static final String[] QUESTIONS;
    public static final int[] ANSWERS;

    static {
        QUESTIONS = createQuestions();
        ANSWERS = createAnswers();
        shuffleQuestionsAndAnswers(QUESTIONS, ANSWERS);
    }

    private static String[] createQuestions() {
        String[] questions = new String[50];

        questions[0] = "What is the mean radius of Earth in kilometers?";
        questions[1] = "What is the official height of Mount Everest in meters?";
        questions[2] = "How many confirmed elements are in the periodic table?";
        questions[3] = "How many kilometers long is the Great Wall of China according to comprehensive archaeological surveys?";
        questions[4] = "How many bones are in an adult human body?";
        questions[5] = "What is the roof height of the Burj Khalifa in meters?";
        questions[6] = "What is the total height of the Eiffel Tower in meters, including its antenna?";
        questions[7] = "What is the official height of Mount Kilimanjaro in meters?";
        questions[8] = "What is the total height of Angel Falls, the world's tallest waterfall, in meters?";
        questions[9] = "What is the maximum depth of Lake Baikal in meters?";
        questions[10] = "What is the length of the main Trans-Siberian Railway line from Moscow to Vladivostok in kilometers?";
        questions[11] = "What is the length of the main suspension span of the Golden Gate Bridge in meters?";
        questions[12] = "How many rooms are in Buckingham Palace?";
        questions[13] = "Approximately how many rooms are in the Palace of Versailles in France?";
        questions[14] = "What is the length of the Suez Canal in kilometers (rounded to the nearest whole kilometer)?";
        questions[15] = "What is the roof height of the Empire State Building in meters?";
        questions[16] = "What is the speed of sound in air at 20 degrees Celsius in meters per second?";
        questions[17] = "What is the melting point of pure gold in degrees Celsius (to the nearest whole degree)?";
        questions[18] = "What is the melting point of pure iron in degrees Celsius?";
        questions[19] = "What is the melting point of pure silver in degrees Celsius (to the nearest whole degree)?";
        questions[20] = "What is the melting point of pure copper in degrees Celsius (to the nearest whole degree)?";
        questions[21] = "How many sonnets are in Shakespeare's 1609 quarto collection?";
        questions[22] = "How many lines of verse are in Homer's epic poem the Iliad?";
        questions[23] = "How many Earth days does it take for Mars to complete one orbit around the Sun (to the nearest whole day)?";
        questions[24] = "What is the orbital period of Neptune around the Sun in Earth years (to the nearest whole year)?";
        questions[25] = "What is the mean surface temperature of Venus in degrees Celsius (to the nearest whole degree)?";
        questions[26] = "What is the mean radius of the Moon in kilometers (to the nearest whole kilometer)?";
        questions[27] = "What is the mean radius of Mars in kilometers (to the nearest whole kilometer)?";
        questions[28] = "What is the circumference of Earth at the equator in kilometers (to the nearest whole kilometer)?";
        questions[29] = "What is the speed of light in a vacuum in kilometers per second (to the nearest whole kilometer per second)?";
        questions[30] = "What is standard atmospheric pressure at sea level in hectopascals (hPa, to the nearest whole number)?";
        questions[31] = "What is the official elevation of Mount Fuji in meters?";
        questions[32] = "What is the elevation of Mount Elbrus, the highest peak in Europe, in meters?";
        questions[33] = "What is the official elevation of Denali, the highest peak in North America, in meters?";
        questions[34] = "What is the total architectural height of the CN Tower in Toronto in meters (to the nearest whole meter)?";
        questions[35] = "What is the architectural height of Taipei 101 in meters (to the nearest whole meter)?";
        questions[36] = "What was the original height of the Great Pyramid of Giza in meters (to the nearest whole meter)?";
        questions[37] = "In what year did the passenger liner RMS Titanic sink?";
        questions[38] = "In what year did the Apollo 11 mission land the first humans on the Moon?";
        questions[39] = "In what year did the Western Roman Empire traditionally fall?";
        questions[40] = "In what year did the French Revolution begin with the storming of the Bastille?";
        questions[41] = "In what year was the Magna Carta granted by King John of England?";
        questions[42] = "In what year was the United States Declaration of Independence adopted?";
        questions[43] = "In what year did Christopher Columbus first reach the Americas?";
        questions[44] = "In what year did Constantinople fall to the Ottoman Empire?";
        questions[45] = "In what year did the Chernobyl nuclear disaster occur?";
        questions[46] = "In what year were the first modern Olympic Games held in Athens, Greece?";
        questions[47] = "In what year did Yuri Gagarin become the first human to travel into space?";
        questions[48] = "In what year did the Berlin Wall fall, opening the border between East and West Berlin?";
        questions[49] = "In what year was the Battle of Hastings fought in England?";

        return questions;
    }

    private static int[] createAnswers() {
        int[] answers = new int[50];

        answers[0] = 6371;
        answers[1] = 8849;
        answers[2] = 118;
        answers[3] = 21196;
        answers[4] = 206;
        answers[5] = 828;
        answers[6] = 330;
        answers[7] = 5895;
        answers[8] = 979;
        answers[9] = 1642;
        answers[10] = 9288;
        answers[11] = 1280;
        answers[12] = 775;
        answers[13] = 2300;
        answers[14] = 193;
        answers[15] = 381;
        answers[16] = 343;
        answers[17] = 1064;
        answers[18] = 1538;
        answers[19] = 962;
        answers[20] = 1085;
        answers[21] = 154;
        answers[22] = 15693;
        answers[23] = 687;
        answers[24] = 165;
        answers[25] = 464;
        answers[26] = 1737;
        answers[27] = 3390;
        answers[28] = 40075;
        answers[29] = 299792;
        answers[30] = 1013;
        answers[31] = 3776;
        answers[32] = 5642;
        answers[33] = 6190;
        answers[34] = 553;
        answers[35] = 508;
        answers[36] = 147;
        answers[37] = 1912;
        answers[38] = 1969;
        answers[39] = 476;
        answers[40] = 1789;
        answers[41] = 1215;
        answers[42] = 1776;
        answers[43] = 1492;
        answers[44] = 1453;
        answers[45] = 1986;
        answers[46] = 1896;
        answers[47] = 1961;
        answers[48] = 1989;
        answers[49] = 1066;

        return answers;
    }
}
