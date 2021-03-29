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

    public int getMinimumX()
}
