package CodSoft;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int timelimit = 60;
    private static final String[] questions = {
            "Which year did India get Independence?",
            "What is the capital of Korea?",
            "Which is the largest ocean in Earth?",
            "What is the largest mammal in the world?",
            "CBI abbreviation",
            "No of states of India"
    };

    private static final String[] correctAns = {
            "1947",
            "Seoul",
            "pacific",
            "Blue Whale",
            "central beureau of investigation",
            "28"
            // Add corresponding correct answers
    };

    private static int score = 0;

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int sec = timelimit;

            @Override
            public void run() {
                if (sec > 0) {
                    if(sec%10==0){
                        System.out.println("Time left: " + sec + " seconds");
                    }
                    sec--;
                } else {
                    System.out.println("Time's up!");
                    timer.cancel();
                    Result();
                    System.exit(0);
                }
            }
        }, 0, 1000); // Schedule the timer to decrement every second

        start();
        Result();
    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(correctAns[i])) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + correctAns[i] + "\n");
            }
        }
    }

    private static void Result() {
        System.out.println("Quiz ended. Your score: " + score + " out of " + questions.length);
    }
}
