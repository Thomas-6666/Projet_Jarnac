package Modele;

public class Joueur{
    private String nom;
    private int score = 0;
    private Reserve reserve;
    private Partie partie;
    private Plateau plateau;

    public Joueur(String n, Partie p){
        nom = n;
        partie = p;
        reserve = new Reserve(this);
        plateau = new Plateau();
    }

    public void setScore(int s){
        score = s;
    }

    public void echangerLettre(String l){
        reserve.remove(l);
        partie.getReserve().ajouterLettre(l);
        reserve.ajouterLettre(partie.getReserve().piocher());
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                '}';
    }

    public Reserve getReserve() {
        return reserve;
    }

    public String getNom() {
        return nom;
    }
}