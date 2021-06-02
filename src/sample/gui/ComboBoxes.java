package sample.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import sample.logic.ValidPublicEmployees;

public abstract class ComboBoxes {

    public void setUpDepartmentsComboBox (ComboBox comboBox,String text) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll(
                "Amazonas", "Antioquía", "Arauca", "Atlántico", "Bolívar", "Boyacá",
                "Caldas", "Caquetá", "Casanare", "Cauca", "Cesar", "Chocó", "Córdoba",
                "Cundinamarca", "Guainía", "Guaviare", "Huila", "La Guajira", "Magdalena",
                "Meta", "Nariño", "Norte de Santander", "Putumayo", "Quindío", "Risaralda",
                "San Andrés y Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca",
                "Vaupés", "Vichada");
        comboBox = new ComboBox<>(list);
        comboBox.setPromptText(text);
        comboBox.setMinWidth(200);
    }

    public void setUpSexComboBox (ComboBox comboBox,String text) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Masculino", "Femenino");
        comboBox = new ComboBox<>(list);
        comboBox.setPromptText(text);
        comboBox.setMinWidth(200);
    }

    public void setUpConditionComboBox (ComboBox comboBox,String text) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Vivo", "Herido", "Muerto", "Desconocido");
        comboBox = new ComboBox<>(list);
        comboBox.setPromptText(text);
        comboBox.setMinWidth(200);
    }

    public void setUpPositionComboBox (ComboBox comboBox,String text) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Civil");
        for (ValidPublicEmployees v : ValidPublicEmployees.values()) {
            list.add(v.toString());
        }
        comboBox = new ComboBox<>(list);
        comboBox.setPromptText(text);
        comboBox.setMinWidth(200);
    }

}