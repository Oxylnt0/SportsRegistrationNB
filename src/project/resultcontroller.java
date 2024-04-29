/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class resultcontroller {

    @FXML
    private Label Name;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private BorderPane borderpane;

    public void set(String fn){
        Name.setText(fn);
    }
}
