import javax.xml.crypto.Data;
import java.net.*;
import java.io.*;

public class MulticastKenanKlient {
    public static void main (String args[]) throws Exception{

        int portnumba = 56;
        if (args.length >= 1) {
            portnumba = Integer.parseInt(args[0]);
        }

        MulticastSocket chatMulticastSocket = new MulticastSocket(portnumba);

        InetAddress group = InetAddress.getByName("225.4.5.6");

        chatMulticastSocket.joinGroup(group);

        String msg = "";
        System.out.println("Type a message for the server:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        msg = br.readLine();

        DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, portnumba);
        chatMulticastSocket.send(data);

        chatMulticastSocket.close();
    }
}
