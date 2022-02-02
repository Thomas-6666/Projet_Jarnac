package Test;

import Modele.BaseDeDonnee;
import Modele.Joueur;
import Modele.Partie;
import Modele.Plateau;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlateauTest {

    protected Plateau p;

    @BeforeEach
    void setUp(){
        p = new Plateau(new Joueur("joueur"));
    }

    @AfterEach
    void tearDown(){
        p = null;
    }

    @Test
    void ajouterMotTest1(){
        assertTrue(p.ajouterMot("oui"));
    }

    @Test
    void ajouterMotTest2(){
        assertFalse(p.ajouterMot("bbbb"));
    }

    @Test
    void compterScoreTest1(){
        p.ajouterMot("oui");
        assertEquals(9, p.compterScore());
    }

    @Test
    void compterScoreTest2(){
        p.ajouterMot("toit");
        assertEquals(16, p.compterScore());
    }

    @Test
    void compterScoreTest3(){
        p.ajouterMot("ecran");
        assertEquals(25, p.compterScore());
    }

    @Test
    void compterScoreTest4(){
        p.ajouterMot("maison");
        assertEquals(36, p.compterScore());
    }

    @Test
    void compterScoreTest5(){
        p.ajouterMot("clavier");
        assertEquals(49, p.compterScore());
    }

    @Test
    void compterScoreTest6(){
        p.ajouterMot("poubelle");
        assertEquals(64, p.compterScore());
    }

    @Test
    void compterScoreTest7(){
        p.ajouterMot("asphyxiez");
        assertEquals(81, p.compterScore());
    }
}
