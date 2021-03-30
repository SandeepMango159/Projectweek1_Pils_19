package domain;

public class Rechthoek extends Vorm{
    private Punt linkerBovenhoek;
    private int breedte;
    private int hoogte;

    public Rechthoek(Punt hoek, int breedte, int hoogte) {
        setLinkerBovenhoek(hoek);
        setBreedte(breedte);
        setHoogte(hoogte);
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return linkerBovenhoek;
    }

    public void setBreedte(int breedte) {
        if (breedte <= 0) {
            throw new DomainException("Breedte is ongeldig");
        }
        this.breedte = breedte;
    }

    public void setHoogte(int hoogte) {
        if (hoogte <= 0) {
            throw new DomainException("Hoogte is ongeldig");
        }
        this.hoogte = hoogte;
    }

    public void setLinkerBovenhoek(Punt linkerBovenhoek) {
        if (linkerBovenhoek == null) {
            throw new DomainException("Punt is ongeldig");
        }
        this.linkerBovenhoek = linkerBovenhoek;
    }

    @Override
    public boolean equals(Object object) {
        boolean equal = false;
        if (object instanceof Rechthoek) {
            Rechthoek other = (Rechthoek) object;
            equal = (this.getLinkerBovenhoek().equals(other.getLinkerBovenhoek()) && this.getBreedte()==(other.getBreedte()) && this.getHoogte()==(other.getHoogte()) ) ;
        }
        return equal;
    }

    @Override
    public String toString() {
        return  "Rechthoek: linkerbovenhoek: (" + this.getLinkerBovenhoek().getX() + ", " + this.getLinkerBovenhoek().getY() + ") - breedte: "  + this.breedte + " - hoogte: " + this.hoogte + "\nOmhullende: ("
                + this.getOmhullende().getLinkerBovenhoek().getX() + ", " + this.getOmhullende().getLinkerBovenhoek().getY() + ") - "  + this.getOmhullende().getBreedte() + " - " + this.getOmhullende().getHoogte();
    }

    @Override
    public Omhullende getOmhullende() {
        return new Omhullende(getLinkerBovenhoek(), getBreedte(), getHoogte());
    }
}
