package sample.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.logic.entities.Report;
import sample.logic.services.IPersonaServices;
import sample.logic.services.IReportServices;
import sample.logic.services.implementation.ReportServices;

import java.util.Map;

public class ReportScene {

    private Scene reportScene;
    private Stage stage;

    private Text titleAge, titleSex, titlePosition, titleDeaths;
    private Label age, sex, position, deaths;

    private GridPane pane;
    private static final String SPACE = ("              \n");

    private TableView<Map.Entry<String, Report>> table;

    private IReportServices reportServices;
    private IPersonaServices personaServices;

    public ReportScene(IPersonaServices personaServices, Stage ownerStage) {
        stage = new Stage();
        this.personaServices = personaServices;
        this.reportServices = new ReportServices(personaServices);

        setUp();
        behavior();

        stage.setTitle("Resumen");
        stage.initOwner(ownerStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(reportScene);
        stage.showAndWait();
    }

    public void setUp() {
        setUpText();
        setUpPane();
        setUpTable();

        reportScene = new Scene(pane, 860, 450);
    }

    public void behavior() {

    }

    private void setUpText() {
        age = new Label();
        age.setText(String.valueOf((int) reportServices.getReportByAge().getCount()) + "%");
        age.setFont(DataScene.FONT_TITLE);
        titleAge = new Text();
        titleAge.setText(reportServices.getReportByAge().getDescription());
        titleAge.setFont(DataScene.FONT);

        sex = new Label();
        sex.setText(String.valueOf(reportServices.getReportBySex().getCount()));
        sex.setFont(DataScene.FONT_TITLE);
        titleSex = new Text();
        titleSex.setText(reportServices.getReportBySex().getDescription());
        titleSex.setFont(DataScene.FONT);

        position = new Label();
        position.setText(String.valueOf(reportServices.getReportByPositionCivil().getCount()));
        position.setFont(DataScene.FONT_TITLE);
        titlePosition = new Text();
        titlePosition.setText(reportServices.getReportByPositionCivil().getDescription());
        titlePosition.setFont(DataScene.FONT);

        deaths = new Label();
        deaths.setText(String.valueOf((int) reportServices.getReportByCivilDeaths().getCount()));
        deaths.setFont(DataScene.FONT_TITLE);
        titleDeaths = new Text();
        titleDeaths.setText(reportServices.getReportByCivilDeaths().getDescription());
        titleDeaths.setFont(DataScene.FONT);
    }

    private void setUpPane() {
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        pane.add(age, 0, 0);
        pane.add(titleAge, 0, 1);

        pane.add(new Text(SPACE),1, 0);

        pane.add(sex, 2, 0);
        pane.add(titleSex, 2, 1);

        pane.add(new Text(SPACE),3, 0);

        pane.add(position, 4, 0);
        pane.add(titlePosition, 4, 1);

        pane.add(new Text(SPACE), 0, 2);

        pane.add(deaths, 0, 3);
        pane.add(titleDeaths, 0, 4);
    }

    public void setUpTable() {
        TableColumn<Map.Entry<String, Report>, String> departmentColumn = new TableColumn<>("Departamentos");
        departmentColumn.setMinWidth(20);
        departmentColumn.setMaxWidth(200);
        departmentColumn.setPrefWidth(150);
        //departmentColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, Report>, String>, ObservableValue<String>>() {
        //    @Override
        //    public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, Report>, String> entryStringCellDataFeatures) {
        //        return new SimpleStringProperty(entryStringCellDataFeatures.getValue().getKey());
        //    }
        //});

        TableColumn<Map.Entry<String, Report>, Integer> countColumn = new TableColumn<>("Personas del Directorio");
        countColumn.setMinWidth(20);
        countColumn.setMaxWidth(200);
        countColumn.setPrefWidth(150);
        //countColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, Report>, Integer>, ObservableValue<Integer>>() {
        //    @Override
        //    public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Map.Entry<String, Report>, Integer> entryIntegerCellDataFeatures) {
        //        return new SimpleObjectProperty<>(entryIntegerCellDataFeatures.getValue().getValue().getCount());
        //    }
        //});

        Map<String, Report> reportMap = reportServices.getReportByDepartment();

        ObservableList<Map.Entry<String, Report>> items = FXCollections.observableArrayList(reportMap.entrySet());

        table = new TableView<>(items);
        table.getColumns().addAll(departmentColumn, countColumn);
        table.setMaxWidth(300);
        table.setPrefWidth(300);
    }
}
