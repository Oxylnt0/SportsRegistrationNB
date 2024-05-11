/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Guest01
 */
public class dashboardadmincontroller implements Initializable{
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    String query  = null;
    Connection connectdb = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    admins admins = null;
    
    ObservableList<admins> list = FXCollections.observableArrayList();
    ObservableList<admins> filteredlist = FXCollections.observableArrayList();
    
    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button backbtn;

    @FXML
    private BorderPane borderpane;

    @FXML
    private TextField email;
    
    @FXML
    private TextField sqlsearch;

    @FXML
    private TableView<admins> table;

    @FXML
    private TableColumn<admins, String> usernamecol;
    
      @FXML
    private TableColumn<admins, String> emailcol;

  @FXML
    void back(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminselect.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("adminselectcss.css").toExternalForm());
        Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Home Page");
        stage.setResizable(false);
        stage.show();
        
    }

    @FXML
    void backp(MouseEvent event) {
        backbtn.setMaxSize(85, 70);
    }

    @FXML
    void backr(MouseEvent event) {
        backbtn.setMaxSize(90, 75);
    }
    
    @FXML
    void backenter(MouseEvent event) {
        backbtn.setStyle("-fx-background-color: green; ");
    }
    
     @FXML
    void backexit(MouseEvent event) {
        backbtn.setStyle("-fx-background-color: red; ");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
           connectdb = Database.getConnection();
        
           ps = connectdb.prepareStatement("select username,email from admin");
           rs = ps.executeQuery();
           
           while(rs.next()){
            
            list.add(new admins
                    (rs.getString("username"), 
                    rs.getString("email")));
            table.setItems(list);
           }
            
           usernamecol.setCellValueFactory(new PropertyValueFactory<>("username"));
           emailcol.setCellValueFactory(new PropertyValueFactory<>("email"));
           
           FilteredList<admins> filteredData = new FilteredList<>(list, b -> true);
           
           sqlsearch.textProperty().addListener((observable, oldValue, newValue) -> {
           filteredData.setPredicate(admin -> {
               
               if(newValue == null || newValue.isEmpty()){
                   return true;
               }
               
               String lowerCaseFilter = newValue.toLowerCase();
               
               if(admin.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                   return true;
               }
               else if (admin.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                   return true;
               }
             return false;
               
           });
    
    });
    
           SortedList<admins> sortedData = new SortedList<>(filteredData);
           
           sortedData.comparatorProperty().bind(table.comparatorProperty());
           
           table.setItems(sortedData);
           
        }
        catch(SQLNonTransientConnectionException e){
            JOptionPane.showMessageDialog(null, "Not connected to Database", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
           Logger.getLogger(Dashboardcontroller.class.getName()).log(Level.SEVERE, null, ex);
       }   
           
    }

}

