package OTTAVALEZIONE.EserciziaMattina;

import java.util.*;

class Utente {
    protected String nome; // Nome dell'utente
    protected String email; // Email dell'utente
    protected float soldi; // Soldi dell'utente

    public Utente(String nome, String email) {
        this.nome = nome; // Inizializza il nome dell'utente
        this.email = email; // Inizializza l'email dell'utente
        this.soldi = new Random().nextFloat() * 100; // Soldi randomizzati fino a 100
    }

    public void stampaDati() {
        System.out.println("Nome: " + nome + ", Email: " + email + ", Soldi: " + soldi); // Stampa i dati dell'utente
    }

    public void aggiornaSoldi() {
        this.soldi = new Random().nextFloat() * 100; // Rivalorizza i soldi a ogni nuovo login
    }

    public String getEmail() {
        return email; // Restituisce l'email dell'utente
    }
}

class Chef extends Utente {
    private List<String> piatti = new ArrayList<>(); // Lista dei piatti creati dallo chef

    public Chef(String nome, String email) {
        super(nome, email); // Chiama il costruttore della classe base Utente
    }

    public void aggiungiPiatto(String piatto) {
        if (piatto == null || piatto.trim().isEmpty()) {
            System.out.println("Errore: Nome piatto non valido.");
            return;
        }
        piatti.add(piatto); // Aggiunge il piatto alla lista dei piatti
        System.out.println("Piatto aggiunto: " + piatto);
    }

    public void stampaPiatti() {
        if (piatti.isEmpty()) {
            System.out.println("Nessun piatto aggiunto.");
        } else {
            System.out.println("Piatti creati da " + nome + ": " + piatti);
        }
    }

    public boolean esistePiatto(String piatto) {
        return piatti.contains(piatto); // Controlla se il piatto esiste nella lista dei piatti
    }
}

class Critico extends Utente {
    private List<String> recensioni = new ArrayList<>(); // Lista delle recensioni lasciate dal critico

    public Critico(String nome, String email) {
        super(nome, email); // Chiama il costruttore della classe base Utente
    }

    public void lasciaRecensione(String piatto, int voto, Chef chef) {
        if (piatto == null || piatto.trim().isEmpty()) {
            System.out.println("Errore: Nome piatto non valido.");
            return;
        }
        if (!chef.esistePiatto(piatto)) {
            System.out.println("Errore: Il piatto non esiste.");
            return;
        }
        if (voto < 1 || voto > 5) {
            System.out.println("Errore: Voto non valido. Deve essere tra 1 e 5.");
            return;
        }
        recensioni.add("Piatto: " + piatto + ", Voto: " + voto); // Aggiunge la recensione alla lista delle recensioni
        System.out.println("Recensione aggiunta per " + piatto + " con voto: " + voto);
    }

    public void stampaRecensioni() {
        if (recensioni.isEmpty()) {
            System.out.println("Nessuna recensione inserita.");
        } else {
            System.out.println("Recensioni di " + nome + ": " + recensioni);
        }
    }
}

public class Ristorante2 {
    private static List<Utente> utenti = new ArrayList<>(); // Lista degli utenti
    private static List<Chef> chefList = new ArrayList<>(); // Lista degli chef
    private static List<Critico> criticoList = new ArrayList<>(); // Lista dei critici
    private static Scanner scanner = new Scanner(System.in); // Scanner per leggere l'input dell'utente

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) { // Ciclo infinito per il menu
            System.out.println("\nMenu:");
            System.out.println("1. Registrazione");
            System.out.println("2. Login");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt(); // Legge la scelta dell'utente
            scanner.nextLine(); // Consuma il newline rimasto nel buffer

            switch (scelta) { // Gestione delle scelte dell'utente
                case 1:
                    registrazione(); // Chiama il metodo di registrazione
                    break;
                case 2:
                    login(); // Chiama il metodo di login
                    break;
                case 3:
                    System.out.println("Uscita dal sistema.");
                    flag = false; // Esce dal ciclo
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
        scanner.close(); // Chiude lo scanner
    }

    private static void registrazione() {
        System.out.print("Inserisci nome utente: ");
        String nome = scanner.nextLine(); // Legge il nome dell'utente
        System.out.print("Inserisci email utente: ");
        String email = scanner.nextLine(); // Legge l'email dell'utente

        if (nome.trim().isEmpty() || email.trim().isEmpty()) {
            System.out.println("Errore: Nome o email non validi.");
            return;
        }

        Utente utente = new Utente(nome, email); // Crea un nuovo utente
        utenti.add(utente); // Aggiunge l'utente alla lista degli utenti
        System.out.println("Registrazione riuscita!");
    }

    private static void login() {
        System.out.print("Inserisci email utente: ");
        String email = scanner.nextLine(); // Legge l'email dell'utente

        Utente utente = trovaUtente(email); // Trova l'utente nella lista degli utenti
        if (utente == null) {
            System.out.println("Errore: Utente non trovato.");
            return;
        }

        utente.aggiornaSoldi(); // Aggiorna i soldi dell'utente
        utente.stampaDati(); // Stampa i dati dell'utente

        System.out.println("Vuoi diventare Chef (1) o Critico (2)? Se vuoi tornare indietro, premi 3.");
        int scelta = scanner.nextInt(); // Legge la scelta dell'utente
        scanner.nextLine(); // Consuma il newline rimasto nel buffer

        if (scelta == 1) {
            Chef chef = new Chef(utente.nome, utente.email); // Crea un nuovo chef
            chefList.add(chef); // Aggiunge lo chef alla lista degli chef
            System.out.print("Inserisci un piatto da aggiungere: ");
            String piatto = scanner.nextLine(); // Legge il nome del piatto
            chef.aggiungiPiatto(piatto); // Aggiunge il piatto alla lista dei piatti dello chef
            chef.stampaPiatti(); // Stampa i piatti dello chef
        } else if (scelta == 2) {
            Critico critico = new Critico(utente.nome, utente.email); // Crea un nuovo critico
            criticoList.add(critico); // Aggiunge il critico alla lista dei critici
            boolean flag = true;
            while (flag) { // Ciclo per lasciare recensioni
                System.out.println("Vuoi lasciare una recensione? (1 = Sì, 2 = No)");
                int sceltaRecensione = scanner.nextInt(); // Legge la scelta dell'utente
                scanner.nextLine(); // Consuma il newline rimasto nel buffer
                if (sceltaRecensione == 1) {
                    System.out.print("Inserisci il nome del piatto da recensire: ");
                    String piatto = scanner.nextLine(); // Legge il nome del piatto
                    Chef chef = trovaChef(piatto); // Trova lo chef che ha creato il piatto
                    if (chef == null) {
                        System.out.println("Errore: Il piatto non esiste.");
                        continue;
                    }
                    System.out.print("Inserisci il voto (1-5): ");
                    int voto = scanner.nextInt(); // Legge il voto
                    scanner.nextLine(); // Consuma il newline rimasto nel buffer
                    critico.lasciaRecensione(piatto, voto, chef); // Lascia la recensione
                    continue;
                } else {
                    flag = false; // Esce dal ciclo
                    break;
                }
            }
            critico.stampaRecensioni(); // Stampa le recensioni del critico
        } else {
            return;
        }
    }

    private static Utente trovaUtente(String email) {
        for (Utente utente : utenti) { // Cerca l'utente nella lista degli utenti
            if (utente.getEmail().equalsIgnoreCase(email)) {
                return utente; // Restituisce l'utente trovato
            }
        }
        return null; // Restituisce null se l'utente non è trovato
    }

    private static Chef trovaChef(String piatto) {
        for (Chef chef : chefList) { // Cerca lo chef nella lista degli chef
            if (chef.esistePiatto(piatto)) {
                return chef; // Restituisce lo chef trovato
            }
        }
        return null; // Restituisce null se lo chef non è trovato
    }
}