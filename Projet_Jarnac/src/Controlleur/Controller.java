package Controlleur;

import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;

import Modele.*;
import Vue.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
    private Label lettres_pioche;

    @FXML
    private Button passer;

    @FXML
    private Button piocher;

    @FXML
    private Button modifier;

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
        assert lettres_pioche != null : "fx:id=\"lettres_pioche\" was not injected: check your FXML file 'Interface.fxml'.";
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
        updateLettresRestantes();
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
                    p.setJoueur(new Ia("IA" + j), j);
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
        if (lettres_j1 != null){

            lettres_j1.setText(j1reserve);
        }
        if (lettres_j2 != null){

            lettres_j2.setText(j2reserve);
        }
        updateLettresRestantes();
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
                updatePlateau();
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
                updatePlateau();
                updatePoints(Partie.getInstance());
            }
            else{
                new ErreurMot(primaryStage);
            }
        }
    }

    public void updatePlateau(){
        List<String> mots = Partie.getInstance().getJoueurs().get(0).getPlateau().getMotEspace();
        P1M1.setText(mots.get(0));
        P1M2.setText(mots.get(1));
        P1M3.setText(mots.get(2));
        P1M4.setText(mots.get(3));
        P1M5.setText(mots.get(4));
        P1M6.setText(mots.get(5));
        P1M7.setText(mots.get(6));
        P1M8.setText(mots.get(7));
        mots = Partie.getInstance().getJoueurs().get(1).getPlateau().getMotEspace();
        P2M1.setText(mots.get(0));
        P2M2.setText(mots.get(1));
        P2M3.setText(mots.get(2));
        P2M4.setText(mots.get(3));
        P2M5.setText(mots.get(4));
        P2M6.setText(mots.get(5));
        P2M7.setText(mots.get(6));
        P2M8.setText(mots.get(7));
    }

    public void passer(){
        Joueur current = Partie.getInstance().getCurrentPlayer();
        if (!current.getFirstChoice() && !Partie.getInstance().getFini()) {
            if (current == Partie.getInstance().getJoueurs().get(0)) {
                Partie.getInstance().setCurrentPlayer(Partie.getInstance().getJoueurs().get(1));
                current = Partie.getInstance().getCurrentPlayer();
                disableChampMot(2);
                indicateur(2);
                if (!Partie.getInstance().isFirstRound()){
                    Partie.getInstance().getCurrentPlayer().setFirstChoice(true);
                    disable1erTour(false);
                }
            } else if (current == Partie.getInstance().getJoueurs().get(1)) {
                Partie.getInstance().setCurrentPlayer(Partie.getInstance().getJoueurs().get(0));
                current = Partie.getInstance().getCurrentPlayer();
                disableChampMot(1);
                indicateur(1);
                Partie.getInstance().getCurrentPlayer().setFirstChoice(true);
                if (Partie.getInstance().isFirstRound()){
                    Partie.getInstance().setFirstRound(false);
                    disable1erTour(false);
                }

            }
            if (current instanceof Ia){
                Ia playerIa = (Ia) current;
                if (playerIa.getFirstChoice() && !Partie.getInstance().isFirstRound()){
                    piocher();
                }
                playerIa.jouerRandom();
            }
        }
    }

    public void piocher(){
        Joueur current = Partie.getInstance().getCurrentPlayer();
        if (current.getFirstChoice()){
            current.piocher(1);
            current.setFirstChoice(false);
            updateLettresRestantes();
        }
    }

    public void updateLettresRestantes(){
        int nb_lettres = Partie.getInstance().getReserve().size();
        if (lettres_pioche != null){
            lettres_pioche.setText("Lettres restantes dans la pioche :\n" + nb_lettres);
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
        modifier.setDisable(b);
        updateLettresRestantes();
    }

    public void echanger(){
        Joueur current = Partie.getInstance().getCurrentPlayer();
        if (current.getFirstChoice()){
            new Echange(primaryStage, current);
            updateLettresRestantes();
        }
    }

    public void abandonner() throws Exception {
        disableAll(true);
        String current = Partie.getInstance().getCurrentPlayer().getNom();
        List<Joueur> listjoueurs = Partie.getInstance().getJoueurs();
        String other = "";
        if (listjoueurs.get(0).getNom() == current){
            other = listjoueurs.get(1).getNom();
        }
        else {
            other = listjoueurs.get(0).getNom();
        }
        new AbandonJoueur(primaryStage, current, other);
        Partie.getInstance().setFini(true);
    }

    public void indicateur(int i){
        String current = Partie.getInstance().getCurrentPlayer().getNom();
        List<Joueur> listjoueurs = Partie.getInstance().getJoueurs();
        String other = "";
        if (listjoueurs.get(0).getNom() == current){
            other = listjoueurs.get(1).getNom();
        }
        else {
            other = listjoueurs.get(0).getNom();
        }
        if (i == 1){
            joueur1.setDisable(false);
            joueur1.setText("⫸ " + current);
            joueur2.setDisable(true);
            joueur2.setText(other);
        }
        else if (i == 2){
            joueur2.setDisable(false);
            joueur2.setText("⫸ " + current);
            joueur1.setDisable(true);
            joueur1.setText(other);
        }
    }

    public void disableAll(boolean b){
        jarnac.setDisable(b);
        passer.setDisable(b);
        piocher.setDisable(b);
        echanger.setDisable(b);
        abandonner.setDisable(b);
        input_j1.setDisable(b);
        input_j2.setDisable(b);
        aide.setDisable(b);
        modifier.setDisable(b);
    }

    public void modifier(){
        if (!Partie.getInstance().isFirstRound() && !Partie.getInstance().getCurrentPlayer().getFirstChoice())
        new Modifier(primaryStage);
    }

    public boolean modifierMot(int l, String m){
        return Partie.getInstance().getCurrentPlayer().modifier(l,m.toUpperCase());
    }

    public void restart(){
        primaryStage.close();
        primaryStage.show();
        mediaPlayer.stop();
        startMusic();
        Controller.getInstance().initplateau();
        new Vue.Popup(primaryStage, 1);
        disableAll(false);
        disable1erTour(true);
        Partie.getInstance().resetReserve();
    }

    MediaPlayer mediaPlayer;
    public void startMusic(){
        String s = "src/ressources/music.mp3";
        Media m = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(m);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void annonceWinner(Joueur los, Joueur win){
        disableAll(true);
        new Victoire(primaryStage, win.getNom(), los.getNom());
    }
}
