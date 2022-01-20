package Test;

import Modele.BaseDeDonnee;
import Modele.Joueur;
import Modele.Partie;
import Modele.Reserve;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReserveTest {


    protected Reserve res;

    @BeforeEach
    void setUp(){
        res = new Reserve(new Joueur("joueur", new Partie(1), new BaseDeDonnee()));
    }

    @AfterEach
    void tearDown(){
        res = null;
    }

    @Test
    void piocherTest(){
        assertThrows(Exception.class, ()->{
            res.piocher();
        });
    }

    @Test
    void piocherTest2(){
        res.ajouterLettre("a");
        assertEquals("a", res.piocher());
    }

    @Test
    void piocherVoyelleTest(){
        res.ajouterLettre("a");
        assertEquals("a", res.piocherVoyelle());
    }

    @Test
    void piocherVoyelleTest2(){
        assertThrows(Exception.class, ()->{
            res.piocherVoyelle();
        });
    }

    @Test
    void piocherVoyelleTest3(){
        res.ajouterLettre("b");
        assertEquals("b", res.piocherVoyelle());
    }

    @Test
    void piocherConsonneTest(){
        res.ajouterLettre("b");
        assertEquals("b", res.piocherConsonne());
    }

    @Test
    void piocherCononneTest2(){
        assertThrows(Exception.class, ()->{
            res.piocherConsonne();
        });
    }

    @Test
    void piocherConsonneTest3(){
        res.ajouterLettre("a");
        assertEquals("a", res.piocherConsonne());
    }

    @Test
    void removeTest1(){
        res.ajouterLettre("a");
        assertTrue(res.remove("a"));
    }

    @Test
    void removeTest2(){
        res.ajouterLettre("a");
        assertFalse(res.remove("b"));
    }

    @Test
    void removeTest3(){
        assertFalse(res.remove("a"));
    }

    @Test
    void containsVT1(){
        res.ajouterLettre("a");
        assertTrue(res.containsVoyelle());
    }

    @Test
    void containsVT2(){
        res.ajouterLettre("b");
        assertFalse(res.containsVoyelle());
    }

    @Test
    void containsVT3(){
        assertFalse(res.containsVoyelle());
    }

    @Test
    void containsCT1(){
        res.ajouterLettre("b");
        assertTrue(res.containsConsonne());
    }

    @Test
    void containsCT2(){
        res.ajouterLettre("a");
        assertFalse(res.containsConsonne());
    }

    @Test
    void containsCT3(){
        assertFalse(res.containsConsonne());
    }


}
