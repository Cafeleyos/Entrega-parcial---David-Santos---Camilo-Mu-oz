package sample.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.logic.entities.Persona;
import sample.logic.services.PersonaException;
import sample.logic.services.implementation.PersonaServices;

import static javafx.application.Application.launch;

public class AddScene extends Stage {

    private Button buttonAdd, buttonCancel;
    private Stage stage;
    private Scene addScene;
    private TextField inputName, inputLastname, inputAge, inputSex, inputDepartment, inputCondition, inputReason, inputId;
    private Label name, lastname, age, sex, department, condition, reason, id;
    private GridPane pane;
    private static final Text title = new Text("Nueva Persona");

    private static final Font FONT = new Font("DIALOG", 15);

    public AddScene() {
        stage = new Stage();

        setUp();
        behavior();

        stage.setTitle("Agregar Nuevo Contacto");
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
        PersonaServices personaServices = new PersonaServices();
        buttonAdd.setOnAction(e -> {
            try {
                Persona persona = new Persona(inputName.getText(), inputLastname.getText(), inputAge.getText(),
                        inputSex.getText(), inputDepartment.getText(), inputCondition.getText(), inputReason.getText(),
                        inputId.getText());
                personaServices.insert(persona);
                inputId.clear();
                inputReason.clear();
                inputAge.clear();
                inputSex.clear();
                inputLastname.clear();
                inputName.clear();
                inputCondition.clear();
                inputDepartment.clear();

                stage.close();
            } catch (PersonaException personaException) {
                personaException.printStackTrace();
            }
        });

        buttonCancel.setOnAction(e -> {
            stage.close();
        });
    }

    public void setUpPane() {
        pane = new GridPane();

        pane.setAlignment(Pos.CENTER);

        pane.setHgap(20);
        pane.setVgap(20);

        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        pane.add(title, 0, 0, 2, 1);

        pane.add(name, 0, 1);
        pane.add(inputName, 1, 1);

        pane.add(lastname, 0, 2);
        pane.add(inputLastname, 1, 2);

        pane.add(age, 0, 3);
        pane.add(inputAge, 1, 3);

        pane.add(sex, 0, 4);
        pane.add(inputSex, 1, 4);

        pane.add(department, 0, 5);
        pane.add(inputDepartment, 1, 5);

        pane.add(condition, 0, 6);
        pane.add(inputCondition, 1, 6);

        pane.add(reason, 0, 7);
        pane.add(inputReason, 1, 7);

        pane.add(id, 0, 8);
        pane.add(inputId, 1, 8);

        pane.add(buttonAdd, 0, 9,2,1);
        pane.add(buttonCancel, 1, 9);
    }

    public void setUpButton() {
        buttonAdd = new Button("Agregar");
        buttonAdd.setPrefSize(100, 30);

        buttonCancel = new Button("Cancel");
        buttonCancel.setPrefSize(100, 30);
    }

    public void setUpInputs() {
        name = new Label();
        name.setFont(FONT);
        name.setText("Nombre:");
        inputName = new TextField();
        inputName.setPromptText("Nombre");

        lastname = new Label();
        lastname.setFont(FONT);
        lastname.setText("Apellido:");
        inputLastname = new TextField();
        inputLastname.setPromptText("Apellido");

        age = new Label();
        age.setFont(FONT);
        age.setText("Años:");
        inputAge = new TextField();
        inputAge.setPromptText("Años");

        sex = new Label();
        sex.setFont(FONT);
        sex.setText("Sexo:");
        inputSex = new TextField();
        inputSex.setPromptText("Sexo");

        department = new Label();
        department.setFont(FONT);
        department.setText("Departamento:");
        inputDepartment = new TextField();
        inputDepartment.setPromptText("Departamento");

        condition = new Label();
        condition.setFont(FONT);
        condition.setText("Estado:");
        inputCondition = new TextField();
        inputCondition.setPromptText("Estado");

        reason = new Label();
        reason.setFont(FONT);
        reason.setText("Razón:");
        inputReason= new TextField();
        inputReason.setPromptText("Razón");

        id = new Label();
        id.setFont(FONT);
        id.setText("Cédula:");
        inputId = new TextField();
        inputId.setPromptText("Cédula");
    }
}
