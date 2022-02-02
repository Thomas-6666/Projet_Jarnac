package Test;

import Modele.BaseDeDonnee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BDDTest {

    protected BaseDeDonnee bdd;

    @BeforeEach
    void setUp() throws Exception{
        bdd = BaseDeDonnee.getInstance();
    }

    @AfterEach
    void tearDown() throws Exception{
        bdd = null;
    }

    @Test
    void verificationTest1(){
        assertTrue(bdd.verification("oui"));
    }

    @Test
    void verificationTest2(){
        assertFalse(bdd.verification("aaaaaaa"));
    }


}
