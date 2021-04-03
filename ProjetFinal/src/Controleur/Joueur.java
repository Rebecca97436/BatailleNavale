/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import Vue.*;
import Modele.*;
import java.util.Scanner;
/**
 *
 * @author rebecca
 */
public class Joueur {
    Plateau1 tr = new Plateau1();
    Case c = new Case();
    Bateau boat = new Bateau();
    
    
    //Methode pour demander au joueur de tirer 
    public  void demanderCaseTir(final Plateau1 tr, Case c) {
Scanner input = new Scanner(System.in);

//initialisation 
c.lig = -1;
c.col = -1;

//tant qu'une case est valide 
while (!c.caseValide(tr,c)) {
System.out.print("Ligne du tir? "); 
//Saisir la ligne de tir 
c.lig = input.nextInt();
System.out.print("Colonne du tir? ");
//Saisir la colonne de tir 
c.col = input.nextInt(); }
}
    
    //Methode pour tirer 
    public int tirer(Plateau1 tr, final Case c)
{
int rs = 0;
String valeur = tr.getCases(tr,c.lig,c.col);

//Si la case est vide 
if (valeur == boat.Mer )
{
    //Modifie la case 
tr.setCases(tr,c.lig,c.col," ");
//Affiche que le que le tir est dans l'eau 
System.out.println("tir dans l’eau!"); }

//Si la case contient un cuirasse 
else if (valeur == boat.Cuirasse) 
{
    //Modifie la case 
tr.setCases(tr,c.lig,c.col,"$"); 
//Affiche que le cuirasse est touche 
System.out.println("... Cuirasse touche...");
rs = 1; 
}

//Si la case contient un croiseur 
else if(valeur == boat.Croiseur)
{
    //Modifie la case 
    tr.setCases(tr, c.lig, c.col, "$");
    //Affiche que le croiseur est touce 
    System.out.println("... Croiseur touche...");
    rs=1;
}

//Si la case contient un destroyeur 
else if(valeur == boat.Destroyeur)
{
    //Modifie la case 
    tr.setCases(tr, c.lig, c.col, "$");
    //Affiche que le destroyeur est touche 
    System.out.println("...Destroyeur touche...");
    rs=1;
}

//Si la case contient un sous Marin 
else if(valeur==boat.sousMarin)
{
    //Modifie la case 
    tr.setCases(tr, c.lig, c.col, "$");
    //Affiche que le sous Marin est touche 
    System.out.println("... un SMarin a coule ...");
    rs=1;
}

//Si la case n'est pas dans le plateau 
else
{
    //Message d'erreur 
System.out.println("OUPS... ne devrait jamais arrive!");
}
return rs; 
}
    
    
    
    
        
        
        
   
    
    
    
}

    
    
    
    
        
        
        
   
    
    
    

