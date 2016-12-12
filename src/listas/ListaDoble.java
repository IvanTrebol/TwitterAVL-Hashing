/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author jorge.reyes
 */
public class ListaDoble extends ListaD{

    @Override
    public void insertaInicio(Object tweet, Object user) {
        if (vacio())
            inicio = ultimo = new NodoDoble(tweet, user);
        else{
            NodoDoble nuevo =  new NodoDoble(tweet, user,inicio,null);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
    }

    @Override
    public void insertaFinal(Object tweet, Object user) {
        if (vacio())
            inicio = ultimo = new NodoDoble(tweet, user);
        else
        {
            NodoDoble nuevo = new NodoDoble(tweet, user,null,ultimo);
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    @Override
    public Object eliminaInicio() {
       Object eliminado = null;
       if (vacio())
            System.out.println("Lista vacía");
       else
       {
           eliminado = inicio.getUser();
           if (inicio==ultimo){
               inicio = ultimo = null;
           }
           else
           {
             inicio = inicio.siguiente;
             inicio.anterior = null;
           } 
       }
       return eliminado;
    }

    @Override
    public Object eliminaFinal() {
       Object eliminado = null; 
       if (vacio())
            System.out.println("Lista vacía.");
       else{
           eliminado = ultimo.getUser();
           if (inicio == ultimo)
               inicio = ultimo =null;
           else{
               ultimo = ultimo.anterior;
               ultimo.siguiente = null;
           }
       } 
       return eliminado;
    }
    
     public void elimina(NodoDoble u){
   
        NodoDoble actual = inicio; 
        NodoDoble pre;
        NodoDoble pos;
        while(actual !=null){
            if(actual==u){
                if(actual==inicio){
                    eliminaInicio();
                    break;
                }
                else{
                    if(actual==ultimo){
                        eliminaFinal();
                        break;
                    }
                    else{
                        pre = actual.getAnterior();
                        pos = actual.getSiguiente();
                        pre.setSiguiente(pos);
                        pos.setAnterior(pre);
                        break;
                        
                    }
                }
            }
            else{
                actual = actual.siguiente;
                        }
            
        }
    }
//    public static void main(String[] args) {
//        ListaDoble listaD = new ListaDoble();
//        listaD.insertaInicio(20);
//        listaD.insertaInicio("perro");
//        listaD.insertaInicio(25.3);
//        listaD.insertaInicio("Hola");
//        listaD.insertaFinal("Ultimo");
//        listaD.eliminaInicio();
//        System.out.println("Imprimiendo la lista normal...");
//        listaD.imprimir();
//        System.out.println("\nImprimiendo la lista en orden inverso");
//        listaD.imprimirAlRevés();
//        System.out.println("\nEliminado el último elemento" + listaD.eliminaFinal());
//        System.out.println("Imprimiendo la lista");
//        listaD.imprimir();
//        System.out.println("Imprimiendo la liste al revés");
//        listaD.imprimirAlRevés();
//    }
    
}
