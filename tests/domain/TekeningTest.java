package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TekeningTest {
    private Vorm gebouw;
    private Vorm dak;
    private Vorm deur;
    private Vorm raam;
    private Vorm deurknop;
    private Vorm raambalk1;
    private Vorm raambalk2;
    private Vorm schouwNietInTekening;


    @Before
    public void setUp() {
        gebouw = new Rechthoek(new Punt(100, 200), 200, 180);
        dak = new Driehoek(new Punt(100, 200), new Punt(300, 200), new Punt(200, 100));
        deur = new Rechthoek(new Punt(130, 280), 50,100);
        raam = new Rechthoek(new Punt(210, 220), 80, 60);
        deurknop = new Cirkel(new Punt(170, 320), 2);
        raambalk1 = new LijnStuk(new Punt(210, 250), new Punt(290, 250));
        raambalk2 = new LijnStuk(new Punt(250, 220), new Punt(250, 280));
        schouwNietInTekening = new Rechthoek(new Punt(150, 150), 20,40);
    }

    @Test
    public void Tekening_moet_een_tekening_aanmaken_met_een_geldige_naam_en_0_vormen() {
        Tekening huis = new Tekening("huis");
        assertEquals("huis", huis.getNaam());
        assertEquals(0, huis.getAantalVormen());
    }

    @Test (expected = IllegalArgumentException.class)
    public void Tekening_moet_exception_gooien_als_naam_null() {
        new Tekening(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Tekening_moet_exception_gooien_als_naam_leeg() {
        new Tekening("");
    }

    @Test
    public void getAantalVormen_moet_aantal_vormen_teruggeven() {
        Tekening huis = createHuisZonderShouw();
        assertEquals(7, huis.getAantalVormen());
    }

    @Test
    public void bevat_geeft_true_als_gegeven_vorm_deel_uitmaakt_van_de_tekening(){
        Tekening huis = createHuisZonderShouw();
        assertTrue(huis.bevat(deur));
    }

    @Test
    public void bevat_geeft_false__als_gegeven_vorm_geen_deel_uitmaakt_van_de_tekening(){
        Tekening huis = createHuisZonderShouw();
        assertFalse(huis.bevat(schouwNietInTekening));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null(){
        Tekening huis = createHuisZonderShouw();
        assertFalse(huis.equals(null));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_tekening_is_met_verschillend_aantal_vormen(){
        Tekening huis = createHuisZonderShouw();
        Tekening huisMetSchouw = createHuisMetSchouw();
        assertFalse(huis.equals(huisMetSchouw));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_tekening_is_met_zelfde_aantal_vormen_ander_vorm(){
        Tekening huis = createHuisZonderShouw();
        Tekening huisMetSchouwZonderDeur = createHuisMetSchouwZonderDeur();
        assertFalse(huis.equals(huisMetSchouwZonderDeur));
    }

    @Test
    public void equals_moet_true_teruggeven_als_parameter_tekening_is_met_zelfde_aantal_vormen_andere_volgorde(){
        Tekening huis = createHuisZonderShouw();
        Tekening huisMetSchouwZonderDeur = createHuisMetSchouwZonderDeur();
        huisMetSchouwZonderDeur.verwijder(schouwNietInTekening);
        huisMetSchouwZonderDeur.voegToe(deur);
        assertTrue(huis.equals(huisMetSchouwZonderDeur));
    }

    @Test
    public void equals_moet_true_teruggeven_als_parameter_tekening_is_met_zelfde_aantal_vormen_zelfde_volgorde(){
        Tekening huis = createHuisZonderShouw();
        Tekening huisMetSchouw = createHuisMetSchouw();
        huisMetSchouw.verwijder(schouwNietInTekening);
        assertTrue(huis.equals(huisMetSchouw));
    }

    @Test (expected = IllegalArgumentException.class)
    public void Test_voegToe_Moet_exception_teruggeven_Als_parameter_null_is() {
        Tekening huis = createHuisZonderShouw();
        huis.voegToe(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Test_voegToe_Moet_exception_teruggeven_Als_parameter_al_in_de_tekening_zit() {
        Tekening huis = createHuisZonderShouw();
        huis.voegToe(gebouw);
    }

    @Test
    public void Test_voegToe_Moet_true_teruggeven_Als_parameter_nog_niet_in_de_tekening_zit_en_niet_null_is() {
        Tekening huis = createHuisZonderShouw();
        Tekening huisTwee = createHuisMetSchouw();
        huis.voegToe(schouwNietInTekening);
        assertTrue(huis.equals(huisTwee));
    }

    @Test (expected = IllegalArgumentException.class)
    public void Test_getVorm_Moet_exception_teruggeven_Als_parameter_negatief_is() {
        Tekening huis = createHuisZonderShouw();
        huis.getVorm(-1);
    }

    @Test
    public void Test_getVorm_Moet_true_teruggeven_Als_parameter_0_is() {
        Tekening huis = createHuisZonderShouw();
        assertEquals(gebouw, huis.getVorm(0) );
    }

    @Test
    public void Test_getVorm_Moet_true_teruggeven_Als_parameter_groter_is_dan_0() {
        Tekening huis = createHuisZonderShouw();
        assertEquals(deur, huis.getVorm(1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void Test_verwijder_Moet_exception_teruggeven_Als_parameter_null_is() {
        Tekening huis = createHuisZonderShouw();
        huis.verwijder(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Test_verwijder_Moet_exception_teruggeven_Als_parameter_niet_in_de_tekening_zit() {
        Tekening huis = createHuisZonderShouw();
        huis.verwijder(schouwNietInTekening);
    }

    @Test
    public void Test_verwijder_Moet_true_teruggeven_Als_parameter_in_de_tekening_zit() {
        Tekening huis = createHuisZonderShouw();
        huis.verwijder(raam);
        assertFalse(huis.bevat(raam));
    }

    @Test (expected = IllegalArgumentException.class)
    public void Test_VoegToe_Moet_exception_gooien_Als_de_minimumX_kleiner_is_dan_de_MinX_van_de_tekening() {
        Tekening huis = createHuisMetSchouw();
        huis.voegToe(new Rechthoek(new Punt(-10, 10), 20, 20));
    }

    @Test
    public void Test_VoegToe_Moet_vorm_toevoegen_Als_de_minimumX_gelijk_is_aan_de_MinX_van_de_tekening() {
        Tekening huis = createHuisMetSchouw();
        Vorm vorm = new Rechthoek(new Punt(0, 10), 20, 20);
        huis.voegToe(vorm);
        assertTrue(huis.bevat(vorm));
    }

    @Test
    public void Test_VoegToe_Moet_vorm_toevoegen_Als_de_minimumX_groter_is_dan_de_MinX_van_de_tekening() {
        Tekening huis = createHuisMetSchouw();
        Vorm vorm = new Rechthoek(new Punt(50, 10), 20, 20);
        huis.voegToe(vorm);
        assertTrue(huis.bevat(vorm));
    }

    @Test (expected = IllegalArgumentException.class)
    public void Test_VoegToe_Moet_exception_gooien_Als_de_minimumY_kleiner_is_dan_de_MinY_van_de_tekening() {
        Tekening huis = createHuisMetSchouw();
        huis.voegToe(new Rechthoek(new Punt(50, -10), 20, 20));
    }

    @Test
    public void Test_VoegToe_Moet_vorm_toevoegen_Als_de_minimumY_gelijk_is_aan_de_MinY_van_de_tekening() {
        Tekening huis = createHuisMetSchouw();
        Vorm vorm = new Rechthoek(new Punt(0, 0), 20, 20);
        huis.voegToe(vorm);
        assertTrue(huis.bevat(vorm));
    }

    @Test
    public void Test_VoegToe_Moet_vorm_toevoegen_Als_de_minimumY_groter_is_dan_de_MinY_van_de_tekening() {
        Tekening huis = createHuisMetSchouw();
        Vorm vorm = new Rechthoek(new Punt(50, 10), 20, 20);
        huis.voegToe(vorm);
        assertTrue(huis.bevat(vorm));
    }

    @Test (expected = IllegalArgumentException.class)
    public void Test_VoegToe_Moet_exception_gooien_Als_de_maximumX_groter_is_dan_de_MaxX_van_de_tekening() {
        Tekening huis = createHuisMetSchouw();
        huis.voegToe(new Rechthoek(new Punt(450, 0), 20, 20));
    }

    @Test
    public void Test_VoegToe_Moet_vorm_toevoegen_Als_de_maximumX_gelijk_is_aan_de_MaxX_van_de_tekening() {
        Tekening huis = createHuisMetSchouw();
        Vorm vorm = new Rechthoek(new Punt(379, 0), 20, 20);
        huis.voegToe(vorm);
        assertTrue(huis.bevat(vorm));
    }

    @Test
    public void Test_VoegToe_Moet_vorm_toevoegen_Als_de_maximumX_kleiner_is_dan_de_MaxX_van_de_tekening() {
        Tekening huis = createHuisMetSchouw();
        Vorm vorm = new Rechthoek(new Punt(370, 10), 20, 20);
        huis.voegToe(vorm);
        assertTrue(huis.bevat(vorm));
    }

    @Test (expected = IllegalArgumentException.class)
    public void Test_VoegToe_Moet_exception_gooien_Als_de_maximumY_groter_is_dan_de_MaxY_van_de_tekening() {
        Tekening huis = createHuisMetSchouw();
        huis.voegToe(new Rechthoek(new Punt(50, 450), 20, 20));
    }

    @Test
    public void Test_VoegToe_Moet_vorm_toevoegen_Als_de_maximumY_gelijk_is_aan_de_MaxY_van_de_tekening() {
        Tekening huis = createHuisMetSchouw();
        Vorm vorm = new Rechthoek(new Punt(50, 379), 20, 20);
        huis.voegToe(vorm);
        assertTrue(huis.bevat(vorm));
    }

    @Test
    public void Test_VoegToe_Moet_vorm_toevoegen_Als_de_maximumY_kleiner_is_dan_de_MaxY_van_de_tekening() {
        Tekening huis = createHuisMetSchouw();
        Vorm vorm = new Rechthoek(new Punt(10, 10), 20, 20);
        huis.voegToe(vorm);
        assertTrue(huis.bevat(vorm));
    }

    public Tekening createHuisMetSchouw() {
        Tekening huisMetSchouw = new Tekening("huisMetSchouw");
        huisMetSchouw.voegToe(gebouw);
        huisMetSchouw.voegToe(deur);
        huisMetSchouw.voegToe(raam);
        huisMetSchouw.voegToe(deurknop);
        huisMetSchouw.voegToe(raambalk1);
        huisMetSchouw.voegToe(raambalk2);
        huisMetSchouw.voegToe(schouwNietInTekening);
        huisMetSchouw.voegToe(dak);
        return huisMetSchouw;
    }

    public Tekening createHuisZonderShouw() {
        Tekening huis = new Tekening("huis");
        huis.voegToe(gebouw);
        huis.voegToe(deur);
        huis.voegToe(raam);
        huis.voegToe(deurknop);
        huis.voegToe(raambalk1);
        huis.voegToe(raambalk2);
        huis.voegToe(dak);
        return huis;
    }

    public Tekening createHuisMetSchouwZonderDeur() {
        Tekening huisMetSchouwZonderDeur = new Tekening("huisMetSchouwZonderDeur");
        huisMetSchouwZonderDeur.voegToe(gebouw);
        huisMetSchouwZonderDeur.voegToe(raam);
        huisMetSchouwZonderDeur.voegToe(deurknop);
        huisMetSchouwZonderDeur.voegToe(raambalk1);
        huisMetSchouwZonderDeur.voegToe(raambalk2);
        huisMetSchouwZonderDeur.voegToe(schouwNietInTekening);
        huisMetSchouwZonderDeur.voegToe(dak);
        return huisMetSchouwZonderDeur;
    }

}
