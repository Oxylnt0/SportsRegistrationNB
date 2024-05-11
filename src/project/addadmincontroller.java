/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Guest01
 */
public class addadmincontroller {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
     @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button backbtn;

    @FXML
    private BorderPane borderpane;

    @FXML
    private VBox loginvbox;

    @FXML
    private TextField email;
    
    @FXML
    private Label passlabel;

    @FXML
    private Label repasslabel;
    
      @FXML
    private Label emaillabel;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField reenterpass;

    @FXML
    private Button reset;

    @FXML
    private Button submit;

    @FXML
    private Label userlabel;

    @FXML
    private TextField username;

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
    void backenter(MouseEvent event) {
        backbtn.setStyle("-fx-background-color: green; ");
    }

    @FXML
    void backexit(MouseEvent event) {
        backbtn.setStyle("-fx-background-color:  red; ");
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
    void onreset(ActionEvent event) {
            username.setText("");
            password.setText("");
            reenterpass.setText("");
            userlabel.setText("");
            emaillabel.setText("");
            passlabel.setText("");
            repasslabel.setText("");
    }

    @FXML
    void onsubmit(ActionEvent event) throws IOException {

        if(username.getText().isEmpty() | email.getText().isEmpty() | password.getText().isEmpty() | reenterpass.getText().isEmpty()){
        
        if (username.getText().isEmpty()) 
                {
                    userlabel.setText("Enter your username");
                } 
                
                else if (!username.getText().isEmpty()) 
                {
                    userlabel.setText("");
                }
             
             if (email.getText().isEmpty()) 
                {
                    emaillabel.setText("Enter your email");
                } 
                
                else if (!email.getText().isEmpty()) 
                {
                    emaillabel.setText("");
                }
             
             if (password.getText().isEmpty()) 
                {
                    passlabel.setText("Enter you password");
                } 
                
                else if (!password.getText().isEmpty()) 
                {
                    passlabel.setText("");
                }
             
               if (reenterpass.getText().isEmpty()) 
                {
                    repasslabel.setText("Re-enter your password");
                } 
                
                else if (!reenterpass.getText().isEmpty()) 
                {
                    repasslabel.setText("");
                }
        
       }
       
        else if (!username.getText().isEmpty() & !email.getText().isEmpty() & !password.getText().isEmpty() & !reenterpass.getText().isEmpty()) {

            if (password.getText().equals(reenterpass.getText())) {

                try {

                    Connection connectdb = Database.getConnection();

                    PreparedStatement ps1 = connectdb
                            .prepareStatement("INSERT INTO admin Values (?, ?, ?)");

                    ps1.setString(1, username.getText());
                    ps1.setString(2, email.getText());
                    ps1.setString(3, password.getText());

                    ps1.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Admin Added");

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

                } catch (SQLNonTransientConnectionException e) {
                    JOptionPane.showMessageDialog(null, "Not connected to Database", "Error", JOptionPane.ERROR_MESSAGE);
                    userlabel.setText("");
                    emaillabel.setText("");
                    passlabel.setText("");
                    repasslabel.setText("");
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboardcontroller.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                password.clear();
                reenterpass.clear();
                userlabel.setText("");
                emaillabel.setText("");
                passlabel.setText("");
                repasslabel.setText("");
            }

        }

    }

    @FXML
    void reseten(MouseEvent event) {
        reset.setStyle("-fx-background-color: green; ");
    }

    @FXML
    void resetex(MouseEvent event) {
        reset.setStyle("-fx-background-color:  #ffbf00; ");
    }

     @FXML
    void resetpressed(MouseEvent event) {
        reset.setMaxSize(110,55);
    }
    
    @FXML
    void resetreleased(MouseEvent event) {
        reset.setMaxSize(115, 60);
    }

    @FXML
    void submiten(MouseEvent event) {
        submit.setStyle("-fx-background-color: green; ");
    }

    @FXML
    void submitex(MouseEvent event) {
        submit.setStyle("-fx-background-color:  #ffbf00; ");
    }

    @FXML
    void submitpressed(MouseEvent event) {
         submit.setMaxSize(110,55);
    }
    
    @FXML
    void submitreleased(MouseEvent event) {
        submit.setMaxSize(115,60);
    }
    
}
