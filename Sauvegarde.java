/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataillenavale;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Badredine
 */

/**
 * On utilise la methode de la serialisation, voir source pour plus d'info 
 * @author Badredine
 */

public class Sauvegarde {
    static class Computer implements Serializable {
        private List<Device> devices = new LinkedList<>();
        
        public Computer (Device... device){
            this.devices.addAll(Arrays.asList(device));
        }
    }
    
    static abstract class Device implements Serializable {
        private String name;
        
        public Device (String name){
            this.name=name;
        }
    }
    
    static class Screen extends Device implements Serializable{
        public Screen(){
            super("screen");
        }
    }
    
    static class Keyboard extends Device implements Serializable{
        public Keyboard(){
            super("keyboard");
        }
    }
    
    public static void main(String[] args){
        Computer c = new Computer(new Keyboard(), new Screen());
        File saveFile = new File("saveFile"); 
        saveComputer(c,saveFile);
        c = loadComputer(saveFile);
    }
    
    private static Computer loadComputer(File saveFile){
        Computer computer = null;
        if (saveFile.exists ()){
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile));
                computer = (Computer) ois.readObject();
                ois.close();
            } 
            catch (IOException e){
                e.printStackTrace();
            }
            catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return computer;
    }
    
    public static void saveComputer(Computer c, File saveFile){
        try{
            if (!saveFile.exists()){
                saveFile.getAbsoluteFile().getParentFile().mkdirs();
            }
            FileOutputStream out = new FileOutputStream(saveFile);
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(c);
            oout.flush();
            oout.close();
            out.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

/* source : http://blog.paumard.org/cours/java/chap10-entrees-sorties-serialization.html
            https://www.youtube.com/watch?v=xzXEgUzRFh8
*/
