package peertopeer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatiCondivisi {

    String IP,Username="";
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
     String risposta = "CIAO CLIENT";


}
