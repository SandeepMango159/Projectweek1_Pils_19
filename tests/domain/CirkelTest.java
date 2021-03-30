package domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CirkelTest {



    private Punt puntGeldig;
    private int straalGeldig;

    private Punt ongeldig;


    @Before
    public void setup() throws Exception {
        puntGeldig = new Punt(10,20);
        straalGeldig = 15;
    }

    @Test
    public void Test_cirkel_geldig_middelpunt_en_straal() {
        Cirkel test = new Cirkel(puntGeldig, straalGeldig);

        assertEquals(puntGeldig, test.getMiddelPunt());
        assertEquals(straalGeldig, test.getRadius());
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_cirkel_met_null_als_middelpunt_gooit_IllegalArgumentException() {
        Cirkel test = new Cirkel(null, straalGeldig);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_cirkel_met_negatieve_straal_gooit_IllegalArgumentException() {
        Cirkel test = new Cirkel(puntGeldig, -5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_cirkel_met_straal_nul_gooit_IllegalArgumentExeception() {
        Cirkel test = new Cirkel(puntGeldig, 0);
    }

    @Test
    public void Test_twee_cirkels_zijn_gelijk_als_zelfde_middelpunt_en_straal() {
        Cirkel test1 = new Cirkel(puntGeldig, straalGeldig);
        Cirkel test2 = new Cirkel(puntGeldig, straalGeldig);

        assertEquals(test1, test2);
    }


    @Test
    public void Test_twee_cirkels_zijn_verschillend_als_tweede_cirkel_null_is() {
        Cirkel test1 = new Cirkel(puntGeldig, straalGeldig);
        assertNotEquals(test1, null);
    }

    @Test
    public void Test_twee_cirkels_zijn_verschillend_als_middelpunt_verschilt() {
        Cirkel test1 = new Cirkel(puntGeldig, straalGeldig);

        Punt p2 = new Punt(100,100);
        Cirkel test2 = new Cirkel(p2, straalGeldig);

        assertNotEquals(test1, test2);
    }

    @Test
    public void Test_twee_cirkels_zijn_verschillend_als_straal_verschilt() {
        Cirkel test1 = new Cirkel(puntGeldig, straalGeldig);
        Cirkel test2 = new Cirkel(puntGeldig, 300);

        assertNotEquals(test1, test2);
    }

    @Test
    public void Test_omhullendevorm(){
        Cirkel test1 = new Cirkel(new Punt(100,150) ,10);
        Omhullende omhullende = new Omhullende(new Punt(90,140),2*10, 2*10 );
        assertEquals(omhullende,test1.getOmhullende());
    }


}
