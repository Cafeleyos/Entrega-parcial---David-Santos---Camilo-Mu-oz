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
import javafx.stage.Stage;
import sample.logic.entities.Persona;

import java.util.HashMap;
import java.util.Map;

public class DataScene extends Application {

    private TableView<Persona> table;
    private Scene dataScene;

    private MenuBar bar;
    private Map<String, MenuItem> fileMenuItems;

    @Override
    public void start(Stage primaryStage) throws Exception{

        setUp();

        primaryStage.setTitle("Directorio del Paro de Colombia");
        primaryStage.setScene(dataScene);
        primaryStage.show();
    }

    public void setUp() {
        setUpTable();
        setUpMenu();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(table);

        BorderPane menuBar = new BorderPane();
        menuBar.setTop(bar);

        dataScene = new Scene(layout, 1080, 720);
    }

    public void setUpMenu() {
        Menu fileMenu = new Menu("Archivos");
        Menu editMenu = new Menu("Editar");
        Menu aboutMenu = new Menu("Acerca de");

        fileMenuItems = new HashMap<>();
        fileMenuItems.put("Agregar", new MenuItem("Agregar"));

        bar = new MenuBar();
        bar.getMenus().addAll(fileMenu, editMenu, aboutMenu);
    }

    public void setUpTable() {
        TableColumn<Persona, String> nameColumn = new TableColumn<>("Contacto");
        nameColumn.setMaxWidth(400);
        nameColumn.setPrefWidth(400);
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Contacto"));

        table = new TableView<>();
        table.getColumns().addAll(nameColumn);
        table.setMaxWidth(400);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
