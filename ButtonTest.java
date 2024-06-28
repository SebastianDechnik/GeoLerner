import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;

// test sprawdza czy przyciski zwracaja wartosc, jesli tak to pojawia sie napis w konsoli
public class ButtonTest {
    public static void main(String[] args) {

        Quiz quiz = new Quiz();

        simulateButtonClick(quiz, quiz.buttonA);
        simulateButtonClick(quiz, quiz.buttonB);
        simulateButtonClick(quiz, quiz.buttonC);
        simulateButtonClick(quiz, quiz.buttonD);

        System.exit(0);
    }

    private static void simulateButtonClick(Quiz quiz, JButton button) {
        
        ActionEvent event = new ActionEvent(button, ActionEvent.ACTION_PERFORMED, button.getActionCommand());
        for (ActionListener listener : button.getActionListeners()) {
            listener.actionPerformed(event);
        }
        System.out.println("Przycisk " + button.getText() + " zwraca wartość i program przechodzi dalej.");
    }
}
