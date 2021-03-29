package domain;

public class Punt {
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
        return super.toString();
    }
}
