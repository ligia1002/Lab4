package problema;

public class SistemDeCalcul extends EchipamentElectronic {
    private String tipMon; // Tipul monitorului
    private double vitProc; // Viteză procesorului
    private int c_hdd; // Capacitatea
    private SistemOperare sisOP;

    public SistemDeCalcul(String denumire, int nrInv, double pret, String zonaMag, Situatie situatie, String tipMon, double vitProc, int c_hdd, SistemOperare sistemOperare) {
        super(denumire, nrInv, pret, zonaMag, situatie);
        this.tipMon = tipMon;
        this.vitProc = vitProc;
        this.c_hdd = c_hdd;
        this.sisOP = sistemOperare;
    }

    public String getTipMon() {
        return tipMon;
    }

    public double getVitProc() {
        return vitProc;
    }

    public void setSisOP(SistemOperare sisOP) {
        this.sisOP = sisOP;
    }

    public int getC_hdd() {
        return c_hdd;
    }

    public SistemOperare getSistemOperare() {
        return sisOP;
    }
    @Override
    public String toString() {

        return super.toString() + ", tip Monitor= " + tipMon + '\''+ ", Viteza Procesor= " + vitProc + '\''+ ", Capacitate HDD= " + c_hdd + '\''+ ", Sistem de operare= " + sisOP + '\'';

    }
}

