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
        res = new Reserve(new Joueur("joueur"));
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
        res.ajouterLettre("A");
        assertEquals("A", res.piocher());
    }

    @Test
    void piocherVoyelleTest(){
        res.ajouterLettre("A");
        assertEquals("A", res.piocherVoyelle());
    }

    @Test
    void piocherVoyelleTest2(){
        assertThrows(Exception.class, ()->{
            res.piocherVoyelle();
        });
    }

    @Test
    void piocherVoyelleTest3(){
        res.ajouterLettre("B");
        assertEquals("B", res.piocherVoyelle());
    }

    @Test
    void piocherConsonneTest(){
        res.ajouterLettre("B");
        assertEquals("B", res.piocherConsonne());
    }

    @Test
    void piocherCononneTest2(){
        assertThrows(Exception.class, ()->{
            res.piocherConsonne();
        });
    }

    @Test
    void piocherConsonneTest3(){
        res.ajouterLettre("A");
        assertEquals("A", res.piocherConsonne());
    }

    @Test
    void removeTest1(){
        res.ajouterLettre("A");
        assertTrue(res.remove("A"));
    }

    @Test
    void removeTest2(){
        res.ajouterLettre("A");
        assertFalse(res.remove("B"));
    }

    @Test
    void removeTest3(){
        assertFalse(res.remove("A"));
    }

    @Test
    void containsVT1(){
        res.ajouterLettre("A");
        assertTrue(res.containsVoyelle());
    }

    @Test
    void containsVT2(){
        res.ajouterLettre("B");
        assertFalse(res.containsVoyelle());
    }

    @Test
    void containsVT3(){
        assertFalse(res.containsVoyelle());
    }

    @Test
    void containsCT1(){
        res.ajouterLettre("B");
        assertTrue(res.containsConsonne());
    }

    @Test
    void containsCT2(){
        res.ajouterLettre("A");
        assertFalse(res.containsConsonne());
    }

    @Test
    void containsCT3(){
        assertFalse(res.containsConsonne());
    }


}
