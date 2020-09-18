package fr.parisnanterre.miage.rps.model;

import java.util.HashMap;
import java.util.Map;

public enum Play {
    ROCK(0), PAPER(1), SCISSORS(2);

    private static Map values = new HashMap<>();
    private int value;

    private Play(int value) {
        this.value = value;
    }

    static {
        for(Play play: Play.values()) {
            values.put(play.value, play);
        }
    }

    public static Play valueOf(int playType) {
        return (Play) values.get(playType);
    }
}
