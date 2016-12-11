
import static GuardarArchivos.main;
import controller.TwitterApp;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static mx.uady.fmat.ed.tweeta.ApplicationTest.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rudy May
 */
public class GuardarArchivos implements Serializable{

    public static void main(String[] args) {
      public static void GuardarDatos(Object numberofTweets) throws IOException{
     
          ObjectOutputStream outputStream = null;

        try {

            //Construct the LineNumberReader object
            outputStream = new ObjectOutputStream(new FileOutputStream("Datos.txt"));

            
            outputStream.writeObject(numberofTweets);

            
            


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            //Close the ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }    
    }
     public static void GuardarDatos(Object numberofTweets) throws IOException{
     
          ObjectOutputStream outputStream = null;

        try {

            //Construct the LineNumberReader object
            outputStream = new ObjectOutputStream(new FileOutputStream("Datos.txt"));

            
            outputStream.writeObject(numberofTweets);

            
            


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            //Close the ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

     
}