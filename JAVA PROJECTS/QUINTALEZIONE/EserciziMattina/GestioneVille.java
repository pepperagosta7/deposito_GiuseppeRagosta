package QUINTALEZIONE.EserciziMattina;

import java.util.ArrayList;
import java.util.Scanner;

public class GestioneVille {

    static ArrayList<String> ville = new ArrayList<>(); // Lista per memorizzare le ville
    static String nome; // Nome della villa
    static int numeroStanze; // Numero di stanze della villa
    static boolean haPiscina; // Indica se la villa ha una piscina
    
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in); // Scanner per leggere l'input dell'utente
        boolean running = true; // Variabile per controllare il ciclo del menu
        while (running) {
            // Menu per selezionare l'operazione desiderata
            System.out.println("\nMenu Operazioni:");
            System.out.println("1. Aggiungi villa");
            System.out.println("2. Visualizza ville");
            System.out.println("3. Cerca per nome");
            System.out.println("4. Esci");
            System.out.println("Scelta: ");
            
            int scelta = scanner.nextInt(); // Legge la scelta dell'utente
            scanner.nextLine(); // Consuma il newline

            // Gestione delle scelte dell'utente
            switch (scelta) {
                case 1:
                    aggiungiVilla(scanner); // Aggiunge una nuova villa
                    break;
                case 2:
                    visualizzaVille(); // Visualizza tutte le ville
                    break;
                case 3:
                    ricercaVilla(scanner); // Cerca una villa per nome
                    break;
                case 4:
                    running = false; // Esce dal programma
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        }
        scanner.close(); // Chiude lo scanner quando il programma termina
    }

    public static void aggiungiVilla(Scanner scanner){
        // Chiede all'utente quante ville vuole inserire
        System.out.println("Quante ville vuoi inserire?");
        int numeroVille = scanner.nextInt();
        scanner.nextLine(); 
        
        // Ciclo per inserire le ville
        for (int i = 0; i < numeroVille; i++) {
            System.out.println("Inserisci il nome della villa:");
            nome = scanner.nextLine();
            
            System.out.println("Inserisci il numero di stanze:");
            numeroStanze = scanner.nextInt();
            
            System.out.println("La villa ha una piscina? (true/false):");
            haPiscina = scanner.nextBoolean();
            scanner.nextLine();
            
            // Aggiunge la villa alla lista
            ville.add("Villa{nome='" + nome + "', numeroStanze=" + numeroStanze + ", haPiscina=" + haPiscina + "}");
        }
    }

    public static void visualizzaVille(){
        // Controlla se la lista delle ville è vuota
        if (ville.isEmpty()) {
            System.out.println("Nessuna villa presente.");
            return;
        }

        // Stampa tutte le ville presenti nella lista
        System.out.println("Ecco le ville inserite:");
        for (String villa : ville) {
            System.out.println(villa);
        }
    }

    public static void ricercaVilla(Scanner scanner){
        // Chiede all'utente il nome della villa da cercare
        System.out.print("\nInserisci il nome della villa da cercare: ");
        String nomeDaCercare = scanner.nextLine();
        boolean trovato = false;

        // Cerca la villa nella lista
        for (String villa : ville) {
            if (villa.contains("nome='" + nomeDaCercare + "'")) {
                System.out.println("Villa trovata: " + villa);
                trovato = true;
                break;
            }
        }

        // Se la villa non è trovata, stampa un messaggio
        if (!trovato) {
            System.out.println("Nessuna villa trovata con il nome: " + nomeDaCercare);
        }
    }
}
