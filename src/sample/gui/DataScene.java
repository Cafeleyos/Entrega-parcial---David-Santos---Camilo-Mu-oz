package sample.gui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.logic.entities.Persona;
import sample.logic.services.implementation.PersonaServices;

import java.util.HashMap;
import java.util.Map;

public class DataScene extends Application {

    private TableView<Persona> table;
    private Scene dataScene;
    private PersonaServices personaServices = new PersonaServices();

    private Button delete;

    private GridPane pane, tablePane;
    private Text name;

    private MenuBar bar;
    private Map<String, MenuItem> menuItems;

    public static final Font FONT = new Font("DIALOG", 15);
    public static final Font FONT_TITLE = new Font("Tahoma", 20);

    @Override
    public void start(Stage primaryStage) {
        setUp();
        behavior();

        primaryStage.setTitle("Directorio del Paro de Colombia");
        primaryStage.setScene(dataScene);
        primaryStage.show();
    }

    public void behavior() {

        table.setItems((ObservableList<Persona>) this.personaServices.getAll());
        /*
        try {
            personaServices.insert(new Persona("Santiago", "Santos", "18", "Masculino",
                    "Tolima", "Vivo", "Ninguna", "100556934"));
            personaServices.insert(new Persona("Daniel", "Santos", "18", "Masculino",
                    "Tolima", "Vivo", "Ninguna", "110556935"));
            personaServices.insert(new Persona("Jose", "Santos", "18", "Masculino",
                    "Tolima", "Vivo", "Ninguna", "100556934"));
        } catch (PersonaException | IOException e) {
            e.printStackTrace();
        }
        */

        menuItems.get("Add").setOnAction(e -> new AddScene(this.personaServices));

        menuItems.get("Update").setOnAction(e -> new UpdateScene());

        menuItems.get("Delete").setOnAction(e -> new DeleteScene(this.personaServices));

        table.setOnMouseClicked(e -> {
            pane.getChildren().clear();
            if(table.getSelectionModel().getSelectedItem() != null) {
                for(Persona p : personaServices.getAll()) {
                    if(table.getSelectionModel().getSelectedItem().getId().equals(p.getId())) {
                        name = new Text(table.getSelectionModel().getSelectedItem().getName() + " " +
                                table.getSelectionModel().getSelectedItem().getLastName());
                        name.setFont(FONT_TITLE);
                        pane.add(name, 0, 1);
                    }
                }
            }
        });

        table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
    }

    public void a() {
        delete = new Button();
        delete.setPrefSize(100, 30);
    }

    public void setUp() {
        setUpTable();
        setUpMenu();
        setUpPane();

        BorderPane menuBar = new BorderPane();
        menuBar.setPadding(new Insets(-10));
        menuBar.setTop(bar);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(menuBar, tablePane, pane);

        dataScene = new Scene(layout, 1080, 720);
    }

    public void setUpPane() {
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER_RIGHT);
        pane.setVgap(20);
        pane.setHgap(20);

        tablePane = new GridPane();
        tablePane.setAlignment(Pos.CENTER_LEFT);
        tablePane.setHgap(20);
        tablePane.setVgap(20);

        tablePane.add(table, 0, 0);
    }

    public void setUpMenu() {
        Menu fileMenu = new Menu("Archivos");
        Menu editMenu = new Menu("Editar");
        Menu aboutMenu = new Menu("Acerca de");

        menuItems = new HashMap<>();
        menuItems.put("Import", new MenuItem("Importar"));
        menuItems.put("Export", new MenuItem("Exportar"));
        menuItems.put("Add", new MenuItem("Agregar"));
        menuItems.put("Update", new MenuItem("Actualizar"));
        menuItems.put("Delete", new MenuItem("Eliminar"));

        fileMenu.getItems().addAll(menuItems.get("Import"), menuItems.get("Export"));
        editMenu.getItems().addAll(menuItems.get("Add"), menuItems.get("Update"), menuItems.get("Delete"));

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

        TableColumn<Persona, String> idColumn = new TableColumn<>("Cédula");
        idColumn.setMinWidth(20);
        idColumn.setMaxWidth(200);
        idColumn.setPrefWidth(150);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        table = new TableView<>();
        table.getColumns().addAll(nameColumn, lastNameColumn, idColumn);
        table.setMaxWidth(450);
    }

    public static void main(String[] args) {
        launch(args);
    }
}