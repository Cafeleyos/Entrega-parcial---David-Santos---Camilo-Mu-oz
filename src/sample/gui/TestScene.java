package sample.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.logic.entities.Persona;
import sample.logic.services.PersonaException;

import java.util.HashMap;
import java.util.Map;

public class TestScene extends Application {

    private TableView<Persona> table;
    private Scene dataScene;
    private TextField ageInput;
    private TextField idInput;
    private Button addButton;


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

    private void behavior() {

        addButton.setOnAction(e -> {
            try {
                System.out.println(new Persona("a","a",ageInput.getText(),"m","m","m","m",idInput.getText()));
            } catch (PersonaException personaException) {
                System.out.println(personaException.getMessage());
                personaException.printStackTrace();
            }
        });
    }

    public void setUp() {
        setUpTable();
        setUpMenu();
        setUpInputs();
        setUpButtons();

        BorderPane menuBar = new BorderPane();
        menuBar.setPadding(new Insets(-10));
        menuBar.setTop(bar);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(menuBar, table, ageInput,idInput,addButton);

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
        TableColumn<Persona, String> nameColumn = new TableColumn<>("Contacto");
        nameColumn.setPrefWidth(400);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Contacto"));

        table = new TableView<>();
        table.getColumns().addAll(nameColumn);
        table.setMaxWidth(400);
    }
    public void setUpInputs() {
        ageInput = new TextField();
        ageInput.setPromptText("age");
        ageInput.setMinWidth(30);

        idInput = new TextField();
        idInput.setPromptText("Id");
        idInput.setMinWidth(30);
    }
    public void setUpButtons()  {
        addButton = new Button();
        addButton.setText("Añadir");
        addButton.setMinWidth(30);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
