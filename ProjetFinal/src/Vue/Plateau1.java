/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Controleur.*;
import Modele.*;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author rebecca
 */
public class Plateau1 {
       String Mer = " "; 
      // int Mer1 = 9;
    String Croiseur = "o";
    String Cuirasse = "*"; 
    String Destroyeur = "+"; 
    String sousMarin = "s"; 
    int Cmax = 16;
    int Lmax = 16;
    
    public int Ligne ; 
    public int Colonne; 
    public String[][] cases;
    
    
    
    
    //Methode pour obtenir une case 
    public String getCases(Plateau1 tr , int x , int y )
    {
        return tr.cases[x][y];
    }
    
    //Methode pour modifier une case 
    public void setCases(Plateau1 tr , int x , int y , String val)
    {
        tr.cases[x][y] = val; 
    }
    
    
    // Methode pour obtenir le symbole d'une case 
    public String symboleBateau(String x)
    {
        if (x==Mer)
        {
            return "--|";
        }
       
        else if(x==Cuirasse)
        {
            return "*";
        }
        else if(x==Croiseur)
        {
            return "s";
        }
        else if(x==Destroyeur)
        {
            return "+";
        }
        else
        {
            return "o";
        }
    }
    
    //Methode pour afficher le plateau du joueur 
    public void afficheTerrain() 
    {

        String result = "";
        char charLigne = 'a';
        String barre = "--|";

        // Ajout de la premiere ligne pour afficher les coordonnées

        result += " |";

        for (int col = 0; col < Colonne ; col++) 
        {
            if (col < 10) result += " " + col + "|";
            else result += col + "|";
        }

        // _________________________________________________________

        // Affichage des cases

        for (int ligne = 0; ligne < Ligne; ligne++) 
        {

            // Afficher la barre 

            result += "\n" + " |";

            for(int col = 0; col < Colonne; col++){
                
                result += barre;}
            
            // _________________

            // Afficher les cases
            
            result += "\n" + charLigne++ + "|";
            
                
            for(int col = 0; col < Colonne; col++) 
            {
                result += "" + cases[ligne][col] + cases[ligne][col] + "|";
            }
            // _________________

        
 
        // _________________________________________________________
        }
        System.out.println(result);
    }
   
    //Methode pour saisir un entier 
    public  int saisirEntier(int binf, int bsup) {
Scanner input = new Scanner(System.in);
int n = binf - 1;
while (!(binf <= n && n <= bsup)) {
System.out.print("Entier dans [" + binf + ".." + bsup + "]? ");
n = input.nextInt(); }
return n; }
    //Methode pour demander la taille du plateau 
    public  void demanderTaille(Plateau1 tr) 
    {
System.out.print("Largeur du terrain: "); 
tr.Ligne = saisirEntier(1,Lmax); 
System.out.print("Hauteur du terrain: "); 
tr.Colonne = saisirEntier(1,Cmax);
}
    
    //Methode pour initialiser le plateau 
    public  void initialiserTerrain(Plateau1 tr) {
tr.cases = new String[Cmax][Lmax];
// Les dimensions sont valides
for (int j = 0; j < tr.Ligne; ++j) {

for (int k = 0; k < tr.Colonne; ++k) {
  this.setCases(tr,j,k,Mer);
} }
}
    
    

    
}
