package Controlleur;

import java.net.URL;
import java.util.ResourceBundle;

import Modele.*;
import Vue.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button abandonner;

    @FXML
    private Button aide;

    @FXML
    private Button echanger;

    @FXML
    private TextField input_j1;

    @FXML
    private TextField input_j2;

    @FXML
    private Button jarnac;

    @FXML
    private Label joueur1;

    @FXML
    private Label joueur2;

    @FXML
    private Label lettres_j1;

    @FXML
    private Label lettres_j2;

    @FXML
    private Button passer;

    @FXML
    private Button piocher;

    @FXML
    private TableView<?> plateau_j1;

    @FXML
    private TableView<?> plateau_j2;

    @FXML
    private Label points_j1;

    @FXML
    private Label points_j2;

    @FXML
    public void initialize() {
        assert abandonner != null : "fx:id=\"abandonner\" was not injected: check your FXML file 'Interface.fxml'.";
        assert aide != null : "fx:id=\"aide\" was not injected: check your FXML file 'Interface.fxml'.";
        assert echanger != null : "fx:id=\"echanger\" was not injected: check your FXML file 'Interface.fxml'.";
        assert input_j1 != null : "fx:id=\"input_j1\" was not injected: check your FXML file 'Interface.fxml'.";
        assert input_j2 != null : "fx:id=\"input_j2\" was not injected: check your FXML file 'Interface.fxml'.";
        assert jarnac != null : "fx:id=\"jarnac\" was not injected: check your FXML file 'Interface.fxml'.";
        assert joueur1 != null : "fx:id=\"joueur1\" was not injected: check your FXML file 'Interface.fxml'.";
        assert joueur2 != null : "fx:id=\"joueur2\" was not injected: check your FXML file 'Interface.fxml'.";
        assert lettres_j1 != null : "fx:id=\"lettres_j1\" was not injected: check your FXML file 'Interface.fxml'.";
        assert lettres_j2 != null : "fx:id=\"lettres_j2\" was not injected: check your FXML file 'Interface.fxml'.";
        assert passer != null : "fx:id=\"passer\" was not injected: check your FXML file 'Interface.fxml'.";
        assert piocher != null : "fx:id=\"piocher\" was not injected: check your FXML file 'Interface.fxml'.";
        assert plateau_j1 != null : "fx:id=\"plateau_j1\" was not injected: check your FXML file 'Interface.fxml'.";
        assert plateau_j2 != null : "fx:id=\"plateau_j2\" was not injected: check your FXML file 'Interface.fxml'.";
        assert points_j1 != null : "fx:id=\"points_j1\" was not injected: check your FXML file 'Interface.fxml'.";
        assert points_j2 != null : "fx:id=\"points_j2\" was not injected: check your FXML file 'Interface.fxml'.";

    }

    public void AppelRegles(View v){
        v.afficherRegles();
    }

    public void AppelPartie(View v, Joueur j1, Joueur j2, Reserve r, Partie p, Plateau pl1, Plateau pl2){
        v.afficherPartie(j1, j2, r, p, pl1, pl2);
    }

    public void AppelResultat(View v, Partie p){
        v.afficherResultat(p);
    }

}
