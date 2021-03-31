package db.domain;

import domain.WoordenLijst;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class WoordenLezer {
    private List<String> woorden;

    public WoordenLezer(String fileName) {
        this.woorden = new ArrayList<String>();
        Scanner scannerFile = null;                             // scanner voor productFile
        try {
            scannerFile = new Scanner(new File("src\\" + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scannerFile != null && scannerFile.hasNextLine()) {                     // voor elke lijn van het bestand
            String s = scannerFile.nextLine();                  // volgende lijn van het bestand
            this.woorden.add(s);
        }
    }

    public WoordenLijst lees() {
        WoordenLijst woordenLijst = new WoordenLijst();
        for (String woord : this.woorden) {
            woordenLijst.voegToe(woord);
        }
        return woordenLijst;
    }
//
//    public String getRandomWoord() {
//        int randomIndex = (int)(Math.random() * this.woorden.size());
//        return this.woorden.get(randomIndex);
//    }
}
