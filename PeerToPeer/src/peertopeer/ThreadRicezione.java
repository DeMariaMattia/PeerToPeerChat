package peertopeer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRicezione extends Thread{
   
    DatagramSocket server = new DatagramSocket(2003);
    DatiCondivisi Cond= new DatiCondivisi();
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
            if(mess.substring(0,2).equals("C;")&& (Cond.getStato()=='C')){
                System.out.println("Connessione già stabilita");
            }
            else if(mess.substring(0,2).equals("C;")){
                Cond.setStato('C');
                System.out.println("Connessione Stabilita");
            }
            else if(mess.substring(0,2).equals("M;")){
                Cond.setStato('M');
                System.out.println("Ciao!!");
            }
            else if(mess.substring(0,3).equals("D;D")){
                System.out.println("Chiusura connessione...");
                Cond.setStato(' ');
            }
            
            System.out.println(mess);
        }
    }
}
