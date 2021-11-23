package peer2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Peer2 {
    public static void main(String[] args) throws IOException {
    //RICEZIONE
        DatagramSocket server = new DatagramSocket(2003);
        byte[] buffer = new byte[1500];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        server.receive(packet);
        byte[] dataReceived = packet.getData();
        String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
        String Controllo=messaggioRicevuto.substring(0, 2);
        String Username=messaggioRicevuto.substring(2, messaggioRicevuto.length());
     //CONTROLLO CONNESSIONE
        if(Controllo.equals("C;")){
            String risposta ="Y"+Username;
            byte[] responseBuffer = risposta.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            responsePacket.setAddress(packet.getAddress());
            responsePacket.setPort(packet.getPort());
            server.send(responsePacket);
        }else{
              String risposta ="N";
            byte[] responseBuffer = risposta.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            responsePacket.setAddress(packet.getAddress());
            responsePacket.setPort(packet.getPort());
            server.send(responsePacket);
        }
    }
    
}
