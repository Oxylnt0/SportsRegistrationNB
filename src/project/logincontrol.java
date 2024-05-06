package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @FXML
    void onsubmit(ActionEvent event) throws SQLException, IOException {
        
        try {
        
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
             
        Database database = new Database();

        Connection connectdb = database.getConnection();

        Statement ps1 = connectdb.createStatement();
        String sql = "Select * from player_id where student_id = " + studID.getText();
        ResultSet rs = ps1.executeQuery(sql);
            if(rs.next()){
                student_id = rs.getString(1);
                fullname = rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4);
                course = rs.getString(5);
                age = rs.getString(6);
                sex = rs.getString(7);
                nationality  = rs.getString(8);
                religion = rs.getString(9);
                height  = rs.getString(10);
                weight = rs.getString(11);
                street = rs.getString(12);
                city =  rs.getString(13);
                province = rs.getString(14);
                mobile = rs.getString(15);
                email = rs.getString(16);
                sport = rs.getString(17);
                sportexp = rs.getString(18);
                sportcond = rs.getString(19);
                medicalcond = rs.getString(20);
                medicalspec = rs.getString(21);
                pass = rs.getString(22);
                        
            }
            
        if(pass.equals(password.getText()) && student_id.equals(studID.getText())){    
            FXMLLoader loader = new FXMLLoader(getClass().getResource("result.fxml"));
            root = loader.load();
        
            resultcontroller resultcontroller = loader.getController();
            resultcontroller.set(student_id, fullname, course, age, sex, nationality, religion, height, weight, street, city, province, mobile, email, sport, sportexp, sportcond, medicalcond, medicalspec);    
        
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("resultcss.css").toExternalForm());
            Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
            stage.getIcons().add(icon);
            stage.setTitle("Welcome " + fullname);
            stage.setResizable(false);
            stage.show();
        }
              
        else if(pass.equals(password.getText()) && !student_id.equals(studID.getText())){
            JOptionPane.showMessageDialog(null, "Incorrect Account Details");
            studidlabel.setText("");
             passlabel.setText("");
        }
        
        else  {
            JOptionPane.showMessageDialog(null, "Incorrect Account Details");
            studidlabel.setText("");
             passlabel.setText("");
        }
        
         }
        
         }
         
         catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Incorrect Account Details");
            studidlabel.setText("");
             passlabel.setText("");
       }
         
    }

}

