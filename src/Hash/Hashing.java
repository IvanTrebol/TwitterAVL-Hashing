/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import listas.ListaDoble;
import listas.ListaSimple;
import listas.Nodo;


/**
 *
 * @author A15216354
 */
public class Hashing {
    private ListaSimple[] tabla = new ListaSimple[1000];
    int val;
    public void insertar(Object tweet,Object user){
        val =dispersion(user.toString());
        if(tabla[val]==null){
            tabla[val] = new ListaSimple();
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
    public String buscar(Object u){
        String ret;
      int a =  dispersion(u.toString());
      Nodo Actual = tabla[a].getInicio();
      while(Actual!=null){
          if(Actual.getUser().toString().equals(u.toString())){
              ret = Actual.getUser().toString() + " - " + Actual.getTweet().toString();
             
              return ret;
          }
          else{
              Actual = Actual.getSiguiente();
          }
      }
        
        
        return u.toString();
    }
     
}

