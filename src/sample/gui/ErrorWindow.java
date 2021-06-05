package sample.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.logic.services.IPersonaServices;

public class ErrorWindow {
    public ErrorWindow(String message) {
        Stage stage = new Stage();

        VBox vBox = new VBox();
        Label label = new Label();
        label.setText(message);
        label.setFont(new Font("Tahoma", 18));
        vBox.getChildren().add(label);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox,500,60);
        stage.setTitle("Error");
        stage.setScene(scene);
        stage.show();
    }
}
