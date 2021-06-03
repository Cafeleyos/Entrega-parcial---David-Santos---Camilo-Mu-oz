package sample.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.logic.entities.Persona;
import sample.logic.services.implementation.PersonaServices;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UpdateScene extends SetUp{
    private Button updateButton, cancelButton;
    private GridPane buttonsBox;
    private Persona persona;
    private final Stage stage;
    private Scene addScene;
    private GridPane pane;
    private String uPosition, uName, uLastName, uAge, uId,uSex,uDepartment, uCondition,uReason;

    private static final Text TITLE = new Text("Edición");

    private final PersonaServices personaServices;
    private VBox layout;

    public UpdateScene(PersonaServices personaServices, Persona persona) {
        super();
        stage = new Stage();
        this.personaServices = personaServices;
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
        setUpLayout();

        addScene = new Scene(layout, 400, 550);
    }

    public void behavior() {
        updateButton.setOnAction(e -> {

        });
    }

    private Map<ComboBox, String> personaComboBoxes() {
        uPosition = persona.getPosition();
        uLastName = persona.getLastName();
        uAge = Integer.toString(persona.getAge());
        uId = persona.getId();
        uReason = persona.getReason();

        Map<ComboBox, String> textFields = new HashMap<>();
        textFields.put(inputPosition,uPosition);
        textFields.put(inputSex,uSex);
        textFields.put(inputDepartment,uDepartment);
        textFields.put(inputCondition,uCondition);


        return textFields;
    }

    private Map<TextField, String> personaTextFields(){
        uName = persona.getName();
        uSex = persona.getSex();
        uDepartment = persona.getDepartment();
        uCondition = persona.getCondition();

        Map<TextField, String> textFields = new HashMap<>();
        textFields.put(inputName,uName);
        textFields.put(inputLastname,uLastName);
        textFields.put(inputAge,uAge);
        textFields.put(inputId,uId);
        textFields.put(inputReason,uReason);

        return textFields;
    }

    
    public void setUpInputs () {

        //Posición
        inputPosition.getSelectionModel().select(persona.getPosition());

        //Nombre
        inputName.setPromptText(persona.getName());

        //Apellido
        inputLastname.setPromptText(persona.getLastName());

        //Edad
        inputAge.setPromptText(Integer.toString(persona.getAge()));

        //Sexo
        inputSex.getSelectionModel().select(persona.getSex());

        //Departamento
        inputDepartment.getSelectionModel().select(persona.getDepartment());

        //Condición
        inputCondition.getSelectionModel().select(persona.getCondition());

        //Razón
        inputReason.setPromptText(persona.getReason());

        //Identificación
        inputId.setPromptText(persona.getId());
    }
    
    public void setUpPane() {
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setVgap(20);

        TITLE.setFont(FONT_TITLE);

        pane.add(TITLE,0,0);

        int counter = 1;
        Map<Node, Node> objectList = listOfObjects();
        for (Map.Entry<Node, Node> p : objectList.entrySet()) {
            pane.add(p.getKey(), 0, counter);
            pane.add(p.getValue(), 1, counter);
            counter++;
        }

    }
    
    public void setUpButtons () {
        buttonsBox = new GridPane();
        buttonsBox.setHgap(30);
        buttonsBox.setAlignment(Pos.CENTER);
        updateButton = new Button("Modificar");
        updateButton.setPrefSize(142,30);

        cancelButton = new Button("Cancel");
        cancelButton.setPrefSize(142,30);

        buttonsBox.add(updateButton,0,0);
        buttonsBox.add(cancelButton,1,0);
    }
    
    private void setUpLayout(){
        layout = new VBox();
        layout.setPadding(new Insets(20));
        layout.setSpacing(20);

        layout.getChildren().addAll(pane,buttonsBox);
    }
}