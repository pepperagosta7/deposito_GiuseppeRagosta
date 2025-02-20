package QUARTALEZIONE.EserciziPomeriggio;

import java.util.ArrayList;
import java.util.Scanner;

public class GestioneSpedizione {
    // Liste statiche per memorizzare le quantità di penne per ciascun colore
    static ArrayList<Integer> penneRosse = new ArrayList<>();
    static ArrayList<Integer> penneBlu = new ArrayList<>();
    static ArrayList<Integer> penneVerdi = new ArrayList<>();
    static ArrayList<Integer> penneNere = new ArrayList<>();
    
    // Scanner per input da tastiera
    static Scanner scanner = new Scanner(System.in);

    // Metodo per aggiungere una spedizione
    public static void aggiungiSpedizione() {
        // Richiede l'inserimento delle quantità di penne per ciascun colore
        System.out.println("Inserisci il numero di penne per ciascun colore:");
        System.out.print("Rosse: ");
        int rosse = scanner.nextInt();
        System.out.print("Blu: ");
        int blu = scanner.nextInt();
        System.out.print("Verdi: ");
        int verdi = scanner.nextInt();
        System.out.print("Nere: ");
        int nere = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline

        // Aggiunge le quantità di penne alle rispettive liste
        penneRosse.add(rosse);
        penneBlu.add(blu);
        penneVerdi.add(verdi);
        penneNere.add(nere);
        
        System.out.println("Spedizione aggiunta con successo!");
    }

    // Metodo per visualizzare tutte le spedizioni
    public static void visualizzaSpedizioni() {
        // Verifica se ci sono spedizioni da visualizzare
        if (penneRosse.isEmpty()) {
            System.out.println("Nessuna spedizione presente.");
            return;
        }

        // Visualizza le spedizioni esistenti
        System.out.println("\nElenco di tutte le spedizioni:");
        for (int i = 0; i < penneRosse.size(); i++) {
            System.out.println("Spedizione " + (i+1) + ": " +
                             "Rosse: " + penneRosse.get(i) + 
                             ", Blu: " + penneBlu.get(i) + 
                             ", Verdi: " + penneVerdi.get(i) + 
                             ", Nere: " + penneNere.get(i));
        }
    }

    // Metodo per calcolare il totale di penne per ciascun colore
    public static void calcolaTotali() {
        // Inizializza le variabili per i totali
        int totRosse = 0, totBlu = 0, totVerdi = 0, totNere = 0;

        // Somma tutte le penne per ogni colore
        for (int i = 0; i < penneRosse.size(); i++) {
            totRosse += penneRosse.get(i);
            totBlu += penneBlu.get(i);
            totVerdi += penneVerdi.get(i);
            totNere += penneNere.get(i);
        }

        // Visualizza i totali per ogni colore
        System.out.println("\nTotali per colore:");
        System.out.println("Penne Rosse: " + totRosse);
        System.out.println("Penne Blu: " + totBlu);
        System.out.println("Penne Verdi: " + totVerdi);
        System.out.println("Penne Nere: " + totNere);
    }

    // Metodo per cercare le spedizioni in base al colore
    public static void cercaPerColore() {
        // Richiede all'utente di inserire un colore da cercare
        System.out.print("\nInserisci il colore da cercare (rosso, blu, verde, nero): ");
        String colore = scanner.nextLine().toLowerCase();
        boolean trovato = false;

        // Visualizza le spedizioni che contengono il colore richiesto
        System.out.println("\nRicerca spedizioni con penne " + colore + ":");
        for (int i = 0; i < penneRosse.size(); i++) {
            boolean daStampare = false;
            
            // Controlla quale colore è stato scelto e stampa le spedizioni corrispondenti
            switch (colore) {
                case "rosso":
                    if (penneRosse.get(i) > 0) daStampare = true;
                    System.out.println("Rosse: " + penneRosse.get(i));
                    break;
                case "blu":
                    if (penneBlu.get(i) > 0) daStampare = true;
                    System.out.println("Blu: " + penneBlu.get(i)); 
                    break;
                case "verde":
                    if (penneVerdi.get(i) > 0) daStampare = true;
                    System.out.println("Verdi: " + penneVerdi.get(i));
                    break;
                case "nero":
                    if (penneNere.get(i) > 0) daStampare = true;
                    System.out.println("Nere: " + penneNere.get(i));
                    break;
                default:
                    System.out.println("Colore non valido.");
                    return;
            }
            
            // Se la spedizione contiene penne del colore ricercato, stampa il dettaglio
            if (daStampare) {
                System.out.println("Spedizione " + (i+1) + ": " +
                                 "Rosse: " + penneRosse.get(i) + 
                                 ", Blu: " + penneBlu.get(i) + 
                                 ", Verdi: " + penneVerdi.get(i) + 
                                 ", Nere: " + penneNere.get(i));
                trovato = true;
            }
        }

        // Se non vengono trovate spedizioni con il colore ricercato
        if (!trovato) {
            System.out.println("Nessuna spedizione trovata con penne di colore " + colore);
        }
    }

    // Metodo principale che gestisce il menu e le operazioni
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            // Menu per selezionare l'operazione desiderata
            System.out.println("\nMenu Operazioni:");
            System.out.println("1. Aggiungi spedizione");
            System.out.println("2. Visualizza spedizioni");
            System.out.println("3. Calcola totali");
            System.out.println("4. Cerca per colore");
            System.out.println("5. Esci");
            System.out.println("Scelta: ");
            
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            // Gestione delle scelte dell'utente
            switch (scelta) {
                case 1:
                    aggiungiSpedizione();  // Aggiunge una nuova spedizione
                    break;
                case 2:
                    visualizzaSpedizioni(); // Mostra tutte le spedizioni
                    break;
                case 3:
                    calcolaTotali(); // Calcola e mostra il totale per colore
                    break;
                case 4:
                    cercaPerColore(); // Cerca le spedizioni in base al colore
                    break;
                case 5:
                    running = false; // Esce dal programma
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        }
        scanner.close(); // Chiude lo scanner quando il programma termina
    }
}
