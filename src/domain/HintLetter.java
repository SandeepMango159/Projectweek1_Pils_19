package domain;

public class HintLetter {


    private char letter;


    private boolean isGeraden = false;

    public HintLetter(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public char toChar() {
        if (isGeraden()) {
            return getLetter();
        } else {
            return (getLetter() == ' ') ? ' ' : '_';
        }
    }

    public boolean raad(char c) {
        if (c == getLetter()) {
            setGeraden(true);
            return true;
        } else {
            return false;
        }
    }

    public boolean isGeraden() {
        return isGeraden;
    }

    public void setGeraden(boolean geraden) {
        isGeraden = geraden;
    }
}
