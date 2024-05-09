package project;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    private Button backbtn;
    
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

    private Stage stage;
    private Scene scene;
    private Parent root;
    
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
       } catch(SQLNonTransientConnectionException e){
            JOptionPane.showMessageDialog(null, "Not connected to Database", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
           Logger.getLogger(Dashboardcontoller.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    
    @FXML
    void back(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainpage.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("mainpagecss.css").toExternalForm());
        Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
        stage.getIcons().add(icon);
        stage.setTitle("About us");
        stage.setResizable(false);
        stage.show();
        
    }

    @FXML
    void backenter(MouseEvent event) {
        backbtn.setStyle("-fx-background-color: green; ");
    }

    @FXML
    void backexit(MouseEvent event) {
        backbtn.setStyle("-fx-background-color: red; ");
    }

    @FXML
    void backp(MouseEvent event) {
        backbtn.setMaxSize(85, 70);
    }

    @FXML
    void backr(MouseEvent event) {
        backbtn.setMaxSize(90, 75);
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
           
           FilteredList<players> filteredData = new FilteredList<>(list, b -> true);
           
           sqlsearch.textProperty().addListener((observable, oldValue, newValue) -> {
           filteredData.setPredicate(player -> {
               
               if(newValue == null || newValue.isEmpty()){
                   return true;
               }
               
               String lowerCaseFilter = newValue.toLowerCase();
               
               if(player.getStudent_id().toLowerCase().contains(lowerCaseFilter)) {
                   return true;
               }
               else if (player.getFirstname().toLowerCase().contains(lowerCaseFilter)) {
                   return true;
               }
                else if (player.getCourse().toLowerCase().contains(lowerCaseFilter)) {
                   return true;
               }
                else if (player.getAge().toLowerCase().contains(lowerCaseFilter)) {
                   return true;
               }
                else if (player.getSex().toLowerCase().contains(lowerCaseFilter)) {
                   return true;
               }
                else if (player.getHeight().toLowerCase().contains(lowerCaseFilter)) {
                   return true;
               }
                else if (player.getWeight().toLowerCase().contains(lowerCaseFilter)) {
                   return true;
               }
                else if (player.getMobile().toLowerCase().contains(lowerCaseFilter)) {
                   return true;
               }
                else if (player.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                   return true;
               }
                else if (player.getSport().toLowerCase().contains(lowerCaseFilter)) {
                   return true;
               }
             return false;
               
           });
    
    });
    
           SortedList<players> sortedData = new SortedList<>(filteredData);
           
           sortedData.comparatorProperty().bind(table.comparatorProperty());
           
           table.setItems(sortedData);
           
    }
           
}
    


