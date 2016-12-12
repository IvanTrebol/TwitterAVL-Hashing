/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.avl;

import Hash.Hashing;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.arboles.NodoBin;

/**
 * 
 * @author Evan-Ian-Ray
 */
public class NodoAVL extends NodoBin{
    protected int fe;
    protected NodoAVL padre;

    public int getFe(){
        return fe;
    }
    
    public void setFe(int fe){
        this.fe=fe;
    }
    
    public NodoAVL getPadre(){
        return padre;
    }
    
    public void setPadre(NodoAVL padre){
        this.padre=padre;
    }
    
    public NodoAVL() {
    }

    public NodoAVL(Object dato) {
        super(dato);
    }

    public NodoAVL(Object dato, NodoBin izq, NodoBin der) {
        super(dato, izq, der);
    }

    public NodoAVL(Object dato, NodoBin izq, NodoBin der, NodoAVL padre) {
        super(dato, izq, der);
        this.padre = padre;
    }

    
    public static int altura(NodoAVL a){
        if(a==null)
            return -1;
        else
            return 1 + Math.max(altura((NodoAVL)a.getIzq()), altura((NodoAVL)a.getDer()));
    }
    
    @Override
    public void inOrden(Hashing Hash){
        if (izq!=null)
            izq.inOrden(Hash);
        try {
            System.out.println(Hash.buscar(dato));
        } catch (IOException ex) {
            Logger.getLogger(NodoAVL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (der!=null)
            der.inOrden(Hash);
    }
    
    public void preOrden(){
        System.out.println(dato+" FE: "+ fe);
        if (izq!=null)
            izq.preOrden();
        if (der!=null)
            der.preOrden();
    }
    
    public void posOrden(){
        if (izq!=null)
            izq.posOrden();
        if (der!=null)
            der.posOrden();
        System.out.println(dato+" FE: "+ fe);
    }
   
    
}
