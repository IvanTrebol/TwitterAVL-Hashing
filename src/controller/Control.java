/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Hash.Hashing;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.avl.ArbolAVL;

/**
 *
 * @author Willi
 */
public class Control {
    
    public void armar(String a) throws IOException{
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(a + ".txt"));
            BufferedReader inUser = new BufferedReader(new FileReader(a + "Users.txt"));
            Hashing Hash = new Hashing();
            String Line = in.readLine();
            String readStringLine = inUser.readLine();
            List<String> lines = new ArrayList<String>();
            while(readStringLine!= null && Line != null) {
                lines.add(readStringLine);
                Hash.insertar(Line, readStringLine);
                readStringLine = inUser.readLine();
                Line = in.readLine();
            }
            in.close();
            inUser.close();
            
            String[] Users = lines.toArray(new String[lines.size()]);
            ArbolAVL Usuarios = new ArbolAVL(Users[0]);
            for(int i = 1; i< Users.length;i++){
                Usuarios.insertar(Users[i]);
                System.out.println(i);
            }
            Usuarios.inOrden(Hash);
            
                
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      public static void main(String[] args) throws IOException {
          Control control = new Control();
          
          control.armar("Giants");
//          Giants, ImAnArtistBecause, Romo,TheWalkingDead
      }
}
