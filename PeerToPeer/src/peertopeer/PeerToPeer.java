package peertopeer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class PeerToPeer {
    public static void main(String[] args) throws SocketException, IOException {
        DatiCondivisi COND= new DatiCondivisi();
        DatagramSocket Socket = new DatagramSocket();
                String MEX="C;"+COND.getUsername();
                byte[] buffer = MEX.getBytes();
		InetAddress address = InetAddress.getByName(COND.getIP());
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 2003);
		Socket.send(packet);
    }
}
