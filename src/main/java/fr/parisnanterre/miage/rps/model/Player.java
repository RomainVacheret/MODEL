package fr.parisnanterre.miage.rps.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Player {
    private final String name;
    private int score;
    private final Collection<Play> plays;
    private int playsIdx = 0;

    Player(String name, Collection<Play> plays) {
        this.name = name;
        this.score = 0;
        this.plays = new ArrayList<>(plays);
    }

    Player(String name) {
        this.name = name;
        this.score = 0;
        this.plays = new ArrayList<>();
        new Random().ints(20, 0, 3).forEach(integer -> this.plays.add(Play.valueOf(integer)));
    }

    public String getName() { return this.name; }

    public int getNumberOfPlays() { return this.plays.size(); }

    public int getScore() { return this.score; }

    public void setScore(int newScore) { this.score = newScore; }

    // Desole pour cette fonction vraiment sale ... Je n'ai pas encore l'habitude de Java...
    public Play getNextMove() { return (Play) ((List) this.plays).get(this.playsIdx++); }

    public void resetMoves() {this.playsIdx = 0; }
}
