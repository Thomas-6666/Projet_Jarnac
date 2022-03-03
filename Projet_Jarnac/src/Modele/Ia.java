package Modele;

import Controlleur.Controller;

import java.util.ArrayList;
import java.util.Random;

public class Ia extends Joueur{

    public ArrayList<String> wordsPlayable = new ArrayList<>();
    BaseDeDonnee bdd;

    public Ia(String n) {
        super(n);
        bdd = BaseDeDonnee.getInstance();
    }

    public void generateWord() {
        wordsPlayable.clear();
        ArrayList<String> temp = new ArrayList<>();
        for (String words : bdd.getBdd()) {
            ArrayList<String> reserve = new ArrayList<>(getReserve().getLettres());
            temp.clear();
            for (char c : words.toCharArray()){
                String lettre = String.valueOf(c);
                lettre= lettre.toUpperCase();
                if (reserve.contains(lettre)){
                    reserve.remove(lettre);
                    temp.add(lettre);
                }
            }

            if (temp.size() == words.length()) {
                wordsPlayable.add(words);
            }

        }
        System.out.println("l'ia a fait sa liste de mot");

    }

    public void jouerRandom(){
        generateWord();
        while (!wordsPlayable.isEmpty()) {
            jouer(wordsPlayable.get(new Random().nextInt(wordsPlayable.size())));
            piocher(1);
            generateWord();
        }
        Controller.getInstance().passer();
    }
}
