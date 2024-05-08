package project;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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

public class logincontrol {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public String pass, student_id, fullname, course, age, sex, nationality, religion, height, weight, street, city, province, mobile, email, sport, sportexp, sportcond, medicalcond, medicalspec;
    
    @FXML
    private AnchorPane anchorpane;

    @FXML
    private BorderPane borderpane;

    @FXML
    private VBox loginvbox;

    @FXML
    private Label passlabel;
    
    @FXML
    private Button backbtn;
    
    @FXML
    private Label studidlabel;
    
    @FXML
    private Button reset;

    @FXML
    private Hyperlink registerlink;
    
    @FXML
    private Button submit;
    
    @FXML
    private TextField studID;
     
    @FXML
    public PasswordField password;

    
    @FXML
    void backenter(MouseEvent event) {
         backbtn.setStyle("-fx-background-color: green; ");
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
    
    @FXML
    void resetpressed(MouseEvent event) {
        reset.setMaxSize(110,55);
    }
    
    @FXML
    void resetreleased(MouseEvent event) {
        reset.setMaxSize(115, 60);
    }
    
     @FXML
    void submitpressed(MouseEvent event) {
         submit.setMaxSize(110,55);
    }
    
    @FXML
    void submitreleased(MouseEvent event) {
        submit.setMaxSize(115,60);
    }
    
    @FXML
    void onlink(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("Register.css").toExternalForm());
        stage.setTitle("Sports Registration");
        stage.setTitle("San Sebastian Recoletos Sports Registration");
        Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
        stage.getIcons().add(icon);
        stage.setResizable(false);
        //primary.setMaximized(true);
        stage.show();
    }
        
    @FXML
    void onreset(ActionEvent event) {
            studID.setText("");
            password.setText("");
    }

    String admin = "me";
    String keycode = "me";
    
    @FXML
    void onsubmit(ActionEvent event) throws SQLException, IOException {
          
         if(studID.getText().isEmpty()){
            studidlabel.setText("Please enter your Student ID");
             if(!password.getText().isEmpty()){
                 passlabel.setText("");
             }
         }
        
         if(password.getText().isEmpty()){
             passlabel.setText("Please enter your Password");
             if(!studID.getText().isEmpty()){
            studidlabel.setText("");
         }
        }
         
         else if (!password.getText().isEmpty() && !studID.getText().isEmpty()) {
             
            if (studID.getText().equals(admin) && password.getText().equals(keycode)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
            Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
            stage.getIcons().add(icon);
            stage.setTitle("Dashboard");
            stage.setResizable(false);
            stage.show();
        }
 
         
        }
    }
}






