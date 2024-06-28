import javax.swing.*;
import java.util.Random;
// Test polegający na sprawdzeniu czy pytania numerują się poprawnie
public class indextest {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        int index = 1;
        String temporarytext;
        for (int i = 0; i < 5; i++) {
            // Simulate clicking a random button
            char clickedButton = simulateRandomButtonClick(quiz);
            temporarytext = "Pytanie:" + index;
            if (quiz.textField.getText().equals(temporarytext)) {
                System.err.println("Zgadza się");
                
            }
            index++;
            // Delay for 2 seconds
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    private static char simulateRandomButtonClick(Quiz quiz) {
        JButton[] buttons = {quiz.buttonA, quiz.buttonB, quiz.buttonC, quiz.buttonD};
        Random random = new Random();
        int randomIndex = random.nextInt(buttons.length);
        buttons[randomIndex].doClick();
        return buttons[randomIndex].getText().charAt(0);
    }
}