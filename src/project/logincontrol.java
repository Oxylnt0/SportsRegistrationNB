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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class logincontrol {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public String str1;
    
    @FXML
    private AnchorPane anchorpane;

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button reset;

    @FXML
    private Hyperlink registerlink;
    
    @FXML
    private Button submit;
    
    @FXML
    private TextField studID;
     
    @FXML
    private PasswordField password;

    @FXML
    void onlink(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("Register.css").toExternalForm());
        stage.setTitle("Sports Registration");
        stage.setTitle("San Sebastian Recoletos Sports Registration");
        stage.getIcons().add(new Image("file:SSCRLogo1.png"));
        stage.setResizable(false);
        //primary.setMaximized(true);
        stage.show();
    }
        
    @FXML
    void onreset(ActionEvent event) {

    }

    @FXML
    void onsubmit(ActionEvent event) throws SQLException, IOException {
        
        Database database = new Database();

        Connection connectdb = database.getConnection();

        Statement ps1 = connectdb.createStatement();
        String sql = "Select firstname from player_id where student_id = " + studID.getText();
        ResultSet rs = ps1.executeQuery(sql);
            if(rs.next()){
                str1 = rs.getString(1);
            }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("result.fxml"));
        root = loader.load();
        
        resultcontroller resultcontroller = loader.getController();
        resultcontroller.set(str1);
        
        
        //root = FXMLLoader.load(getClass().getResource("result.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        //primary.setMaximized(true);
        stage.show();
    }

}

