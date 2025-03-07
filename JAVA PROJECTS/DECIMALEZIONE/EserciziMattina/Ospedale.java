package DECIMALEZIONE.EserciziMattina;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe base Persona
class Persona {
    private String nome;
    private String cognome;
    
    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    public void stampaRuolo() {
        System.out.println("Ruolo non specificato");
    }
}

// Classe derivata Medico
class Medico extends Persona {
    private String specializzazione;
    
    public Medico(String nome, String cognome, String specializzazione) {
        super(nome, cognome);
        this.specializzazione = specializzazione;
    }
    
    public String getSpecializzazione() {
        return specializzazione;
    }
    
    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }
    
    @Override
    public void stampaRuolo() {
        System.out.println("Ruolo: Medico");
        System.out.println("Nome: " + getNome());
        System.out.println("Cognome: " + getCognome());
        System.out.println("Specializzazione: " + specializzazione);
    }
}

// Classe derivata Paziente
class Paziente extends Persona {
    private int codicePaziente;
    
    public Paziente(String nome, String cognome, int codicePaziente) {
        super(nome, cognome);
        this.codicePaziente = codicePaziente;
    }
    
    public int getCodicePaziente() {
        return codicePaziente;
    }
    
    public void setCodicePaziente(int codicePaziente) {
        this.codicePaziente = codicePaziente;
    }
    
    @Override
    public void stampaRuolo() {
        System.out.println("Ruolo: Paziente");
        System.out.println("Nome: " + getNome());
        System.out.println("Cognome: " + getCognome());
        System.out.println("Codice Paziente: " + codicePaziente);
    }
}

// Classe principale Ospedale
public class Ospedale {
    // Lista di medici
    private static List<Medico> medici = new ArrayList<>();
    // Lista di pazienti
    private static List<Paziente> pazienti = new ArrayList<>();
    // Scanner per l'input
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        boolean exit = false;
        
        while (!exit) {
            // Stampa il menu
            System.out.println("\nMenu Ospedale");
            System.out.println("1. Inserisci Medico");
            System.out.println("2. Inserisci Paziente");
            System.out.println("3. Stampa Tutti");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            
            int scelta;
            try {
                // Legge la scelta dell'utente
                scelta = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero valido.");
                continue;
            }
            
            switch (scelta) {
                case 1:
                    // Configura un medico
                    configuraMedico();
                    break;
                case 2:
                    // Configura un paziente
                    configuraPaziente();
                    break;
                case 3:
                    // Stampa tutti i medici e i pazienti
                    stampaTutti();
                case 4:
                    // Esce dal programma
                    exit = true;
                    System.out.println("Chiusura del programma.");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        }
        
        scanner.close();
    }
    // Metodo per stampare le informazioni di una persona
    public static void stampaInfoPersona(Persona p) {
        p.stampaRuolo();
    }
    
    // Metodo per verificare se una stringa è valida
    private static boolean isStringValid(String str) {
        return str != null && !str.trim().isEmpty();
    }
    
    // Metodo per verificare se un medico è già presente
    private static boolean isMedicoPresente(String nome, String cognome) {
        return medici.stream().anyMatch(m -> m.getNome().equalsIgnoreCase(nome) && m.getCognome().equalsIgnoreCase(cognome));
    }
    
    // Metodo per verificare se un paziente è già presente
    private static boolean isPazientePresente(int codicePaziente) {
        return pazienti.stream().anyMatch(p -> p.getCodicePaziente() == codicePaziente);
    }

    public static void configuraMedico(){
        try {
            // Inserimento dati del medico
            System.out.print("Nome: ");
            String nomeMedico = scanner.nextLine();
            System.out.print("Cognome: ");
            String cognomeMedico = scanner.nextLine();
            System.out.print("Specializzazione: ");
            String specializzazione = scanner.nextLine();
            
            // Verifica se i campi sono validi
            if (!isStringValid(nomeMedico) || !isStringValid(cognomeMedico) || !isStringValid(specializzazione)) {
                System.out.println("Errore: i campi non possono essere vuoti.");
                return;
            }
            
            // Verifica se il medico è già presente
            if (isMedicoPresente(nomeMedico, cognomeMedico)) {
                System.out.println("Errore: medico già presente.");
                return;
            }
            
            // Crea un nuovo medico e lo aggiunge alla lista
            Medico medico = new Medico(nomeMedico, cognomeMedico, specializzazione);
            medici.add(medico);
            System.out.println("\nDati Medico Inseriti:");
            stampaInfoPersona(medico);
        } catch (Exception e) {
            System.out.println("Errore nell'inserimento dei dati: " + e.getMessage());
        }
    }

    public static void configuraPaziente(){
        try {
            // Inserimento dati del paziente
            System.out.print("Nome: ");
            String nomePaziente = scanner.nextLine();
            System.out.print("Cognome: ");
            String cognomePaziente = scanner.nextLine();
            System.out.print("Codice Paziente: ");
            int codicePaziente = Integer.parseInt(scanner.nextLine());
            
            // Verifica se i campi sono validi
            if (!isStringValid(nomePaziente) || !isStringValid(cognomePaziente)) {
                System.out.println("Errore: i campi non possono essere vuoti.");
                return;
            }
            
            // Verifica se il codice paziente è già presente
            if (isPazientePresente(codicePaziente)) {
                System.out.println("Errore: codice paziente già esistente.");
                return;
            }
            
            // Crea un nuovo paziente e lo aggiunge alla lista
            Paziente paziente = new Paziente(nomePaziente, cognomePaziente, codicePaziente);
            pazienti.add(paziente);
            System.out.println("\nDati Paziente Inseriti:");
            stampaInfoPersona(paziente);
        } catch (NumberFormatException e) {
            System.out.println("Errore: il codice paziente deve essere un numero valido.");
        }
    }

    public static void stampaTutti() {
        System.out.println("\nLista Medici:");
        if (medici.isEmpty()) {
            System.out.println("Nessun medico registrato.");
        } else {
            for (Medico medico : medici) {
                stampaInfoPersona(medico);
            }
        }
        
        System.out.println("\nLista Pazienti:");
        if (pazienti.isEmpty()) {
            System.out.println("Nessun paziente registrato.");
        } else {
            for (Paziente paziente : pazienti) {
                stampaInfoPersona(paziente);
            }
        }
    }
}
