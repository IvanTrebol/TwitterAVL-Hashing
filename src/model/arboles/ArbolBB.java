/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.arboles;

import java.util.Objects;

/**
 * 
 * @author Evan-Ian-Ray
 */
public class ArbolBB {
    protected NodoBin raiz;
    
    public ArbolBB(Object o){
        raiz = new NodoBin(o);
    }
    
    public void inOrden(){
//        if (raiz!=null)
//            raiz.inOrden();
    }
    
    public void preOrden(){
        if (raiz!=null)
            raiz.preOrden();
    }
    
    public void posOrden(){
        if (raiz!=null)
            raiz.posOrden();
    }
    
    public void insertar(Object o){
        insertarOrdenado(raiz,o);
    }
    
    private void insertarOrdenado(NodoBin n, Object o){
        if((Integer)o< (Integer)n.getDato())
          if(n.getIzq()==null)
              n.setIzq(new NodoBin(o));
          else
              insertarOrdenado(n.getIzq(),o);
        else
            if((Integer)o>(Integer)n.getDato())
                if(n.getDer()==null)
                    n.setDer(new NodoBin(o));
                else
                    insertarOrdenado(n.getDer(),o);
              
    }
    
    public boolean buscar(Object o){
       return buscar(raiz,o);
    }
    
    private boolean buscar(NodoBin n, Object o){
        if (Objects.equals((Integer) o, (Integer)n.getDato()))
            return true;
        else
            if ((Integer) o <= (Integer) n.getDato())
                if(n.getIzq()!=null)
                    return buscar(n.getIzq(),o);
                else
                    return false;
            else        
                if(n.getDer()!=null)
                    return buscar(n.getDer(),o);
                else
                    return false;
    }
    
    public void borrar(Object o){
        borrar(raiz,o);
    }
    
    private NodoBin borrar(NodoBin n, Object o){
        if (n==null)
            return null;
        else{
         if ((Integer )o < (Integer) n.getDato())
             n.setIzq(borrar(n.getIzq(),o));
         else
             if ((Integer )o > (Integer) n.getDato())
             n.setDer(borrar(n.getDer(),o));
             else//Encontramos al que se requería
                 if(n.getIzq()!=null && n.getDer()!=null){//¿Tiene ambos hijos?
                     //Aplicamos el criterio del hijo más izquierdo del subárbol derecho
//                     NodoBin minimo = buscarMin(n.getDer());
//                     n.setDato(minimo.getDato());
//                     n.setDer(borrarMin(n.getDer()));
                       NodoBin maximo = buscarMax(n.getIzq());
                       n.setDato(maximo.getDato());
                       n.setIzq(borrarMax(n.getIzq()));
                 }
                 else//Puede tener 1 o ningún hijo
                     n = (n.getIzq()!=null)?n.getIzq():n.getDer();
                 
        }
        return n;
    }
    
    private NodoBin buscarMin(NodoBin n){
        while (n.getIzq()!=null)
           n = n.getIzq();
        return n;
    }
    
    private NodoBin borrarMin(NodoBin n){
        if (n.getIzq()!=null){
            n.setIzq(borrarMin(n.getIzq()));
            return n;
        }
        else
            return n.getDer();
    }
    
    private NodoBin buscarMax(NodoBin n){
        while (n.getDer()!=null)
          n = n.getDer();
        return n;
    }
    
    private NodoBin borrarMax(NodoBin n){
        if (n.getDer()!=null){
            n.setDer(borrarMax(n.getDer()));
            return n;
        }
        else
            return n.getIzq();
    } 
            
            
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB(28);
        arbol.insertar(92);
        arbol.insertar(14);
        arbol.insertar(73);
        arbol.insertar(1);
        arbol.insertar(91);
        arbol.insertar(100);
        arbol.insertar(15);
        arbol.insertar(74);
        arbol.insertar(2000);
        arbol.insertar(602);
//        if(arbol.buscar(2000))
//            System.out.println("El dato si se encuentra");
//        else
//            System.out.println("El dato no se encuentra");
        System.out.println("InOrden:");
        arbol.inOrden();
//        System.out.println("\nPreOrden");
//        arbol.preOrden();
//        System.out.println("\nPosOrden");
//        arbol.posOrden();
        arbol.borrar(92);
        System.out.println("Borrando el 92");
        arbol.inOrden();
    }
}
