package Modele;

import java.util.ArrayList;
import java.util.List;

public class Ia {
    public BaseDeDonnee bdd = new BaseDeDonnee();
    public ArrayList<String> reserve = new ArrayList<>() {{
        add("p");
        add("u");
        add("i");
    }};

    public Ia() {
    }

    public static boolean containsWords(String inputString, List<String> items) {
        boolean found = false;
        int compteur = 0;
        inputString = inputString.toUpperCase();
        //J'ai un doute sur l'utilité du while
        while (compteur < items.size() || compteur < inputString.length()) {
            for (String item : items) {
                if (inputString.contains(item)) {
                    compteur += 1;
                    if (compteur == inputString.length()) {
                        found = true;
                        return found;
                    }
                }
            }
            break;
        }
        return found;
    }

    public static void main(String[] args) {
        Ia ia = new Ia();
        ia.generateWord(ia.reserve);

    }


    public String generateWord(ArrayList<String> reserve) {
        int size = reserve.size();
        String word = reserve.get(0);
        //TODO
        //Trouver un moyen de calculer les combinaisons possibles et empêcher d'avoir deux fois les mêmes
        //Exemple : ['a','b',c'], ['b','a','c'], etc
        //Mettre ça dans un while pour tester toutes les possibilités
        //A la fin du while, si la liste qui sera rempli dans le if (found) est vide alors faire /passer
        //Si non, parcourir la liste et jouer le mot le plus grand
        for (int i = 1; i < size; i++) {
            word += reserve.get(i);
            if (word.length() > 2) {
                //Vérifier que le mot est dans la bdd
                boolean found = containsWords(word, bdd.getBdd());
                if (found) {
                    System.out.println("C'est dedans l'IA peut jouer : " + word);
                } else {
                    System.out.println("C'est pas dedans, l'IA voulait jouer : " + word);
                }
            }
        }


        return word;
    }
}
