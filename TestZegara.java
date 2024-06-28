package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;

// test sprawdza czy timer zaczyna odliczanie od 15s

public class TestZegara {
    private Zegar zegar;
    private JLabel poleZegara;

    @BeforeEach
    public void setUp() {
        zegar = new Zegar();
        poleZegara = new JLabel();
    }
    @Test
    public void testInitialTime() {
        assertEquals(15, zegar.getTime(), "Odliczanie startuje od 15s");
    }
}
