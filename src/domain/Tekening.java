package domain;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Tekening implements Drawable{
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
        if (vorm == null || this.bevat(vorm)) {
            throw new IllegalArgumentException();
        }
        this.vormen.add(vorm);
    }

    public Vorm getVorm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        return this.vormen.get(i);
    }

    public int getAantalVormen() {
        return this.vormen.size();
    }

    public void verwijder(Vorm vorm) {
        if (vorm == null || !this.bevat(vorm)) {
            throw new IllegalArgumentException();
        }
        this.vormen.remove(vorm);
    }

    public boolean bevat (Vorm vorm) {
        if (vorm == null) {
            throw new IllegalArgumentException();
        }
        return this.vormen.contains(vorm);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tekening) {
            Tekening tekening = (Tekening) obj;
            if (tekening.vormen.size() != this.vormen.size()) {
                return false;
            }
            for (Vorm v : this.vormen) {
                if (!tekening.bevat(v)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "Naam van de tekening: " + this.getNaam() + "\nDe vormen in deze tekening: ";
        for (Vorm v : vormen) {
            result += v.toString() + "\n";
        }
        return result;
    }

    @Override
    public void teken(Pane root) {
        for (Vorm v : vormen) {
            v.teken(root);
        }
    }
}
