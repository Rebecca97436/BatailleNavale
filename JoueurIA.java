/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava.v3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author momar
 */
public class JoueurIA {
    
    
     Plateau2 tr = new Plateau2();
    Case c = new Case();
    Bateau boat = new Bateau();
    
    public  void demanderCaseTirIA(final Plateau2 tr, Case c) {
Random rnd = new Random();
c.lig = -1;
c.col = -1;
while (!c.caseValide(tr,c)) {
System.out.print("Ligne du tir? " ); 
c.lig =  Math.abs(rnd.nextInt()) % tr.Ligne;
    System.out.println("la ligne est " +c.lig );
System.out.print("Colonne du tir? " );
c.col = Math.abs(rnd.nextInt()) % tr.Colonne;
    System.out.println("la colonne est " +c.col);}
}
    
    
    public int tirerIA(Plateau2 tr, final Case c)
{
int rs = 0;
String valeur = tr.getCases(tr,c.lig,c.col); 
this.demanderCaseTirIA(tr, c);
if (valeur == boat.Mer )
{
    
tr.setCases(tr,c.lig,c.col," ");
System.out.println("tir dans l’eau!"); }
else if (valeur == "D") 
{
tr.setCases(tr,c.lig,c.col,"$"); 
System.out.println("... Cuirass touche...");
rs = 1; 
}
else if(valeur == "D")
{
    tr.setCases(tr, c.lig, c.col, "$");
    System.out.println("... Croiseur touche...");
    rs=1;
}
else if(valeur == "D")
{
    tr.setCases(tr, c.lig, c.col, "$");
    System.out.println("...Destroyeur touche...");
    rs=1;
}
else if(valeur=="D")
{
    tr.setCases(tr, c.lig, c.col, "$");
    System.out.println("...SMarin touche...");
    rs=1;
}
else
{
System.out.println("OUPS... ne devrait jamais arrive!");
}
return rs; 
}
    
}
