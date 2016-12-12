/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import listas.ListaDoble;
import listas.ListaSimple;
import listas.Nodo;
import listas.NodoDoble;


/**
 *
 * @author A15216354
 */
public class Hashing {
    private String y;
    private ListaDoble[] tabla = new ListaDoble[1000];

    public Hashing(String y) {
        this.y = y;
    }
    
    public void insertar(Object tweet,Object user){
    
        int val;
        
        val =dispersion(user.toString());
        if(tabla[val]==null){
            
            tabla[val] = new ListaDoble();
         tabla[val].insertaFinal(tweet, user);
        }
        else{
            tabla[val].insertaFinal(tweet, user);
        }
        
    }
    public int dispersion(String cadena){
        int i;
        int n = cadena.length();
        int val= 0;
        
        for(i=0;i<n;i++){
           val = val+ (cadena.codePointAt(i)*(31^(n-(i+1)))) ;
            
        }
        
        val = val % 1000;
        
       return val; 
    }
    public String buscar(Object u) throws IOException{
        String ret;
      int a =  dispersion(u.toString());
      NodoDoble Actual = tabla[a].getInicio();
      while(Actual!=null){
          if(Actual.getUser().toString().equals(u.toString())){
              ret = Actual.getUser().toString() + " - " + Actual.getTweet().toString();
              BufferedWriter us = new BufferedWriter(new FileWriter(y + ".txt"));
              BufferedWriter users = new BufferedWriter(new FileWriter(y + "User.txt"));
              us.write(Actual.getTweet().toString());
              users.write(Actual.getUser().toString());
              
             tabla[a].elimina(Actual);
              return ret;
          }
          else{
              Actual = Actual.getSiguiente();
          }
      }
        
        
        return u.toString();
    }
   
     
}

