package domain;

import java.util.ArrayList;
import java.util.List;

public class Tekening {
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MAX_X = 399;
    public static final int MAX_Y = 399;
    private String naam;
    private List<Vorm> vormen;

    public Tekening(String naam) {
        if (naam == null|| naam.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.naam = naam;
        this.vormen = new ArrayList<Vorm>();
    }

    public static boolean isValidNaam(String naam) {
        if (naam == null || naam.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public String getNaam() {
        return this.naam;
    }

    public void voegToe(Vorm vorm) {
        this.vormen.add(vorm);
    }

    public Vorm getVorm(int i) {
        return this.vormen.get(i);
    }

    public int getAantalVormen() {
        return this.vormen.size();
    }

    public void verwijder(Vorm vorm) {
        this.vormen.remove(vorm);
    }

    public boolean bevat (Vorm vorm) {
        return this.vormen.contains(vorm);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tekening) {
            Tekening tekening = (Tekening) obj;
            if (this.naam == tekening.naam && this.vormen.equals(tekening.vormen)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
