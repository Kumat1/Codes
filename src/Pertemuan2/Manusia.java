package Pertemuan2;

import Pertemuan2.Abstract.MakhlukHidup;

import java.text.ParseException;

/**
 * Created by matt on 3/22/17.
 */
public class Manusia extends MakhlukHidup {
    public static final int KELAMIN_PRIA = 1;
    public static final int KELAMIN_WANITA = 2;

    public String nama;
    public int jenisKelamin;

    public Manusia(String nama, String tempatLahir, String tanggalLahir, int jenisKelamin) throws ParseException {
        super(tempatLahir, tanggalLahir);
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
    }

    @Override
    public void ngorok() {
        System.out.println("KROOOOK!!!!!");
    }

    public String toString() {
        return this.nama;
    }
}
