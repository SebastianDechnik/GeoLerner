package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;

// test sprawdza czy odliczanie się zatrzymuje

public class TestStopCountdown {
    private Zegar zegar;
    private JLabel poleZegara;

    @BeforeEach
    public void setUp() {
        zegar = new Zegar();
        poleZegara = new JLabel();
    }
    @Test
    public void testStopCountdown() {
        zegar.startCountdown(poleZegara);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        zegar.stopCountdown();
        int timeAfterStop = zegar.getTime();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(timeAfterStop, zegar.getTime(), "Odliczanie się zatrzymuje");
    }
}
