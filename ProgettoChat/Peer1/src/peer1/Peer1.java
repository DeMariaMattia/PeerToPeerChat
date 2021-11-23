package peer1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Peer1 {
    public static void main(String[] args) throws SocketException, IOException {
        
        //RICHIESTA CONNESSIONE
		DatagramSocket Socket = new DatagramSocket();
                String TentativoConnessione="C;Mattia";
                byte[] buffer = TentativoConnessione.getBytes();
		InetAddress address = InetAddress.getByName("localhost");
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 2003);
		Socket.send(packet);
		packet = new DatagramPacket(buffer, buffer.length);
	//RISPOSTA DEL PEER2 ALLA RICHIESTA DI CONNESSIONE DEL PEER1
                byte[] buffer2 = new byte[1500];
                DatagramPacket packet2 = new DatagramPacket(buffer2, buffer2.length,address,2003);
                Socket.receive(packet2);
                byte[] dataReceived2 = packet2.getData();
                String messaggioRicevuto2 = new String(dataReceived2, 0, packet2.getLength());
                System.out.println(messaggioRicevuto2);
        //RISPOSTA DEL PEER1 ALLA RICHIESTA DI CONNESSIONE DEL PEER2
                if(messaggioRicevuto2.equals("Y")||messaggioRicevuto2.equals("N")){
                    String Risposta="Y";
                    byte[] bufferRisp = Risposta.getBytes();
                    DatagramPacket packetRisp = new DatagramPacket(bufferRisp, bufferRisp.length, address, 2003);
                    Socket.send(packetRisp);
                    packet = new DatagramPacket(bufferRisp, bufferRisp.length);
                }else{
                    String Risposta="N";
                    byte[] bufferRisp = Risposta.getBytes();
                    DatagramPacket packetRisp = new DatagramPacket(bufferRisp, bufferRisp.length, address, 2003);
                    Socket.send(packetRisp);
                    packet = new DatagramPacket(bufferRisp, bufferRisp.length);
                }
        byte[] bufferRisp = new byte[1500];
        DatagramPacket packetRisp = new DatagramPacket(bufferRisp, bufferRisp.length);
        Socket.receive(packetRisp);
        byte[] dataReceivedRisp = packetRisp.getData();
        String messaggioRicevutoRisp = new String(dataReceivedRisp, 0, packetRisp.getLength());
        System.out.println(messaggioRicevutoRisp);
    }
    
}
