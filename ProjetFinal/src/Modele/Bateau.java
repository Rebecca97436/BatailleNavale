/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import Vue.*;
import Controleur.*;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author rebecca
 */
public class Bateau {
    
    
    
    public String Mer = " "; 
      // int Mer1 = 9;
    public String Croiseur = "o";
    public String Cuirasse = "*"; 
    public String Destroyeur = "+"; 
    public String sousMarin = "s"; 
    
    Plateau1 p = new Plateau1();
    Plateau2 p2 = new Plateau2();
    
    //Methode pour placer les bateaux 
    public  void mettreBateaux(Plateau1 tr, int nbt) {
Random rnd = new Random();

for (int n = 1; n <= nbt; ++n) {
int j, k , x ,y;
do 
{
    //Ligne aleatoire 
j = Math.abs(rnd.nextInt()) % tr.Ligne;
//Colonne aleatoire 
k = Math.abs(rnd.nextInt()) % tr.Colonne; 
//Ligne aleatoire
x = Math.abs(rnd.nextInt()) % tr.Ligne;
//Colonne Aleatoire 
y = Math.abs(rnd.nextInt()) % tr.Colonne; 

} while (!(p.getCases(tr,j,k) == Mer ) ); 
/*this.setCases(tr,j,k,Croiseur);*/
//Modifie la case 
p.setCases(tr, x, y, sousMarin);
} 
    }
    
    
    //Methode pour placer les bateaux 
    public  void mettreBateaux2(Plateau1 tr, int nbt) {
Random rnd = new Random();
for (int n = 1; n <= nbt; ++n) {
int j, k , x ,y;
// Choix de ligne et colonne aleatoire 
do 
{
j = Math.abs(rnd.nextInt(11)) % tr.Ligne;
k = Math.abs(rnd.nextInt(11)) % tr.Colonne; 
x = Math.abs(rnd.nextInt(11)) % tr.Ligne;
y = Math.abs(rnd.nextInt(11)) % tr.Colonne; 

} while (!(p.getCases(tr,j,k) == Mer ) ); 

//Modifie les cases 
    for ( int i=0 ; i<5 ; i++)
{
p.setCases(tr,j+i,k,Croiseur);
p.setCases(tr,x,y+i,Croiseur);
//this.setCases(tr, x, y, sousMarin);
}
}
    }

    //Methode pour placer les bateaux 
    public  void mettreBateaux3(Plateau1 tr, int nbt) {
Random rnd = new Random();
for (int n = 1; n <= nbt; ++n) {
int j, k , x ,y;
//Choix de Ligne et de colonne Aleatoire 
do 
{
j = Math.abs(rnd.nextInt(7)) % tr.Ligne;
k = Math.abs(rnd.nextInt(7)) % tr.Colonne; 


} while (!(p.getCases(tr,j,k) == Mer ) ); 
 //Modifie la case    
for ( int i=0 ; i<7 ; i++)
{
p.setCases(tr,j,k+i,Cuirasse);

//this.setCases(tr, x, y, sousMarin);
}
}
    }
    
    
    //Methode pour placer les bateaux 
     public  void mettreBateaux4(Plateau1 tr, int nbt) {
Random rnd = new Random();
for (int n = 1; n <= nbt; ++n) {
int j, k , x ,y , b ,a;

do 
{
j = Math.abs(rnd.nextInt(13)) % tr.Ligne;
k = Math.abs(rnd.nextInt(13)) % tr.Colonne; 
x = Math.abs(rnd.nextInt(13)) % tr.Ligne;
y = Math.abs(rnd.nextInt(13)) % tr.Colonne; 
a = Math.abs(rnd.nextInt(13)) % tr.Ligne;
b = Math.abs(rnd.nextInt(13)) % tr.Colonne; 

} while (!(p.getCases(tr,j,k) == Mer ) ); 
    for ( int i=0 ; i<3 ; i++)
{
p.setCases(tr,j+i,k,Destroyeur);
p.setCases(tr,x,y+i,Destroyeur);
p.setCases(tr,a+i, b,Destroyeur );
}
}
    }
     
     
     
     //Methode pour  demander dans quelle case deplacer le bateau   
     public  void demanderCaseDeplacement(final Plateau2 tr2, Case c) {
        Scanner input = new Scanner(System.in);
        c.lig = -1;
        c.col = -1;
        while (!c.caseValide(tr2,c)) {
        System.out.print("Saisir la ligne du bateau à déplacer svp : "); 
        c.lig = input.nextInt();
        System.out.print("Saisir la colonne du bateau à déplacer svp : ");
        c.col = input.nextInt(); }
    }

//Methode de deplacement des bateaux 
    public void deplacementBateaux(Plateau2 tr2, final Case c){
//Si la case contient un sous Marin , on deplace vers le bas
        if (tr2.getCases(tr2,c.lig,c.col) == Mer && p2.getCases(tr2, c.lig+1, c.col)== sousMarin )
        {
        tr2.setCases(tr2, c.lig, c.col,"s");
        tr2.setCases(tr2, c.lig+1, c.col," ");
        System.out.println("...Sous-Marin déplacé !..."); }
        
        //Si la case contient un sous Marin on deplace vers le haut 
        else if(tr2.getCases(tr2,c.lig,c.col) == Mer && p2.getCases(tr2, c.lig-1, c.col)== sousMarin )
        {
        tr2.setCases(tr2, c.lig, c.col,"s");
        tr2.setCases(tr2, c.lig-1, c.col," ");
        System.out.println("...Sous-Marin déplacé !..."); }
        
        //Si la case contient un sous Marin , on de place vers la droite 
        else if(tr2.getCases(tr2,c.lig,c.col) == Mer && p2.getCases(tr2, c.lig, c.col+1)== sousMarin )
        {
        tr2.setCases(tr2, c.lig, c.col,"s");
        tr2.setCases(tr2, c.lig, c.col+1," ");
        System.out.println("...Sous-Marin déplacé !..."); }
        
        //Si la case contient un sous Marin on deplace vers la gauche 
        else if(tr2.getCases(tr2,c.lig,c.col) == Mer && p2.getCases(tr2, c.lig, c.col-1)== sousMarin )
        {
        tr2.setCases(tr2, c.lig, c.col,"s");
        tr2.setCases(tr2, c.lig, c.col-1," ");
        System.out.println("...Sous-Marin déplacé !..."); }
        
        //Sinon
        else{
           System.out.println("...Déplacement non autorisé pour le sous marin !..."); 
        }
           
    }
    
//Methode pour placer les bateaux 
    public void deplacementBateaux2(Plateau2 tr2, final Case c){
        
        int j, k , x ,y,t,u;
        j = c.lig;
        k = c.col;
        x = c.lig+1;
        y = c.col+1;
        t = c.lig-1;
        u = c.col-1;
// Si la case contient un croiseur 
        if (tr2.getCases(tr2,j,k) == Mer && p2.getCases(tr2, x, k)== Croiseur )//remonter le bateau
        {
            for ( int i=0 ; i<5 ; i++){
            tr2.setCases(tr2,j,k,"o");
            tr2.setCases(tr2,j-1,k,"o");
            tr2.setCases(tr2,j-2,k,"o");
            tr2.setCases(tr2,j-3,k,"o");
            tr2.setCases(tr2,j-4,k,"o");
            tr2.setCases(tr2, x, k," ");
            tr2.setCases(tr2, x+1, k," ");
            tr2.setCases(tr2, x+2, k," ");
            tr2.setCases(tr2, x+3, k," ");
            tr2.setCases(tr2, x+4, k," ");
         }System.out.println("...Croiseur déplacé !...");
        }
        //Si la case contient un croiseur 
        else if(tr2.getCases(tr2,j,k) == Mer && p2.getCases(tr2, t, k)== Croiseur )//descendre le bateau
        {
            for ( int i=0 ; i<5 ; i++){
            tr2.setCases(tr2,j,k,"o");
            tr2.setCases(tr2,j+1,k,"o");
            tr2.setCases(tr2,j+2,k,"o");
            tr2.setCases(tr2,j+3,k,"o");
            tr2.setCases(tr2,j+4,k,"o");
            tr2.setCases(tr2, t, k," ");
            tr2.setCases(tr2, t-1, k," ");
            tr2.setCases(tr2, t-2, k," ");
            tr2.setCases(tr2, t-3, k," ");
            tr2.setCases(tr2, t-4, k," ");
            }
        System.out.println("...Croiseur déplacé !..."); 
        }
        //Si la case contient un croiseur 
        else if(tr2.getCases(tr2,j,k) == Mer && p2.getCases(tr2, j, y)== Croiseur )//à gauche
         {
            for ( int i=0 ; i<5 ; i++){
            tr2.setCases(tr2,j,k,"o");
            tr2.setCases(tr2,j,k-1,"o");
            tr2.setCases(tr2,j,k-2,"o");
            tr2.setCases(tr2,j,k-3,"o");
            tr2.setCases(tr2,j,k-4,"o");
            tr2.setCases(tr2, j, y," ");
            tr2.setCases(tr2, j, y+1," ");
            tr2.setCases(tr2, j, y+2," ");
            tr2.setCases(tr2, j, y+3," ");
            tr2.setCases(tr2, j, y+4," ");
            }
        System.out.println("...Croiseur déplacé !..."); }
        //Si la case contient uun croiseur 
        else if(tr2.getCases(tr2,j,k) == Mer && p2.getCases(tr2, j, u)== Croiseur )// à droite 
        {
            for ( int i=0 ; i<5 ; i++){
            tr2.setCases(tr2,j,k,"o");
             tr2.setCases(tr2,j,k+1,"o");
              tr2.setCases(tr2,j,k+2,"o");
              tr2.setCases(tr2,j,k+3,"o");
              tr2.setCases(tr2,j,k+4,"o");
            tr2.setCases(tr2, j, u," ");
                        tr2.setCases(tr2, j, u-1," ");
                        tr2.setCases(tr2, j, u-2," ");
                        tr2.setCases(tr2, j, u-3," ");
                         tr2.setCases(tr2, j, u-4," ");

            }
            System.out.println("...Croiseur déplacé !..."); 
        }
        //sinon 
        else{
           System.out.println("...Déplacement non autorisé pour le croiseur !..."); 
        }




    }
    
    
    
    
    //Methode pour placer les bateaux 
    public void deplacementBateaux3(Plateau2 tr2, final Case c){
           int j, k , x ,y,t,u;
        j = c.lig;
        k = c.col;
        x = c.lig+1;
        y = c.col+1;
        t = c.lig-1;
        u = c.col-1;
        //Si la case contient un destroyeur 
        if (tr2.getCases(tr2,j,k) == Mer && p2.getCases(tr2, x, k)== Destroyeur )//remonter le bateau
        {
            for ( int i=0 ; i<3 ; i++){
                tr2.setCases(tr2,j,k,"+");
                tr2.setCases(tr2,j-1,k,"+");
                tr2.setCases(tr2,j-2,k,"+");
                tr2.setCases(tr2, x, k," ");
                tr2.setCases(tr2, x+1, k," ");
                tr2.setCases(tr2, x+2, k," ");
            
         }System.out.println("...Destroyer déplacé !...");
        }
        
        //Si la case contient un destroyeur 
        else if(tr2.getCases(tr2,j,k) == Mer && p2.getCases(tr2, t, k)== Destroyeur )//descendre le bateau
        {
            for ( int i=0 ; i<3 ; i++){
                tr2.setCases(tr2,j,k,"+");
                tr2.setCases(tr2,j+1,k,"+");
                tr2.setCases(tr2,j+2,k,"+");
                tr2.setCases(tr2, t, k," ");
                tr2.setCases(tr2, t-1, k," ");
                tr2.setCases(tr2, t-2, k," ");
                
            }
        System.out.println("...Destroyer déplacé !..."); 
        }
        //Si la case contient un destroyeur 
        else if(tr2.getCases(tr2,j,k) == Mer && p2.getCases(tr2, j, y)== Destroyeur )//à gauche
        {
            for ( int i=0 ; i<3 ; i++){
                tr2.setCases(tr2,j,k,"+");
                tr2.setCases(tr2,j,k-1,"+");
                tr2.setCases(tr2,j,k-1,"+");
                tr2.setCases(tr2, j, y," ");
                tr2.setCases(tr2, j, y+1," ");
                tr2.setCases(tr2, j, y+2," ");
            }
        System.out.println("...Destroyer déplacé !..."); }
        
        //Si la case contient un destroyeur 
               else if(tr2.getCases(tr2,j,k) == Mer && p2.getCases(tr2, j, u)== Destroyeur )// à droite 
        {
            for ( int i=0 ; i<3 ; i++){
                tr2.setCases(tr2,j,k+i,"+");
                tr2.setCases(tr2, j, u-i," ");
            }
            System.out.println("...Destroyer déplacé !..."); 
        }
               //Sinon 
        
        else{
           System.out.println("...Déplacement non autorisé pour le destroyeur !..."); 
                    
            }
 }
    
    //Methode pour placer les bateaux 
    public void deplacementBateaux4(Plateau2 tr2, final Case c){

        int j, k , x ,y,t,u;
        j = c.lig;
        k = c.col;
        //x = c.lig+1;
        y = c.col+1;
        //t = c.lig-1;
        u = c.col-1;
               
        /*if (tr.getCases(tr,j,k) == Mer && p.getCases(tr, x, k)== Cuirasse )//remonter le bateau
        {
            for ( int i=0 ; i<7 ; i++){
            tr.setCases(tr,j+i,k,"*");
            tr.setCases(tr, x+i, k," ");
         }System.out.println("...Cuirassé déplacé !...");
        }
        
        else if(tr.getCases(tr,j,k) == Mer && p.getCases(tr, t, k)== Cuirasse )//descendre le bateau
        {
            for ( int i=0 ; i<7 ; i++){
            tr.setCases(tr,j+i,k,"*");
            tr.setCases(tr, t+i, k," ");
            }
        System.out.println("...Cuirassé déplacé !..."); 
        }*/
        
        /*else*/ 
        
        //Si la case contient un cuirasse 
        if(tr2.getCases(tr2,j,k) == Mer && p2.getCases(tr2, j, y)== Cuirasse )//à gauche
        {
            for ( int i=0 ; i<7 ; i++){
                
                tr2.setCases(tr2,j,k-i,"*");
                tr2.setCases(tr2, j, y+i," ");
                
            }
        System.out.println("...Cuirassé déplacé !..."); }
        
        //Si la case contient un cuirasse 
        else if(tr2.getCases(tr2,j,k) == Mer && p2.getCases(tr2, j, u)== Cuirasse )// à droite 
        {
            for ( int i=0 ; i<7 ; i++){
                
                tr2.setCases(tr2,j,k+i,"*");
               
                tr2.setCases(tr2, j, u-i," ");
               
                    }
            System.out.println("...Cuirassé déplacé !..."); 
        }
        //Sinon 
        else{
           System.out.println("...Déplacement non autorisé pour le cuirasse !..."); 
                    
            }


}

    
    //______________________________________________________________________
    
    //Programme pour mettre les bateaux dans le plateau de l'IA 
    
    
    
    void mettreBateaux2(Plateau2 tr2, int nbt) {
    Random rnd = new Random();
for (int n = 1; n <= nbt; ++n) {
int j, k , x ,y;
do 
{
j = Math.abs(rnd.nextInt(11)) % tr2.Ligne;
k = Math.abs(rnd.nextInt(11)) % tr2.Colonne; 
x = Math.abs(rnd.nextInt(11)) % tr2.Ligne;
y = Math.abs(rnd.nextInt(11)) % tr2.Colonne; 

} while (!(p2.getCases(tr2,j,k) == Mer ) ); 
    for ( int i=0 ; i<5 ; i++)
{
p2.setCases(tr2,j+i,k,Croiseur);
p2.setCases(tr2,x,y+i,Croiseur);
//this.setCases(tr, x, y, sousMarin);
}
}
    }
       

    void mettreBateaux(Plateau2 tr2, int nb) {
        Random rnd = new Random();

for (int n = 1; n <= nb; ++n) {
int j, k , x ,y;
do 
{
j = Math.abs(rnd.nextInt()) % tr2.Ligne;
k = Math.abs(rnd.nextInt()) % tr2.Colonne; 
x = Math.abs(rnd.nextInt()) % tr2.Ligne;
y = Math.abs(rnd.nextInt()) % tr2.Colonne; 

} while (!(p2.getCases(tr2,j,k) == Mer ) ); 
//this.setCases(tr,j,k,Croiseur);

p2.setCases(tr2, x, y, sousMarin);
} 
    }
        
    

    void mettreBateaux3(Plateau2 tr2, int nbt) {
        Random rnd = new Random();
for (int n = 1; n <= nbt; ++n) {
int j, k , x ,y;
do 
{
j = Math.abs(rnd.nextInt(7)) % tr2.Ligne;
k = Math.abs(rnd.nextInt(7)) % tr2.Colonne; 


} while (!(p2.getCases(tr2,j,k) == Mer ) ); 
    
for ( int i=0 ; i<7 ; i++)
{
p2.setCases(tr2,j,k+i,Cuirasse);

//this.setCases(tr, x, y, sousMarin);
}
}
    }

    
    
    void mettreBateaux4(Plateau2 tr2, int nbt) {
        Random rnd = new Random();
for (int n = 1; n <= nbt; ++n) {
int j, k , x ,y , b ,a;

do 
{
j = Math.abs(rnd.nextInt(13)) % tr2.Ligne;
k = Math.abs(rnd.nextInt(13)) % tr2.Colonne; 
x = Math.abs(rnd.nextInt(13)) % tr2.Ligne;
y = Math.abs(rnd.nextInt(13)) % tr2.Colonne; 
a = Math.abs(rnd.nextInt(13)) % tr2.Ligne;
b = Math.abs(rnd.nextInt(13)) % tr2.Colonne; 

} while (!(p2.getCases(tr2,j,k) == Mer ) ); 
    for ( int i=0 ; i<3 ; i++)
{
p2.setCases(tr2,j+i,k,Destroyeur);
p2.setCases(tr2,x,y+i,Destroyeur);
p2.setCases(tr2,a+i, b,Destroyeur );
}
}
    }
}