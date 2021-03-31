
package ui;



import domain.Tekening;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FxTekenVensterApp extends Application {

    private TextField invoerNaam;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root,300,300);
        invoerNaam = new TextField("Geef de naam van de tekening");
        root.getChildren().add(invoerNaam);

        primaryStage.setScene(scene);

        // Stage met naam van nieuwe tekening(venster)
        // De root meegeven en de Tekening
        // In TekenVensterApp kan je een nieuwe GUI aanmakenn die FiguurApp bvb oproept en nieuwe figuren haalt die je wilt tekenen
        // Zo ff niet gedaan, zit er nu hardgecodeerd in wat je wilt tekenen.
        // Voeg die vormen toe aan de Tekening klasse en op het einde roep je Tekening.teken op om alle vormen te tekenen
        // In Tekening ga je over de lijst met alle vormen heen en teken je ze dan, door de vorm zijn eigen teken methode
        //  op te roepen, vb driehoek.teken
        // In elke Vorm zijn eigen klasse voegt die die zelf toe aan de root
        // En dat is het, zit klaar op de root (hier dus) en daarna show je de stage met de tekeningen

        invoerNaam.setOnAction( eventIngaveNaam -> {
            primaryStage.setTitle(invoerNaam.getText());
            root.getChildren().clear();
            new TekenVensterApp(root,new Tekening(invoerNaam.getText()));});

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}