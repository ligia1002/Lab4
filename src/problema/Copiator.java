package problema;




public class Copiator extends EchipamentElectronic {
            private int p_ton; // Numărul de pagini pe toner
            private FormatCopiere formatcopie; // A3 sau A4

            public Copiator(String denumire, int nrInv, double pret, String zonaMag, Situatie situatie, int p_ton, FormatCopiere formatCopiere) {
                super(denumire, nrInv, pret, zonaMag, situatie);
                this.p_ton = p_ton;
                this.formatcopie = formatCopiere;
            }

            public int getP_ton() {
                return p_ton;
            }

            public FormatCopiere getFormatCopiere() {
                return formatcopie;
            }

    public void setFormatcopie(FormatCopiere formatcopie) {
        this.formatcopie = formatcopie;
    }

    @Override
    public String toString() {
        return super.toString()+ "Copiator{" +
                "p_ton=" + p_ton +
                ", formatcopie=" + formatcopie +
                '}';
    }
}

