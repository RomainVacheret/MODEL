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

        public Result play(Player p1, Player p2) {
                int p1Plays = p1.getNumberOfPlays();
                int p2Plays = p2.getNumberOfPlays();
                int minPlays = p1Plays < p2Plays ? p1Plays : p2Plays;

                for(int i = 0; i < minPlays; i++) {
                        Result result = this.play(p1.getNextMove(), p2.getNextMove());

                        if(result == Result.LOST || result == Result.TIE) {
                                p2.setScore(p2.getScore() + 1);
                        }
                        if(result != Result.LOST)        {
                                p1.setScore(p1.getScore() + 1);
                        }
                }

                if(p1.getScore() == p2.getScore()) {
                        return Result.TIE;
                }
                return p1.getScore() < p2.getScore() ? Result.LOST : Result.WIN;
        }
}
