package Pertemuan2.Abstract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by matt on 3/22/17.
 */
public abstract class MakhlukHidup {
    public String tempatLahir;
    public Date tanggalLahir;

    public MakhlukHidup(String tempatLahir, String tanggalLahir) throws ParseException {

        // Parsing tanggal pada Java
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        this.tanggalLahir = format.parse(tanggalLahir);
        this.tempatLahir = tempatLahir;
    }

    public  abstract void ngorok();

}
