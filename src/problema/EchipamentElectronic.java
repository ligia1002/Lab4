package problema;


public class EchipamentElectronic {
    private String denumire;
    private int nrInv;
    private double pret;
    private String zonaMag;
    private Situatie situatie;

    public EchipamentElectronic(String denumire, int nrInv, double pret, String zonaMag,  Situatie situatie) {
        this.denumire = denumire;
        this.nrInv = nrInv;
        this.pret = pret;
        this.zonaMag=zonaMag;
        this.situatie = situatie;
    }


    @Override
    public String toString() {
        return "EchipamentElectronic{" +
                "denumire='" + denumire + '\'' +
                ", nrInv=" + nrInv +
                ", pret=" + pret +
                ", zonaMag='" + zonaMag + '\'' +
                ", situatie=" + situatie +
                '}';
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setNrInv(int nrInv) {
        this.nrInv = nrInv;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setZonaMag(String zonaMag) {
        this.zonaMag = zonaMag;
    }

    public void setSituatie(Situatie situatie) {
        this.situatie = situatie;
    }

    public String getDenumire(){
        return denumire;
    }
    public int getNrInv(){
        return nrInv;
    }
    public double getPret(){
        return pret;
    }

    public Situatie getSituatie() {
        return situatie;
    }

    public String getZonaMag() {
        return zonaMag;
    }
}
