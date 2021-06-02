package sample.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import sample.logic.ValidPublicEmployees;

import java.util.Map;

public class SetUp {
    public static final String EMPTY = "-";

    public void setUpDepartmentsComboBox (ComboBox<String> comboBox, String text) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll(
                "Amazonas", "Antioquía", "Arauca", "Atlántico", "Bolívar", "Boyacá",
                "Caldas", "Caquetá", "Casanare", "Cauca", "Cesar", "Chocó", "Córdoba",
                "Cundinamarca", "Guainía", "Guaviare", "Huila", "La Guajira", "Magdalena",
                "Meta", "Nariño", "Norte de Santander", "Putumayo", "Quindío", "Risaralda",
                "San Andrés y Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca",
                "Vaupés", "Vichada");

        comboBox.setItems(list);
        comboBox.setPromptText(text);
        comboBox.setMinWidth(200);
    }

    public void setUpSexComboBox (ComboBox<String> comboBox, String text) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Masculino", "Femenino");

        comboBox.setItems(list);
        comboBox.setPromptText(text);
        comboBox.setMinWidth(200);
    }

    public void setUpConditionComboBox (ComboBox<String> comboBox, String text) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Vivo", "Herido", "Muerto", "Desconocido");

        comboBox.setItems(list);
        comboBox.setPromptText(text);
        comboBox.setMinWidth(200);
    }

    public void setUpPositionComboBox (ComboBox comboBox, String text) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Civil");
        for (ValidPublicEmployees v : ValidPublicEmployees.values()) {
            list.add(v.toString());
        }
        comboBox.setItems(list);
        comboBox.setPromptText(text);
        comboBox.setMinWidth(200);
    }

    public void setUpLabels(Map<Label, String> map){
        for (Map.Entry<Label,String> e: map.entrySet()){
            e.getKey().setFont(DataScene.FONT);
            e.getKey().setText(e.getValue());
        }
    }

}