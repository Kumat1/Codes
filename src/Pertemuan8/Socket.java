package Pertemuan8;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
 * Created by matt on 5/17/17.
 */
public class Socket {
    public static void main(String args[]) throws IOException {
        java.net.Socket socket=  new java.net.Socket(InetAddress.getLoopbackAddress(), 3000);

        DataOutputStream sendStream = new DataOutputStream(socket.getOutputStream());
        sendStream.writeBytes("HELLO SAYANG!");


        sendStream.close();

        // TODO INI BELUM
//        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String temp;
//        while((temp = reader.readLine()) != null) {
//            System.out.println(temp);
//
//        }
//        reader.close();
//        socket.close();
        // TODO INI BELUM
    }
}
