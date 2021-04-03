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
public class Menu {
Charger bg = new Charger();
File saveFile;
String[] args;
public Menu() 

{
    Scanner in = new Scanner(System.in);
    int choix=0;
    do{
    System.out.println("1) Jouer une partie\n2) Charger une partie\n3) Aide\n4) Quitter");
System.out.print("Choix: ");
    choix = in.nextInt();

    
switch (choix) 

{
    //Choix 1 : debuter la partie 
    case 1:
    System.out.println ( "Vous avez choisi l'option 1" );
    System.out.println ("Bonne partie.");
        Partie play = new Partie();
        play.Partie();
    break;
//Choix 2 : charger une partie 
    case 2:
    System.out.println ( "Vous avez choisi l'option 2" );
    System.out.println ("Rebonjour.");
    
    
        bg.load();
             
           
        
        //Sauvegarde sauve = new Sauvegarde();
        //sauve.Sauvegarde();
    break;

// Choix 3 : Avoir l'aide 
    case 3:
    System.out.println ( "Vous avez choisi l'option 3" );
    System.out.println ("Aide.");
        Aide a = new Aide();
        a.Aide();
    break;
  //Choix 4 : Quitter le jeu       
        case 4:
    System.out.println ( "Vous avez choisi l'option 4" );
    System.out.println ("Au revoir.");
    break;

    default:
    System.out.println ( "choix non reconnu" );
        System.out.println("Veuillez respecter le menu!");
}

    }while(choix > 4);
}
}