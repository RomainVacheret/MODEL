package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {
    RockPaperScissors rps;

    @BeforeMethod
    public void setup() {
        rps = new RockPaperScissors();
    }

    @AfterMethod
    public void tearDown() {
        rps = null;
    }

    @Parameters({"papier", "pierre"})
    @Test
    public void testPlay(String p1, String p2) {
        assertEquals(rps.play(Play.PAPER, Play.SCISSORS), Result.WIN);
//        assertEquals(rps.play(PAP));
    }

}