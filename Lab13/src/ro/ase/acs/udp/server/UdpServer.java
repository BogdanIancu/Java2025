package ro.ase.acs.udp.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class UdpServer {
    public static void main(String[] args) {
        int port = 7777;
        try (DatagramSocket serverSocket = new DatagramSocket(port);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Server started on port: " + port);
            while (true) {
                byte[] buffer = new byte[256];
                DatagramPacket packetToBeReceived =
                        new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(packetToBeReceived);
                String message = new String(packetToBeReceived.getData());
                System.out.println(message.trim());

                System.out.print("Message: ");
                String replyMessage = scanner.nextLine();
                byte[] array = replyMessage.getBytes();
                DatagramPacket packetToBeSent = new DatagramPacket(array, array.length,
                        packetToBeReceived.getAddress(), packetToBeReceived.getPort());
                serverSocket.send(packetToBeSent);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
