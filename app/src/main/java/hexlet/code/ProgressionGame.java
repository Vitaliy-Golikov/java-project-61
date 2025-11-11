package hexlet.code;

import java.util.Random;

public class ProgressionGame implements Game {
    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

    @Override
    public String getRules() {
        return "What number is missing in the progression?";
    }

    @Override
    public String generateQuestion() {
        int startProgression = random.nextInt(5, 11);
        int addNumber = random.nextInt(1, 6);
        int lengthProgression = 10;
        int delNumber = random.nextInt(lengthProgression);
        int progressionNum = startProgression;
        currentQuestion = "";

        for (int i = 0; i < lengthProgression; i++) {

            if (i == delNumber) {
                currentQuestion += " " + "..";
                currentAnswer = String.valueOf(progressionNum);
            } else {
                currentQuestion += " " + String.valueOf(progressionNum);
            }

            progressionNum += addNumber;

        }

        return currentQuestion.trim();

    }

    @Override
    public  String getCorrectAnswer() {
        return currentAnswer;
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return currentAnswer.equals(userAnswer);
    }
}
