package sample.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExportScene extends Stage {

    private Scene exportScene;
    private Stage stage;

    private static final Text TEXT = new Text("Elija una Opción");

    private ComboBox<String> exportable = new ComboBox<>();
    private Character character;
    private GridPane pane;

    private Button confirmation, cancel;

    public ExportScene(Stage ownerStage) {
        stage = new Stage();

        setUp();
        behavior();

        stage.setTitle("Exportar");
        stage.initOwner(ownerStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(exportScene);
        stage.showAndWait();
    }

    public void setUp() {
        setUpButton();
        setUpComboBox(exportable);
        setUpPane();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(TEXT, exportable, pane);
        TEXT.setFont(DataScene.FONT_TITLE);
        vBox.setAlignment(Pos.CENTER);

        exportScene = new Scene(vBox, 400, 200);
    }

    public void behavior() {
        confirmation.setOnAction(e -> {
            stage.close();
            switch (exportable.getValue()) {
                case "CSV" -> character = ',';
                case "PCS" -> character = ';';
                case "BSC" -> character = '|';
            }
        });

        cancel.setOnAction(e -> stage.close());
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

    public Character getExport() {
        return character;
    }
}
