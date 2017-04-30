package Pertemuan3a;

import javax.swing.*;
import java.awt.*;

public class HidupBaru extends JFrame {
/*
    GUI = Graphical User Interface
    Swing
 */

    public HidupBaru() {
        JPanel panel = (JPanel) this.getContentPane();
//        panel.setLayout(new GridLayout(2,0));

        // BorderLayout
        BorderLayout borderLayout = new BorderLayout();
        panel.setLayout(borderLayout);

        JLabel tulisan = new JLabel("Dahulu, kamu" +
                " mempermainkanku.");
        JLabel tulisan2 = new JLabel("Kini, aku ingin" +
                " memulai HIDUP BARU tanpamu. :\'(");
        JButton tombol = new JButton("Klik Saya");
        panel.add(tulisan, BorderLayout.NORTH);
        panel.add(tombol, BorderLayout.CENTER);
        panel.add(tulisan2, BorderLayout.SOUTH);

        this.pack();
        this.setMinimumSize(this.getPreferredSize());

        this.setVisible(true);
        this.setLocationRelativeTo(null);
        // Keluar dari aplikasi jika aplikasi
        // ditutup
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Memberi judul aplikasi
        this.setTitle("Hidup Baru");
    }


    public static void main(String args[]) {
        HidupBaru hidupBaru =
                new HidupBaru();
    }
}
