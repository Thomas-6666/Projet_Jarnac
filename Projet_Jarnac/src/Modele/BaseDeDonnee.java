package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDonnee {
    private static BaseDeDonnee instance;
    private List<String> mots;

    private BaseDeDonnee() {
        mots = new ArrayList<>();
        try {
            // Le fichier d'entrée
            File file = new File("BDD.txt");
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                mots.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BaseDeDonnee getInstance() {
        if (instance == null) {
            instance = new BaseDeDonnee();
        }
        return instance;
    }

    public boolean verification(String mot) {
        for (String motDB : mots) {
            if (motDB.equalsIgnoreCase(mot)) {
                return true;
            }
        }
        return false;
    }

    //RAJOUTER PAR MOI POUR TEST IA
    public List<String> getBdd() {
        return mots;
    }
}

