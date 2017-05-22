package Pertemuan8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by matt on 5/17/17.
 */
public class SocketServer {

    public static void main(String args[]) throws IOException {
        ServerSocket server = new ServerSocket(3000, 0, InetAddress.getLoopbackAddress());

        java.net.Socket request = server.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));

        String temp;
        while((temp = reader.readLine()) != null) {
            System.out.println(temp);
        }

        request.close();
    }
}
