
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rudy May
 */
public class InformacionDeUsuario implements Serializable {
 public String Usuario;
 public String Twitter;
 public String TopicTrend;

    public InformacionDeUsuario(String Usuario, String Twitter, String TopicTrend) {
        this.Usuario=Usuario;
        this.Twitter=Twitter;
        this.TopicTrend=TopicTrend;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String Twitter) {
        this.Twitter = Twitter;
    }

    public String getTopicTrend() {
        return TopicTrend;
    }

    public void setTopicTrend(String TopicTrend) {
        this.TopicTrend = TopicTrend;
    }
 
 
 
}
