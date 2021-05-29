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

public class AddScene extends Stage {

    private Button buttonAdd;
    private Scene addScene;
    private TextField inputName, inputLastname, inputAge, inputSex, inputDepartment, inputCondition, inputReason, inputId;
    private Text name, lastname, age, sex, department, condition, reason, id;
    private DataScene dataScene = new DataScene();

    private static final Font FONT = new Font("DIALOG", 15);

    public AddScene(Stage stage) {
        setUp();

        stage.setTitle("Agregar Nuevo Contacto");
        stage.setScene(addScene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(dataScene.getPrimaryStage());
        stage.show();
    }

    public void setUp() {
        setUpButton();
        setUpImputs();

        HBox inputsNameLastname = new HBox(10);
        inputsNameLastname.getChildren().addAll(name, inputName, lastname, inputLastname);

        HBox inputsAgeSex = new HBox(10);
        inputsNameLastname.getChildren().addAll(age, inputAge, sex, inputSex);

        HBox buttons = new HBox();
        buttons.getChildren().addAll(buttonAdd);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(inputsNameLastname, buttons);

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
        name.setText("Nombre:");
        inputName = new TextField();
        inputName.setPromptText("Nombre");
        inputName.setMaxWidth(100);

        lastname = new Text();
        lastname.setFont(FONT);
        lastname.setText("Apellido:");
        inputLastname = new TextField();
        inputLastname.setPromptText("Apellido");
        inputLastname.setMaxWidth(100);

        age = new Text();
        age.setFont(FONT);
        age.setText("Años:");
        inputAge = new TextField();
        inputAge.setPromptText("Años");
        inputAge.setMaxWidth(100);

        sex = new Text();
        sex.setFont(FONT);
        sex.setText("Sexo:");
        inputSex = new TextField();
        inputSex.setPromptText("Sexo");
        inputSex.setMaxWidth(100);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
