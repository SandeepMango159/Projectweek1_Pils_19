package domain;

public abstract class Vorm {
    public abstract Omhullende getOmhullende();

    public String toString() {
        return "Omhullende: (" + this.getOmhullende().getLinkerBovenhoek().getX() + ", " + this.getOmhullende().getLinkerBovenhoek().getY() + ") - "  + this.getOmhullende().getBreedte() + " - " + this.getOmhullende().getHoogte();
    }
}
