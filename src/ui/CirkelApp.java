package ui;

import domain.Cirkel;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CirkelApp {

    private Label invoerXLabel, invoerYLabel, invoerStraalLabel;
    private TextField invoerX, invoerY, invoerStraal;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Punt punt;
    private int puntX;
    private int puntY;
    private int straal;

    public CirkelApp(GridPane root) {

        invoerXLabel =  new Label("Geef de x-coördinaat van het middelpunt van de cirkel ");
        invoerX= new TextField();
        invoerYLabel = new Label("Geef de y-coördinaat van het middelpunt cirkel ");
        invoerY = new TextField();

        invoerStraalLabel = new Label("Geef de straal van de cirkel: ");
        invoerStraal = new TextField();

        root.add(invoerXLabel,0,0);
        root.add(invoerX,1,0);




        invoerX.setOnAction(eventIngaveX ->{
            try {
                puntX = Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, 1);
                root.add(invoerY, 1, 1);
            }
            catch(NumberFormatException e){
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY.setOnAction(eventIngaveY -> {
            try {
                puntY = Integer.parseInt(invoerY.getText());
                punt = new Punt(puntX, puntY);


                root.add(invoerStraalLabel, 0, 2);
                root.add(invoerStraal, 1,2);


            } catch(NumberFormatException e){

                invoerY.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerStraal.setOnAction((eventIngaveStraal -> {
            try {

                straal = Integer.parseInt(invoerStraal.getText());

                Cirkel cirkel = new Cirkel(punt, straal);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(cirkel.toString());
                root.add(uitvoer, 0, 4);
            }
            catch(NumberFormatException ex) {
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("straal moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
            catch(IllegalArgumentException  e) {
                invoerStraal.clear();

                Alert f = new Alert(Alert.AlertType.WARNING);

                f.setTitle("test");
                f.setContentText(e.getMessage());
                f.showAndWait();
            }
        }
        ));


    }
}
