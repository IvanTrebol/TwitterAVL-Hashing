package mx.uady.fmat.ed.tweeta;

import com.google.gson.Gson;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Tweet;
public class ApplicationTest {
    
//        Llaves para la authenticacion a twitter
    static String consumerKey = "y1i3Hhy3GUMOx9jvulw4Y8B1z";
    static String consumerSecret = "GG5DsFKTNPKz8PabBDY7a7sbm9gjVlYJqx3y3ifBAGpS5MGEL0";
    static String token = "240873982-qDYkFUqP8WSjD4M0LtBRn9w0ixPMFmvWcuj3lBlg";
    static String secret = "ahVTnCMzhaCBZNyWzRd4agB0eiWB23O92cY1ft6ba6BQy";
    
    public static void main(String[] args) {
//      Libreria para la conexión a la stream api de twitter
//      https://github.com/twitter/hbc        
        
//      Implementacion de cola, especial para su uso en concurrencia 
//      con capacidad de hasta 10,000 espacios
        BlockingQueue<String> tweetsQueue = new LinkedBlockingQueue<>(10000);
        
//      Añadir la lista de terminos a filtrar de la api publica de twitter
        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        endpoint.trackTerms(Arrays.asList("election2016"));
        
        // Abrir una nueva conexion a la api
        Authentication auth = new OAuth1(consumerKey, consumerSecret, token, secret);
        Client client = new ClientBuilder()
                .hosts(Constants.STREAM_HOST)
                .authentication(auth)
                .endpoint(endpoint)
                .processor(new StringDelimitedProcessor(tweetsQueue)) // <======
                .build();
        
        client.connect(); // <-----------------
        
        Gson gson = new Gson();
        
//        Tomar solo los primeros 1,000 tweets
        for (int i = 0; i < 1000; i++) {
            try {
                String text = tweetsQueue.take(); // Tomar el json del tweet
                
                // Usa Gson (una librería) para convertir el json a un objeto de java
                // https://github.com/google/gson/blob/master/UserGuide.md#TOC-Gson-With-Maven
                // http://developers.squarespace.com/what-is-json/
                
                Tweet tweet = gson.fromJson(text, Tweet.class);
                
                System.out.println(tweet);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ApplicationTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        client.stop(); // <---------------------
    }
}
