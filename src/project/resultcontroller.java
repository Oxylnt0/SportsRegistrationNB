package project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class resultcontroller {

   @FXML
    private Label Fullname;

    @FXML
    private Label age;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private BorderPane borderpane;

    @FXML
    private Label chosensport;

    @FXML
    private Label city;

    @FXML
    private Label condition;

    @FXML
    private Label conditionkind;

    @FXML
    private Label course;

    @FXML
    private Label email;

    @FXML
    private Label experiencesport;

    @FXML
    private Label height;

    @FXML
    private Label mobile;

    @FXML
    private Label nation;

    @FXML
    private Label prov;

    @FXML
    private Label religion;

    @FXML
    private Label sex;

    @FXML
    private Label specificsport;

    @FXML
    private Label street;

    @FXML
    private Label studentid;

    @FXML
    private VBox vbox;

    @FXML
    private VBox vbox1;
    
    @FXML
    private HBox hbox;
    
    @FXML
    private Label weight;


    public void set(String studid, String fn, String c, String a, String s, String n , String r, String h, String w, String sa, String cy, String p, String mn, String em, String sp, String sx, String sc, String mc, String ms ){
        studentid.setText(studid);
        Fullname.setText(fn);
        course.setText(c);
        age.setText(a);
        sex.setText(s);
        nation.setText(n);
        religion.setText(r);
        height.setText(h);
        weight.setText(w);
        street.setText(sa);
        city.setText(cy);
        prov.setText(p);
        mobile.setText(mn);
        email.setText(em);
        chosensport.setText(sp);
        experiencesport.setText(sx);
        specificsport.setText(sc);
        condition.setText(mc);
        conditionkind.setText(ms);
    }
}
