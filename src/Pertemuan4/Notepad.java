package Pertemuan4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Notepad extends JFrame {

    private JTextArea textArea;
    private File currentFile = null;

    public Notepad() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JPanel panel = (JPanel) this.getContentPane();
        GridLayout gridLayout = new GridLayout();
        panel.setLayout(gridLayout);

//        JTextField field = new JTextField();
        textArea = new JTextArea();
//        panel.add(field);
        panel.add(new JScrollPane(textArea));
        this.setTitle("Notepad");

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File"),
                view = new JMenu("View");
        JMenuItem open = new JMenuItem("Open..."),
                save = new JMenuItem("Save"),
                saveAs = new JMenuItem("Save As");
        JMenu font = new JMenu("Font");
        JMenuItem size14 = new JMenuItem("14");
        JMenuItem size16 = new JMenuItem("16");
        JMenuItem size18 = new JMenuItem("18");
        JMenuItem customSize = new JMenuItem("Custom size....");

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
                if (fileChooser.showOpenDialog(Notepad.this) == JFileChooser.APPROVE_OPTION) {
                    Notepad.this.openFile(fileChooser.getSelectedFile());
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Notepad.this.save(false);
            }
        });

        saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Notepad.this.save(true);
            }
        });

        size14.setActionCommand("14");
        size16.setActionCommand("16");
        size18.setActionCommand("18");
        customSize.setActionCommand("-");

        ActionListener sizeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Integer size;
                System.out.println(actionEvent.getActionCommand());
                if (actionEvent.getActionCommand().equals("-")) {
                    Integer input = (Integer) JOptionPane.showInputDialog(Notepad.this, "Masukkan ukuran font yang anda inginkan.",
                            "Ubah Ukuran Font", JOptionPane.INFORMATION_MESSAGE, null, new Integer[]{12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72}, "Ukuran");
                    if (input == null)
                        return;
                    size = Integer.valueOf(input);
                } else
                    size = Integer.valueOf(actionEvent.getActionCommand());

                Notepad.this.changeTextSize(size);
            }
        };

        size14.addActionListener(sizeListener);
        size16.addActionListener(sizeListener);
        size18.addActionListener(sizeListener);
        customSize.addActionListener(sizeListener);

        file.add(open);
        file.add(save);
        file.add(saveAs);

        // Menu untuk Test Alert Box
        JMenuItem test = new JMenuItem("Test");
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        Notepad.this, "Cinta " +
                                "ini tidak akan berakhir.",
                        "Hai Sayang!",
                        JOptionPane.WARNING_MESSAGE);
                String jawaban = JOptionPane.showInputDialog(
                        Notepad.this,
                        "Apa jawaban anda?",
                        "Hai Sayang!",
                        JOptionPane.WARNING_MESSAGE
                );
                System.out.println(jawaban);
            }
        });
        view.add(test);

        view.add(font);
        font.add(size14);
        font.add(size16);
        font.add(size18);
        font.add(customSize);
        menuBar.add(file);
        menuBar.add(view);
        this.setJMenuBar(menuBar);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        // Mengeset ukuran minimum JFrame
        this.pack();
        this.setMinimumSize(this.getPreferredSize());

        this.setVisible(true);
    }

    private void openFile(File selectedFile) {
        // Cek apakah file tersebut memang ada dan memang merupakan sebuah file (bukan direktori)
        if (selectedFile.exists() && selectedFile.isFile()) {
            // Jika iya, baca file
            // Ada beberapa cara dalam membaca file

            // Pertama, dengan menggunakan array byte
            // Buat sebuah array byte untuk menampung isi file untuk sementara
            byte[] array = new byte[2048];

            // Siap sedia input stream untuk membaca file ke dalam aplikasi (input)
            InputStream is = null;
            try {
                is = new FileInputStream(selectedFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showConfirmDialog(this, "Gagal memuat file yang anda minta.", "ERROR", ERROR);
                return; // Berhenti jika error

            }

            // Siapkan sebuah string untuk menampung konten file
/*
            String s = "";
            try {
                // Selama konten file masih tersedia
                while (is.available() > 0) {
                    // Baca konten file dan
                    is.read(array);
                    // Tambahkan (concatenate) ke dalam string s
                    s += new String(array);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            this.textArea.setText(s); // Masukkan tulisan ke dalam JTextArea
*/

            //
            this.textArea.setText("");
            try {
                // Cara Kedua : Memakai BufferedReader
                // Buat sebuah object BufferedReader dengan InputStream is (dibaca oleh InputStreamReader)
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                // Sediakan string kosong
                String content = "";

                // Lakukan looping jika masih ada baris berikutnya, bukan masa depan kita
                while((content = reader.readLine()) != null) {
                    // Tambahkan ke dalam textArea, tambahkan \n sebagai newline
                    this.textArea.setText(this.textArea.getText() + content + '\n');
                }

                reader.close(); // Jangan lupa, tutup readernya.

            } catch (IOException e) {
                e.printStackTrace();
            }

            // Jangan lupa untuk menutup input stream (dibuat terpisah agar anda
            // dapat mencoba aplikasi dengan mudah)
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.resetCurrentFile(selectedFile); // Setel ulang judul aplikasi dan currentFile
        }
    }

    private boolean save(boolean saveAs) {
        File file = null;
        // Cek apakah anda ingin menyimpan sebagai file lain atau tidak
        // atau saat ini, tidak ada file yang sedang dibuka / sedang aktif.
        if (saveAs || currentFile == null) {
            // Jika ya, buka file chooser dan pilih dimana anda ingin menyimpan
            // file tersebut
            JFileChooser chooser = new JFileChooser(currentFile);
            chooser.setDialogType(JFileChooser.OPEN_DIALOG);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
                file = chooser.getSelectedFile();
            else  // Jika anda tidak jadi menyimpan file tersebut dan pasrah
                return false; // terhadap dia yang telah berpaling darimu, keluar
            // dari fungsi ini
        } else
            file = currentFile; // Jika hanya ingin menyimpan, ya pakailah file yang tadi

        try {
            // Buat file baru, walaupun bukan merupakan file baru dan
            file.createNewFile();
            // Buat output stream untuk menuliskan data tersebut ke file lain
            FileOutputStream os = new FileOutputStream(file);

            // Ubah string menjadi array byte
            byte[] array = textArea.getText().getBytes();

            // Kemudian tuliskan ke dalam file
            os.write(array);
            // Jangan lupa tutup hatinya, sehingga hatinya hanya ada untukmu
            os.close();

            // Beerikan nilai kepada title pada JFrame dan currentFile
            this.resetCurrentFile(file);

            // Beritahu bahwa penyimpanan berhasil
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showConfirmDialog(this, "Aplikasi mengalami error berikut ketika mencoba untuk menyimpan " +
                    "file : " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void resetCurrentFile(File file) {
        currentFile = file;
        this.setTitle(currentFile.getAbsolutePath() + " - Notepad");
    }

    private void changeTextSize(Integer size) {
        Font oldFont = this.textArea.getFont();
        this.textArea.setFont(new Font(oldFont.getFontName(), oldFont.getStyle(), size));
    }

    public static void main(String[] args) {
        Notepad notepad = new Notepad();
    }
}
