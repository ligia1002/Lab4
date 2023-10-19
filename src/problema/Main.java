package problema;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException{
        List<EchipamentElectronic> echipamente = new ArrayList<>();
        String numeFisier = "src/problema/echipamente.txt";

        Scanner scanner = new Scanner(new File(numeFisier));

        while (scanner.hasNextLine()) {
            String linie = scanner.nextLine();
            String[] split = linie.split(";");
            if (split.length >= 7) {
                String denumire = split[0];
                int nrInv = Integer.parseInt(split[1]);
                double pret = Double.parseDouble(split[2]);
                String zonaMag = split[3];
                Situatie situatie = Situatie.valueOf(split[4].toUpperCase());

                String tipEchipament = split[5].toLowerCase();


                if (tipEchipament.equals("imprimanta") && split.length >= 9) {

                    int ppm = Integer.parseInt(split[6]);
                    String rezolutie = split[7];
                    int p_car = Integer.parseInt(split[8]);
                    ModTiparire modTiparire = ModTiparire.valueOf(split[9].toUpperCase());
                    echipamente.add(new Imprimanta(denumire, nrInv, pret, zonaMag, situatie, ppm, rezolutie, p_car, modTiparire));

                } else if (tipEchipament.equals("copiator") && split.length >= 8) {

                    int p_ton = Integer.parseInt(split[6]);
                    FormatCopiere formatCopiere = FormatCopiere.valueOf(split[7].toUpperCase());
                    echipamente.add(new Copiator(denumire, nrInv, pret, zonaMag, situatie, p_ton, formatCopiere));

                } else if (tipEchipament.equals("sistem de calcul") && split.length >= 8) {

                    String tipMon = split[6];
                    double vitProc = Double.parseDouble(split[7]);
                    int c_hdd = Integer.parseInt(split[8]);
                    SistemOperare sistemOperare = SistemOperare.valueOf(split[9].toUpperCase());

                    echipamente.add(new SistemDeCalcul(denumire, nrInv, pret, zonaMag, situatie, tipMon, vitProc, c_hdd, sistemOperare));
                }
            }
        }
        Meniu meniu = new Meniu();
        meniu.ruleazaMeniu(echipamente);
    }
}
