package Controlleur;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.List;
import java.util.ResourceBundle;

import Modele.*;
import Vue.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {
    private static Controller controller;

    private Stage primaryStage;


    private Controller(){ }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

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
    private TextArea lettres_j1;

    @FXML
    private TextArea lettres_j2;

    @FXML
    private Button passer;

    @FXML
    private Button piocher;

    /*@FXML
    private TableView<?> plateau_j1;

    @FXML
    private TableView<?> plateau_j2;*/

    @FXML
    private Label P1L0;
    @FXML
    private Label P1L1;
    @FXML
    private Label P1L2;
    @FXML
    private Label P1L3;
    @FXML
    private Label P1L4;
    @FXML
    private Label P1L5;
    @FXML
    private Label P1L6;
    @FXML
    private Label P1L7;
    @FXML
    private Label P1L8;

    @FXML
    private Label P1M1;
    @FXML
    private Label P1M2;
    @FXML
    private Label P1M3;
    @FXML
    private Label P1M4;
    @FXML
    private Label P1M5;
    @FXML
    private Label P1M6;
    @FXML
    private Label P1M7;
    @FXML
    private Label P1M8;

    @FXML
    private Label P2L0;
    @FXML
    private Label P2L1;
    @FXML
    private Label P2L2;
    @FXML
    private Label P2L3;
    @FXML
    private Label P2L4;
    @FXML
    private Label P2L5;
    @FXML
    private Label P2L6;
    @FXML
    private Label P2L7;
    @FXML
    private Label P2L8;

    @FXML
    private Label P2M1;
    @FXML
    private Label P2M2;
    @FXML
    private Label P2M3;
    @FXML
    private Label P2M4;
    @FXML
    private Label P2M5;
    @FXML
    private Label P2M6;
    @FXML
    private Label P2M7;
    @FXML
    private Label P2M8;

    @FXML
    private Label points_j1;

    @FXML
    private Label points_j2;

    @FXML
    void show_regles(ActionEvent event) {
        new Vue.Regles(primaryStage);
    }

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
        //assert plateau_j1 != null : "fx:id=\"plateau_j1\" was not injected: check your FXML file 'Interface.fxml'.";
        //assert plateau_j2 != null : "fx:id=\"plateau_j2\" was not injected: check your FXML file 'Interface.fxml'.";
        assert points_j1 != null : "fx:id=\"points_j1\" was not injected: check your FXML file 'Interface.fxml'.";
        assert points_j2 != null : "fx:id=\"points_j2\" was not injected: check your FXML file 'Interface.fxml'.";
        //initplateau();
    }

    public void initplateau(){
        P1L0.setText("\t\t9\t16\t25\t36\t49\t64\t81");
        P2L0.setText("\t\t9\t16\t25\t36\t49\t64\t81");
    }

    public void AppelRegles(View v) {
        v.afficherRegles();
    }

    public void AppelPartie(View v, Joueur j1, Joueur j2, Reserve r, Partie p, Plateau pl1, Plateau pl2) {
        v.afficherPartie(j1, j2, r, p, pl1, pl2);
    }

    public void AppelResultat(View v, Partie p) {
        v.afficherResultat(p);
    }

    public boolean Recup(String n, int j) {
        if (n.length() == 0) {
            return false;
        }
        if (j == 1 || j == 2) {
            Partie p = Partie.getInstance();
            if (!n.equalsIgnoreCase("ia")) {
                p.setJoueur(new Joueur(n), j);
                if (j == 1)
                    joueur1.setText(n);
                if (j == 2)
                    joueur2.setText(n);
            } else {
                if (j == 1)
                    joueur1.setText("IA1");
                if (j == 2) {
                    joueur2.setText("IA2");
                    p.setJoueur(new Ia("IA" + j), j);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void setStage(Stage s) {
        primaryStage = s;
    }

    public static void setInstance(Controller c) {
        controller = c;

    }

    public void updateReserve(Partie p) {
        List<Joueur> listjoueurs = p.getJoueurs();
        String j1reserve = listjoueurs.get(0).getReserve().LettresReserve();
        String j2reserve = listjoueurs.get(1).getReserve().LettresReserve();
        lettres_j1.setText(j1reserve);
        lettres_j2.setText(j2reserve);
    }

    public void player1jouer(){
        Partie p = Partie.getInstance();
        Joueur current = p.getCurrentPlayer();
        Joueur j = p.getJoueurs().get(0);
        if (j == current && !j.getFirstChoice()){
            String mot = input_j1.getText();
            if (j.jouer(mot)){
                input_j1.setText("");
                j.piocher(1);
                updatePlateau(1);
                updatePoints(Partie.getInstance());
            }
            else{
                new ErreurMot(primaryStage);
            }
        }
    }

    public void player2jouer(){
        Partie p = Partie.getInstance();
        Joueur current = p.getCurrentPlayer();
        Joueur j = p.getJoueurs().get(1);
        if (current == j && !j.getFirstChoice()){
            String mot = input_j2.getText();
            if (j.jouer(mot)){
                input_j2.setText("");
                j.piocher(1);
                updatePlateau(2);
                updatePoints(Partie.getInstance());
            }
            else{
                new ErreurMot(primaryStage);
            }
        }
    }

    public void updatePlateau(int i){
        Joueur j = Partie.getInstance().getCurrentPlayer();
        List<String> mots = j.getPlateau().getMotEspace();
        if (i == 1){
            P1M1.setText(mots.get(0));
            P1M2.setText(mots.get(1));
            P1M3.setText(mots.get(2));
            P1M4.setText(mots.get(3));
            P1M5.setText(mots.get(4));
            P1M6.setText(mots.get(5));
            P1M7.setText(mots.get(6));
            P1M8.setText(mots.get(7));
        } else if (i == 2){
            P2M1.setText(mots.get(0));
            P2M2.setText(mots.get(1));
            P2M3.setText(mots.get(2));
            P2M4.setText(mots.get(3));
            P2M5.setText(mots.get(4));
            P2M6.setText(mots.get(5));
            P2M7.setText(mots.get(6));
            P2M8.setText(mots.get(7));
        }
    }

    public void passer(){
        Joueur current = Partie.getInstance().getCurrentPlayer();
        if (!current.getFirstChoice()) {
            if (current == Partie.getInstance().getJoueurs().get(0)) {
                Partie.getInstance().setCurrentPlayer(Partie.getInstance().getJoueurs().get(1));
                disableChampMot(2);
                if (!Partie.getInstance().isFirstRound()){
                    Partie.getInstance().getCurrentPlayer().setFirstChoice(true);
                    disable1erTour(false);
                }
            } else if (current == Partie.getInstance().getJoueurs().get(1)) {
                Partie.getInstance().setCurrentPlayer(Partie.getInstance().getJoueurs().get(0));
                disableChampMot(1);
                Partie.getInstance().getCurrentPlayer().setFirstChoice(true);
                if (Partie.getInstance().isFirstRound()){
                    Partie.getInstance().setFirstRound(false);
                    disable1erTour(false);
                }
            }
            current.setFirstChoice(true);
        }
    }

    public void piocher(){
        Joueur current = Partie.getInstance().getCurrentPlayer();
        if (current.getFirstChoice()){
            current.piocher(1);
            current.setFirstChoice(false);
        }
    }

    public void updatePoints(Partie p) {
        List<Joueur> listjoueurs = p.getJoueurs();
        int j1pts = listjoueurs.get(0).getScore();
        int j2pts = listjoueurs.get(1).getScore();
        points_j1.setText("Points : " + j1pts);
        points_j2.setText("Points : " + j2pts);
    }

    public void disableChampMot(int i){
        if (i == 1){
            input_j1.setDisable(false);
            input_j2.setDisable(true);
        }
        if (i == 2){
            input_j1.setDisable(true);
            input_j2.setDisable(false);
        }
    }

    public void disable1erTour(boolean b){
        jarnac.setDisable(b);
        piocher.setDisable(b);
        echanger.setDisable(b);
    }

    public void echanger(){
        Joueur current = Partie.getInstance().getCurrentPlayer();
        if (current.getFirstChoice()){
            new Echange(primaryStage, current);
        }
    }
}
