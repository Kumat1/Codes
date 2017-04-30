package Pertemuan2;

import java.text.ParseException;

/**
 * Created by matt on 3/22/17.
 */
public class Penyanyi extends Manusia {

    public Penyanyi(String nama, String tempatLahir, String tanggalLahir, int jenisKelamin) throws ParseException {
        super(nama, tempatLahir, tanggalLahir, jenisKelamin);
    }

    public void ngorok() {
        System.out.println("LALALALALALA!!!!");
    }
}
