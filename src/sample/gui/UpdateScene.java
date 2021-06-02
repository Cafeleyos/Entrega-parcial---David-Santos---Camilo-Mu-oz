package sample.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.logic.entities.Persona;
import sample.logic.services.implementation.PersonaServices;

public class UpdateScene {
    private Button buttonAdd, buttonCancel;
    private ComboBoxes comboBoxes;
    private Persona persona;
    private final Stage stage;
    private Scene addScene;
    private TextField inputName, inputLastname, inputAge, inputReason, inputId;
    private ComboBox<String> inputDepartment, inputSex, inputCondition, inputPosition;
    private Label name, lastname, age, sex, department, condition, reason, id, position;
    private GridPane pane;

    private static final Text TITLE = new Text("Modificar Persona");

    private final PersonaServices personaServices;

    public UpdateScene(PersonaServices personaServices, Persona persona) {
        stage = new Stage();
        this.personaServices = personaServices;
        this.comboBoxes = new ComboBoxes();
        setUp();
        behavior();

        stage.setTitle("Modificar Persona");
        stage.setScene(addScene);
        stage.show();
    }

    public void setUp() {
        setUpPane();
        setUpInputs();

        addScene = new Scene(pane, 400, 550);
    }

    public void behavior() {

    }
    public void setUpInputs () {

        position = new Label();
        position.setFont(DataScene.FONT);
        position.setText("Posición:");
        inputPosition = new ComboBox<>();
        comboBoxes.setUpPositionComboBox(inputPosition,ComboBoxes.EMPTY);

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
        inputSex = new ComboBox<>();
        comboBoxes.setUpSexComboBox(inputSex,ComboBoxes.EMPTY);

        department = new Label();
        department.setFont(DataScene.FONT);
        department.setText("Departamento");
        inputDepartment = new ComboBox<>();
        comboBoxes.setUpDepartmentsComboBox(inputDepartment,ComboBoxes.EMPTY);

        condition = new Label();
        condition.setFont(DataScene.FONT);
        condition.setText("Estado:");
        inputCondition = new ComboBox<>();
        comboBoxes.setUpConditionComboBox(inputCondition,ComboBoxes.EMPTY);

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

    public void setUpPane() {
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setVgap(20);

        TITLE.setFont(DataScene.FONT_TITLE);
        pane.add(TITLE, 0, 0, 2, 1);
    }
}