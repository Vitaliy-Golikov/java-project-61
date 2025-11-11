package hexlet.code;

public interface Game {
    String getRules();
    String generateQuestion();
    String getCorrectAnswer();
    boolean checkAnswer(String userAnswer);
}
