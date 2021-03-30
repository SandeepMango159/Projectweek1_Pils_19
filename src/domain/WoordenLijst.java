package domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WoordenLijst {
    private List<String> woorden;

    public WoordenLijst() {
        this.woorden = new ArrayList<String>();
    }

    public int getAantalWoorden() {
        return this.woorden.size();
    }

    public List<String> getWoorden() {
        return this.woorden;
    }

    public void voegToe(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new DomainException("Het woord mag niet leeg zijn.");
        }
        if (this.woorden.contains(s)) {
            throw new DomainException("Dit woord zit al in de woordenlijst.");
        }
        this.woorden.add(s);
    }

    public String getRandomWoord() {
        int randomIndex = (int)(Math.random() * this.woorden.size());
        return this.woorden.get(randomIndex);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WoordenLijst) {
            WoordenLijst woordenLijst = (WoordenLijst) obj;
            if (woordenLijst.getWoorden().size() != this.getWoorden().size()) {
                return false;
            }
            for (String s : this.getWoorden()) {
                if (!woordenLijst.getWoorden().contains(s)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "De woordenlijst bevat de volgende woorden: " + "\n";
        for (String s : this.woorden) {
            result += s + "\n";
        }
        return result;
    }
}
