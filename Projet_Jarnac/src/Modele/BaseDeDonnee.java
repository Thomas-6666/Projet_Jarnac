package Modele;

import java.io.*;

public class BaseDeDonnee {

    public void liretoutlefichier(){
        try
        {
            // Le fichier d'entrée
            File file = new File("BDD.txt");
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while((line = br.readLine()) != null)
            {
                // ajoute la ligne au buffer
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            System.out.println("Contenu du fichier: ");
            System.out.println(sb.toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean verification(String mot){
        try
        {
            // Le fichier d'entrée
            File file = new File("BDD.txt");
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while((line = br.readLine()) != null) {
                mot = mot.toUpperCase();
                System.out.println(mot);
                System.out.println(line);
                if (line == mot) {
                    fr.close();
                    System.out.println("C'est true");
                    return true;
                }
            }
            fr.close();
            System.out.println("C'est false");
            return false;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            //Pas sûr de ce return false, mais si je le met pas, ça marche pas.
            System.out.println("C'est false + exception");
            return false;
        }
    }
}

