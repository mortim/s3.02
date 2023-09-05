package com.cosmopolis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

public class Sauvegarde {
    private String chemin;

    public Sauvegarde(String chemin) {
        this.chemin = chemin.substring(0, chemin.length()-4) + "-" + LocalDateTime.now() + ".dat";
    }

    public Ville lire() {
        Ville v = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.chemin));
            v = (Ville)ois.readObject();
            ois.close();
        } catch(FileNotFoundException e) {
            System.out.println("Fichier introuvable");
        } catch(IOException e) {
            System.out.println("Erreur de traitement I/O");
        } catch(ClassNotFoundException e) {
            System.out.println("Classe introuvable");
        }
        return v;
    }

    public void sauvegarder(Ville v) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.chemin));
            oos.writeObject(v);
            oos.close();
        } catch(IOException e) {
            System.out.println("Erreur de traitement I/O");
        }
    }
}
