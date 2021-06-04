package sample.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.logic.entities.Report;
import sample.logic.services.IReportServices;
import sample.logic.services.implementation.ReportServices;

public class ReportScene {

    private Scene reportScene;
    private Stage stage;

    private TableView<Report> table;

    private IReportServices reportServices;

    public ReportScene(Stage ownerStage) {
        stage = new Stage();

        setUp();
        behavior();

        stage.setTitle("Resumen");
        stage.initOwner(ownerStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(reportScene);
        stage.showAndWait();
    }

    public void setUp() {
        setUpTable();

        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(table);

        reportScene = new Scene(layout, 500, 200);
    }

    public void behavior() {
        this.reportServices = new ReportServices();
    }

    public void setUpTable() {
        TableColumn<Report, String> departmentColumn = new TableColumn<>("department");
        departmentColumn.setMinWidth(20);
        departmentColumn.setMaxWidth(200);
        departmentColumn.setPrefWidth(150);
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

        TableColumn<Report, Integer> countColumn = new TableColumn<>("count");
        countColumn.setMinWidth(20);
        countColumn.setMaxWidth(200);
        countColumn.setPrefWidth(150);
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("count"));

        table = new TableView<>();
        table.getColumns().addAll(departmentColumn, countColumn);
    }
}
