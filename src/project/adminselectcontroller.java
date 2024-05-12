/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class adminselectcontroller {
    
     @FXML
    private Button addadmin;

    @FXML
    private Button adminlist;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button backbtn;
    
    @FXML
    private BorderPane borderpane;

    @FXML
    private Button registerlist;

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    void adden(MouseEvent event) {
        addadmin.setStyle("-fx-background-color: green; ");
    }

    @FXML
    void addex(MouseEvent event) {
        addadmin.setStyle("-fx-background-color: #ffbf00; ");
    }

    @FXML
    void addp(MouseEvent event) {
        addadmin.setMaxSize(175, 65);
    }

    @FXML
    void addr(MouseEvent event) {
        addadmin.setMaxSize(180, 70);
    }

    @FXML
    void adminen(MouseEvent event) {
        adminlist.setStyle("-fx-background-color: green; ");
    }

    @FXML
    void adminex(MouseEvent event) {
        adminlist.setStyle("-fx-background-color: #ffbf00; ");
    }

    @FXML
    void adminp(MouseEvent event) {
        adminlist.setMaxSize(175, 65);
    }

    @FXML
    void adminr(MouseEvent event) {
        adminlist.setMaxSize(180, 70);
    }

    @FXML
    void onaddadmin(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("addadmin.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("addadmincss.css").toExternalForm());
        Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Add Admin");
        stage.setResizable(false);
        stage.show();
        
    }

    @FXML
    void onadminlist(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboardadmin.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("dashboardadmincss.css").toExternalForm());
        Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Admin List");
        stage.setResizable(false);
        stage.show();
        
    }

    @FXML
    void onregisterlist(ActionEvent event) throws IOException  {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
        Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Registrant List");
        stage.setResizable(false);
        stage.show();
        
    }

    @FXML
    void registeren(MouseEvent event) {
        registerlist.setStyle("-fx-background-color: green; ");
    }

    @FXML
    void registerex(MouseEvent event) {
        registerlist.setStyle("-fx-background-color: #ffbf00; ");
    }

    @FXML
    void registerp(MouseEvent event) {
        registerlist.setMaxSize(175, 65);
    }

    @FXML
    void registerr(MouseEvent event) {
        registerlist.setMaxSize(180, 70);
    }
    
    @FXML
    void back(ActionEvent event) throws IOException {

        JOptionPane.showMessageDialog(null, "Log out Successful");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainpage.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("mainpagecss.css").toExternalForm());
        Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Home Page");
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
        backbtn.setMaxSize(125, 33);
    }

    @FXML
    void backr(MouseEvent event) {
        backbtn.setMaxSize(130, 38);
    }
    
}
