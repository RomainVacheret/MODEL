package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {
    RockPaperScissors rps;
    List p1Moves;
    List p2Moves;
    Player p1;
    Player p2;
    Player p3;

    @BeforeMethod
    public void setup() {
        rps = new RockPaperScissors();

        List<Play> p1Moves = this.assignMove1();;
        List<Play> p2Moves = this.assignMove2();;

        p1 = new Player("Player1", p1Moves);
        p2 = new Player("Player2", p2Moves);
        p3 = new Player("Player3", p1Moves);
    }

    @AfterMethod
    public void tearDown() {
        rps = null;
        p1Moves = null;
        p2Moves = null;
        p1 = null;
        p2 = null;
        p3 = null;
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

    private List<Play> assignMove1() { return Arrays.asList(Play.SCISSORS, Play.PAPER, Play.ROCK); }
    private List<Play> assignMove2() { return Arrays.asList(Play.PAPER, Play.ROCK, Play.SCISSORS); }

    @Test
    public void testWinPlay() { assertEquals(rps.play(p1, p2), Result.WIN);}

    @Test
    public void testTiePlay() {
        p1.resetMoves();
        p1.setScore(0);
        assertEquals(rps.play(p1, p3), Result.TIE);
    }

    @Test
    public void testLostPlay() {
        p1.resetMoves();
        p2.resetMoves();
        p1.setScore(0);
        p2.setScore(0);
        assertEquals(rps.play(p2, p1), Result.LOST);
    }


    @Test(dataProvider = "winProvider")
    public void testWinPlay(Play p1, Play p2) {
        assertEquals(rps.play(p1, p2), Result.WIN);
    }

    @Test(dataProvider = "tieProvider")
    public void testTiePlay(Play p1, Play p2) {
        assertEquals(rps.play(p1, p2), Result.TIE);
    }

    @Test(dataProvider = "lostProvider")
    public void testLostPlay(Play p1, Play p2) {
        assertEquals(rps.play(p1, p2), Result.LOST);
    }

    @Parameters({"papier", "pierre"})
    @Test
    public void testWinPlay(String p1, String p2) {
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), Result.WIN);
    }

    @Parameters({"papier", "papier"})
    @Test
    public void testTiePlay(String p1, String p2) {
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), Result.TIE);
    }

    @Parameters({"papier", "ciseaux"})
    @Test
    public void testLostPlay(String p1, String p2) {
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), Result.LOST);
    }
}