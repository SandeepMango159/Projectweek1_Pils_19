package domain;

public class Cirkel extends Vorm{

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
            throw new IllegalArgumentException("Middelpunt mag geen  null zijn");
        }
    }

    public void setRadius(int newRadius) throws IllegalArgumentException {
        if (newRadius > 0) {
            this.radius = newRadius;
        }
        else {
            throw new IllegalArgumentException("Straal mag niet gelijk aan nul of negatief zijn");
        }
    }

    public Punt getMiddelpunt() {
        return this.middelpunt;
    }

    public int getRadius() {
        return this.radius;
    }

    public boolean equals(Object andereCirkel) {

        if (andereCirkel instanceof Cirkel) {
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
        return "Cirkel: middelpunt: " + getMiddelpunt().toString() + " - straal: " + getRadius() + "\n" + super.toString();
    }

    @Override
    public Omhullende getOmhullende() {
        return new Omhullende(new Punt(getMiddelpunt().getX() - getRadius(), getMiddelpunt().getY() - getRadius()), getRadius() * 2, getRadius() * 2);
    }
}
