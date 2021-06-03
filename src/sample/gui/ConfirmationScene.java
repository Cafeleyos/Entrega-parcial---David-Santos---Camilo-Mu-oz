package sample.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationScene extends Stage {

    private Scene confirmationScene;
    private Stage stage;

    private static final Text TEXT = new Text("¿Quieres confirmar los cambios?");
    private GridPane pane;

    private Button confirmation, cancel;
    private boolean result;

    public ConfirmationScene(Stage ownerStage) {
        stage = new Stage();

        setUp();
        behavior();

        stage.setTitle("Confirmación");
        stage.initOwner(ownerStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(confirmationScene);
        stage.showAndWait();
    }

    public void setUp() {
        setUpButton();
        setUpPane();

        confirmationScene = new Scene(pane, 300, 100);
    }

    public void behavior() {
        confirmation.setOnAction(e -> {
            stage.close();
            result = true;
        });

        cancel.setOnAction(e -> {
            stage.close();
            result = false;
        });
    }

    public void setUpButton() {
        confirmation = new Button("Confirmar");
        confirmation.setPrefSize(100, 30);

        cancel = new Button("Cancelar");
        cancel.setPrefSize(100, 30);
    }

    public void setUpPane() {
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(20);
        pane.setHgap(20);

        pane.add(TEXT, 0, 0, 2, 1);

        pane.add(confirmation, 0, 1);
        pane.add(cancel, 1, 1);
    }

    public boolean getConfirmation() {
        return result;
    }
}
