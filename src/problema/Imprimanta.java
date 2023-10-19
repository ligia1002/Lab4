package problema;

public class Imprimanta extends EchipamentElectronic {
    private int ppm; // Pagini pe minut
    private String dpi; // Rezoluție (Dots Per Inch)
    private int p_car; // Număr de pagini pe cartuș
    private ModTiparire modTiparire;

    public Imprimanta(String denumire, int nrInv, double pret, String zonaMag, Situatie situatie,
                      int ppm, String dpi, int p_car, ModTiparire modTiparire) {
        super(denumire, nrInv, pret, zonaMag, situatie);
        this.ppm = ppm;
        this.dpi = dpi;
        this.p_car = p_car;
        this.modTiparire = modTiparire;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public void setP_car(int p_car) {
        this.p_car = p_car;
    }

    public void setModTiparire(ModTiparire modTiparire) {
        this.modTiparire = modTiparire;
    }

    @Override
    public String toString() {

        return super.toString() +'\''+ ppm +'\'' + dpi +'\''+  p_car +'\'' +  modTiparire+'\n';
    }
}


