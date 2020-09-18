package fr.parisnanterre.miage.rps.model;

public class RockPaperScissors {
        public RockPaperScissors() {

        }

        // Partie 3
        // Retourne toujours la meme valeur
        // Les parametres ne sont pas utilises
        public Result play(Play p1, Play p2) {
                switch(p1) {
                        case PAPER:
                             switch(p2) {
                                     case PAPER:
                                             return Result.TIE;
                                     case ROCK:
                                             return Result.WIN;
                                     case SCISSORS:
                                             return  Result.LOST;
                             }
                        case ROCK:
                                switch(p2) {
                                        case PAPER:
                                                return Result.LOST;
                                        case ROCK:
                                                return Result.TIE;
                                        case SCISSORS:
                                                return Result.WIN;
                                }
                        case SCISSORS:
                                switch(p2) {
                                        case PAPER:
                                                return Result.WIN;
                                        case ROCK:
                                                return Result.LOST;
                                        case SCISSORS:
                                                return Result.TIE;
                                }
                }
                return null;
        }
}
