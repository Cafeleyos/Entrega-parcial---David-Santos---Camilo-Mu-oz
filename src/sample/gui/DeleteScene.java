package sample.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;
import sample.logic.services.PersonaException;
import sample.logic.services.implementation.PersonaServices;

public class DeleteScene extends Stage {

    private final Stage stage;
    private Scene deleteScene;

    private Button delete, cancel;
    private TextField inputId;
    private Label id;
    private PersonaServices personaServices;

    private GridPane pane;
    private static final Text TITLE = new Text("Eliminar una Persona");

    public DeleteScene(PersonaServices personaServices, Stage ownerStage) {
        stage = new Stage();
        this.personaServices = personaServices;

        setUp();
        behavior();

        stage.setTitle("Eliminar Contacto");
        stage.initOwner(ownerStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(deleteScene);
        stage.showAndWait();
    }

    public void setUp() {
        setUpInputs();
        setUpButton();
        setUpPane();

        deleteScene = new Scene(pane, 400, 150);
    }

    public void behavior() {
        delete.setOnAction(e -> {
            try {
                personaServices.delete(personaServices.findIndex(inputId.getText()));
            } catch (PersonaException personaException) {
                personaException.printStackTrace();
            }
            new ConfirmationScene(stage);
            inputId.clear();
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

        pane.add(id, 0, 1);
        pane.add(inputId, 1, 1);

        pane.add(delete, 0, 2);
        pane.add(cancel, 1, 2);
    }

    public void setUpInputs() {
        id = new Label("Cédula");
        id.setFont(DataScene.FONT);
        id.setText("Cédula:");
        inputId = new TextField();
        inputId.setPromptText("Cédula");
    }
}