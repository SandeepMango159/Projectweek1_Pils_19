package domain;

import java.util.Arrays;

public class Driehoek {



    private Punt hoekpunt1;
    private Punt hoekpunt2;
    private Punt hoekpunt3;

    private Punt[] gesorteerdeHoekpunten = new Punt[3];

    public Driehoek(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
        setPunten(hoekpunt1, hoekpunt2, hoekpunt3);
    }

    private void setPunten(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
        if (isValidHoekpunten(hoekpunt1, hoekpunt2, hoekpunt3)) {
            this.hoekpunt1 = hoekpunt1;
            this.hoekpunt2 = hoekpunt2;
            this.hoekpunt3 = hoekpunt3;
        }
        // Geen else nodig, als de hoekpunten niet valid zijn wordt er een exception met message gegooid in de checker
    }

    private boolean isValidHoekpunten(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) throws IllegalArgumentException {

        // Heb in aparte ifs voor leesbaarheid
        // Check al of niet null
        if ((hoekpunt1 != null) || (hoekpunt2 != null) || (hoekpunt3 != null)) {
            // De hoekpunten mogen niet samenvallen (twee aan twee)
            if ( (!hoekpunt1.equals(hoekpunt2)) && (!hoekpunt1.equals(hoekpunt3)) && (!hoekpunt2.equals(hoekpunt3)) ) {
                // Hoekpunten mogen niet op 1 lijn liggen
                // formule: (x2-x1)*(y3-y1) = (x3-x1)*(y2-y1)
                if ( !(liggenOp1Lijn(hoekpunt1, hoekpunt2, hoekpunt3))) {
                    // Dan zijn ze valid als ze aan alle 3 voorwaarden voldoen
                    return true;
                }
                // Liggen op 1 lijn
                else {
                    throw new IllegalArgumentException("Je punten mogen niet op 1 lijn liggen");
                }
            }
            // Hoekpunten vallen samen
            else {
                throw new IllegalArgumentException("Je hoekpunten mogen niet samenvallen");
            }
        }
        // Een hoekpunt is null
        else {
            throw new IllegalArgumentException("Je hoekpunten mogen niet null zijn");
        }
    }

    private boolean liggenOp1Lijn(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
        if ( (hoekpunt2.getX() - hoekpunt1.getX() ) * (hoekpunt3.getY() - hoekpunt1.getY())
                == (hoekpunt3.getX() - hoekpunt1.getX())*(hoekpunt2.getY() - hoekpunt1.getY()) ) {
            return true;
        }
        else {
            return false;
        }
    }

    public Punt getHoekPunt1() {
        return this.hoekpunt1;
    }

    public Punt getHoekPunt2() {
        return this.hoekpunt2;
    }

    public Punt getHoekPunt3() {
        return this.hoekpunt3;
    }



    public void sorteerHoekPunten() {

        gesorteerdeHoekpunten[0] = getHoekPunt1();
        gesorteerdeHoekpunten[1] = getHoekPunt2();
        gesorteerdeHoekpunten[2] = getHoekPunt3();

        Arrays.sort(gesorteerdeHoekpunten);



    }

    @Override
    public String toString() {
        //  Eerst nog sorteren
        sorteerHoekPunten();
        
        return "hoekpunt1: " + gesorteerdeHoekpunten[0].toString() + " - hoekpunt2: " + gesorteerdeHoekpunten[1].toString() + " - hoekpunt3: " + gesorteerdeHoekpunten[2].toString();
    }

    public boolean equals(Object object) {
        // Geen nullcheck nodig als je instance of gebruikt
        // The expression x instanceof SomeClass is false if x is null.
        // Check of zelfde klasse object
        if (object instanceof Driehoek) {
            Driehoek andereDriehoek = (Driehoek) object;
            // Pas gelijk als alle hoekpunten gelijk zijn aan elkaar
            if ((this.getHoekPunt1()==andereDriehoek.getHoekPunt1()) && (this.getHoekPunt2()==andereDriehoek.getHoekPunt2()) && (this.getHoekPunt3()==andereDriehoek.getHoekPunt3())) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

}
