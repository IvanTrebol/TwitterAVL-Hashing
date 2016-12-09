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
public class ListaSimple extends Lista{

    @Override
    public void insertaInicio(Object tweet, Object user){
        if(vacio())
            inicio = ultimo = new Nodo(tweet, user);
        else{
            inicio = new Nodo(tweet, user,inicio);
        }
    }

    @Override
    public void insertaFinal(Object tweet, Object user) {
        if(vacio())
            inicio = ultimo = new Nodo(tweet, user);
        else{
        Nodo temp = new Nodo(tweet, user);
        ultimo.setSiguiente(temp);
        ultimo = temp;    
        }
    }

    @Override
    public Object eliminaInicio() {
    Object eliminado;    
        if (vacio())
            eliminado = null;
        else{
           eliminado = inicio.getTweet();
           inicio = inicio.getSiguiente();
        }
    return eliminado;
    }

    @Override
    public Object eliminaFinal() {
       return null;
    }
    
    public Object get(int index){
    Object elemento = null;
    int cont=0;
    Nodo actual = inicio;
    while(actual!=null){
        if (cont==index){
            return actual.getTweet();
        }
        else{
            actual = actual.getSiguiente();
            cont++;
        }
    }
    return elemento;
    }
    
//    public void insertaOrdenado(int dato){
//        if (vacio())
//            insertaInicio(dato);
//        else
//            if (inicio == ultimo){ //solo hay un nodo en la lista
//                if (dato < (Integer)inicio.getDato())
//                    insertaInicio(dato);
//                else
//                    insertaFinal(dato);
//            }
//            else { //La lista contiene más de un elemento
//                Nodo antes = null, despues = inicio;
//                while(despues!= null && dato > (Integer)despues.getDato()){
//                    antes = despues;
//                    despues = despues.getSiguiente();
//                }
//                if (antes==null)
//                    insertaInicio(dato);
//                else
//                    if (despues==null)
//                        insertaFinal(dato);
//                    else{
//                       Nodo nuevo = new Nodo(dato,despues);
//                       antes.setSiguiente(nuevo);
//                    }
//            }
//        
//    }
    
 
}
