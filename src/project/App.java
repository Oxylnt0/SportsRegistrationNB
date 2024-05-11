package project;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primary) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
        Scene scene = new Scene(root);
        primary.setScene(scene);
        primary.setTitle("Home Page");
        scene.getStylesheets().add(getClass().getResource("mainpagecss.css").toExternalForm());
        Image icon = new Image(getClass().getResourceAsStream("SSCRLogo1.png"));
        primary.getIcons().add(icon);
        primary.setResizable(false);
        //primary.setMaximized(true);
        primary.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
