package ui;

import domain.HintWoord;
import domain.Speler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class WoordRadenApp {
    private Label rarara, hints, geefLetter, feedback;
    private TextField invoerLetter;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public WoordRadenApp(GridPane root, Speler matijs){
        HintWoord woord = new HintWoord("hangmanspelletje");
        rarara = new Label("Rarara, welk woord zoeken we?");
        hints = new Label(woord.toString());
        geefLetter = new Label("Geef een letter:");
        invoerLetter = new TextField();


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
                root.getChildren().clear();
                invoerLetter.clear();
               if (woord.raad(invoerLetter.getText().charAt(0)) ){
                   feedback = new Label("Super, doe zo voort!");
               }else{
                   feedback = new Label("Helaas,volgende keer beter!");
               }
               hints.setText(woord.toString());
                root.add(feedback,0,0);
                root.add(rarara,0,1);
                root.add(hints, 0, 2);
                root.add(geefLetter, 0,4);
                root.add(invoerLetter, 0,5);

            }
        });

    }
}
