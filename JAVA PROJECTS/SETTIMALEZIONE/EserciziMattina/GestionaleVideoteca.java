package SETTIMALEZIONE.EserciziMattina;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionaleVideoteca {
    private static Scanner scanner = new Scanner(System.in); // Scanner per leggere l'input dell'utente
    private static Videoteca videoteca = new Videoteca(); // Creazione di un oggetto Videoteca

    public static void main(String[] args) {
        while (true) { // Ciclo infinito per il menu
            System.out.println("\nMenu Videoteca:");
            System.out.println("1. Aggiungi Film");
            System.out.println("2. Rimuovi Film");
            System.out.println("3. Aggiungi Utente");
            System.out.println("4. Noleggia Film");
            System.out.println("5. Mostra Catalogo");
            System.out.println("6. Mostra Noleggi di un Utente");
            System.out.println("7. Cerca Film");
            System.out.println("8. Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt(); // Legge la scelta dell'utente
            scanner.nextLine(); // Consuma il newline rimasto nel buffer

            switch (scelta) { // Gestione delle scelte dell'utente
                case 1:
                    aggiungiFilm(); // Aggiunge un film
                    break;
                case 2:
                    rimuoviFilm(); // Rimuove un film
                    break;
                case 3:
                    aggiungiUtente(); // Aggiunge un utente
                    break;
                case 4:
                    noleggiaFilm(); // Noleggia un film
                    break;
                case 5:
                    videoteca.mostraCatalogo(); // Mostra il catalogo dei film
                    break;
                case 6:
                    mostraNoleggi(); // Mostra i noleggi di un utente
                    break;
                case 7:
                    cercaFilm(); // Cerca un film
                    break;
                case 8:
                    System.out.println("Uscita dal sistema.");
                    scanner.close(); // Chiude lo scanner
                    return; // Esce dal programma
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    private static void aggiungiFilm() {
        System.out.print("Inserisci titolo film: ");
        String titolo = scanner.nextLine(); // Legge il titolo del film
        System.out.print("Inserisci anno di uscita: ");
        int anno = scanner.nextInt(); // Legge l'anno di uscita del film
        scanner.nextLine(); // Consuma il newline rimasto nel buffer
        videoteca.addFilm(new Film(titolo, anno)); // Aggiunge il film alla videoteca
    }

    private static void rimuoviFilm() {
        System.out.print("Inserisci titolo del film da rimuovere: ");
        String titoloRimuovi = scanner.nextLine(); // Legge il titolo del film da rimuovere
        videoteca.removeFilm(titoloRimuovi); // Rimuove il film dalla videoteca
    }

    private static void aggiungiUtente() {
        System.out.print("Inserisci ID Utente: ");
        String idUtente = scanner.nextLine(); // Legge l'ID dell'utente
        System.out.print("Inserisci Nome Utente: ");
        String nomeUtente = scanner.nextLine(); // Legge il nome dell'utente
        videoteca.addUtente(new Utente1(idUtente, nomeUtente)); // Aggiunge l'utente alla videoteca
    }

    private static void noleggiaFilm() {
        System.out.print("Inserisci ID Utente: ");
        String idNoleggio = scanner.nextLine(); // Legge l'ID dell'utente che noleggia
        System.out.print("Inserisci titolo del film da noleggiare: ");
        String titoloNoleggio = scanner.nextLine(); // Legge il titolo del film da noleggiare
        
        Film filmNoleggio = videoteca.trovaFilm(titoloNoleggio); // Trova il film nella videoteca
        Utente1 utente = videoteca.trovaUtente(idNoleggio); // Trova l'utente nella videoteca

        if (filmNoleggio != null && utente != null) { // Controlla se il film e l'utente esistono
            if (utente.rentFilm(filmNoleggio)) { // Noleggia il film all'utente
                System.out.println(idNoleggio + " ha noleggiato " + titoloNoleggio);
            } else {
                System.out.println("Limite di noleggi raggiunto. Restituisci un film prima di noleggiarne un altro.");
            }
        } else {
            System.out.println("Film o utente non disponibile.");
        }
    }

    private static void mostraNoleggi() {
        System.out.print("Inserisci ID Utente: ");
        String idUtente = scanner.nextLine(); // Legge l'ID dell'utente
        Utente1 utente = videoteca.trovaUtente(idUtente); // Trova l'utente nella videoteca
        if (utente != null) { // Controlla se l'utente esiste
            utente.showNoleggi(); // Mostra i noleggi dell'utente
        } else {
            System.out.println("Utente non trovato.");
        }
    }

    private static void cercaFilm() {
        System.out.println("Cerca film per:");
        System.out.println("1. Titolo");
        System.out.println("2. Anno di uscita");
        System.out.print("Scelta: ");
        int scelta = scanner.nextInt(); // Legge la scelta dell'utente
        scanner.nextLine(); // Consuma il newline rimasto nel buffer

        switch (scelta) {
            case 1:
                System.out.print("Inserisci il titolo del film: ");
                String titolo = scanner.nextLine(); // Legge il titolo del film
                videoteca.cercaFilmPerTitolo(titolo); // Cerca il film per titolo
                break;
            case 2:
                System.out.print("Inserisci l'anno di uscita del film: ");
                int anno = scanner.nextInt(); // Legge l'anno di uscita del film
                scanner.nextLine(); // Consuma il newline rimasto nel buffer
                videoteca.cercaFilmPerAnno(anno); // Cerca il film per anno
                break;
            default:
                System.out.println("Scelta non valida.");
        }
    }
}

class Film {
    String titolo; // Titolo del film
    int annoUscita; // Anno di uscita del film

    public Film(String titolo, int annoUscita) {
        this.titolo = titolo; // Inizializza il titolo del film
        this.annoUscita = annoUscita; // Inizializza l'anno di uscita del film
    }

    public String getTitolo() {
        return titolo; // Restituisce il titolo del film
    }

    public int getAnnoUscita() {
        return annoUscita; // Restituisce l'anno di uscita del film
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo; // Imposta il titolo del film
    }   

    public void setAnnoUscita(int annoUscita) {
        this.annoUscita = annoUscita; // Imposta l'anno di uscita del film
    }

    @Override
    public String toString() {
        return "Film{" +
                "titolo='" + titolo + '\'' +
                ", annoUscita=" + annoUscita +
                '}'; // Restituisce una rappresentazione testuale del film
    }
}

class Utente1 {
    private static final int MAX_NOLEGGI = 5; // Numero massimo di film che un utente può noleggiare contemporaneamente
    String ID; // ID dell'utente
    String nome; // Nome dell'utente
    ArrayList<Film> filmNoleggiati = new ArrayList<Film>(0); // Lista dei film noleggiati dall'utente

    public Utente1(String ID, String nome) {
        this.ID = ID; // Inizializza l'ID dell'utente
        this.nome = nome; // Inizializza il nome dell'utente
    }

    public boolean rentFilm(Film film) {
        if (filmNoleggiati.size() >= MAX_NOLEGGI) { // Controlla se l'utente ha raggiunto il limite di noleggi
            return false; // Restituisce false se il limite è stato raggiunto
        }
        filmNoleggiati.add(film); // Aggiunge un film alla lista dei film noleggiati
        return true; // Restituisce true se il film è stato noleggiato con successo
    }

    public void showNoleggi() {
        System.out.println("Film noleggiati da " + nome + ":");
        if (filmNoleggiati.isEmpty()) { // Controlla se la lista dei film noleggiati è vuota
            System.out.println("Nessun film noleggiato.");
        } else {
            for (Film film : filmNoleggiati) { // Stampa i film noleggiati
                System.out.println("- " + film);
            }
        }
    }

    public String getIdUtente() {
        return ID; // Restituisce l'ID dell'utente
    }
}

class Videoteca {
    private ArrayList<Film> catalogo; // Catalogo dei film
    private ArrayList<Utente1> utenti; // Lista degli utenti

    public Videoteca() {
        catalogo = new ArrayList<>(); // Inizializza il catalogo dei film
        utenti = new ArrayList<>(); // Inizializza la lista degli utenti
    }

    public void addFilm(Film film) {
        catalogo.add(film); // Aggiunge un film al catalogo
        System.out.println("Film aggiunto: " + film);
    }

    public void removeFilm(String titolo) {
        for (Film film : catalogo) { // Cerca il film nel catalogo
            if (film.getTitolo().equalsIgnoreCase(titolo)) {
                catalogo.remove(film); // Rimuove il film dal catalogo
                System.out.println("Film rimosso: " + film);
                return;
            }
        }
        System.out.println("Film non trovato.");
    }

    public void addUtente(Utente1 utente) {
        utenti.add(utente); // Aggiunge un utente alla lista degli utenti
        System.out.println("Utente aggiunto: " + utente.nome);
    }

    public Film trovaFilm(String titolo) {
        for (Film film : catalogo) { // Cerca il film nel catalogo
            if (film.getTitolo().equalsIgnoreCase(titolo)) {
                return film; // Restituisce il film trovato
            }
        }
        return null; // Restituisce null se il film non è trovato
    }

    public void mostraCatalogo() {
        System.out.println("Catalogo della Videoteca:");
        if (catalogo.isEmpty()) { // Controlla se il catalogo è vuoto
            System.out.println("Nessun film disponibile.");
        } else {
            for (Film film : catalogo) { // Stampa i film nel catalogo
                System.out.println("- " + film);
            }
        }
    }

    public Utente1 trovaUtente(String idUtente) {
        for (Utente1 utente : utenti) { // Cerca l'utente nella lista degli utenti
            if (utente.ID.equals(idUtente)) {
                return utente; // Restituisce l'utente trovato
            }
        }
        return null; // Restituisce null se l'utente non è trovato
    }

    public void cercaFilmPerTitolo(String titolo) {
        boolean trovato = false;
        for (Film film : catalogo) { // Cerca il film nel catalogo
            if (film.getTitolo().equalsIgnoreCase(titolo)) {
                System.out.println("Film trovato: " + film);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun film trovato con il titolo: " + titolo);
        }
    }

    public void cercaFilmPerAnno(int anno) {
        boolean trovato = false;
        for (Film film : catalogo) { // Cerca il film nel catalogo
            if (film.getAnnoUscita() == anno) {
                System.out.println("Film trovato: " + film);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun film trovato per l'anno: " + anno);
        }
    }
}

