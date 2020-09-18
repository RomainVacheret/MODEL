package fr.parisnanterre.miage.rps.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Player {
    private final String name;
    private int score;
    private final Collection<Play> plays;

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
}
