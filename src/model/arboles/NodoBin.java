/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.arboles;

import Hash.Hashing;

/**
 * 
 * @author Evan-Ian-Ray
 */
public class NodoBin {
    protected Object dato;
    protected NodoBin izq;
    protected NodoBin der;

    public NodoBin(Object dato, NodoBin izq, NodoBin der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public NodoBin(Object dato) {
        this.dato = dato;
    }

    public NodoBin() {
    }

    //IRD
    public void inOrden(Hashing Hash){
        if (izq!=null)
            izq.inOrden(Hash);
        System.out.println(Hash.buscar(dato));
        if (der!=null)
            der.inOrden(Hash);
    }
    
    //RID
    public void preOrden(){
        System.out.println(dato);
        if (izq!=null)
            izq.preOrden();
        if(der!=null)
            der.preOrden();
    }
    
    //IDR
    public void posOrden(){
        if (izq!=null)
            izq.posOrden();
        if(der!=null)
            der.posOrden();
        System.out.println(dato);
    }
    
    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * @return the izq
     */
    public NodoBin getIzq() {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(NodoBin izq) {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public NodoBin getDer() {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(NodoBin der) {
        this.der = der;
    }
    
    
}
