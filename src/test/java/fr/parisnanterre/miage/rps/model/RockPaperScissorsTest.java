package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.*;

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

    @DataProvider(name = "winProvider")
    public Object[][] createWinData() {
        return new Object[][] {{Play.SCISSORS, Play.PAPER}, {Play.PAPER, Play.ROCK}, {Play.ROCK, Play.SCISSORS}};
    }

    @DataProvider(name = "tieProvider")
    public Object[][] createTieData() {
        return new Object[][] {{Play.SCISSORS, Play.SCISSORS}, {Play.PAPER, Play.PAPER}, {Play.ROCK, Play.ROCK}};
    }

    @DataProvider(name = "lostProvider")
    public Object[][] createLoseData() {
        return new Object[][] {{Play.PAPER, Play.SCISSORS}, {Play.ROCK, Play.PAPER}, {Play.SCISSORS, Play.ROCK}};
    }

    @Test(dataProvider = "winProvider")
    public void testPlayWin(Play p1, Play p2) {
        assertEquals(rps.play(p1, p2), Result.WIN);
    }

    @Test(dataProvider = "tieProvider")
    public void testPlayTie(Play p1, Play p2) {
        assertEquals(rps.play(p1, p2), Result.TIE);
    }

    @Test(dataProvider = "lostProvider")
    public void testPlayLost(Play p1, Play p2) {
        assertEquals(rps.play(p1, p2), Result.LOST);
    }


//    @Parameters({"papier", "papier"})
//    @Test
//    public void testPlay(String p1, String p2) {
//        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), Result.WIN);
//    }
//
//    @Parameters({"papier", "papier"})
//    @Test
//    public void testTiePlay(String p1, String p2) {
//        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), Result.TIE);
//    }
//
//    @Parameters({"papier", "ciseaux"})
//    @Test
//    public void testLostPlay(String p1, String p2) {
//        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), Result.LOST);
//    }



}