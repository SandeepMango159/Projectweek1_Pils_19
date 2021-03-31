
package ui;

import javafx.scene.layout.GridPane;
import domain.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.*;


public class TekenVensterApp {
    private Tekening tekening;

    public TekenVensterApp(Pane root, Tekening tekening){
        if (tekening == null) throw new UiException();
        this.tekening = tekening;
        this.teken(root);
    }

    public void teken(Pane root) throws UiException{
        if (root != null) {
            tekening.teken(root);
        }
        else {
            throw new UiException("Root pane is niet geldig");
        }
    }
}
