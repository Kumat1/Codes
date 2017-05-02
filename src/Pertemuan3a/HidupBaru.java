package Pertemuan3a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        tombol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(HidupBaru.this, "Saya tidak bisa MOVE ON!!!", "Gawat", JOptionPane.INFORMATION_MESSAGE);
                if(JOptionPane.showConfirmDialog(HidupBaru.this, "Apakah anda ingin tetap melanjutkan cinta ini?", "Permintaan", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    String message = JOptionPane.showInputDialog(HidupBaru.this, "APRIL MOP! Mana mau aku balikan sama mantan.", "APRIL MOP");
                    System.out.println(message);


                }

            }
        });
        tombol.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                System.out.println("Tatap Mata Saya");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {

            }
        });
        tombol.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                System.out.println("Wah!!");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
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
