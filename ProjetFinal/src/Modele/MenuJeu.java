/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import Vue.*;
import Controleur.*;
import java.util.Scanner;
/**
 *
 * @author rebecca
 */
public class MenuJeu {
    
    public MenuJeu() 
    {
        Plateau1 tr = new Plateau1();
        Bateau bt = new Bateau();
        Joueur player = new Joueur();
        Case v = new Case();
     Scanner in = new Scanner(System.in);
    int choix1=0;
    do{
    System.out.println("1) Faire un tir \n2) Déplacer un bateau\n3) Quitter\n4) Passer son tour");
System.out.print("Choix1: ");
    choix1 = in.nextInt();

    




switch (choix1) 

{
    case 1:
    System.out.println ( "Vous avez choisi l'option 1" );
    System.out.println ("...Tirez!!...");
    int ntirs = 0;
       int ncoules = 0;
        while (ncoules < 1) 
       {
           player.demanderCaseTir(tr, v);
         ncoules += player.tirer(tr,v);
           
         tr.afficheTerrain();
         ++ntirs; 
        break; 
       }
       
        break;
       

    case 2:
    System.out.println ( "Vous avez choisi l'option 2" );
    System.out.println ("Déplacer votre bateau.");
    
    
        //Sauvegarde sauve = new Sauvegarde();
        //sauve.Sauvegarde();
    break;

    case 3:
    System.out.println ( "Vous avez choisi l'option 3" );
    System.out.println ("Au revoir");
    
        break;
        
        case 4:
    System.out.println ( "Vous avez choisi l'option 4" );
    System.out.println ("Au revoir.");
    break;

    default:
    System.out.println ( "Choix non reconnu" );
        System.out.println("Veuillez respecter le menu!");
}





    }while(choix1 > 4);
    }}
    
    
    
        
