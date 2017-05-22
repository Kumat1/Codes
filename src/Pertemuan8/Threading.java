package Pertemuan8;

import java.util.Scanner;

/**
 * Created by matt on 5/17/17.
 */
public class Threading implements  Runnable {
    boolean masihPacaran = true;
    @Override
    public void run() {
        int i = 1;
        while(masihPacaran) {
            System.out.println(i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        masihPacaran = false;
    }

    public static void main(String args[]) {
        Threading obj = new Threading();
        Thread thread = new Thread(obj);
        thread.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("KETIK APAPUN UNTUK PUTUS!");

        if(scanner.next() != null) {
            obj.stop();
        }
    }
}
