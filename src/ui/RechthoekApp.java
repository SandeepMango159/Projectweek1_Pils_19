package ui;

import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class RechthoekApp {
    private Label invoerXLabel, invoerYLabel, invoerBreedteLabel, invoerHoogteLabel;
    private TextField invoerX, invoerY, invoerBreedte, invoerHoogte;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Rechthoek rechthoek;
    private Punt linkerBovenhoek;

    public RechthoekApp(GridPane root) {

        invoerXLabel =  new Label("Geef de x-coördinaat van de linkerbovenhoek van de rechthoek ");
        invoerX= new TextField();
        invoerYLabel = new Label("Geef de y-coördinaat van de linkerbovenhoek van de rechthoek ");
        invoerY = new TextField();
        invoerBreedteLabel = new Label("Geef de breedte van de rechthoek ");
        invoerBreedte = new TextField();
        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek ");
        invoerHoogte = new TextField();

        root.add(invoerXLabel,0,0);
        root.add(invoerX,1,0);

        invoerX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, 1);
                root.add(invoerY, 1, 1);
            }
            catch(Exception e){
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY.setOnAction(eventIngaveY -> {
            try {
                linkerBovenhoek = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                root.add(invoerBreedteLabel, 0, 2);
                root.add(invoerBreedte, 1, 2);
            } catch(Exception e){

                invoerY.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerBreedte.setOnAction(eventIngaveY -> {
            try {
                if (Integer.parseInt(invoerBreedte.getText()) <= 0) {
                    throw new Exception("breedte moet een positief geheel getal zijn");
                }
                root.add(invoerHoogteLabel, 0, 3);
                root.add(invoerHoogte, 1, 3);
            } catch(Exception e){

                invoerBreedte.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("breedte moet een positief geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerHoogte.setOnAction(eventIngaveY -> {
            try {
                rechthoek = new Rechthoek(linkerBovenhoek, Integer.parseInt(invoerBreedte.getText()), Integer.parseInt(invoerHoogte.getText()));
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(rechthoek.toString());
                root.add(uitvoer, 0, 0);
            } catch(Exception e){

                invoerHoogte.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("hoogte moet een positief geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }

    public RechthoekApp(GridPane root, Tekening tekening) {

        invoerXLabel =  new Label("Geef de x-coördinaat van de linkerbovenhoek van de rechthoek ");
        invoerX= new TextField();
        invoerYLabel = new Label("Geef de y-coördinaat van de linkerbovenhoek van de rechthoek ");
        invoerY = new TextField();
        invoerBreedteLabel = new Label("Geef de breedte van de rechthoek ");
        invoerBreedte = new TextField();
        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek ");
        invoerHoogte = new TextField();

        root.add(invoerXLabel,0,0);
        root.add(invoerX,1,0);

        invoerX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, 1);
                root.add(invoerY, 1, 1);
            }
            catch(Exception e){
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY.setOnAction(eventIngaveY -> {
            try {
                linkerBovenhoek = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                root.add(invoerBreedteLabel, 0, 2);
                root.add(invoerBreedte, 1, 2);
            } catch(Exception e){

                invoerY.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerBreedte.setOnAction(eventIngaveY -> {
            try {
                if (Integer.parseInt(invoerBreedte.getText()) <= 0) {
                    throw new Exception("breedte moet een positief geheel getal zijn");
                }
                root.add(invoerHoogteLabel, 0, 3);
                root.add(invoerHoogte, 1, 3);
            } catch(Exception e){

                invoerBreedte.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("breedte moet een positief geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerHoogte.setOnAction(eventIngaveY -> {
            try {
                rechthoek = new Rechthoek(linkerBovenhoek, Integer.parseInt(invoerBreedte.getText()), Integer.parseInt(invoerHoogte.getText()));
                tekening.voegToe(rechthoek);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(rechthoek.toString());
                root.add(uitvoer, 0, 0);
            } catch(Exception e){

                invoerHoogte.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("hoogte moet een positief geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }
}
