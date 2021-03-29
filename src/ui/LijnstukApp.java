package ui;

import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LijnstukApp {
    private Label invoerStartpuntXLabel, invoerEindpuntXLabel, invoerStartpuntYLabel, invoerEindpuntYLabel;
    private TextField invoerStartpuntX, invoerEindpuntX, invoerStartpuntY, invoerEindpuntY;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private LijnStuk lijnStuk;
    private Punt startpunt;
    private Punt eindpunt;

    public LijnstukApp(GridPane root) {

        invoerStartpuntXLabel =  new Label("Geef de x-coördinaat van het startpunt van het lijnstuk ");
        invoerStartpuntX= new TextField();
        invoerEindpuntXLabel = new Label("Geef de x-coördinaat van het eindpunt van het lijnstuk ");
        invoerEindpuntX = new TextField();
        invoerStartpuntYLabel =  new Label("Geef de y-coördinaat van het startpunt van het lijnstuk ");
        invoerStartpuntY= new TextField();
        invoerEindpuntYLabel = new Label("Geef de y-coördinaat van het eindpunt van het lijnstuk ");
        invoerEindpuntY = new TextField();

        root.add(invoerStartpuntXLabel,0,0);
        root.add(invoerStartpuntX,1,0);

        invoerStartpuntX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerStartpuntX.getText());
                root.add(invoerStartpuntYLabel, 0, 1);
                root.add(invoerStartpuntY, 1, 1);
            }
            catch(NumberFormatException e){
                invoerStartpuntX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("De x-coördinaat van het startpunt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerStartpuntY.setOnAction(eventIngaveY -> {
            try {
                startpunt = new Punt(Integer.parseInt(invoerStartpuntX.getText()), Integer.parseInt(invoerStartpuntY.getText()));
                root.add(invoerEindpuntXLabel, 0, 2);
                root.add(invoerEindpuntX, 1, 2);
            } catch(NumberFormatException e){
                invoerStartpuntY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("De y-coördinaat van het startpunt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerEindpuntX.setOnAction(eventIngaveY -> {
            try {
                Integer.parseInt(invoerEindpuntX.getText());
                root.add(invoerEindpuntYLabel, 0, 3);
                root.add(invoerEindpuntY, 1, 3);
            } catch(NumberFormatException e){
                invoerEindpuntX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("De x-coördinaat van het eindpunt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerEindpuntY.setOnAction(eventIngaveY -> {
            try {
                eindpunt = new Punt(Integer.parseInt(invoerEindpuntX.getText()), Integer.parseInt(invoerEindpuntY.getText()));
                lijnStuk = new LijnStuk(startpunt, eindpunt);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(lijnStuk.toString());
                root.add(uitvoer, 0, 0);
            } catch(NumberFormatException e){
                invoerEindpuntY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("De y-coördinaat van het eindpunt moet een geheel getal zijn. ");
                foutenboodschap.showAndWait();
            }
        });
    }

    public LijnstukApp(GridPane root, Tekening tekening) {

        invoerStartpuntXLabel =  new Label("Geef de x-coördinaat van het startpunt van het lijnstuk ");
        invoerStartpuntX= new TextField();
        invoerEindpuntXLabel = new Label("Geef de x-coördinaat van het eindpunt van het lijnstuk ");
        invoerEindpuntX = new TextField();
        invoerStartpuntYLabel =  new Label("Geef de y-coördinaat van het startpunt van het lijnstuk ");
        invoerStartpuntY= new TextField();
        invoerEindpuntYLabel = new Label("Geef de y-coördinaat van het eindpunt van het lijnstuk ");
        invoerEindpuntY = new TextField();

        root.add(invoerStartpuntXLabel,0,0);
        root.add(invoerStartpuntX,1,0);

        invoerStartpuntX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerStartpuntX.getText());
                root.add(invoerStartpuntYLabel, 0, 1);
                root.add(invoerStartpuntY, 1, 1);
            }
            catch(NumberFormatException e){
                invoerStartpuntX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("De x-coördinaat van het startpunt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerStartpuntY.setOnAction(eventIngaveY -> {
            try {
                startpunt = new Punt(Integer.parseInt(invoerStartpuntX.getText()), Integer.parseInt(invoerStartpuntY.getText()));
                root.add(invoerEindpuntXLabel, 0, 2);
                root.add(invoerEindpuntX, 1, 2);
            } catch(NumberFormatException e){
                invoerStartpuntY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("De y-coördinaat van het startpunt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerEindpuntX.setOnAction(eventIngaveY -> {
            try {
                Integer.parseInt(invoerEindpuntX.getText());
                root.add(invoerEindpuntYLabel, 0, 3);
                root.add(invoerEindpuntY, 1, 3);
            } catch(NumberFormatException e){
                invoerEindpuntX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("De x-coördinaat van het eindpunt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerEindpuntY.setOnAction(eventIngaveY -> {
            try {
                eindpunt = new Punt(Integer.parseInt(invoerEindpuntX.getText()), Integer.parseInt(invoerEindpuntY.getText()));
                lijnStuk = new LijnStuk(startpunt, eindpunt);
                tekening.voegToe(lijnStuk);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(lijnStuk.toString());
                root.add(uitvoer, 0, 0);
            } catch(NumberFormatException e){
                invoerEindpuntY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("De y-coördinaat van het eindpunt moet een geheel getal zijn. ");
                foutenboodschap.showAndWait();
            }
        });
    }
}
