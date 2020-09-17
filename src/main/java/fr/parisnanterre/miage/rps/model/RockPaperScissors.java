package fr.parisnanterre.miage.rps.model;

public class RockPaperScissors {
        public RockPaperScissors() {

        }

        // Partie 3
        // Retourne toujours la meme valeur
        // Les parametres ne sont pas utilises
        Result play(Play p1, Play p2) {
            return Result.LOST;
        }
}
