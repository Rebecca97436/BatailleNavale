/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava.v3;

import java.util.Random;

/**
 *
 * @author momar
 */
public class Bateau {
    
    
    
    String Mer = " "; 
      // int Mer1 = 9;
    String Croiseur = "o";
    String Cuirasse = "*"; 
    String Destroyeur = "+"; 
    String sousMarin = "s"; 
    
    Plateau1 p = new Plateau1();
    
    public  void mettreBateaux(Plateau1 tr, int nbt) {
Random rnd = new Random();

for (int n = 1; n <= nbt; ++n) {
int j, k , x ,y;
do 
{
j = Math.abs(rnd.nextInt()) % tr.Ligne;
k = Math.abs(rnd.nextInt()) % tr.Colonne; 
x = Math.abs(rnd.nextInt()) % tr.Ligne;
y = Math.abs(rnd.nextInt()) % tr.Colonne; 

} while (!(p.getCases(tr,j,k) == Mer ) ); 
//this.setCases(tr,j,k,Croiseur);

p.setCases(tr, x, y, sousMarin);
} 
    }
    
    public  void mettreBateaux2(Plateau1 tr, int nbt) {
Random rnd = new Random();
for (int n = 1; n <= nbt; ++n) {
int j, k , x ,y;
do 
{
j = Math.abs(rnd.nextInt(11)) % tr.Ligne;
k = Math.abs(rnd.nextInt(11)) % tr.Colonne; 
x = Math.abs(rnd.nextInt(11)) % tr.Ligne;
y = Math.abs(rnd.nextInt(11)) % tr.Colonne; 

} while (!(p.getCases(tr,j,k) == Mer ) ); 
    for ( int i=0 ; i<5 ; i++)
{
p.setCases(tr,j+i,k,Croiseur);
p.setCases(tr,x,y+i,Croiseur);
//this.setCases(tr, x, y, sousMarin);
}
}
    }

    
    public  void mettreBateaux3(Plateau1 tr, int nbt) {
Random rnd = new Random();
for (int n = 1; n <= nbt; ++n) {
int j, k , x ,y;
do 
{
j = Math.abs(rnd.nextInt(7)) % tr.Ligne;
k = Math.abs(rnd.nextInt(7)) % tr.Colonne; 


} while (!(p.getCases(tr,j,k) == Mer ) ); 
    
for ( int i=0 ; i<7 ; i++)
{
p.setCases(tr,j,k+i,Cuirasse);

//this.setCases(tr, x, y, sousMarin);
}
}
    }
    
     public  void mettreBateaux4(Plateau1 tr, int nbt) {
Random rnd = new Random();
for (int n = 1; n <= nbt; ++n) {
int j, k , x ,y , b ,a;

do 
{
j = Math.abs(rnd.nextInt()) % tr.Ligne;
k = Math.abs(rnd.nextInt()) % tr.Colonne; 
x = Math.abs(rnd.nextInt()) % tr.Ligne;
y = Math.abs(rnd.nextInt()) % tr.Colonne; 
a = Math.abs(rnd.nextInt()) % tr.Ligne;
b = Math.abs(rnd.nextInt()) % tr.Colonne; 

} while (!(p.getCases(tr,j,k) == Mer ) ); 
    for ( int i=0 ; i<3 ; i++)
{
p.setCases(tr,j+i,k,Destroyeur);
p.setCases(tr,x,y+i,Destroyeur);
p.setCases(tr,a+i, b,Destroyeur );
}
}
    }

}
