package domain;

public class Speler {

    private String naam;
    private int score;

    public Speler(String naam) {
        setNaam(naam);
        this.score = 0;
    }

    public Speler(String naam, int score) {
        setNaam(naam);
        setScore(score);
    }

    public void addToScore(int positiveScore) {
        setScore(getScore() + positiveScore);
//        als deze functie een score bovenop de huidige score moet toevoegen -> setScore(getScore() + positiveScore);
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public boolean equals(Object object) {
        boolean equal = false;
        if (object instanceof Speler) {
            Speler other = (Speler) object;
            equal = (this.getNaam().equals(other.getNaam()) && this.getScore()==(other.getScore()) ) ;
        }
        return equal;
    }

    @Override
    public String toString() {
        return  naam + " heeft als score "  + score;
    }

    public void setNaam(String naam) {
        if (!isvalidNaam(naam)) {
            throw new DomainException("naam is ongeldig");
        }
        this.naam = naam;
    }

    private boolean isvalidNaam(String naam) {
        return naam != null && !naam.isEmpty() && !naam.trim().isEmpty();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (!isvalidScore(score)) {
            throw new DomainException("score is ongeldig");
        }
        this.score = score;
    }

    private boolean isvalidScore(int score) {
        return score >=0;
    }


}
