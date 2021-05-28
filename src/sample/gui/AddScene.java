package sample.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddScene extends Application {

    private Scene addScene;

    @Override
    public void start(Stage stage) throws Exception {


        stage.setTitle("Agregar Nuevo Contacto");
        stage.setScene(addScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
