package peertopeer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRicezione extends Thread{
   
    DatagramSocket server = new DatagramSocket(2003);
    String Out="";
    public ThreadRicezione() throws IOException {
    }
    @Override
    public void run() {
        while (true) {
            byte[] buffer = new byte[1500];
            DatagramPacket pacchetto = new DatagramPacket(buffer, buffer.length);
            try {
                server.receive(pacchetto);
            } catch (IOException ex) {
                Logger.getLogger(ThreadRicezione.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] DatiRicevuti = pacchetto.getData();
            String mess = new String(DatiRicevuti, 0, pacchetto.getLength());
            System.out.println(mess);
        }
    }
}
