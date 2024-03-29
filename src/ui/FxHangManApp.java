package ui;

import db.domain.WoordenLezer;
import domain.Speler;
import domain.WoordenLijst;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxHangManApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        WoordenLezer woordenlezer = new WoordenLezer("hangman.txt");
        WoordenLijst woordenlijst = woordenlezer.lees();

        VBox root = new VBox();

        Scene scene = new Scene(root,450,500);

        TextField invoerNaam = new TextField("Geef de naam van de speler");
        root.getChildren().add(invoerNaam);

        primaryStage.setScene(scene);

        invoerNaam.setOnAction( eventIngaveNaam -> {
            primaryStage.setTitle(invoerNaam.getText());
            root.getChildren().clear();
            new HangManApp(root,new Speler(invoerNaam.getText()), woordenlijst);

        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}