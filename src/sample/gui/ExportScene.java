package sample.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.logic.services.IPersonaServices;
import sample.logic.services.implementation.PersonaServices;

import java.io.FileNotFoundException;

public class ExportScene extends Stage {

    private Scene exportScene;
    private final Stage STAGE;

    public static final Text TEXT = new Text("Elija una Opción");

    private final ComboBox<String> EXPORTABLE = new ComboBox<>();
    private Character character;
    private GridPane pane;

    private Button confirmation, cancel;

    private IPersonaServices personaServices;

    public ExportScene(IPersonaServices personaServices, Stage ownerStage) {
        STAGE = new Stage();
        this.personaServices = personaServices;

        setUp();
        behavior();

        STAGE.setTitle("Exportar");
        STAGE.initOwner(ownerStage);
        STAGE.initModality(Modality.APPLICATION_MODAL);
        STAGE.setScene(exportScene);
        STAGE.showAndWait();
    }

    public void setUp() {
        setUpButton();
        setUpComboBox(EXPORTABLE);
        setUpPane();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(TEXT, EXPORTABLE, pane);
        TEXT.setFont(DataScene.FONT_TITLE);
        vBox.setAlignment(Pos.CENTER);

        exportScene = new Scene(vBox, 400, 200);
    }

    public void behavior() {
        personaServices = new PersonaServices();

        confirmation.setOnAction(e -> {
            STAGE.close();
            switch (EXPORTABLE.getValue()) {
                case "CSV" -> character = ',';
                case "PCS" -> character = ';';
                case "BSC" -> character = '|';
            }
            try {
                this.personaServices.export(character);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        cancel.setOnAction(e -> STAGE.close());
    }

    public void setUpPane() {
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(confirmation, 0, 2);
        pane.add(cancel, 1, 2);
    }

    public void setUpButton() {
        confirmation = new Button("Aceptar");
        confirmation.setPrefSize(100, 30);

        cancel = new Button("Cancelar");
        cancel.setPrefSize(100, 30);
    }

    public void setUpComboBox(ComboBox<String> comboBox) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("CSV", "PCS", "BSC");

        comboBox.setItems(list);
        comboBox.setPromptText("-");
        comboBox.setMinWidth(200);
    }
}
