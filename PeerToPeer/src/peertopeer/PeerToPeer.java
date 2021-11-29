package peertopeer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeerToPeer {
    //192.168.188.23
    public static void main(String[] args) throws SocketException, IOException {
        DatiCondivisi COND= new DatiCondivisi();
         DatagramSocket Socket = new DatagramSocket();
                if(COND.getStato()=='C'){
                String MEX="Connessione Stabilita";
                byte[] buffer = MEX.getBytes();
		InetAddress address = InetAddress.getByName("192.168.188.36");
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 2003);
		Socket.send(packet); 
                }
        ThreadRicezione Ric = new ThreadRicezione();
        Ric.start();
        try {
            Ric.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(PeerToPeer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
