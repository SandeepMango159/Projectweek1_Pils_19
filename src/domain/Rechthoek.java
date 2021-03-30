package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


public class Rechthoek extends Vorm implements Drawable{
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
        return  "Rechthoek: linkerbovenhoek: (" + this.getLinkerBovenhoek().getX() + ", " + this.getLinkerBovenhoek().getY() + ") - breedte: "  + this.breedte + " - hoogte: " + this.hoogte + "\n"
                + super.toString();
    }


    @Override
    public Omhullende getOmhullende() {
        return new Omhullende(getLinkerBovenhoek(), getBreedte(), getHoogte());
    }

    @Override
    public void teken(Pane root) {

        Rectangle rechthoek = new Rectangle(this.getLinkerBovenhoek().getX(), this.getLinkerBovenhoek().getY(), this.getBreedte(), this.getHoogte());

        rechthoek.setFill(this.getkleur());

        root.getChildren().add(rechthoek);

    }
}
