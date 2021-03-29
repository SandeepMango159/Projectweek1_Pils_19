package domain;

public class Cirkel {

    private Punt middelpunt;
    private int radius;

    public Cirkel(Punt middelpunt, int straal) {
            setMiddelPunt(middelpunt);
            setRadius(straal);
    }

    public void setMiddelPunt(Punt newMiddelpunt) throws IllegalArgumentException {
        if (newMiddelpunt != null) {
            this.middelpunt = newMiddelpunt;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void setRadius(int newRadius) throws IllegalArgumentException {
        if (newRadius > 0) {
            this.radius = newRadius;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public Punt getMiddelpunt() {
        return this.middelpunt;
    }

    public int getRadius() {
        return this.radius;
    }

    public boolean equals(Object andereCirkel) {

        if (andereCirkel != null) {
            Cirkel otherCirkel = (Cirkel) andereCirkel;

            if ( (this.getMiddelpunt() == otherCirkel.getMiddelpunt() ) &&
                    (this.getRadius() == otherCirkel.getRadius()) ) {
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

    @Override
    public String toString() {
        return "Cirkel: middelpunt: " + getMiddelpunt().toString() + " - straal: " + getRadius();
    }


}
