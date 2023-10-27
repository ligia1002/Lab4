package problema;
import java.util.Scanner;
import java.util.List;
import java.io.*;

import java.io.IOException;


public class Meniu {
    public static void afisareEchipamente(List<EchipamentElectronic> echipamente) {
        System.out.println("Lista echipamentelor:");
        for (EchipamentElectronic echipament : echipamente) {
            System.out.println(echipament);
        }
    }

    public static void afisareImprimante(List<EchipamentElectronic> echipamente) {
        System.out.println("Lista imprimantelor:");
        for (EchipamentElectronic echipament : echipamente) {
            if (echipament instanceof Imprimanta) {
                System.out.println(echipament);
            }
        }
    }

    public static void afisareCopiatoare(List<EchipamentElectronic> echipamente) {
        System.out.println("Lista copiatoarelor:");
        for (EchipamentElectronic echipament : echipamente) {
            if (echipament.getClass()== Copiator.class) {
                System.out.println(echipament);
            }
        }
    }
    public static void afisareSisCalcul(List<EchipamentElectronic> echipamente){
        System.out.println("Lista Sistemelor de calcul: ");
        for(EchipamentElectronic echipament:echipamente)
            if(echipament.getClass().getCanonicalName().contains("SistemDeCalcul")){
                System.out.println(echipament);
            }

    }

    public static void modificareStare(List<EchipamentElectronic> echipamente){
        System.out.println("Dati numarul de inventar al echip. pentru schimbarea starii:");
        Scanner scanner=new Scanner(System.in);
        int nrInventar=scanner.nextInt();
        System.out.println("Dati starea pe care vreti s-o ia echipamentul: ");

        Scanner scannerStr=new Scanner(System.in);
        String noua_stare=scanner.next();
        Situatie enum_noua_stare=Situatie.valueOf(noua_stare.toUpperCase());

        for(EchipamentElectronic echipament:echipamente)
            if(echipament.getNrInv()==nrInventar)
            {
                echipament.setSituatie(enum_noua_stare);

            }

    }
    public static void setaremoddescriere(List<EchipamentElectronic> echipamente){
        System.out.println("Dati numarul de inventar al imprimantei. pentru setarea modului de scriere:");
        Scanner scanner=new Scanner(System.in);
        int nrInventar=scanner.nextInt();
        System.out.println("Dati modul de tiparire pe care să-l setați: color/alb_negru");

        String nou_mod=scanner.next();
        ModTiparire enum_nou_mod=ModTiparire.valueOf(nou_mod.toUpperCase());

        for(EchipamentElectronic echipament:echipamente)
            if(echipament.getNrInv()==nrInventar)
                if(echipament instanceof Imprimanta imprimanta)
                {
                    imprimanta.setModTiparire(enum_nou_mod);
                 }
        else   System.out.println("Echipamentul nu este de tip imprimanta.");

    }

    public static void setareFormatCopiere(List<EchipamentElectronic> echipamente){
        System.out.println("Dati numarul de inventar al copiatorului pentru setarea modului de scriere:");
        Scanner scanner=new Scanner(System.in);
        int nrInventar=scanner.nextInt();
        System.out.println("Dati modul de tiparire pe care să-l setați: A3/A4");

        String nou_format=scanner.next();
        FormatCopiere enum_nou_format=FormatCopiere.valueOf(nou_format.toUpperCase());

        for(EchipamentElectronic echipament:echipamente)
            if(echipament.getNrInv()==nrInventar)
                if(echipament instanceof Copiator copiator)
                {
                    copiator.setFormatcopie(enum_nou_format);
                }
                else   System.out.println("Echipamentul nu este de tip Copiator.");

    }

    public static void instalareAnumitSisDeOperare(List<EchipamentElectronic> echipamente){
        System.out.println("Dati numarul de inventar al Sistemului de calcul pentru setarea modului de scriere:");
        Scanner scanner=new Scanner(System.in);
        int nrInventar=scanner.nextInt();
        System.out.println("Dati Sistemul de operare de instalat: windows/ linux");

        String nou_sisOP=scanner.next();
        SistemOperare enum_sisOP=SistemOperare.valueOf(nou_sisOP.toUpperCase());

        for(EchipamentElectronic echipament:echipamente)
            if(echipament.getNrInv()==nrInventar)
                if(echipament instanceof SistemDeCalcul sis)
                {
                    sis.setSisOP(enum_sisOP);
                }
                else   System.out.println("Echipamentul nu este de tip Sistem de Calcul.");

    }

    public static void afisareEchipamenteVandute(List<EchipamentElectronic>echipamente){
        System.out.println("Lista Echipamentelor vandute: ");
        for(EchipamentElectronic echipament:echipamente)
            if(echipament.getSituatie().equals(Situatie.VANDUT)){
                System.out.println(echipament);
            }

    }
    public static void serializare(List<EchipamentElectronic> echipamente) {
        try (FileOutputStream fileOut = new FileOutputStream("echip.bin");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(echipamente);
            System.out.println("Serializare reușită în echip.bin.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<EchipamentElectronic> deserializare() {
        List<EchipamentElectronic> echipamente = null;
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("echip.bin"))) {
            echipamente = (List<EchipamentElectronic>) objectIn.readObject();
            System.out.println("Deserializare reușită din echip.bin.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return echipamente;
    }
    public static void ruleazaMeniu(List<EchipamentElectronic> echipamente) {
        Scanner scanner = new Scanner(System.in);
        int optiune;

        while (true) {
            System.out.println("Meniu:");
            System.out.println("1. Afișare toate echipamentele");
            System.out.println("2. Afișare imprimante");
            System.out.println("3. Afișare copiatoare");
            System.out.println("4. Afișare sisteme de calcul");
            System.out.println("5. Schimbare stare");
            System.out.println("6. Setarea unui anumit mod de scriere pentru imprimanta");
            System.out.println("7. Setarea unui format de copiere pentru copiatoare");
            System.out.println("8. Instalarea unui anumit sistem de operare pe un sistem de calcul ");
            System.out.println("9. Afişarea echipamentelor vândute ");
            System.out.println("0. Ieșire");

            System.out.print("Introduceți opțiunea: ");
            optiune = scanner.nextInt();

            switch (optiune) {
                case 1:
                    afisareEchipamente(echipamente);
                    break;
                case 2:
                    afisareImprimante(echipamente);
                    break;
                case 3:
                    afisareCopiatoare(echipamente);
                    break;
                case 4:
                    afisareSisCalcul(echipamente);
                    break;
                case 5:
                    modificareStare(echipamente);
                    break;
                case 6:
                    setaremoddescriere(echipamente);
                    break;
                case 7:
                    setareFormatCopiere(echipamente);
                    break;
                case 8:
                    instalareAnumitSisDeOperare(echipamente);
                    break;
                case 9: afisareEchipamenteVandute(echipamente);
                    break;

                case 0:
                    System.out.println("Ieșire din meniu.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opțiune invalidă. Vă rugăm să alegeți din nou.");
            }
        }
    }
}


