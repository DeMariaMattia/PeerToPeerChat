package peertopeer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Logger;

public class DatiCondivisi {

    String IP,Username="";
    char Stato=' ';
    public void Set(String ip,String Usern){
        IP=ip;
        Username=Usern;
    }
    public String getIP(){
        return IP;
    }

    public String getUsername() {
        return Username;
    }

    public char getStato() {
        return Stato;
    }

    public void setStato(char Stato) {
        this.Stato = Stato;
    }
   


}
