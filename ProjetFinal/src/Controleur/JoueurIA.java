/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import Vue.*;
import Modele.*;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author rebecca
 */
public class JoueurIA {
    
    
     Plateau2 tr = new Plateau2();
    Case c = new Case();
    Bateau boat = new Bateau();
    
    
    // Methode pour demander la case de tir 
    public  void demanderCaseTirIA(final Plateau2 tr, Case c) {
Random rnd = new Random();

//initialisation 
c.lig = -1;
c.col = -1;

//Tant qu'une case est valide 
while (!c.caseValide(tr,c)) 
{
System.out.print("Ligne du tir? " ); 
c.lig =  Math.abs(rnd.nextInt()) % tr.Ligne;
    System.out.println("la ligne est " +c.lig );
System.out.print("Colonne du tir? " );
c.col = Math.abs(rnd.nextInt()) % tr.Colonne;
    System.out.println("la colonne est " +c.col);
}
}
    
    //Methode pour permettre a l'IA de tirer 
    public int tirerIA(Plateau2 tr, final Case c)
{
int rs = 0;
String valeur = tr.getCases(tr,c.lig,c.col); 
this.demanderCaseTirIA(tr, c);

//Si la case ne contient pas de bateau 
if (valeur == boat.Mer )
{
 //Modifie la Case    
tr.setCases(tr,c.lig,c.col," ");
//Affiche que le tir est dans l'eau 
System.out.println("Tir dans l’eau!"); }

//Si la case contient un cuirasse
else if (valeur == "*") 
{
    //Modifie la case 
tr.setCases(tr,c.lig,c.col,"$"); 
//Affiche que le cuirasse est touche 
System.out.println("... Cuirasse touché...");
rs = 1; 
}

//Si la case contient un croiseur 
else if(valeur == "O")
{
    //Modifie la case 
    tr.setCases(tr, c.lig, c.col, "$");
    //Affiche que le croiseur est touche 
    System.out.println("... Croiseur touché...");
    rs=1;
}

//Si la case contient un destroyeur 
else if(valeur == "+")
{
    //Modifie la case 
    tr.setCases(tr, c.lig, c.col, "$");
    //Affiche que le sousMarin est touche 
    System.out.println("...Destroyer touché...");
    rs=1;
   
        
       
    
    
    
    
}

//Si la case contient un sousMarin 
else if(valeur=="s")
{
    //Modifie la case
    tr.setCases(tr, c.lig, c.col, "$");
    //Affiche que le sous Marin est touche-coulé 
    System.out.println("...Sous-Marin coulé...");
    rs=1;
    
}

//Si la case n'est pas dans le plateau 
else
{
    //Affiche le message d'erreur 
System.out.println("OUPS... ne devrait jamais arriver!");
}
return rs; 
}
    
}

