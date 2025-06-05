package ro.ase.acs.udp.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Message: ");
                String message = scanner.nextLine();
                byte[] array = message.getBytes();
                InetAddress serverAddress = InetAddress.getByName("localhost");
                DatagramPacket packetToBeSent = new DatagramPacket(array, array.length,
                        serverAddress, 7777);
                clientSocket.send(packetToBeSent);

                byte[] buffer = new byte[256];
                DatagramPacket packetToBeReceived = new DatagramPacket(buffer, buffer.length);
                clientSocket.receive(packetToBeReceived);

                String receivedMessage = new String(packetToBeReceived.getData());
                System.out.println(receivedMessage.trim());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
