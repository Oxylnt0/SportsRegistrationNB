/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Desktop;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import static javafx.util.Duration.seconds;
import javax.swing.Action;

/**
 *
 * @author Guest01
 */
public class mainpage {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button aboutus;

    @FXML
    private Button adminlogin;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button register;
    
    @FXML
    private AnchorPane mainanchorpane;
    
    @FXML
    private Button website;

    @FXML
    void aboutp(MouseEvent event) {
        aboutus.setMaxSize(175, 65);
    }

    @FXML
    void aboutr(MouseEvent event) {
        aboutus.setMaxSize(180, 70);
    }

    @FXML
    void adminp(MouseEvent event) {
        adminlogin.setMaxSize(175, 65);
    }

    @FXML
    void adminr(MouseEvent event) {
        adminlogin.setMaxSize(180, 70);
    }

    @FXML
    void onabout(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("About.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("About.css").toExternalForm());
        Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
        stage.getIcons().add(icon);
        stage.setTitle("About us");
        stage.setResizable(false);
        stage.show();
        
    }

    @FXML
    void onadminlogin(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("logincss.css").toExternalForm());
        Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Admin Login");
        stage.setResizable(false);
        stage.show();
        
    }

   @FXML
    void onwebsite(ActionEvent event) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(java.net.URI.create("https://sscr.edu"));
    }
    
    @FXML
    void onregister(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("Register.css").toExternalForm());
        Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Register");
        stage.setResizable(false);
        stage.show();
        
    }

    @FXML
    void registerp(MouseEvent event) {
        register.setMaxSize(175, 65);
    }

    @FXML
    void registerr(MouseEvent event) {
        register.setMaxSize(180, 70);
    }

    @FXML
    void webister(MouseEvent event) {
        website.setMaxSize(180, 70);
    }

    @FXML
    void websitep(MouseEvent event) {
        website.setMaxSize(175, 65);
    }
    
    @FXML
    void adminen(MouseEvent event) {
        adminlogin.setStyle("-fx-background-color: green; ");
    }

    @FXML
    void adminex(MouseEvent event) {
        adminlogin.setStyle("-fx-background-color:  #ffbf00; ");
    }
    
    @FXML
    void registeren(MouseEvent event) {
        register.setStyle("-fx-background-color: green; ");
    }

    @FXML
    void registerex(MouseEvent event) {
        register.setStyle("-fx-background-color:  #ffbf00; ");
    }
    
    @FXML
    void weben(MouseEvent event) {
        website.setStyle("-fx-background-color: green; ");
    }

    @FXML
    void webex(MouseEvent event) {
        website.setStyle("-fx-background-color:  #ffbf00; ");
    }
    
    @FXML
    void abouten(MouseEvent event) {
        aboutus.setStyle("-fx-background-color: green; ");
    }

    @FXML
    void aboutex(MouseEvent event) {
        aboutus.setStyle("-fx-background-color:  #ffbf00; ");
    }

}
