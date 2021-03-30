package domain;

import javafx.scene.paint.Color;

public abstract class Vorm implements Drawable{

    private Color kleur;

    public Color getkleur() {
        return this.kleur;
    }
    public void setKleur(Color kleur) throws DomainException {
        if ( (kleur != null) && (kleur instanceof  Color) ) {
            this.kleur = kleur;
        }
        else {
            throw new DomainException("Is geen geldige kleur");
        }
    }
    public abstract Omhullende getOmhullende();

    public String toString() {
        return "Omhullende: (" + this.getOmhullende().getLinkerBovenhoek().getX() + ", " + this.getOmhullende().getLinkerBovenhoek().getY() + ") - "  + this.getOmhullende().getBreedte() + " - " + this.getOmhullende().getHoogte();
    }
}
