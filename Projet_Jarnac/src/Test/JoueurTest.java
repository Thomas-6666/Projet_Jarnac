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
    protected Joueur other;

    @BeforeEach
    void setUp(){
        Partie p = Partie.getInstance();
        joueur = new Joueur("Joueur");
        other = new Joueur("Joueur2");
        p.setJoueur(joueur, 1);
        p.setJoueur(other, 2);

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

    @Test
    void elT1(){
        joueur.getReserve().ajouterLettre("O");
        joueur.getReserve().ajouterLettre("U");
        joueur.getReserve().ajouterLettre("I");
        assertTrue(joueur.echangerLettre("oui"));
    }

    @Test
    void elT2(){
        assertFalse(joueur.echangerLettre("non"));
    }

    @Test
    void elT3(){
        assertFalse(joueur.echangerLettre("no"));
    }

}
