/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Controleur.*;
import Modele.*;
/**
 *
 * @author rebecca
 */
public class Case {
    
    public int lig;
public int col;
    

// Methode pour retourner un intervalle 
public  boolean dansIntervalle(int n, int a, int b) 
{
return (a <= n && n <= b); 
}

public  boolean caseValide(final Plateau1 tr, final Case c) {
  // la Case doit être sur le Terrain
boolean b = (dansIntervalle(c.lig,0,tr.Ligne - 1) && dansIntervalle(c.col,0,tr.Colonne - 1));

// Si oui, evalCase est licite
if (b) {
String valeur = tr.getCases(tr,c.lig,c.col);
// Et la valeur doit être Mer ou Bateau b = (valeur == Mer || valeur == Bateau);
}
return b; 
}

public boolean caseValide(Plateau2 tr2, Case c) {
        // la Case doit être sur le Terrain
boolean b = (dansIntervalle(c.lig,0,tr2.Ligne - 1) && dansIntervalle(c.col,0,tr2.Colonne - 1));

// Si oui, evalCase est licite
if (b) {
String valeur = tr2.getCases(tr2,c.lig,c.col);
// Et la valeur doit être BMer ou BBateau b = (valeur == BMer || valeur == BBateau);
}
return b; 

    }



}
