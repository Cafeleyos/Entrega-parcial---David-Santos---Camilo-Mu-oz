package sample.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
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

public class AddScene {

    private Button buttonAdd, buttonCancel;
    private final Stage stage;
    private Scene addScene;
    private TextField inputName, inputLastname, inputAge, inputReason, inputId;
    private ComboBox<String> inputDepartment, inputSex, inputCondition, inputPosition;
    private Label name, lastname, age, sex, department, condition, reason, id, position;
    private GridPane pane;

    private static final Text TITLE = new Text("Nueva Persona");
    private PersonaServices personaServices;

    public AddScene(PersonaServices personaServices) {
        stage = new Stage();
        this.personaServices = personaServices;
        setUp();
        behavior();

        stage.setTitle("Añadir Nuevo Contacto");
        stage.setScene(addScene);
        stage.show();
    }

    public void setUp() {
        setUpButton();
        setUpInputs();
        setUpPane();
        addScene = new Scene(pane, 400, 550);
    }

    public void behavior() {
        buttonAdd.setOnAction(e -> {
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
        buttonCancel.setOnAction(e -> stage.close());
    }

    public void setUpPane () {
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

        pane.add(buttonAdd, 0, objectList.size() + 1, 2, 1);
        pane.add(buttonCancel, 1, objectList.size() + 1);
    }

    public void setUpButton () {
        buttonAdd = new Button("Agregar");
        buttonAdd.setPrefSize(100, 30);

        buttonCancel = new Button("Cancel");
        buttonCancel.setPrefSize(100, 30);
    }

    public void setUpInputs () {

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

    public void setUpDepartmentsComboBox () {
        ObservableList<String> departmentsList = FXCollections.observableArrayList();
        departmentsList.addAll(
                "Amazonas", "Antioquía", "Arauca", "Atlántico", "Bolívar", "Boyacá",
                "Caldas", "Caquetá", "Casanare", "Cauca", "Cesar", "Chocó", "Córdoba",
                "Cundinamarca", "Guainía", "Guaviare", "Huila", "La Guajira", "Magdalena",
                "Meta", "Nariño", "Norte de Santander", "Putumayo", "Quindío", "Risaralda",
                "San Andrés y Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca",
                "Vaupés", "Vichada");
        inputDepartment = new ComboBox<>(departmentsList);
        inputDepartment.setPromptText("-");
        inputDepartment.setMinWidth(200);
    }

    public void setUpSexComboBox () {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Masculino", "Femenino");
        inputSex = new ComboBox<>(list);
        inputSex.setPromptText("-");
        inputSex.setMinWidth(200);
    }

    public void setUpConditionComboBox () {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Vivo", "Herido", "Muerto", "Desconocido");
        inputCondition = new ComboBox<>(list);
        inputCondition.setPromptText("-");
        inputCondition.setMinWidth(200);
    }

    public void setUpPositionComboBox () {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Civil");
        for (ValidPublicEmployees v : ValidPublicEmployees.values()) {
            list.add(v.toString());
        }
        inputPosition = new ComboBox<>(list);
        inputPosition.setPromptText("-");
        inputPosition.setMinWidth(200);
    }

    private Map<Node, Node> createListOfObjets () {
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
}

