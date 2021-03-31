/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava.v3;

import java.util.Scanner;

/**
 *
 * @author momar
 */
class Partie {
    

    public void Partie()
    {
        Plateau1 tr = new Plateau1();
        Plateau2 tr2 = new Plateau2();
        Bateau bt = new Bateau();
        Joueur player = new Joueur();
        JoueurIA Computer = new JoueurIA();
        Case v = new Case();
        
        tr.demanderTaille(tr);
        tr.initialiserTerrain(tr);
        tr2.demanderTaille(tr2);
        tr2.initialiserTerrain(tr2);
        int nbateaux = 1;
        int nb = 4;
        int nbr = 1;
        int nbre = 1;
        
        
        bt.mettreBateaux2(tr, nbateaux);
        bt.mettreBateaux(tr, nb);
        bt.mettreBateaux3(tr, nbr);
        bt.mettreBateaux4(tr, nbre);
        
        bt.mettreBateaux2(tr2, nbateaux);
        bt.mettreBateaux(tr2, nb);
        bt.mettreBateaux3(tr2, nbr);
        bt.mettreBateaux4(tr2, nbre);
        //Tableau Joueur
        tr.afficheTerrain();
        System.out.println();
        System.out.println("Plateau contenant les navires de l'IA");
        tr2.afficheTerrain();
        System.out.println("Plateau contenant les navires du Joueur");
        
        
     Scanner in = new Scanner(System.in);
    int choix1=0;
    
        
    int ncoules = 0;
while (ncoules < 5) 
       {
    System.out.println("1) Faire un tir \n2) deplacer un bateau\n3) quitter\n4) Passer son tour");
System.out.print("Choix1: ");
    choix1 = in.nextInt();

switch (choix1) 

{
    case 1:
    System.out.println ( "Vous avez choisi l'option 1" );
    System.out.println ("...Tirez!!...");
    int ntirs = 0;
       
        

           player.demanderCaseTir(tr, v);
         ncoules += player.tirer(tr,v);
           System.out.println();
         tr.afficheTerrain();
         ++ntirs;  
         
         System.out.println(" c'est au tour du joueur 2");
         System.out.println();
         
         Computer.tirerIA(tr2,v);
         
         tr2.afficheTerrain();
         System.out.println("Terrain contenant les navires du Joueur");
         tr.afficheTerrain();
        System.out.println("Terrain contenant les navires de l'IA");
       
        break;
       

    case 2:
    System.out.println ( "Vous avez choisi l'option 2" );
    System.out.println ("Deplacer votre bateau.");
    
    bt.demanderCaseDeplacement(tr2, v);
    bt.deplacementBateaux(tr2, v);
    bt.deplacementBateaux2(tr2, v);
    bt.deplacementBateaux3(tr2, v);
    bt.deplacementBateaux4(tr2, v);
    tr2.afficheTerrain();
        System.out.println("Terrain contenant les navires du Joueur");
    tr.afficheTerrain();
        System.out.println("Terrain contenant les navires de l'IA");
    
        //Sauvegarde sauve = new Sauvegarde();
        //sauve.Sauvegarde();
    break;

    case 3:
    System.out.println ( "Vous avez choisi l'option 3" );
    System.out.println ("Au revoir");
    new Menu();
    
        break;
        
        case 4:
    System.out.println ( "Vous avez choisi l'option 4" );
    System.out.println ("C'est au tour du joueur 2.");
    
         Computer.tirerIA(tr2,v);
            System.out.println();
         tr2.afficheTerrain();
    break;

    default:
    System.out.println ( "choix non reconnu" );
        System.out.println("Veuillez respecter le menu!");
}
       }




    
    
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
        
      
        


}