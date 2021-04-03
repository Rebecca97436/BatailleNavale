/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Vue.*;
import Controleur.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Badredine
 */

/**
 * On utilise la methode de la serialisation, voir source pour plus d'info 
 * @author Badredine
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static java.lang.System.out;
import java.util.ArrayList;

public class Sauvegarde {

    private static Partie p;
    private static  Plateau1 Pla;
    
   
    File bg;

  public  void Sauvegarde() {
      
  
      
   try {
Partie b = new Partie();
System.out.println(b);
FileOutputStream fos = new FileOutputStream("b.serial");
ObjectOutputStream oos = new ObjectOutputStream(fos);
try {
oos.writeObject(b);
oos.flush();
} finally {
oos.close();
fos.close();
}
b = new Partie();
System.out.println(b);
FileInputStream fis = new FileInputStream("b.serial");
ObjectInputStream ois = new ObjectInputStream(fis);
try {
b = (Partie) ois.readObject();
} finally {
try {
ois.close();
} finally {
fis.close();
}
}
System.out.println(b);
} catch(ClassNotFoundException cnfe) {
cnfe.printStackTrace();
} catch(IOException ioe) {
ioe.printStackTrace();
}
}
}
  
    /* ArrayList al=new ArrayList();
     
     al.add( p );
     
     try {
       FileOutputStream fileOut = new FileOutputStream("f");
       ObjectOutputStream out = new ObjectOutputStream(fileOut);
       out.writeObject(al);
       out.close();
       fileOut.close();
       System.out.println("\nSauvegarde terminée avec succès...\n");
 
     } catch (FileNotFoundException e) {
       e.printStackTrace();
     } catch (IOException e) {
       e.printStackTrace();
     }
  }*/
