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
public class Joueur {
    
    Case c = new Case();
    Bateau boat = new Bateau();
    
    public  void demanderCaseTir(final Plateau1 tr, Case c) {
Scanner input = new Scanner(System.in);
c.lig = -1;
c.col = -1;
while (!c.caseValide(tr,c)) {
System.out.print("Ligne du tir? "); c.lig = input.nextInt();
System.out.print("Colonne du tir? ");
c.col = input.nextInt(); }
}
    
    
    public int tirer(Plateau1 tr, final Case c)
{
int rs = 0;
String valeur = tr.getCases(tr,c.lig,c.col); 
if (valeur == boat.Mer )
{
tr.setCases(tr,c.lig,c.col," ");
System.out.println("tir dans l’eau!"); }
else if (valeur == boat.Cuirasse) 
{
tr.setCases(tr,c.lig,c.col,"$"); 
System.out.println("... Cuirasse touche...");
rs = 1; 
}
else if(valeur == boat.Croiseur)
{
    tr.setCases(tr, c.lig, c.col, "$");
    System.out.println("... Croiseur touche...");
    rs=1;
}
else if(valeur == boat.Destroyeur)
{
    tr.setCases(tr, c.lig, c.col, "$");
    System.out.println("...Destroyeur touche...");
    rs=1;
}
else if(valeur==boat.sousMarin)
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
