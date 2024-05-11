package project;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public String adminname, code;
    
    @FXML
    private AnchorPane anchorpane;

    @FXML
    private BorderPane borderpane;

    @FXML
    private BorderPane childborder;
    
    @FXML
    private VBox loginvbox;

    @FXML
    private Label passlabel;
    
    @FXML
    private Button backbtn;
    
    @FXML
    private Label userlabel;
    
    @FXML
    private Button reset;

    @FXML
    private Hyperlink registerlink;
    
    @FXML
    private Button submit;
    
    @FXML
    private TextField username;
     
    @FXML
    public PasswordField password;

    @FXML
    void reseten(MouseEvent event) {
        reset.setStyle("-fx-background-color: green; ");
    }

    @FXML
    void resetex(MouseEvent event) {
        reset.setStyle("-fx-background-color:  #ffbf00; ");
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
        stage.setTitle("Home Page");
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
    void onreset(ActionEvent event) {
            passlabel.setText("");
            userlabel.setText("");
            username.setText("");
            password.setText("");
    }
    
    @FXML
    void onsubmit(ActionEvent event) throws IOException {
          
         if(username.getText().isEmpty()){
            userlabel.setText("Please enter your Username");
             if(!password.getText().isEmpty()){
                 passlabel.setText("");
             }
         }
        
         if(password.getText().isEmpty()){
             passlabel.setText("Please enter your Password");
             if(!username.getText().isEmpty()){
            userlabel.setText("");
         }
        }
         
         else if (!password.getText().isEmpty() && !username.getText().isEmpty()) {
             
             try {
             
             Connection connectdb = Database.getConnection();

             PreparedStatement ps1 = connectdb
                    .prepareStatement("select username, password from admin where username = '" + username.getText() + "'");
             
             ResultSet rs = ps1.executeQuery();
             
             while(rs.next()){
                         adminname = rs.getString(1);
                         code = rs.getString(2);
           }
             
             if(adminname == null & code == null){
                 JOptionPane.showMessageDialog(null, "Admin not found", "Error", JOptionPane.ERROR_MESSAGE);
                adminname = null;
                code = null;
                username.clear();
                password.clear();
             }

             else if(username.getText().equals(adminname) & password.getText().equals(code)){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("adminselect.fxml"));
                root = loader.load();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                scene.getStylesheets().add(getClass().getResource("adminselectcss.css").toExternalForm());
                Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
                stage.getIcons().add(icon);
                stage.setTitle("Admin Select");
                stage.setResizable(false);
                stage.show();
                
            }
             
            else {
                JOptionPane.showMessageDialog(null, "Incorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
                adminname = null;
                code = null;
                username.clear();
                password.clear();
                userlabel.setText("");
                passlabel.setText("");
            }
         }   catch(SQLNonTransientConnectionException e){
            JOptionPane.showMessageDialog(null, "Not connected to Database", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
           Logger.getLogger(Dashboardcontroller.class.getName()).log(Level.SEVERE, null, ex);
       }   
         
        }
    }
}






