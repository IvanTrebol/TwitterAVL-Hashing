package controller;

import com.google.gson.Gson;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Tweet;
/**
 *
 * @author Evan-Ian-Ray
 */
public class TwitterApp {
    
    // Llaves para la authenticacion a twitter
    static String consumerKey = "y1i3Hhy3GUMOx9jvulw4Y8B1z";
    static String consumerSecret = "GG5DsFKTNPKz8PabBDY7a7sbm9gjVlYJqx3y3ifBAGpS5MGEL0";
    static String token = "240873982-qDYkFUqP8WSjD4M0LtBRn9w0ixPMFmvWcuj3lBlg";
    static String secret = "ahVTnCMzhaCBZNyWzRd4agB0eiWB23O92cY1ft6ba6BQy";
    
    public TwitterApp(){
        this.openTwitterClient();
    }
    
   private Client openTwitterClient(){

         // Abrir una nueva conexion a la api
        Client client = new ClientBuilder()
                .hosts( Constants.STREAM_HOST )
                .authentication( authentification() )
                .endpoint( endpointDictator() )
                .processor( new StringDelimitedProcessor( delimitCharacterCapacity() ) ) // <======
                .build();
        
        client.connect(); // <-----------------

        return client;
    } 
    
    private Authentication authentification(){
        
        Authentication auth = new OAuth1( consumerKey, consumerSecret, token, secret );
        return auth;
    }
    
    private StatusesFilterEndpoint endpointDictator(){
     
        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        return endpoint;
    }
    
    private BlockingQueue<String> delimitCharacterCapacity(){
        
        // Implementacion de cola, especial para su uso en concurrencia 
        // con capacidad de hasta 10,000 espacios
        BlockingQueue<String> tweetsQueue = new LinkedBlockingQueue<>(10000);
        
        return tweetsQueue;
    }
    
    protected void topicsToSearch(String topicToSearch ){
        
        // Añadir la lista de terminos a filtrar de la api publica de twitter
        endpointDictator().trackTerms( Arrays.asList( topicToSearch ) );
        
    }
    
    protected void showTweetsOnScreen( Object numberOfTweets ) throws FileNotFoundException{
        
        Gson gson = new Gson();
        
/*
        ColaPrioridad tweetsOnScreen = new ColaPrioridad();
        ListaSimple listOfTweets = new ListaSimple();
*/
        
        // Tomar solo los primeros 1,000 tweets
        for (int i = 0; i < ( int )numberOfTweets; i++) {
            try {
                String text = delimitCharacterCapacity().take(); // Tomar el json del tweet
                
                // Usa Gson (una librería) para convertir el json a un objeto de java
                // https://github.com/google/gson/blob/master/UserGuide.md#TOC-Gson-With-Maven
                // http://developers.squarespace.com/what-is-json/
                
                Tweet tweet = gson.fromJson(text, Tweet.class);
                
                System.out.println( tweet );
                
/*
                listOfTweets.insertaInicio( tweet );
                tweetsOnScreen.InsertarOrdenado( listOfTweets );
*/              
                
            } catch ( InterruptedException ex ) {
                Logger.getLogger(TwitterApp.class.getName() ).log( Level.SEVERE, null, ex );
            }
            
        }
        closeApp();
    }
    
    protected void closeApp(){
        openTwitterClient().stop();
    }
}
