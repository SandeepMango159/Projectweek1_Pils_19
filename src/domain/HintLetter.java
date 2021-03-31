package domain;

public class HintLetter {


    private char letter;


    private boolean isGeraden = false;

    public HintLetter(char letter) {
        this.letter = Character.toLowerCase(letter);
        if (letter == ' ') {
            isGeraden = true;
        }
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
        if (isGeraden) {
            return false;
        }
        else if (Character.toLowerCase(c) == getLetter()) {
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
