import javax.swing.*;
// test sprawdza czy wszystkie pytania w bazie się nie powtarzają
public class QuestionTest {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        String[] questions = quiz.questions;

        boolean allDifferent = true;
        for (int i = 0; i < questions.length; i++) {
            for (int j = i + 1; j < questions.length; j++) {
                if (questions[i].equals(questions[j])) {
                    allDifferent = false;
                    break;
                }
            }
            if (!allDifferent) {
                break;
            }
        }

        if (allDifferent) {
            System.out.println("Każde pytanie jest inne.");
        } else {
            System.out.println("Błąd: Niektóre pytania są takie same.");
        }

        System.exit(0);
    }
}
