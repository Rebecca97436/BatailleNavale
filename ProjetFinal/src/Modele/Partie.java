/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import Vue.*;
import Controleur.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
/**
 *
 * @author rebecca
 */
class Partie implements Serializable {

  

   
    
Sauvegarde bg = new Sauvegarde();
Charger bh = new Charger();
File saveFile;
    private String[] args;

    public void Partie() 
    {
        Plateau1 tr = new Plateau1();
        Plateau2 tr2 = new Plateau2();
        Bateau bt = new Bateau();
        Joueur player = new Joueur();
        JoueurIA Computer = new JoueurIA();
        Case v = new Case();
        
        // Creation des plateaux de jeu 
        tr.demanderTaille(tr);
        tr.initialiserTerrain(tr);
        tr2.demanderTaille(tr2);
        tr2.initialiserTerrain(tr2);
        
        // Nombre de bateaux 
        int nbateaux = 1;
        int nb = 4;
        int nbr = 1;
        int nbre = 1;
        
        // Mettre les bateaux sur le plateau 1 
        
        
        bt.mettreBateaux2(tr, nbateaux);
        bt.mettreBateaux(tr, nb);
        bt.mettreBateaux3(tr, nbr);
        bt.mettreBateaux4(tr, nbre);
        
        
        
        //Mettre les bateaux sur le plateau 2 
        bt.mettreBateaux2(tr2, nbateaux);
        bt.mettreBateaux(tr2, nb);
        bt.mettreBateaux3(tr2, nbr);
        bt.mettreBateaux4(tr2, nbre);
        
        
        //Tableau Joueur
        
        System.out.println("_______________________________________________");
        System.out.println();
        
        tr2.afficheTerrain();
        System.out.println();
        System.out.println("Plateau contenant les navires du joueur");
        
        
        System.out.println("_______________________________________________");
        System.out.println();
        //Tableau IA 
        tr.afficheTerrain();
        System.out.println("Plateau contenant les navires de l'IA");
        
        
        System.out.println();
        
        
     Scanner in = new Scanner(System.in);
    int choix1=0;
    
        
    int ncoules = 0;
    int ncoules2 = 0;
do
       {
    System.out.println("1) Faire un tir \n2) deplacer un bateau\n3) Sauvegarder\n4) Passer son tour");
System.out.print("Choix1: ");
    choix1 = in.nextInt();
    
    
// Choix 1 = tirer une case 
switch (choix1) 

{
    case 1:
    System.out.println ( "Vous avez choisi l'option 1" );
        System.out.println();
    System.out.println ("...Tirez!!...");
    int ntirs = 0;
       
    //Demande case de tir    
        System.out.println();
    player.demanderCaseTir(tr, v);
    
    //Tirer 
        System.out.println();
         ncoules += player.tirer(tr,v);
           System.out.println();
           
           //Affichage du terrain utilise 
         tr.afficheTerrain();
         ++ntirs;  
         System.out.println();
         System.out.println("____________________________________");
         System.out.println(" c'est au tour du joueur 2");
         System.out.println();
         
         //L'IA qui tire 
         ncoules2 +=Computer.tirerIA(tr2,v);
         System.out.println();
         //Affichage des terrain 
         tr2.afficheTerrain();
         System.out.println("Terrain contenant les navires du Joueur");
         System.out.println();
         tr.afficheTerrain();
        System.out.println("Terrain contenant les navires de l'IA");
        System.out.println();
        System.out.println("_______________________________________");
        System.out.println();
       
        break;
       
//Chiox 2 = deplacement des bateaux 
    case 2:
        System.out.println();
    System.out.println ( "Vous avez choisi l'option 2" );
        System.out.println();
    System.out.println ("Deplacer votre bateau.");
    //Demande case
        System.out.println();
    bt.demanderCaseDeplacement(tr2, v);
        System.out.println();
    //Deplace les bateaux 
    bt.deplacementBateaux(tr2, v);
    bt.deplacementBateaux2(tr2, v);
    bt.deplacementBateaux3(tr2, v);
    bt.deplacementBateaux4(tr2, v);
        System.out.println();
    //Affiche les plateaux 
    tr2.afficheTerrain();
        System.out.println("Terrain contenant les navires du Joueur");
        System.out.println();
    tr.afficheTerrain();
        System.out.println("Terrain contenant les navires de l'IA");
        
        System.out.println("_____________________________________");
        System.out.println();
    
        //Sauvegarde sauve = new Sauvegarde();
        //sauve.Sauvegarde();
    break;
//Choix 3 = quitte le jeu 
    case 3:
        
    System.out.println ( "Vous avez choisi l'option 3" );
    System.out.println ("Au revoir");
    
     bg.Sauvegarde();
             
    
    new Menu();
    
        break;
      // Choix 4 : passer son tour   
        case 4:
            System.out.println();
    System.out.println ( "Vous avez choisi l'option 4" );
            System.out.println();
    System.out.println ("C'est au tour du joueur 2.");
            System.out.println();
    
         Computer.tirerIA(tr2,v);
            System.out.println();
         tr2.afficheTerrain();
            System.out.println("Plateau contenant les navires du joueur");
            System.out.println();
         tr.afficheTerrain();
            System.out.println("Plateau contenant les navires de l'IA");
            System.out.println();
         
    break;

    default:
    System.out.println ( "choix non reconnu" );
        System.out.println("Veuillez respecter le menu!");
}
       }while (ncoules < 30);


        System.out.println("...TOUS LES BATEAUX ONT COULE!!!...");
        System.out.println("... VICTOIRE !!!...");
   
    
}
         // Tableau IA 
        //tr.initialiserTerrain(tr);
        //tr.afficheTerrain();
       /* int ntirs = 0;
       int ncoules = 0;
        while (ncoules < 10) 
       {
         player.demanderCaseTir(tr, v);
         
         ncoules += player.tirer(tr,v);
         tr.afficheTerrain();
         ++ntirs; 
       }*/
        
      
        public void cloturerPartie()
        {
            
        }


}
