package NONALEZIONE.EserciziPomeriggio.SubFolderEsercizio;

import java.util.Scanner;

public class Supermercato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Aggiungi un prodotto alimentare");
            System.out.println("2. Aggiungi un prodotto elettronico");
            System.out.println("3. Aggiungi un prodotto di abbigliamento");
            System.out.println("4. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (scelta) {
                    case 1:
                        System.out.print("Inserisci codice: ");
                        String codiceA = scanner.nextLine();
                        System.out.print("Inserisci nome: ");
                        String nomeA = scanner.nextLine();
                        System.out.print("Inserisci prezzo: ");
                        double prezzoA = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Inserisci data di scadenza (yyyy-MM-dd): ");
                        String scadenzaA = scanner.nextLine();
                        ProdottoAlimentare pa = new ProdottoAlimentare(codiceA, nomeA, prezzoA, scadenzaA);
                        System.out.println(pa.getDettagli());
                        break;

                    case 2:
                        System.out.print("Inserisci codice: ");
                        String codiceE = scanner.nextLine();
                        System.out.print("Inserisci nome: ");
                        String nomeE = scanner.nextLine();
                        System.out.print("Inserisci prezzo: ");
                        double prezzoE = scanner.nextDouble();
                        System.out.print("Inserisci garanzia in mesi: ");
                        int garanziaE = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Inserisci data di acquisto (yyyy-MM-dd): ");
                        String dataAcquistoE = scanner.nextLine();
                        ProdottoElettronico pe = new ProdottoElettronico(codiceE, nomeE, prezzoE, garanziaE, dataAcquistoE);
                        System.out.println(pe.getDettagli());
                        break;

                    case 3:
                        System.out.print("Inserisci codice: ");
                        String codiceAb = scanner.nextLine();
                        System.out.print("Inserisci nome: ");
                        String nomeAb = scanner.nextLine();
                        System.out.print("Inserisci prezzo: ");
                        double prezzoAb = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Inserisci taglia: ");
                        String taglia = scanner.nextLine();
                        System.out.print("Inserisci materiale: ");
                        String materiale = scanner.nextLine();
                        System.out.print("Inserisci data di acquisto (yyyy-MM-dd): ");
                        String dataAcquistoAb = scanner.nextLine();
                        ProdottoAbbigliamento pab = new ProdottoAbbigliamento(codiceAb, nomeAb, prezzoAb, taglia, materiale, dataAcquistoAb);
                        System.out.println(pab.getDettagli());
                        break;

                    case 4:
                        exit = true;
                        break;

                    default:
                        System.out.println("Scelta non valida. Riprova.");
                }
            } catch (Exception e) {
                System.out.println("Errore nell'inserimento dei dati.");
                scanner.nextLine(); // Consuma il newline rimasto nel buffer
            }
        }
        scanner.close();
    }
}