package project;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Dashboardcontoller implements Initializable{

   @FXML
    private Label Fullname;

    @FXML
    private Label age;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private BorderPane borderpane;

    @FXML
    private Label chosensport;

    @FXML
    private Label city;

    @FXML
    private Label condition;

    @FXML
    private Label conditionkind;

    @FXML
    private Label course;

    @FXML
    private Label email;

    @FXML
    private Label experiencesport;

    @FXML
    private Label height;

    @FXML
    private Label mobile;

    @FXML
    private Label nation;

    @FXML
    private Label prov;

    @FXML
    private Label religion;

    @FXML
    private Label sex;

    @FXML
    private Label specificsport;

    @FXML
    private Label street;

    @FXML
    private Label studentid;

    @FXML
    private VBox vbox;

    @FXML
    private VBox vbox1;
    
    @FXML
    private HBox hbox;
    
    @FXML
    private Label weight;

     @FXML
    private TableView<players> table;
    
    @FXML
    private TableColumn<players, String> agecol;


    @FXML
    private TextField sqlsearch;
    
    @FXML
    private TableColumn<players, String> coursecol;

    @FXML
    private TableColumn<players, String> emailcol;

    @FXML
    private TableColumn<players, String> hcol;

    @FXML
    private TableColumn<players, String> mobilecol;

    @FXML
    private TableColumn<players, String> namecol;

    @FXML
    private TableColumn<players, String> sexcol;

    @FXML
    private TableColumn<players, String> sportcol;

    @FXML
    private TableColumn<players, String> studidcol;

    @FXML
    private TableColumn<players, String> wcol;

    String query  = null;
    Connection connectdb = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    players players = null;
    
    ObservableList<players> list = FXCollections.observableArrayList();
     ObservableList<players> filteredlist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       try {
           loadtable();
       } catch (SQLException ex) {
           Logger.getLogger(Dashboardcontoller.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    private void loadtable() throws SQLException {
        
           connectdb = Database.getConnection();
        
           ps = connectdb.prepareStatement("select * from player_id");
           rs = ps.executeQuery();
           
           while(rs.next()){
            
            list.add(new players
                    (rs.getString("student_id"), 
                    rs.getString("firstname"), 
                    rs.getString("course"), 
                    rs.getString("age"), 
                    rs.getString("sex"), 
                    rs.getString("height"), 
                    rs.getString("weight"), 
                    rs.getString("mobile_no"), 
                    rs.getString("email"), 
                    rs.getString("sport")));
            table.setItems(list);
           }
            
           agecol.setCellValueFactory(new PropertyValueFactory<>("age"));
           coursecol.setCellValueFactory(new PropertyValueFactory<>("course"));
           emailcol.setCellValueFactory(new PropertyValueFactory<>("email"));
           hcol.setCellValueFactory(new PropertyValueFactory<>("height"));
           mobilecol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
           namecol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
           sexcol.setCellValueFactory(new PropertyValueFactory<>("sex"));
           sportcol.setCellValueFactory(new PropertyValueFactory<>("sport"));
           studidcol.setCellValueFactory(new PropertyValueFactory<>("student_id"));
           wcol.setCellValueFactory(new PropertyValueFactory<>("weight"));
    }
    
}


