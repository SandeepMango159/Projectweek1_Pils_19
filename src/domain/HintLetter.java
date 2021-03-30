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
}
