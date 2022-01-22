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
        String reserveAsString = "";
        for (String s : ia.reserve) {
            reserveAsString+= s;
        }
        ia.generateArrangement(reserveAsString, "");

    }

    //Fonction pour afficher tous les arranegemnets (pour l'instant void mais retournera une liste de str)
    public void generateArrangement(String str, String ans) {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recurvise call
            generateArrangement(ros, ans + ch);
        }
    }


    public ArrayList getReserve() {
        return reserve;
    }

    public String generateWord(ArrayList<String> reserve) {
        int size = reserve.size();
        String word = reserve.get(0);
        //TODO
        //Il faut tester les arranegements à chaque fois
        //Si ma réserve est de taille 5
        //Je teste tous les arrangements pour faire un mot de 3 lettres, puis je trouve les nouveaux arrangements pour 4 lettres et enfin 5 lettres.
        //Mettre ça dans un while pour tester toutes les possibilités
        //Remplir quoi qu'il arrive la liste wordsGenerated
        //Remplir wordsPlayable uniquement si play la vérification passe
        //A la fin du while, si wordsPlayable /passer
        //Si non, parcourir wordsPlayble et jouer le mot le plus grand
        int nbArrangements = arrangement(size, size);

        //Permet de savoir combien de fois on va devoir changer d'arrangements.
        // Taille 3 = 1 fois || Taille 4 = 2 fois || etc...
        int nbTryNewArrangements = size - 2;
        System.out.println("Il y a " + nbArrangements + " arrangements possible");
        System.out.println("Pour une taille de " + size + " il faut tester " + nbTryNewArrangements + " arrangement(s) différent()s");
        List<String> wordsPlayable;
        List<String> wordsGenerated;
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

    public int arrangement(int n, int k) {
        /*n! / (n-k)!
        n = Nombre d'éléments dans l'ensemble
        k = Nombre d'élement qu'on pioche
        */
        int resultat = factorial(n) / factorial(n - k);
        return resultat;
    }

    public int factorial(int f) {
        if (f <= 1) {
            return 1;
        } else {
            return f * factorial(f - 1);
        }
    }
}
