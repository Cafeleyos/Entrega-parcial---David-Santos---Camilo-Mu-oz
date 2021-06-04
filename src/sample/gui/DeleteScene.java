package sample.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;
import sample.logic.services.IPersonaServices;
import sample.logic.services.PersonaException;

public class DeleteScene extends Stage {

    private final Stage STAGE;
    private Scene deleteScene;

    private Button delete, cancel;
    private TextField inputId;
    private Label id;

    private IPersonaServices personaServices;
    private ConfirmationScene confirmationScene;

    private GridPane pane;
    private static final Text TITLE = new Text("Eliminar una Persona");

    public DeleteScene(IPersonaServices personaServices, Stage ownerStage) {
        STAGE = new Stage();
        this.personaServices = personaServices;

        setUp();
        behavior();

        STAGE.setTitle("Eliminar Contacto");
        STAGE.initOwner(ownerStage);
        STAGE.initModality(Modality.APPLICATION_MODAL);
        STAGE.setScene(deleteScene);
        STAGE.showAndWait();
    }

    public void setUp() {
        setUpInputs();
        setUpButton();
        setUpPane();

        deleteScene = new Scene(pane, 400, 150);
    }

    public void behavior() {


        delete.setOnAction(e -> {
            confirmationScene = new ConfirmationScene(STAGE, "Eliminar");

            if(confirmationScene.getConfirmation()) {
                try {
                    personaServices.delete(personaServices.findIndex(inputId.getText()));
                    inputId.clear();
                } catch (PersonaException personaException) {
                    personaException.printStackTrace();
                }
            }
        });

        cancel.setOnAction(e -> STAGE.close());
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

        TITLE.setFont(DataScene.FONT_TITLE);
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