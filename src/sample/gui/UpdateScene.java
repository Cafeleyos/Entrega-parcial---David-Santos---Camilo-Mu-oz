package sample.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.logic.services.implementation.PersonaServices;

public class UpdateScene {
    private static final Text TITLE = new Text("Modificar Persona");
    private Stage stage;
    private Scene updateScene;
    private PersonaServices personaServices;
    private GridPane pane;
    private TextField inputName, inputLastname, inputAge, inputReason, inputId;
    private ComboBox<String> inputDepartment, inputSex, inputCondition, inputPosition;
    private Label name, lastname, age, sex, department, condition, reason, id, position;

    public UpdateScene(PersonaServices personaServices) {
        stage = new Stage();
        this.personaServices = personaServices;
        setUp();
        behavior();

        stage.setTitle("Modificar Persona");
        stage.setScene(updateScene);
        stage.show();

    }

    private void setUp() {
        setUpLayout();
        //setUpInputs();
        updateScene = new Scene(pane,400,550);
    }


    /*
    private void setUpInputs() {

        position = new Label();
        position.setFont(DataScene.FONT);
        position.setText("Posición:");
        setUpPositionComboBox();

        name = new Label();
        name.setFont(DataScene.FONT);
        name.setText("Nombre:");
        inputName = new TextField();
        inputName.setPromptText("Nombre");

        lastname = new Label();
        lastname.setFont(DataScene.FONT);
        lastname.setText("Apellido:");
        inputLastname = new TextField();
        inputLastname.setPromptText("Apellido");

        age = new Label();
        age.setFont(DataScene.FONT);
        age.setText("Años:");
        inputAge = new TextField();
        inputAge.setPromptText("Años");

        sex = new Label();
        sex.setFont(DataScene.FONT);
        sex.setText("Sexo:");
        setUpSexComboBox();

        department = new Label();
        department.setFont(DataScene.FONT);
        department.setText("Departamento");
        setUpDepartmentsComboBox();

        condition = new Label();
        condition.setFont(DataScene.FONT);
        condition.setText("Estado:");
        setUpConditionComboBox();

        reason = new Label();
        reason.setFont(DataScene.FONT);
        reason.setText("Razón:");
        inputReason = new TextField();
        inputReason.setPromptText("Razón");

        id = new Label();
        id.setFont(DataScene.FONT);
        id.setText("Identificación:");
        inputId = new TextField();
        inputId.setPromptText("Identificación");
    }
    */
    private void setUpLayout() {
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setVgap(20);
        TITLE.setFont(DataScene.FONT_TITLE);
        pane.add(TITLE, 0, 0);

    }

    private void behavior(){

    }
}