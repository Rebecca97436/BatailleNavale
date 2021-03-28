/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava.v3;

/**
 *
 * @author momar
 */
class Partie {
    

    public void Partie()
    {
        Plateau1 tr = new Plateau1();
        Bateau bt = new Bateau();
        Joueur player = new Joueur();
        Case v = new Case();
        
        tr.demanderTaille(tr);
        tr.initialiserTerrain(tr);
        int nbateaux = 1;
        int nb = 4;
        int nbr = 1;
        int nbre = 1;
        
        
        bt.mettreBateaux2(tr, nbateaux);
        bt.mettreBateaux(tr, nb);
        bt.mettreBateaux3(tr, nbr);
        bt.mettreBateaux4(tr, nbr);
        //Tableau Joueur
        tr.afficheTerrain();
        
        
        // Tableau IA 
        //tr.initialiserTerrain(tr);
        //tr.afficheTerrain();
        
        
       int ntirs = 0;
       int ncoules = 0;
       while (ncoules < nbateaux) 
       {
         player.demanderCaseTir(tr, v);
         
         ncoules += player.tirer(tr,v);
         tr.afficheTerrain();
         ++ntirs; 
       }
        

}
}