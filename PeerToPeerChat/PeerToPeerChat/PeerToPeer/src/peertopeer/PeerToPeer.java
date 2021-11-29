package peertopeer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//192.168.188.36
public class PeerToPeer {
    public static void main(String[] args) throws SocketException, IOException {
        DatiCondivisi COND= new DatiCondivisi();
        Scanner Tastiera= new Scanner(System.in);
        DatagramSocket Socket = new DatagramSocket();
        System.out.println("Inserire Username");
                String MEX="C;"+Tastiera.nextLine() ;
                byte[] buffer = MEX.getBytes();
                System.out.println("Inserire IP Destinatario ");
                String IP=Tastiera.nextLine() ;
		InetAddress address = InetAddress.getByName(IP);
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 2003);
		Socket.send(packet);
               
                System.out.println("Inserire Messaggio");
                String MESSAGGIO="M;"+Tastiera.nextLine() ;
                byte[] buffer2 = MESSAGGIO.getBytes();
		InetAddress address2 = InetAddress.getByName(IP);
		DatagramPacket packet2 = new DatagramPacket(buffer2, buffer2.length, address2, 2003);
		Socket.send(packet2);
                
                String MESSAGGIOD="D;"+Tastiera.nextLine() ;
                byte[] bufferD = MESSAGGIOD.getBytes();
		InetAddress addressD = InetAddress.getByName(IP);
		DatagramPacket packetD = new DatagramPacket(bufferD, bufferD.length, addressD, 2003);
		Socket.send(packetD);
                
                
                ThreadRicezione Ric = new ThreadRicezione();
                Ric.start();    
        try {
            Ric.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(PeerToPeer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
