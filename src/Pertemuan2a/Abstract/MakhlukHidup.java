package Pertemuan2a.Abstract;

/**
 * Created by matt on 3/22/17.
 */
public abstract class MakhlukHidup {
    public String alatPernafasan;

    public MakhlukHidup(String alat) {
        this.alatPernafasan = alat;
    }

    public abstract void bernafas();
}
