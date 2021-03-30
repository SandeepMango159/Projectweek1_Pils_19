package ui;

import com.sun.java.browser.plugin2.DOM;
import domain.DomainException;
import domain.Driehoek;
import domain.Punt;
import domain.Rechthoek;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import jdk.nashorn.internal.ir.CatchNode;

public class DriehoekApp {
    private Label invoerPunt1XLabel, invoerPunt1YLabel, invoerPunt2XLabel, invoerPunt2YLabel, invoerPunt3XLabel, invoerPunt3YLabel;
    private TextField invoerPunt1X, invoerPunt1Y, invoerPunt2X, invoerPunt2Y, invoerPunt3X, invoerPunt3Y;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    int hoekpunt1X;
    int hoekpunt1Y;
    private Punt p1;

    int hoekpunt2X;
    int hoekpunt2Y;
    private Punt p2;

    int hoekpunt3X;
    int hoekpunt3Y;
    private Punt p3;

    public DriehoekApp(GridPane root) {

        // TODO alles van driehoekapp

        invoerPunt1XLabel =  new Label("Geef de x-coördinaat van het eerste hoekpunt");
        invoerPunt1X = new TextField();
        invoerPunt1YLabel = new Label("Geef de y-coördinaat van het eerste hoekpunt ");
        invoerPunt1Y = new TextField();
        invoerPunt2XLabel = new Label("Geef de x-coördinaat van het tweede hoekpunt ");
        invoerPunt2X = new TextField();
        invoerPunt2YLabel = new Label("Geef de y-coördinaat van het tweede hoekpunt ");
        invoerPunt2Y = new TextField();
        invoerPunt3XLabel = new Label("Geef de x-coördinaat van het derde hoekpunt");
        invoerPunt3X = new TextField();
        invoerPunt3YLabel = new Label("Geef de y-coördinaat van het derde hoekpunt");
        invoerPunt3Y = new TextField();


        root.add(invoerPunt1XLabel,0,0);
        root.add(invoerPunt1X,1,0);

        invoerPunt1X.setOnAction(eventIngaveX ->{
            try {
                hoekpunt1X = Integer.parseInt(invoerPunt1X.getText());

                // Voeg deze check toe zodat als je al een waarde hebt toegekent in dit tekstvak en het na
                // het toevoegen van een volgende je niet een label dubbel toevoegt en error krijgt
                if (!root.getChildren().contains(invoerPunt1YLabel)) {
                    root.add(invoerPunt1YLabel, 0, 1);
                    root.add(invoerPunt1Y, 1, 1);
                }

            }
            catch(Exception e){
                invoerPunt1X.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
//                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerPunt1Y.setOnAction(eventIngaveY -> {
            try {
                hoekpunt1Y = Integer.parseInt(invoerPunt1Y.getText());
                p1 = new Punt(hoekpunt1X, hoekpunt1Y);

                if (!root.getChildren().contains(invoerPunt2XLabel)) {
                root.add(invoerPunt2XLabel, 0, 2);
                root.add(invoerPunt2X, 1, 2);
                }

            } catch(Exception e){
                invoerPunt1Y.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerPunt2X.setOnAction(eventIngaveY -> {
            try {
                hoekpunt2X = Integer.parseInt(invoerPunt2X.getText());
                if (!root.getChildren().contains(invoerPunt2YLabel)) {
                    root.add(invoerPunt2YLabel, 0, 3);
                    root.add(invoerPunt2Y, 1, 3);
                }
            } catch(Exception e){

                invoerPunt2X.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x-coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerPunt2Y.setOnAction(eventIngaveY -> {
            try {
                hoekpunt2Y = Integer.parseInt(invoerPunt2Y.getText());
                p2 = new Punt(hoekpunt2X, hoekpunt2Y);
                if (!root.getChildren().contains(invoerPunt3XLabel)) {
                    root.add(invoerPunt3XLabel, 0, 4);
                    root.add(invoerPunt3X, 1, 4);
                }
            } catch(Exception e){

                invoerPunt2Y.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y-coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerPunt3X.setOnAction(eventIngaveY -> {
            try {
                hoekpunt3X = Integer.parseInt(invoerPunt3X.getText());
               if (!root.getChildren().contains(invoerPunt3YLabel)) {
                    root.add(invoerPunt3YLabel, 0, 5);
                    root.add(invoerPunt3Y, 1, 5);
               }

            } catch(Exception e){

                invoerPunt3X.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x-coörodinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerPunt3Y.setOnAction(eventIngaveY -> {
            try {
                hoekpunt3Y = Integer.parseInt(invoerPunt3Y.getText());
                p3 = new Punt(hoekpunt3X, hoekpunt3Y);

                Driehoek driehoek = new Driehoek(p1, p2, p3);

                Text output = new Text();
                output.setText(driehoek.toString());
                root.getChildren().clear();
                root.add(output, 0, 0);

            }
            catch(DomainException ex) {
                foutenboodschap.setContentText(ex.getMessage());
                foutenboodschap.showAndWait();
                root.getChildren().clear();
                root.add(invoerPunt1XLabel, 0,0);
                root.add(invoerPunt1X, 1,0);
            }
            catch(NumberFormatException e){
                invoerPunt3Y.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y-coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });


    }
}
