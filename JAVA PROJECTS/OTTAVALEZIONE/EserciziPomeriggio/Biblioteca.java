package OTTAVALEZIONE.EserciziPomeriggio;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> catalogo = new ArrayList<>();

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
    }

    // Aggiungere un libro (se già esiste, aumenta le copie disponibili)
    public void aggiungiLibro(String titolo, String autore, int copie) {
        if (titolo == null || titolo.trim().isEmpty() || autore == null || autore.trim().isEmpty() || copie <= 0) {
            System.out.println("Errore: Dati del libro non validi.");
            return;
        }
        for (Libro libro : catalogo) {
            if (libro.getTitolo().equalsIgnoreCase(titolo)) {
                System.out.println("Il libro esiste già. Aggiungo " + copie + " copie.");
                libro.aggiungiCopie(copie);
                return;
            }
        }
        catalogo.add(new Libro(titolo, autore, copie));
        System.out.println("Libro aggiunto: " + titolo + " di " + autore + " con " + copie + " copie.");
    }

    // Rimuovere un libro dal catalogo (senza Iterator)
    public void rimuoviLibro(String titolo) {
        if (titolo == null || titolo.trim().isEmpty()) {
            System.out.println("Errore: Titolo del libro non valido.");
            return;
        }
        boolean rimosso = catalogo.removeIf(libro -> libro.getTitolo().equalsIgnoreCase(titolo));

        if (rimosso) {
            System.out.println("Libro rimosso.");
        } else {
            System.out.println("Libro non trovato.");
        }
    }

    // Prestare un libro se disponibile
    public void prestaLibro(String titolo) {
        if (titolo == null || titolo.trim().isEmpty()) {
            System.out.println("Errore: Titolo del libro non valido.");
            return;
        }
        for (Libro libro : catalogo) {
            if (libro.getTitolo().equalsIgnoreCase(titolo)) {
                if (libro.getCopieDisponibili() > 0) {
                    libro.prestaCopia();
                    System.out.println("Hai preso in prestito: " + libro.getTitolo());
                } else {
                    System.out.println("Libro non disponibile per il prestito.");
                }
                return;
            }
        }
        System.out.println("Libro non trovato.");
    }

    // Restituire un libro
    public void restituisciLibro(String titolo) {
        if (titolo == null || titolo.trim().isEmpty()) {
            System.out.println("Errore: Titolo del libro non valido.");
            return;
        }
        for (Libro libro : catalogo) {
            if (libro.getTitolo().equalsIgnoreCase(titolo)) {
                if (libro.getCopieInPrestito() > 0) {
                    libro.restituisciCopia();
                    System.out.println("Hai restituito: " + libro.getTitolo());
                } else {
                    System.out.println("Errore: Nessuna copia di questo libro è attualmente in prestito.");
                }
                return;
            }
        }
        System.out.println("Libro non trovato.");
    }

    // Stampare l'elenco dei libri disponibili
    public void stampaLibriDisponibili() {
        if (catalogo.isEmpty()) {
            System.out.println("La biblioteca non ha libri disponibili.");
        } else {
            System.out.println("Libri disponibili in biblioteca:");
            for (Libro libro : catalogo) {
                System.out.println(libro);
            }
        }
    }
}