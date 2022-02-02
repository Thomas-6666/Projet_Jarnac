package Test;

import Modele.BaseDeDonnee;
import Modele.Joueur;
import Modele.Partie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartieTest {

    protected Partie partie;

    @BeforeEach
    void setUp(){
        partie = new Partie(1);
    }

    @AfterEach
    void tearDown(){
        partie = null;
    }

    @Test
    void arreterTest(){
        Joueur j1 = new Joueur("J1");
        partie.setJoueur(j1,1);
        partie.setJoueur(new Joueur("J2"),2);
        partie.arreter(j1);
        assertTrue(partie.getFini());
    }

    @Test
    void arreterTest2(){
        assertFalse(partie.getFini());
    }
}
