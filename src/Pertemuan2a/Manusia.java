package Pertemuan2a;

import Pertemuan2a.Abstract.MakhlukHidup;
import Pertemuan2a.Interace.FungsiDasarManusia;

/**
 * Nah, di class ini, kita akan mencoba
 * untuk menerapkan interface.
 */
public class Manusia extends MakhlukHidup implements FungsiDasarManusia {
    // Buat dua property pada class
    // Manusia, yang satu adlaha nama
    // yang satu lagi adalah tempat
    // lahir
    public String nama, tempatLahir;

    public Manusia(String alat) {
        super(alat);
    }

    @Override
    public void makan() {
        System.out.println("MAKAN AJA " +
                "TERUS KAU!");
    }

    @Override
    public void bicara() {
        System.out.println("OOEEEEEE!!");
        System.out.println("OOEEEEEE!!");
    }

    @Override
    public void tidur() {
        System.out.println("KROOOOOK!!");
        System.out.println("TRUUUUUS!!");
    }

    public static void main(String[] args) {
        Manusia manusia = new Manusia("Paru-paru");
        manusia.bicara();
        manusia.makan();
        manusia.bicara();
        manusia.tidur();
        manusia.bernafas();
    }

    @Override
    public void bernafas() {
        System.out.println("HAAAAAAA");
        System.out.println("HUUUUUUU");
    }
    /*
        BUAT SEBUAH CLASS BARU UNTUK
        SEBUAH MAKHLUK HIDUP YANG
        MENERIMA TURUNAN DARI CLASS
        MakhlukHidup dan mengimplementasi
        kan sebuah interface baru.

        Tiga orang pertama yang selesai
        dan benar, mendapatkan nilai
        100 - ((urutan - 1) * 7)

        Dibawah tiga orang pertama
        80 - ((urutan - 4) * 5)
     */
}
