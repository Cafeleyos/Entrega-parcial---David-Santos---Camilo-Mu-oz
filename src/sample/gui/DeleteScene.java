package sample.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;
import sample.logic.services.implementation.PersonaServices;

import javax.xml.crypto.Data;

public class DeleteScene extends Stage {

    private Stage stage;
    private Scene deleteScene;

    private Button delete, cancel;
    private TextField inputCedula;
    private Label cedula;
    private PersonaServices personaServices;
    private DataScene dataScene;

    private GridPane pane;
    private static final Text TITLE = new Text("Eliminar una Persona");

    public DeleteScene() {
        stage = new Stage();

        setUp();
        behavior();

        stage.setTitle("Eliminar Contacto");
        stage.setScene(deleteScene);
        stage.show();
    }

    public void setUp() {
        setUpInputs();
        setUpButton();
        setUpPane();


        deleteScene = new Scene(pane, 400, 150);
    }

    public void behavior() {
        personaServices = new PersonaServices();
        dataScene = new DataScene();

        delete.setOnAction(e -> {
            personaServices.delete(personaServices.findIndex(inputCedula.getText()));
            inputCedula.clear();
        });

        cancel.setOnAction(e -> stage.close());
    }

    public void setUpButton() {
        delete = new Button("Borrar");
        delete.setPrefSize(100, 30);

        cancel = new Button("Cancelar");
        cancel.setPrefSize(100, 30);
    }

    public void setUpPane() {
        pane = new GridPane();

        pane.setAlignment(Pos.CENTER);

        pane.setVgap(20);
        pane.setHgap(20);

        TITLE.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        pane.add(TITLE, 0, 0, 2, 1);

        pane.add(cedula, 0, 1);
        pane.add(inputCedula, 1, 1);

        pane.add(delete, 0, 2);
        pane.add(cancel, 1, 2);
    }

    public void setUpInputs() {
        cedula = new Label("Cédula");
        cedula.setFont(DataScene.FONT);
        cedula.setText("Cédula:");
        inputCedula = new TextField();
        inputCedula.setPromptText("Cédula");
    }
}