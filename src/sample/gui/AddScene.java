package sample.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddScene extends Application {

    private Button buttonAdd;
    private Scene addScene;
    private TextField inputName, inputLastname, age, sex, department, condition, reason, id;
    private Text name, lastname;
    private DataScene dataScene = new DataScene();

    private static final Font FONT = new Font("DIALOG", 15);

    @Override
    public void start(Stage stage) throws Exception {
        setUp();

        stage.setTitle("Agregar Nuevo Contacto");
        stage.setScene(addScene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(dataScene.getPrimatyStage());
        stage.show();
    }

    public void setUp() {
        setUpButton();
        setUpImputs();

        HBox inputs = new HBox();
        inputs.getChildren().addAll(name, inputName);

        HBox buttons = new HBox();
        buttons.getChildren().addAll(buttonAdd);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(inputs, buttons);

        addScene = new Scene(layout, 400, 200);
    }

    //public void behavior() {
    //    buttonAdd.setOnAction();
    //}

    public void setUpButton() {
        buttonAdd = new Button("Add");
        buttonAdd.setPrefSize(100, 30);
    }

    public void setUpImputs() {
        name = new Text();
        name.setFont(FONT);
        name.setText("Nombre: ");
        inputName = new TextField();
        inputName.setPromptText("Nombre");
        inputName.setMaxWidth(100);

        lastname = new Text();
        lastname.setFont(FONT);
        lastname.setText("Apellido: ");
        inputName = new TextField();
        inputName.setPromptText("Apellido");
        inputName.setMaxWidth(100);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
