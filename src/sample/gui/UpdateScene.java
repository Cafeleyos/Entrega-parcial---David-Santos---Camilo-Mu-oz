package sample.gui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.logic.entities.Persona;
import sample.logic.entities.PublicEmployee;
import sample.logic.services.implementation.PersonaServices;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
        this.persona = persona;
        setUp();
        behavior();

        stage.setTitle("Modificar Persona");
        stage.setScene(addScene);
        stage.show();
    }

    public void setUp() {
        setUpInputs();
        setUpPane();


        addScene = new Scene(pane, 400, 550);
    }

    public void behavior() {

    }
    public void setUpInputs () {

        position = new Label();
        position.setFont(DataScene.FONT);
        position.setText("Nombre:");
        inputPosition = new ComboBox<>();
        comboBoxes.setUpPositionComboBox(inputPosition,ComboBoxes.EMPTY);
        inputPosition.getSelectionModel().select(persona.getPosition());


        name = new Label();
        name.setFont(DataScene.FONT);
        name.setText("Nombre:");
        inputName = new TextField();
        inputName.setPromptText(persona.getName());

        lastname = new Label();
        lastname.setFont(DataScene.FONT);
        lastname.setText("Apellido:");
        inputLastname = new TextField();
        inputLastname.setPromptText(persona.getLastName());

        age = new Label();
        age.setFont(DataScene.FONT);
        age.setText("Años:");
        inputAge = new TextField();
        inputAge.setPromptText(Integer.toString(persona.getAge()));

        sex = new Label();
        sex.setFont(DataScene.FONT);
        sex.setText("Sexo:");
        inputSex = new ComboBox<>();
        comboBoxes.setUpSexComboBox(inputSex,ComboBoxes.EMPTY);
        inputSex.getSelectionModel().select(persona.getSex());

        department = new Label();
        department.setFont(DataScene.FONT);
        department.setText("Departamento");
        inputDepartment = new ComboBox<>();
        comboBoxes.setUpDepartmentsComboBox(inputDepartment,ComboBoxes.EMPTY);
        inputDepartment.getSelectionModel().select(persona.getDepartment());

        condition = new Label();
        condition.setFont(DataScene.FONT);
        condition.setText("Estado:");
        inputCondition = new ComboBox<>();
        comboBoxes.setUpConditionComboBox(inputCondition,ComboBoxes.EMPTY);
        inputCondition.getSelectionModel().select(persona.getCondition());

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

        int counter = 1;
        Map<Node, Node> objectList = createListOfObjets();
        for (Map.Entry<Node, Node> p : objectList.entrySet()) {
            pane.add(p.getKey(), 0, counter);
            pane.add(p.getValue(), 1, counter);
            counter++;
        }


    }

    public Map<Node, Node> createListOfObjets () {
        Map<Node, Node> objectList = new LinkedHashMap<>();
        objectList.put(position, inputPosition);
        objectList.put(name, inputName);
        objectList.put(lastname, inputLastname);
        objectList.put(age, inputAge);
        objectList.put(id, inputId);
        objectList.put(sex, inputSex);
        objectList.put(department, inputDepartment);
        objectList.put(condition, inputCondition);
        objectList.put(reason, inputReason);
        return objectList;
    }

    public void setUpLabels() {
        Map<Label, String> labels = new HashMap<>();
        labels.put(position,"Posición");
        labels.put(name,"Nombre");
        labels.put(lastname,"Apellido");
        labels.put(age,"Edad");
        labels.put(id,"Cédula");
        labels.put(sex,"Sexo");
        labels.put(department,"Departamento");
        labels.put(condition,"Posición");
        labels.put(reason,"Posición");
    }
}