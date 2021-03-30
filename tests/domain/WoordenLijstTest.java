package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class WoordenLijstTest {

    private WoordenLijst woordenlijstLeeg;
    private WoordenLijst woordenlijstMetEenGeldigWoord;
    private WoordenLijst woordenlijstMetGeldigeWoorden;
    private ArrayList<String> geldigeWoorden;

    @Before
    public void setUp() throws Exception {
        geldigeWoorden = new ArrayList<String>();
        geldigeWoorden.add("test");
        geldigeWoorden.add("game");
        geldigeWoorden.add("hangman");

        woordenlijstLeeg = new WoordenLijst();

        woordenlijstMetEenGeldigWoord = new WoordenLijst();
        woordenlijstMetEenGeldigWoord.voegToe(geldigeWoorden.get(0));

        woordenlijstMetGeldigeWoorden = new WoordenLijst();
        woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(0));
        woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(1));
        woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(2));

    }

    @Test
    public void test_Constructor_Zonder_parameters_Moet_woordenlijst_aanmaken() {
        WoordenLijst woordenlijstLeeg = new WoordenLijst();
        assertEquals(0,woordenlijstLeeg.getAantalWoorden());
    }

    @Test
    public void test_voegToe_Met_als_parameter_een_geldig_woord_Moet_het_woord_toevoegen() {
        woordenlijstLeeg.voegToe(geldigeWoorden.get(0));
        assertEquals(1,woordenlijstLeeg.getAantalWoorden());
    }

    @Test (expected = DomainException.class)
    public void test_voegToe_Met_als_parameter_null_Moet_een_exception_gooien() {
        woordenlijstLeeg.voegToe(null);
    }

    @Test (expected = DomainException.class)
    public void test_voegToe_Met_als_parameter_een_leeg_woord_Moet_een_exception_gooien() {
        woordenlijstLeeg.voegToe("");
    }

    @Test (expected = DomainException.class)
    public void test_voegToe_Met_als_parameter_een_woord_dat_al_in_de_lijst_staat_Moet_een_exception_gooien() {
        String woordAlInLijst = geldigeWoorden.get(2);
        woordenlijstMetGeldigeWoorden.voegToe(woordAlInLijst);
    }

    @Test
    public void test_getRandomWoord_Zonder_parameters_Geeft_een_woord_terug_dat_in_de_woordenlijst_staat() {
        String randomWoord = woordenlijstMetGeldigeWoorden.getRandomWoord();
        assertTrue(woordenlijstMetGeldigeWoorden.getWoorden().contains(randomWoord));
    }
}
