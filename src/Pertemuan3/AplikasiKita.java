package Pertemuan3;

import javax.swing.*;

/**
 * Created by matt on 3/29/17.
 */
public class AplikasiKita extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AplikasiKita kita = new AplikasiKita();
            }
        });

    }

    public AplikasiKita(){
        JLabel label = new JLabel("Bersemi Kembali");
        JPanel panel = new JPanel();
        panel.add(label);
        this.setContentPane(panel);
        this.setTitle("Cinta Kita");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
