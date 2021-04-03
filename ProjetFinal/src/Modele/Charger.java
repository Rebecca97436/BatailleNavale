/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import Vue.*;
import Controleur.*;
 import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
/**
 *
 * @author momar
 */
public class Charger {
  



  public  void load() {

      
      
Partie p = null;
try {
// ouverture d'un flux d'entrée depuis le fichier "personne.serial"
FileInputStream fis = new FileInputStream("personne.serial");
// création d'un "flux objet" avec le flux fichier
ObjectInputStream ois= new ObjectInputStream(fis);
try {
// désérialisation : lecture de l'objet depuis le flux d'entrée
p = (Partie) ois.readObject();
} finally {
// on ferme les flux
try {
ois.close();
} finally {
fis.close();
}
}
} catch(IOException ioe) {
ioe.printStackTrace();
} catch(ClassNotFoundException cnfe) {
cnfe.printStackTrace();
}
if(p != null) {
System.out.println(p + " a ete deserialise");
}
}
    //lecture
   /* ArrayList<String> arraylist= new ArrayList<String>();
    try {
      FileInputStream fileIn = new FileInputStream("test");
      ObjectInputStream ois = new ObjectInputStream(fileIn);
      arraylist = (ArrayList) ois.readObject();
      ois.close();
      fileIn.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
       e.printStackTrace();
    }

    System.out.println("Lire les données: \n");
    for(String o:arraylist)
      System.out.println(o);
  }*/
}


