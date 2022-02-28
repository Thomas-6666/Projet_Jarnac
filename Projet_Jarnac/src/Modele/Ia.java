package Modele;

import Controlleur.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ia extends Joueur{

    public ArrayList<String> wordsPlayable = new ArrayList<>();
    BaseDeDonnee bdd;

    public Ia(String n) {
        super(n);
        bdd = BaseDeDonnee.getInstance();
    }

   /* public static void main(String[] args) {
        Ia ia = new Ia();
        System.out.println("Réserve de l'IA : " + ia.reserve);
        String wordPlayed = ia.generateWord(ia.reserve);
        if (wordPlayed.equalsIgnoreCase("/passer")){
            System.out.println("L'IA va passer son tour en faisant : " + wordPlayed);
        }
        else {
            System.out.println("L'IA va jouer le mot : " + wordPlayed);
        }
    }*/

    public void generateWord() {
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
        if (!wordsPlayable.isEmpty()) {
            System.out.println("Voici tous les mots que l'IA pourrait jouer : " + wordsPlayable);
            int nombreRandom = genererateRandom(0, wordsPlayable.size());
            jouer(wordsPlayable.get(nombreRandom));
            Controller.getInstance().passer();
        }
        else {
            Controller.getInstance().passer();
        }

    }

    public int genererateRandom(int borneInf, int borneSup) {
        Random random = new Random();
        int nb;
        nb = random.nextInt(borneSup - borneInf) + borneInf;
        return nb;
    }
}
