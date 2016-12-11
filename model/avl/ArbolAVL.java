/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.avl;

/**
 * 
 * @author Evan-Ian-Ray
 */
public class ArbolAVL {
    protected NodoAVL raiz;

    public ArbolAVL(String h) {
        raiz = new NodoAVL(h);
    }
    
    public void inOrden(){
        if (raiz!=null)
            raiz.inOrden();
    }
    
    public void preOrden(){
        if (raiz!=null)
            raiz.preOrden();
    }
    
    public void posOrden(){
        if (raiz!=null)
            raiz.posOrden();
    }
    
    public void insertar(String h){
        insertarOrdenado(raiz,h);
    }
    
    private void insertarOrdenado(NodoAVL n, String h){
        if (h.compareTo((String)n.getDato())<0){
            if (n.getIzq()==null){
                n.setIzq(new NodoAVL(h,null,null,n));
                recalcularFE(n);
            }
            else
                insertarOrdenado((NodoAVL)n.getIzq(),h);
            }  
        else{
            if (h.compareTo((String)n.getDato())>0)
                if (n.getDer()==null){
                n.setDer(new NodoAVL(h,null,null,n));
                recalcularFE(n);
            }
            else
                insertarOrdenado((NodoAVL)n.getDer(),h);
        }
    }
    
    public void recalcularFE(NodoAVL nodo){
        if (nodo!=null){
            nodo.setFe(NodoAVL.altura((NodoAVL)nodo.getDer())- NodoAVL.altura((NodoAVL)nodo.getIzq()));
            if (nodo.getFe()==2 || nodo.getFe()==-2)
                balancear(nodo);
            else
                recalcularFE(nodo.getPadre());
        }
    }
    
    public void balancear(NodoAVL nodo){
        int feActual = nodo.getFe();
        if (feActual==2){
            switch(((NodoAVL)nodo.getDer()).getFe()){
                case 0:
                case 1: 
                    rotacionDD(nodo);
                    System.out.println("RotacionDD");
                    break;
                case -1:
                    rotacionDI(nodo);
                    System.out.println("RotacionDI");
                    break;
            }
        }
        else
            switch(((NodoAVL)nodo.getIzq()).getFe()){
                case 0:
                case 1: 
                    rotacionID(nodo);
                    System.out.println("RotacionID");
                    break;
                case -1:
                    rotacionII(nodo);
                    System.out.println("RotacionII");
                    break;
        }
    }
    
    public void rotacionDD(NodoAVL nodo){
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL)P.getDer();
        NodoAVL B = (NodoAVL)Q.getIzq();
        
        if (Padre!=null)
            if (Padre.getDer()==P)
                Padre.setDer(Q);
            else
                Padre.setIzq(Q);
        else
            raiz = Q;
        
        //Reconstruir el árbol
        P.setDer(B);
        Q.setIzq(P);
        
        //Reasignar papás
        P.setPadre(Q);
        if(B!=null) B.setPadre(P);
        Q.setPadre(Padre);
        
        //Ajustar los FE
        P.setFe(0);
        Q.setFe(0);
    }
    public void rotacionDI(NodoAVL nodo){
       NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL)P.getDer();
        NodoAVL R = (NodoAVL)Q.getIzq();
        NodoAVL B = (NodoAVL)R.getDer();
        NodoAVL C = (NodoAVL)R.getIzq();
        
        if (Padre!=null)
            if (Padre.getIzq()==nodo)
                Padre.setIzq(R);
            else
                Padre.setDer(R);
        else
            raiz = R;
        
        //Reconstruir el árbol
        Q.setIzq(B);
        P.setDer(C);
        R.setDer(Q);
        R.setIzq(P);
        
        //Reasignación de los padres
        R.setPadre(Padre);
        P.setPadre(R);
        Q.setPadre(R);               
        if (B!=null) B.setPadre(Q);
        if (C!=null) C.setPadre(Q);
        
        //Asignar valores a los FE
        switch (R.getFe()){
            case -1:
                Q.setFe(0);
                P.setFe(1);
                break;
            case 0:
                Q.setFe(0);
                P.setFe(0);
                break;
            case 1:
                Q.setFe(-1);
                P.setFe(0);
                break;
        
        }
    }
    
    
    public void rotacionID(NodoAVL nodo){
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL)P.getIzq();
        NodoAVL R = (NodoAVL)Q.getDer();
        NodoAVL B = (NodoAVL)R.getIzq();
        NodoAVL C = (NodoAVL)R.getDer();
        
        if (Padre!=null)
            if (Padre.getDer()==nodo)
                Padre.setDer(R);
            else
                Padre.setIzq(R);
        else
            raiz = R;
        
        //Reconstruir el árbol
        Q.setDer(B);
        P.setIzq(C);
        R.setIzq(Q);
        R.setDer(P);
        
        //Reasignación de los padres
        R.setPadre(Padre);
        P.setPadre(R);
        Q.setPadre(R);               
        if (B!=null) B.setPadre(Q);
        if (C!=null) C.setPadre(Q);
        
        //Asignar valores a los FE
        switch (R.getFe()){
            case -1:
                Q.setFe(0);
                P.setFe(1);
                break;
            case 0:
                Q.setFe(0);
                P.setFe(0);
                break;
            case 1:
                Q.setFe(-1);
                P.setFe(0);
                break;
        
        }
    }
    
    public void rotacionII(NodoAVL nodo){
         NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL)P.getIzq();
        NodoAVL B = (NodoAVL)Q.getDer();
        
        if (Padre!=null)
            if (Padre.getIzq()==P)
                Padre.setIzq(Q);
            else
                Padre.setDer(Q);
        else
            raiz = Q;
        
        //Reconstruir el árbol
        P.setIzq(B);
        Q.setDer(P);
        
        //Reasignar papás
        P.setPadre(Q);
        if(B!=null) B.setPadre(P);
        Q.setPadre(Padre);
        
        //Ajustar los FE
        P.setFe(0);
        Q.setFe(0);
    }
    
    
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL("arboleishon");
       
        
        
        arbol.insertar("señoraloca25");
        arbol.insertar("elamigopablo34");
        arbol.insertar("barneñ87");
        arbol.insertar("diasdepaso");
        arbol.insertar("sombrasoscuras");
        arbol.insertar("mayoritachi");
        arbol.insertar("chefjamon");
        arbol.inOrden();
        
       
    }
}
    
