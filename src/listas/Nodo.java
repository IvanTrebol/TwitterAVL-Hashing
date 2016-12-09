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
public class Nodo {
    protected Object tweet;
    protected Object user;
    protected Nodo siguiente;

    public Nodo() {
    }

    
    public Nodo(Object tweet, Object user) {
        this.tweet = tweet;
        this.user = user;
    }

    
    
    public Nodo(Object tweet,Object user , Nodo siguiente) {
        this.tweet = tweet;
        this.user = user;
        this.siguiente = siguiente;
    }

    /** Esta es una función para obtener el dato de la clase 
     * Nodo.
     * @return the dato
     */
    public Object getTweet() {
        return tweet;
    }

    /**
     * @param dato the dato to set
     */
    public void setTweet(Object dato) {
        this.tweet = dato;
    }

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }
    
    
    
    
}
