package Test;

import Modele.BaseDeDonnee;
import Modele.Joueur;
import Modele.Partie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JoueurTest {

    protected Joueur joueur;

    @BeforeEach
    void setUp(){
        joueur = new Joueur("Joueur", new Partie(1), new BaseDeDonnee());
    }

    @AfterEach
    void tearDown(){
        joueur = null;
    }

    @Test
    void jouerT1(){
        joueur.getReserve().ajouterLettre("o");
        joueur.getReserve().ajouterLettre("u");
        joueur.getReserve().ajouterLettre("i");
        assertTrue(joueur.jouer("oui"));
    }

    @Test
    void jouerT2(){
        joueur.getReserve().ajouterLettre("n");
        joueur.getReserve().ajouterLettre("o");
        joueur.getReserve().ajouterLettre("n");
        assertFalse(joueur.jouer("oui"));
    }

}
