package ui;

import db.WoordenLezer;
import domain.HintWoord;
import domain.Speler;
import domain.WoordenLijst;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class WoordRadenApp {
    private Label rarara, hints, geefLetter, feedback;
    private TextField invoerLetter;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);
    private int aantalZetten;

    public WoordRadenApp(GridPane root, Speler speler){
        WoordenLezer woordenLezer = new WoordenLezer();
        HintWoord woord = new HintWoord(woordenLezer.getRandomWoord());
        rarara = new Label("Rarara, welk woord zoeken we?");
        hints = new Label(woord.toString());
        geefLetter = new Label("Geef een letter:");
        invoerLetter = new TextField();
        aantalZetten = 0;


        root.add(rarara,0,0);
        root.add(hints, 0, 1);
        root.add(geefLetter, 0,3);
        root.add(invoerLetter, 0,4);

        invoerLetter.setOnAction(event -> {
            if (invoerLetter.getText().length() != 1){
                invoerLetter.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Geef 1 letter.");
                foutenboodschap.showAndWait();
            }else{
                aantalZetten++;
                root.getChildren().clear();
                boolean geraden = false;
                if (woord.raad(invoerLetter.getText().charAt(0)) ){
                    geraden = woord.isGeraden();
                    if (!geraden) {
                        feedback = new Label("Super, doe zo voort!");
                    }
                }else{
                   feedback = new Label("Helaas,volgende keer beter!");
                }
                if (!geraden) {
                    invoerLetter.clear();
                    hints.setText(woord.toString());
                    root.add(feedback,0,0);
                    root.add(rarara,0,1);
                    root.add(hints, 0, 2);
                    root.add(geefLetter, 0,4);
                    root.add(invoerLetter, 0,5);
                }
                else {
                    feedback = new Label("Goed gedaan " + speler.getNaam() + "! Je hebt het woord geraden in " + this.aantalZetten + " zetten.");
                    root.add(feedback, 0, 0);
                }

            }
        });

    }
}
