package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;

//test sprawdza czy odliczanie timera się zakończyło

public class TestCountdownFinish {
    private Zegar zegar;
    private JLabel poleZegara;

    @BeforeEach
    public void setUp() {
        zegar = new Zegar();
        poleZegara = new JLabel();
    }
    @Test
    public void testCountdownFinish() {
        boolean[] countdownFinished = {false};
        zegar.setCountdownListener(() -> countdownFinished[0] = true);

        zegar.startCountdown(poleZegara);

        try {
            Thread.sleep(16000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(countdownFinished[0], "Odliczanie zajmuje 15 s");
    }

}
