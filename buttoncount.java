import javax.swing.*;
// test sprawdza czy wyswietlaja sie 4 przyciski
public class buttoncount {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        int buttonCount = quiz.centerPanel.getComponentCount();
        if (buttonCount == 4) {
            System.out.println("Pojawiają się 4 przyciski");
        } else {
            System.out.println("Błąd: Na formularzu nie znajdują się cztery przyciski.");
        }

        System.exit(0);
    }
}
