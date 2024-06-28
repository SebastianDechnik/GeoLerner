import javax.swing.*;
// Test sprawdza, czy wartości przycisków A, B, C i D są różne
public class ButtonValuesTest {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        boolean valuesDifferent = !(quiz.buttonA.getText().equals(quiz.buttonB.getText()) ||
                                    quiz.buttonA.getText().equals(quiz.buttonC.getText()) ||
                                    quiz.buttonA.getText().equals(quiz.buttonD.getText()) ||
                                    quiz.buttonB.getText().equals(quiz.buttonC.getText()) ||
                                    quiz.buttonB.getText().equals(quiz.buttonD.getText()) ||
                                    quiz.buttonC.getText().equals(quiz.buttonD.getText()));

        if (valuesDifferent) {
            System.out.println("Każdy przycisk zwraca inną wartość");
        } else {
            System.out.println("Błąd: Niektóre wartości przycisków są takie same");
        }

        System.exit(0);
    }
}
