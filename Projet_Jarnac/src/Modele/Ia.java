package Modele;

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

    public String generateWord() {
        ArrayList<String> temp = new ArrayList<>();
        for (String words : bdd.getBdd()) {
            ArrayList<String> reserve = new ArrayList<>(getReserve().getLettres());
            temp.clear();
            boolean flag = true;
            for (char c : words.toCharArray()){
                String lettre = String.valueOf(c);
                lettre= lettre.toUpperCase();
                if (reserve.contains(lettre)){
                    reserve.remove(lettre);
                    temp.add(lettre);
                }
            }



           /* for (String size : reserve) {
                size = size.toUpperCase();
                if (!words.contains(size)) {
                    temp.add(size);
                    flag = false;
                }
            }*/
            //TROUVER UN MOYEN DE CORRIGER ICI
            //Ok j'ai trouvé ça vient du equals, ça prendra pas OUI car il aura que OUI et pas toute la réserve
            if (temp.size() == words.length()) {
                wordsPlayable.add(words);
            }

        }
        if (!wordsPlayable.isEmpty()) {
            System.out.println("Voici tous les mots que l'IA pourrait jouer : " + wordsPlayable);
            int nombreRandom = genererateRandom(0, wordsPlayable.size());
            return wordsPlayable.get(nombreRandom);
        }
        else {
            return "/passer";
        }

    }

    public int genererateRandom(int borneInf, int borneSup) {
        Random random = new Random();
        int nb;
        nb = random.nextInt(borneSup - borneInf) + borneInf;
        return nb;
    }
}
