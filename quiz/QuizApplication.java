import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static int score = 0;
    private static int questionIndex = 0;
    private static String[][] questions = {
            {"What is the capital of France?", "A. London", "B. Paris", "C. Berlin", "D. Madrid", "B"},
            {"Which planet is known as the Red Planet?", "A. Venus", "B. Mars", "C. Jupiter", "D. Saturn", "B"},
            {"What is the largest mammal in the world?", "A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Lion", "B"}
    };

    public static void main(String[] args) {
        Timer timer = new Timer();
        Scanner scanner = new Scanner(System.in);

        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Time's up!");
                showResult();
                System.exit(0);
            }
        };

        timer.schedule(task, 20000); // 20 seconds timer

        while (questionIndex < questions.length) {
            displayQuestion();
            String answer = scanner.nextLine().toUpperCase();
            if (answer.equals(questions[questionIndex][5])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
            questionIndex++;
        }

        showResult();
    }

    private static void displayQuestion() {
        System.out.println(questions[questionIndex][0]);
        for (int i = 1; i < 5; i++) {
            System.out.println(questions[questionIndex][i]);
        }
    }

    private static void showResult() {
        System.out.println("Quiz ended!");
        System.out.println("Your final score is: " + score + "/" + questions.length);
        System.out.println("Summary of correct/incorrect answers:");
        for (int i = 0; i < questions.length; i++) {
            if (questions[i][5].equals("B")) {
                System.out.println("Question " + (i + 1) + ": Correct");
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }
    }
}
