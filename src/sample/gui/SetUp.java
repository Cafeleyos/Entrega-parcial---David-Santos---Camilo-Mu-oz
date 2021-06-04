package sample.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.logic.ValidPublicEmployees;

import java.util.*;

public class SetUp {
    protected TextField inputName, inputLastname, inputAge, inputReason, inputId;
    protected ComboBox<String> inputDepartment, inputSex, inputCondition, inputPosition;
    protected Label name, lastname, age, sex, department, condition, reason, id, position;
    public static final int NUMBER_OF_ITEMS = 9;
    public static final String POSITION = "Posición";
    public static final String NAME  = "Nombre";
    public static final String LAST_NAME = "Apellido";
    public static final String AGE = "Edad";
    public static final String ID = "Identificación";
    public static final String SEX = "Sexo";
    public static final String DEPARTMENT = "Departamento";
    public static final String CONDITION = "Condición";
    public static final String REASON = "Razón";

    public SetUp() {
        initInputs();
        setUpInputs();
    }
    
    private void setUpInputs(){
        setUpLabels(labelsList());
        
        //Posición
        setUpPositionComboBox(inputPosition);
      
        //Sexo
        setUpSexComboBox(inputSex);

        //Departamento
        setUpDepartmentsComboBox(inputDepartment);

        //Condición
        setUpConditionComboBox(inputCondition);

    }

    private void setUpDepartmentsComboBox (ComboBox<String> comboBox) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll(
                "Amazonas", "Antioquía", "Arauca", "Atlántico", "Bolívar", "Boyacá",
                "Caldas", "Caquetá", "Casanare", "Cauca", "Cesar", "Chocó", "Córdoba",
                "Cundinamarca", "Guainía", "Guaviare", "Huila", "La Guajira", "Magdalena",
                "Meta", "Nariño", "Norte de Santander", "Putumayo", "Quindío", "Risaralda",
                "San Andrés y Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca",
                "Vaupés", "Vichada");

        comboBox.setItems(list);
        comboBox.setPromptText("-");
        comboBox.setMinWidth(200);
    }

    private void setUpSexComboBox (ComboBox<String> comboBox) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Masculino", "Femenino");

        comboBox.setItems(list);
        comboBox.setPromptText("-");
        comboBox.setMinWidth(200);
    }

    private void setUpConditionComboBox (ComboBox<String> comboBox) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Vivo", "Herido", "Muerto", "Desconocido");

        comboBox.setItems(list);
        comboBox.setPromptText("-");
        comboBox.setMinWidth(200);
    }

    private void setUpPositionComboBox (ComboBox comboBox) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Civil");
        for (ValidPublicEmployees v : ValidPublicEmployees.values()) {
            list.add(v.toString());
        }
        comboBox.setItems(list);
        comboBox.setPromptText("-");
        comboBox.setMinWidth(200);
    }

    protected void setUpLabels(Map<Label, String> map){
        for (Map.Entry<Label,String> e: map.entrySet()){
            e.getKey().setFont(DataScene.FONT);
            e.getKey().setText(e.getValue());
        }
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

    protected Map<Node, Node> listOfObjects () {
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

    protected Map<Label, String> labelsList() {
        Map<Label, String> labels = new HashMap<>();
        labels.put(name, NAME);
        labels.put(lastname,LAST_NAME);
        labels.put(age,AGE);
        labels.put(id,ID);
        labels.put(sex,SEX);
        labels.put(department,DEPARTMENT);
        labels.put(condition,CONDITION);
        labels.put(reason,REASON);
        labels.put(position,POSITION);

        return labels;
    }

    public List<String> stringList() {
        List<String> list = new ArrayList<>();
        list.add(POSITION);
        list.add(NAME);
        list.add(LAST_NAME);
        list.add(AGE);
        list.add(ID);
        list.add(SEX);
        list.add(DEPARTMENT);
        list.add(CONDITION);
        list.add(REASON);
        return list;
    }
}