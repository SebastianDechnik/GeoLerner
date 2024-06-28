import javax.swing.*;
import java.util.Random;
import java.awt.*;
// Test przeklikuje pytania i sprawdza czy wyświetla sie jeden z kolorów: zielony/czerwony na przycisku zgodnie z poprawnością odpowiedzi
public class ColorTest {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        int correctAnswers = 0;

        for (int i = 0; i < 5; i++) {
            JButton clickedButton = simulateRandomButtonClick(quiz);
            Color bgColor = clickedButton.getBackground();
            if(colorsAreEqual(bgColor,new Color(50,196,52) )){
                System.err.println("zielony");
            }
            else{
                System.err.println("czerwony");
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
      
        System.exit(0);
    }

    private static JButton simulateRandomButtonClick(Quiz quiz) {
        JButton[] buttons = {quiz.buttonA, quiz.buttonB, quiz.buttonC, quiz.buttonD};
        Random random = new Random();
        int randomIndex = random.nextInt(buttons.length);
        buttons[randomIndex].doClick();
        return buttons[randomIndex];
    }
    private static char simulateButtonClick(Quiz quiz) {
        quiz.buttonC.doClick();
        return quiz.buttonC.getText().charAt(0);
    }
    public static boolean colorsAreEqual(Color color1, Color color2) {
        return color1.getRed() == color2.getRed()
            && color1.getGreen() == color2.getGreen()
            && color1.getBlue() == color2.getBlue();
    }
}
