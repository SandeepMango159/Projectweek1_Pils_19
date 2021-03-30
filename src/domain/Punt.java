package domain;

public class Punt implements Comparable<Punt>{
    private int x;
    private int y;

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Punt) {
            Punt punt = (Punt) obj;
            if (this.getY() == punt.getY() && this.getX() == punt.getX()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + ", " +this.getY() + ")";
    }



    @Override
    public int compareTo(Punt o) {
        // als this > o dan return 1
        // als this < o dan return -1
        // als gelijk dan return 0
        if (this.getX() > o.getX() ) {
            return 1;
        }
        else if (this.getX() == o.getX() ) {

            if (this.getY() > o.getY() ) {
                    return 1;
            }
            else if (this.getY() == o.getY() ) {
                return 0;
            }
            else {
                return -1;
            }
        }
        // Anders is this.getX < o.getX
        else {
            return -1;
        }
    }
}
