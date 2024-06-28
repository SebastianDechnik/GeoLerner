import javax.swing.*;
import java.util.Random;
// Test przeklikuje pytania i sprawdza czy quiz się zakończył
public class GeneralTest {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        int correctAnswers = 0;

        for (int i = 0; i < 5; i++) {
            // Kliknięcie losowego przycisku
            char clickedButton = simulateRandomButtonClick(quiz);

            // Opóźnienie na 2 sekundy
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

          
        }
        String text = quiz.textField.getText();
        if(text=="Wynik Quizu"){
        System.err.println("Quiz się zakończył sukcesem");
        }
        else{
            System.err.println("nie ok");
        }
      //  System.exit(0);
    }

    private static char simulateRandomButtonClick(Quiz quiz) {
        JButton[] buttons = {quiz.buttonA, quiz.buttonB, quiz.buttonC, quiz.buttonD};
        Random random = new Random();
        int randomIndex = random.nextInt(buttons.length);
        buttons[randomIndex].doClick();
        return buttons[randomIndex].getText().charAt(0);
    }
}
