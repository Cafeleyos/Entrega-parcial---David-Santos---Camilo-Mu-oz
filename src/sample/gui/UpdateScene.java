package sample.gui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.logic.entities.Persona;
import sample.logic.services.implementation.PersonaServices;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UpdateScene {
    private Button updateButton, cancelButton;
    private GridPane buttonsBox;
    private SetUp setUp;
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
        this.setUp = new SetUp();
        this.persona = persona;
        setUp();
        behavior();

        stage.setTitle("Modificar Persona");
        stage.setScene(addScene);
        stage.show();
    }

    public void setUp() {
        setUpInputs();
        setUpButtons();
        setUpPane();


        addScene = new Scene(pane, 400, 550);
    }

    public void behavior() {

    }
    public void setUpInputs () {
        initInputs();

        //Labels
        setUp.setUpLabels(labelsList());

        //Posición
        setUp.setUpPositionComboBox(inputPosition);
        inputPosition.getSelectionModel().select(persona.getPosition());

        //Nombre
        inputName.setPromptText(persona.getName());

        //Apellido
        inputLastname.setPromptText(persona.getLastName());

        //Edad
        inputAge.setPromptText(Integer.toString(persona.getAge()));

        //Sexo
        setUp.setUpSexComboBox(inputSex);
        inputSex.getSelectionModel().select(persona.getSex());

        //Departamento
        setUp.setUpDepartmentsComboBox(inputDepartment);
        inputDepartment.getSelectionModel().select(persona.getDepartment());

        //Condición
        setUp.setUpConditionComboBox(inputCondition);
        inputCondition.getSelectionModel().select(persona.getCondition());

        //Razón
        inputReason.setPromptText(persona.getReason());

        //Identificación
        inputId.setPromptText(persona.getId());
    }

    private void initInputs() {
        //Text Fields
        inputName = new TextField();
        inputLastname = new TextField();
        inputAge = new TextField();
        inputReason = new TextField();
        inputId = new TextField();

        //ComboBoxes
        inputDepartment = new ComboBox<>();
        inputSex = new ComboBox<>();
        inputCondition = new ComboBox<>();
        inputPosition = new ComboBox<>();

        //Labels
        name = new Label();
        lastname = new Label();
        age = new Label();
        sex = new Label();
        department = new Label();
        condition = new Label();
        reason = new Label();
        id = new Label();
        position = new Label();
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
        pane.addRow(objectList.size()+1,buttonsBox);

    }

    public void setUpButtons () {
        buttonsBox = new GridPane();
        buttonsBox.setHgap(30);
        updateButton = new Button("Modificar");
        updateButton.setPrefSize(100,30);

        cancelButton = new Button("Cancel");
        cancelButton.setPrefSize(100,30);


        buttonsBox.add(updateButton,0,0);
        buttonsBox.add(cancelButton,1,0);
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

    public Map<Label, String> labelsList() {
        Map<Label, String> labels = new HashMap<>();
        labels.put(position,"Posición");
        labels.put(name,"Nombre");
        labels.put(lastname,"Apellido");
        labels.put(age,"Edad");
        labels.put(id,"Identificación");
        labels.put(sex,"Sexo");
        labels.put(department,"Departamento");
        labels.put(condition,"Condición");
        labels.put(reason,"Razón");

        return labels;
    }
}