package sample.gui;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationScene extends Stage {

    private Scene confirmationScene;
    private Stage stage;


    public ConfirmationScene(Stage ownerStage) {
        stage = new Stage();

        stage.setTitle("Confirmación");
        stage.initOwner(ownerStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(confirmationScene);
        stage.showAndWait();
    }
}
