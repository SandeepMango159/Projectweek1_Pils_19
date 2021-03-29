package domain;

public class Omhullende {
    private Punt linkerBovenhoek;
    private int breedte;
    private int hoogte;

    public Omhullende(Punt hoek, int breedte, int hoogte) {
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
        if (breedte < 0) {
            throw new DomainException("Breedte is ongeldig");
        }
        this.breedte = breedte;
    }

    public void setHoogte(int hoogte) {
        if (hoogte < 0) {
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
        if (object instanceof Omhullende) {
            Omhullende other = (Omhullende) object;
            equal = (this.getLinkerBovenhoek().equals(other.getLinkerBovenhoek()) && this.getBreedte()==(other.getBreedte()) && this.getHoogte()==(other.getHoogte()) ) ;
        }
        return equal;
    }

    @Override
    public String toString() {
        return  "Omhullende: (" + this.getLinkerBovenhoek().getX() + ", " + this.getLinkerBovenhoek().getY() + ") - "  + this.breedte + " - " + this.hoogte;
    }

    public int getMinimumX() {
        return this.getLinkerBovenhoek().getX();
    }

    public int getMaximumX() {
        return this.getLinkerBovenhoek().getX() + breedte;
    }

    public int getMinimumY() {
        return this.getLinkerBovenhoek().getY();
    }

    public int getMaximumY() {
        return this.getLinkerBovenhoek().getY() + hoogte;
    }
}
