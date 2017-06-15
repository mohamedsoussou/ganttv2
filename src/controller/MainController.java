/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXDatePicker;
import dao.AffEquipementDao;
import dao.CaseeDao;
import dao.ExploitationDao;
import dao.NiveauDao;
import dao.StockDao;
import dao.TrancheDao;
import entities.AffEquipement;
import entities.Casee;
import entities.Exploitation;
import entities.Niveau;
import entities.Stock;
import entities.Tranche;
import helpper.ExploitationHelpper;
import helpper.MachineHelpper;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.DateUtil;
import util.Strings;

/**
 * FXML Controller class
 *
 * @author Aimad.JAOUHAR
 */
public class MainController implements Initializable {

    @FXML
    private Button btnActualiserCase;
    @FXML
    private Button btnAjouterCase;
    @FXML
    private Button btnGanttCase;
    @FXML
    private Button btnSupprimerCase;
    @FXML
    private Button btnModifierExploitation;
    @FXML
    private TableView<Exploitation> exploitationTable = new TableView<>();
    @FXML
    private Button btnAjouterPrelevement;
    @FXML
    private Button btnAffichGraph;
    @FXML
    private ComboBox<?> comboQualite1;
    @FXML
    private ComboBox<?> comboQualite2;
    @FXML
    private ComboBox<?> comboQualite3;
    @FXML
    private LineChart<?, ?> chartEvolutionStock;
    @FXML
    private Button btnActualiserMachine;
    @FXML
    private Button btnGanttMachine;
    @FXML
    private TableView<AffEquipement> machineTable = new TableView<>();
    @FXML
    private ComboBox<Tranche> comboTranche;
    @FXML
    private ComboBox<Casee> comboCasee;
    @FXML
    private ComboBox<Niveau> comboNivBut;
    @FXML
    private TextField textIndice;
    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXDatePicker timePicker;
    @FXML
    private Button btnEnregistrerExploitation;
    @FXML
    private ComboBox<?> comboQualite;
    @FXML
    private TextField txtQuantite;
    @FXML
    private JFXDatePicker datePickerStock;
    @FXML
    private JFXDatePicker timePickerStock;
    @FXML
    private Button btnEnregistrerStock;
    @FXML
    private SwingNode swingNode;
    
    private List<AffEquipement> affEquipements;
    private List<Niveau> niveaus;
    private List<Tranche> tranches;

    private Exploitation selectedExploitation;

    private MachineHelpper machineHelpper;
    private ExploitationHelpper exploitationHelpper;

    private AffEquipementDao affEquipementDao = new AffEquipementDao();
    private ExploitationDao exploitationDao = new ExploitationDao();
    private NiveauDao niveauDao = new NiveauDao();
    private TrancheDao trancheDao = new TrancheDao();
    private StockDao stockDao = new StockDao();

    @FXML
    private void onClickActualiserCase(ActionEvent event) {
    }

    @FXML
    private void onClickAjouterCase(ActionEvent event) throws IOException {
        showDialog(Strings.DIALOGUE_MESSAGE_CREATION_TITLE, "Fenetre1");
    }

    @FXML
    private void onClickGanttCase(ActionEvent event) {
    }

    @FXML
    private void onClickSupprimerExploitation(ActionEvent event) {
        int code = exploitationDao.supprimer(selectedExploitation);
        showErrorsExploitationDrop(code);
    }

    @FXML
    private void onClickBtnEnregistrerExploitation(ActionEvent event) {
        selectedExploitation = getExploitationAttributes();
        int code = exploitationDao.enregistrer(selectedExploitation);
        if (code > 0) {
            exploitationHelpper.create(selectedExploitation);
            selectedExploitation = null;
        }
        showErrorsExploitationCreation(code);
    }

    @FXML
    private void onClickModifierExploitation(ActionEvent event) throws IOException {
        selectedExploitation = injectExploitationAttributes();
        if (selectedExploitation != null) {
            showDialog(Strings.DIALOGUE_MESSAGE_MODIFICATION_TITLE, "Fenetre1");
        }
    }

    @FXML
    private void onClickAjouterPrelevement(ActionEvent event) throws IOException {
        showDialog(Strings.DIALOGUE_MESSAGE_CREATION_PRELEVEMENT, "FenetreAjouterPre");
    }

    @FXML
    private void onClickBtnAffichGraph(ActionEvent event) {
    }

    @FXML
    private void onSelectComboTranche(ActionEvent event) {
        comboCasee.setItems(FXCollections.observableArrayList(((Tranche) comboTranche.getSelectionModel().getSelectedItem()).getCasee()));
    }

    @FXML
    private void onSelectComboQualite1(ActionEvent event) {
    }

    @FXML
    private void onSelectComboQualite2(ActionEvent event) {
    }

    @FXML
    private void onSelectComboQualite3(ActionEvent event) {

    }

    @FXML
    private void onClickBtnActualiserMachine(ActionEvent event) {
        affEquipements = affEquipementDao.findAll();
        machineHelpper.setList(affEquipements);
    }

    @FXML
    private void onClickBtnGanttMachine(ActionEvent event) {
    }

    @FXML
    private void onClickBtnEnregistrerStock(ActionEvent event) {
        Stock stock = getPrelevement();
        stockDao.addStock(stock);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTables();
        initAllButtons();
    }

    private void initAllButtons() {
        initButton(Strings.BTN_ICON_ACTUALISERCASE, Strings.BTN_TOOLTIP_ACTUALISERCASE, btnActualiserCase);
        initButton(Strings.BTN_ICON_ACTUALISERMACHINE, Strings.BTN_TOOLTIP_ACTUALISERMACHINE, btnActualiserMachine);
        initButton(Strings.BTN_ICON_AFFICHGRAPH, Strings.BTN_TOOLTIP_AFFICHGRAPH, btnAffichGraph);
        initButton(Strings.BTN_ICON_AJOUTERCASE, Strings.BTN_TOOLTIP_AJOUTERCASE, btnAjouterCase);
        initButton(Strings.BTN_ICON_AJOUTERPRELEVEMENT, Strings.BTN_TOOLTIP_AJOUTERPRELEVEMENT, btnAjouterPrelevement);
        initButton(Strings.BTN_ICON_ENREGISTRER, Strings.BTN_TOOLTIP_ENREGISTRER, btnEnregistrerExploitation);
        initButton(Strings.BTN_ICON_GANTTCASE, Strings.BTN_TOOLTIP_GANTTCASE, btnGanttCase);
        initButton(Strings.BTN_ICON_GANTTMACHINE, Strings.BTN_TOOLTIP_GANTTMACHINE, btnGanttMachine);
        initButton(Strings.BTN_ICON_MODIFIERCASE, Strings.BTN_TOOLTIP_MODIFIERCASE, btnModifierExploitation);
        initButton(Strings.BTN_ICON_SUPPRIMERCASE, Strings.BTN_TOOLTIP_SUPPRIMERCASE, btnSupprimerCase);
    }

    private void initButton(String icon, String toolTip, Button btn) {
        btn = new Button();
        btn.setTooltip(new Tooltip(toolTip));
    }

    private void initAllComboBox() {
        niveaus = niveauDao.findAll();
        comboNivBut.setItems(FXCollections.observableArrayList(niveaus));
        tranches = trancheDao.findAll();
        comboTranche.setItems(FXCollections.observableArrayList(tranches));
    }

    private void initTables() {
        machineHelpper = new MachineHelpper(machineTable);
        exploitationHelpper = new ExploitationHelpper(exploitationTable);
    }

    private void showDialog(String message, String fenetre) throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/" + fenetre + ".fxml"));
        final Parent root = loader.load();
        final Scene scene = new Scene(root, 300, 250);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
    private Stock getPrelevement(){
        Stock stock =new Stock();
        //stock.setNumero((Long) comboQualite.getSelectionModel().getSelectedItem());
        stock.setDatee(DateUtil.fxDateTimeToJava(datePickerStock, timePickerStock));
        return stock;
    }

    private Exploitation getExploitationAttributes() {
        Exploitation exploitation = new Exploitation();
        exploitation.setCasee((Casee) comboCasee.getSelectionModel().getSelectedItem());
        exploitation.setNiveauBut((Niveau) comboNivBut.getSelectionModel().getSelectedItem());
        exploitation.setIndicePriorite(Integer.parseInt(textIndice.getText()));
        exploitation.setDateDebut(new Date(datePicker.getValue().getYear(), datePicker.getValue().getMonthValue(), datePicker.getValue().getDayOfMonth(), timePicker.getTime().getHour(), timePicker.getTime().getMinute()));
        return exploitation;
    }

    private Exploitation injectExploitationAttributes() {
        Exploitation exploitation = exploitationHelpper.getSelected();
        if (exploitation == null) {
            comboCasee.getSelectionModel().select(exploitation.getCasee());
            comboTranche.getSelectionModel().select(exploitation.getCasee().getTranche());
            comboNivBut.getSelectionModel().select(exploitation.getNiveauBut());
            textIndice.setText(exploitation.getIndicePriorite() + "");
            DateUtil.javaUtilToFxDate(datePicker, exploitation.getDateDebut());
            DateUtil.javaUtilToFxTime(timePicker, exploitation.getDateDebut());
        }
        return exploitation;
    }

    private void showErrorsExploitationCreation(int code) {
        switch (code) {
            case -1:
                break;
            case -2:
                break;
            case -3:
                break;
            case -4:
                break;
            case -5:
                break;
            case 1:
                break;
            default:;
        }
    }

    private void showErrorsExploitationDrop(int code) {
        switch (code) {
            case -1:
                break;
            case 1:
                break;
            default:;
        }
    }

}
