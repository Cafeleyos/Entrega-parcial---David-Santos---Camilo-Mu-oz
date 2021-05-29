package sample.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.logic.entities.Person;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataScene extends Application {

    private TableView<Person> table;
    private Scene dataScene;

    private AddScene addScene;
    private Stage primatyStage;

    private MenuBar bar;
    private Map<String, MenuItem> menuItems;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primatyStage = primaryStage;

        setUp();
        behavior();

        primaryStage.setTitle("Directorio del Paro de Colombia");
        primaryStage.setScene(dataScene);
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primatyStage;
    }

    public void behavior() {
        menuItems.get("Add").setOnAction(e -> {

        });
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
        TableColumn<Person, String> nameColumn = new TableColumn<>("Contacto");
        nameColumn.setPrefWidth(400);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Contacto"));

        table = new TableView<>();
        table.getColumns().addAll(nameColumn);
        table.setMaxWidth(400);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
