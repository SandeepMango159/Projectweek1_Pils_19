package domain;

import java.util.Arrays;

public class HintWoord {
    private HintLetter[] hintwoord;

    public HintWoord(String woord){
        if (woord == null || woord.isEmpty()) {
            throw new DomainException("Invalid word");
        }
        HintLetter[] array = new HintLetter[woord.length()];
        for (int i = 0; i < woord.length(); i++){
            array[i] = new HintLetter(woord.charAt(i));
        }
        hintwoord = array;
    }

    public boolean raad(char c){
        boolean b = false;
        for (HintLetter element: hintwoord ) {
           if(element.raad(c)){
               b = true;
           }
        }
        return b;
    }

    public boolean isGeraden(){
        for (HintLetter element: hintwoord ) {
            if(! element.isGeraden()){
                return false;
            }
        }
        return true;
    }
    public String getWoord() {
        String result= "";
        for (HintLetter element: hintwoord){
            result += element.getLetter();
        }
        return result;
    }

    public String toString(){
        String result= "";
        for (HintLetter element: hintwoord){
            result += " " + element.toChar();
        }
        return result.substring(1);
    }
}
