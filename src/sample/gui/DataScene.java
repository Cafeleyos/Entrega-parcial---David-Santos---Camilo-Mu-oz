package sample.gui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.logic.entities.Persona;
import sample.logic.services.PersonaException;
import sample.logic.services.implementation.PersonaServices;

import java.util.HashMap;
import java.util.Map;

public class DataScene extends Application {

    private TableView<Persona> table;
    private Scene dataScene;
    private PersonaServices personaServices;

    private MenuBar bar;
    private Map<String, MenuItem> menuItems;

    @Override
    public void start(Stage primaryStage) throws Exception{
        setUp();
        behavior();

        primaryStage.setTitle("Directorio del Paro de Colombia");
        primaryStage.setScene(dataScene);
        primaryStage.show();
    }

    public void behavior() {
        personaServices = new PersonaServices();

        try {
            personaServices.insert(new Persona("Santiago", "Santos", "18", "Masculino", "Tólima", "Vivo", "Ninguna", "1005569340"));
        } catch (PersonaException e) {
            e.printStackTrace();
        }

        table.setItems((ObservableList<Persona>) personaServices.getAll());

        menuItems.get("Add").setOnAction(e -> new AddScene());

        menuItems.get("Delete").setOnAction(e -> new DeleteScene());
    }

    public void setUp() {
        setUpTable();
        setUpMenu();

        BorderPane menuBar = new BorderPane();
        menuBar.setPadding(new Insets(-10));
        menuBar.setTop(bar);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(menuBar, table);

        dataScene = new Scene(layout, 1080, 720);
    }

    public void setUpMenu() {
        Menu fileMenu = new Menu("Archivos");
        Menu editMenu = new Menu("Editar");
        Menu aboutMenu = new Menu("Acerca de");

        menuItems = new HashMap<>();
        menuItems.put("Import", new MenuItem("Importar"));
        menuItems.put("Export", new MenuItem("Exportar"));
        menuItems.put("Add", new MenuItem("Agregar"));
        menuItems.put("Act", new MenuItem("Actualizar"));
        menuItems.put("Delete", new MenuItem("Eliminar"));

        fileMenu.getItems().addAll(menuItems.get("Import"), menuItems.get("Export"));
        editMenu.getItems().addAll(menuItems.get("Add"), menuItems.get("Act"), menuItems.get("Delete"));

        bar = new MenuBar();
        bar.getMenus().addAll(fileMenu, editMenu, aboutMenu);
    }

    public void setUpTable() {
        TableColumn<Persona, String> nameColumn = new TableColumn<>("Nombre");
        nameColumn.setMinWidth(20);
        nameColumn.setMaxWidth(200);
        nameColumn.setPrefWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Persona, String> lastNameColumn = new TableColumn<>("Apellido");
        lastNameColumn.setMinWidth(20);
        lastNameColumn.setMaxWidth(200);
        lastNameColumn.setPrefWidth(150);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Persona, String> conditionColumn = new TableColumn<>("Condición");
        conditionColumn.setMinWidth(20);
        conditionColumn.setMaxWidth(200);
        conditionColumn.setPrefWidth(150);
        conditionColumn.setCellValueFactory(new PropertyValueFactory<>("condition"));

        table = new TableView<>();
        table.getColumns().addAll(nameColumn, lastNameColumn, conditionColumn);
        table.setMaxWidth(450);
    }

    public ObservableList<Persona> getSelectionPerson() {
        return table.getSelectionModel().getSelectedItems();
    }

    public static void main(String[] args) {
        launch(args);
    }
}