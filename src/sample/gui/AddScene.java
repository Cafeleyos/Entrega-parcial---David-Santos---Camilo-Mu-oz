package sample.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.logic.entities.Persona;
import sample.logic.entities.PublicEmployee;
import sample.logic.services.PersonaException;
import sample.logic.ValidPublicEmployees;
import sample.logic.services.implementation.PersonaServices;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AddScene extends SetUp {

    private Button addButton, cancelButton;
    private GridPane buttonsBox;
    private final Stage stage;
    private Scene addScene;
    private GridPane pane;
    private VBox layout;

    private static final Text TITLE = new Text("Añadir");
    private final PersonaServices personaServices;

    public AddScene(PersonaServices personaServices) {
        super();
        stage = new Stage();
        this.personaServices = personaServices;
        setUp();
        behavior();

        stage.setTitle("Añadir Persona");
        stage.setScene(addScene);
        stage.show();
    }

    public void behavior() {
        addButton.setOnAction(e -> {
            try {
                boolean isPublicEmployee = false;
                for (ValidPublicEmployees v : ValidPublicEmployees.values()) {
                    if (inputPosition.getValue().equals(v.toString())) {
                        isPublicEmployee = true;
                    }
                }
                if (!isPublicEmployee) {
                    Persona persona = new Persona(inputName.getText(), inputLastname.getText(), inputAge.getText(),
                            inputSex.getValue(), inputDepartment.getValue(), inputCondition.getValue(), inputReason.getText(),
                            inputId.getText());
                    personaServices.insert(persona);
                } else {
                    PublicEmployee publicEmployee = new PublicEmployee(inputName.getText(), inputLastname.getText(), inputAge.getText(),
                            inputSex.getValue(), inputDepartment.getValue(), inputCondition.getValue(), inputReason.getText(),
                            inputId.getText(), inputPosition.getValue());
                    personaServices.insert(publicEmployee);
                }
                inputId.clear();
                inputReason.clear();
                inputAge.clear();
                inputLastname.clear();
                inputName.clear();
                stage.close();
                new AddScene(personaServices);

            } catch (IOException | PersonaException exception) {
                exception.printStackTrace();
            }
        });
        cancelButton.setOnAction(e -> stage.close());
    }

    public void setUp() {
        setUpInputs();
        setUpButtons();
        setUpPane();
        setUpLayout();

        addScene = new Scene(layout, 400, 550);
    }

    public void setUpInputs () {
        //labels
        setUpLabels(labelsList());

        Map<Label, String> list = labelsList();

        //Nombre
        inputName.setPromptText(list.get(name));

        //Apellido
        inputLastname.setPromptText(list.get(lastname));

        //Edad
        inputAge.setPromptText(list.get(age));
        
        //Razón
        inputReason.setPromptText(list.get(reason));

        //Identificación
        inputId.setPromptText(list.get(id));
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
        addButton = new Button("Añadir");
        addButton.setPrefSize(142,30);

        cancelButton = new Button("Cancelar");
        cancelButton.setPrefSize(142,30);

        buttonsBox.add(addButton,0,0);
        buttonsBox.add(cancelButton,1,0);
    }
    private void setUpLayout(){
        layout = new VBox();
        layout.setPadding(new Insets(20));
        layout.setSpacing(20);

        layout.getChildren().addAll(pane,buttonsBox);
    }
}

