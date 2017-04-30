package Pertemuan3a;

/**
 * Created by matt on 4/3/17.
 */
public class ProgramException {
    public static void main(String[] args) {
        String a[] = new String[10];
        try {
            System.out.println(a[-1]);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Anda mengakses " +
                    "array pada indeks yang salah.");
        }
        catch(Exception e) {
            System.out.println("Aku ga tahu aku salah" +
                    " apa. Selama ini aku telah berbuat banyak" +
                    " untukmu. ANIIIII!");
        }
    }
}
