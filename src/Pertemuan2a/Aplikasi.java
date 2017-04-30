package Pertemuan2a;

public class Aplikasi {
    protected String nama;
    public Aplikasi() {
        System.out.println("Object " +
                "Aplikasi berhasil " +
                "dibuat.");
    }
    // CONSTRUCTOR
    // => 82
    // APA ITU METHOD OVERLOADING?
    // => 81

    public Aplikasi(String pesan) {
        System.out.println(pesan);
    }

    public static void main(String[] args) {
        Aplikasi a = new Aplikasi();
    }
}
