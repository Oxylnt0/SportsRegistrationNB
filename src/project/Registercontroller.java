package project;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Registercontroller{

    private Stage stage;
    private Scene scene;
    private Parent root;
    
     @FXML
    private TextField Courses;

    @FXML
    private TextField StudentID;

    @FXML
    private TextField age;

    @FXML
    private Label agelabel;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private BorderPane borderpane;

    @FXML
    private Label clabel;

    @FXML
    private TextField email;

    @FXML
    private Label emaillabel;

    @FXML
    private RadioButton female;

    @FXML
    private TextField firstname;

    @FXML
    private Label fnamelabel;

    @FXML
    private TextField height;

    @FXML
    private Label hlabel;

    @FXML
    private TextField lastname;

    @FXML
    private Label lnamelabel;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup mftoggle;

    @FXML
    private TextField middlename;

    @FXML
    private Label mnamelabel;

    @FXML
    private TextField number;

    @FXML
    private Label numlabel;

    @FXML
    private Button reset;

    @FXML
    private Label sexlabel;

    @FXML
    private Label silabel;

    @FXML
    private Button submit;
    
    @FXML
    private RadioButton badminton;

    @FXML
    private RadioButton basketball;
    
    @FXML
    private RadioButton volleyball;
    
    @FXML
    private Button backbtn;
    
    @FXML
    private VBox vbox;

    @FXML
    private TextField weight;

    @FXML
    private Label wlabel;

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

    @FXML
    void resetpressed(MouseEvent event) {
        reset.setMaxSize(140,59);
    }
    
    @FXML
    void resetreleased(MouseEvent event) {
        reset.setMaxSize(146,65);
    }
    
     @FXML
    void submitpressed(MouseEvent event) {
         submit.setMaxSize(140,59);
    }
    
    @FXML
    void submitreleased(MouseEvent event) {
        submit.setMaxSize(146,65);
    }
    
    @FXML
    public void onsubmit(ActionEvent event) {

        try {
            String sex = "";
            String sports = "";
            
            if (male.isSelected()) {
                sex = "M";
            }

            else if (female.isSelected()) {
                sex = "F";
            }
            
             if (basketball.isSelected()) {
                sports = "Basketball";
            }

            else if (volleyball.isSelected()) {
                sports = "Volleyball";
            }
             
            else if (badminton.isSelected()) {
                sports = "Badminton";
            }

            // SQL
            Database database = new Database();

            Connection connectdb = Database.getConnection();

            PreparedStatement ps1 = connectdb
                    .prepareStatement("INSERT INTO player_id Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps1.setString(1, StudentID.getText());
            ps1.setString(2, firstname.getText());
            ps1.setString(3, middlename.getText());
            ps1.setString(4, lastname.getText());
            ps1.setString(5, Courses.getText());
            ps1.setString(6, age.getText());
            ps1.setString(7, sex);
            ps1.setString(8, height.getText());
            ps1.setString(9, weight.getText());
            ps1.setString(10, number.getText());
            ps1.setString(11, email.getText());
            ps1.setString(12, sports);
            
            if (firstname.getText().isEmpty() |
                    middlename.getText().isEmpty() |
                    lastname.getText().isEmpty() |
                    age.getText().isEmpty() |
                    (!male.isSelected() &
                            !female.isSelected())|
                    height.getText().isEmpty() |
                    weight.getText().isEmpty() |
                    number.getText().isEmpty() |
                    email.getText().isEmpty())
                    
                     {
                         
                if (StudentID.getText().isEmpty()) 
                {
                    silabel.setText("*Required field");
                } 
                
                else if (!StudentID.getText().isEmpty()) 
                {
                    silabel.setText("");
                }
                
                if (firstname.getText().isEmpty()) 
                {
                    fnamelabel.setText("*Required field");
                } 
                
                else if (!firstname.getText().isEmpty()) 
                {
                    fnamelabel.setText("");
                }
                
                if (middlename.getText().isEmpty())
                {
                    mnamelabel.setText("*Required field");
                } 
                
                else if (!middlename.getText().isEmpty()) 
                {
                    mnamelabel.setText("");
                }
                
                if (lastname.getText().isEmpty()) {
                    lnamelabel.setText("*Required field");
                } 
                
                else if (!lastname.getText().isEmpty()) 
                {
                    lnamelabel.setText("");
                }
                
                if (Courses.getText().isEmpty()) 
                {
                    clabel.setText("*Required field");
                } else if (!Courses.getText().isEmpty()) 
                    
                {
                    clabel.setText("");
                }
                
                if (age.getText().isEmpty()) {
                    agelabel.setText("*Required field");
                } 
                
                else if (!age.getText().isEmpty()) 
                {
                    agelabel.setText("");
                }
                
                if (!male.isSelected() & !female.isSelected()) 
                {
                    sexlabel.setText("*Required field");
                } 
                
                else if (male.isSelected() | female.isSelected()) 
                {
                    sexlabel.setText("");
                }
                
                if (height.getText().isEmpty()) 
                {
                    hlabel.setText("*Required field");
                } 
                
                else if (!height.getText().isEmpty()) 
                {
                    hlabel.setText("");
                }
                if (weight.getText().isEmpty()) 
                {
                    wlabel.setText("*Required field");
                } 
                
                else if (!weight.getText().isEmpty()) 
                {
                    wlabel.setText("");
                }
                
                if (number.getText().isEmpty()) 
                {
                    numlabel.setText("*Required field");
                } 
                
                else if (!number.getText().isEmpty()) 
                {
                    numlabel.setText("");
                }
                if (email.getText().isEmpty()) {
                    emaillabel.setText("*Required field");
                } 
                
                else if (!email.getText().isEmpty()) {
                    emaillabel.setText("");
                }
                
            } 
            
            else if (!firstname.getText().isEmpty() &
                    !middlename.getText().isEmpty() &
                    !lastname.getText().isEmpty() &
                    !age.getText().isEmpty() &
                    (male.isSelected() |
                      female.isSelected()) &
                    !height.getText().isEmpty() &
                    !email.getText().isEmpty() &
                    !weight.getText().isEmpty() &
                    !number.getText().isEmpty())
                             {

                fnamelabel.setText("");
                mnamelabel.setText("");
                lnamelabel.setText("");
                agelabel.setText("");
                sexlabel.setText("");
                sexlabel.setText("");
                hlabel.setText("");
                wlabel.setText("");
                numlabel.setText("");
                emaillabel.setText("");
                
                ps1.executeUpdate();
                JOptionPane.showMessageDialog(null, "You have successfully registered!");
                
                                 firstname.setText("");
                                 middlename.setText("");
                                 lastname.setText("");
                                 age.setText("");
                                 male.setSelected(false);
                                 female.setSelected(false);
                                 height.setText("");
                                 weight.setText("");
                                 number.setText("");
                                 email.setText("");
                                 Courses.setText("");
                                 StudentID.setText("");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onreset(ActionEvent event) {
        
        firstname.setText("");
        middlename.setText("");
        lastname.setText("");
        age.setText("");
        male.setSelected(false);
        female.setSelected(false);
        height.setText("");
        weight.setText("");
        number.setText("");
        email.setText("");
        Courses.setText("");
        StudentID.setText("");

        clabel.setText("");
        silabel.setText("");
        fnamelabel.setText("");
        mnamelabel.setText("");
        lnamelabel.setText("");
        agelabel.setText("");
        sexlabel.setText("");
        hlabel.setText("");
        wlabel.setText("");
        numlabel.setText("");
        emaillabel.setText("");
        
    }

}