package domain;

public class LijnStuk extends Vorm{
    private Punt startPunt;
    private Punt eindPunt;

    public LijnStuk(Punt startPunt, Punt eindPunt) {
        setStartEnEindPunt(startPunt, eindPunt);
    }

    public Punt getStartPunt() {
        return this.startPunt;
    }

    public Punt getEindPunt() {
        return this.eindPunt;
    }

   private void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {
       if (startPunt == null || eindPunt == null || startPunt.equals(eindPunt)) {
           throw new DomainException();
       }
       this.startPunt = startPunt;
       this.eindPunt = eindPunt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LijnStuk) {
            LijnStuk lijnstuk = (LijnStuk) obj;
            if (lijnstuk.getStartPunt().equals(this.getStartPunt()) && lijnstuk.getEindPunt().equals(this.getEindPunt())
            || lijnstuk.getEindPunt().equals(this.getStartPunt()) && lijnstuk.getStartPunt().equals(this.getEindPunt())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Lijn: startpunt: " + this.getStartPunt().toString() + " - eindpunt: " + this.getEindPunt().toString();
    }

    @Override
    public Omhullende getOmhullende() {
        int leftX = Math.min(getStartPunt().getX(), getEindPunt().getX());
        int leftY = Math.min(getStartPunt().getY(), getEindPunt().getY());
        int rightX = Math.max(getStartPunt().getX(), getEindPunt().getX());
        int rightY = Math.max(getStartPunt().getY(), getEindPunt().getY());
        return new Omhullende(new Punt(leftX, leftY), rightX - leftX, rightY - leftY);
    }
}
