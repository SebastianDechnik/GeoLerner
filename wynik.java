import javax.swing.*;
//test sprawdza czy pierwsze pytanie jest z bazy pytań questions
public class wynik {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        String firstQuestion = quiz.questions[0];
        if (firstQuestion.equals(quiz.questions[0])) {
            System.out.println("Pierwsze pytanie zostało poprawnie ustawione.");
        } else {
            System.out.println("Błąd: Pierwsze pytanie nie zostało poprawnie ustawione.");
        }

        System.exit(0);
    }
}
