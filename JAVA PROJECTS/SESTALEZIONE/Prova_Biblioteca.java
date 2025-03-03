package SESTALEZIONE;

import java.util.Scanner;

public class Prova_Biblioteca {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in); // Scanner per leggere l'input dell'utente

        // Inserimento dei dati del libro
        System.out.println("Inserisci un libro: ");
        System.out.println("Inserisci il nome dell'autore: ");
        String nomeAutore = input.nextLine();
        System.out.println("Inserisci il numero di pagine: ");
        int nrPagine = input.nextInt();

        // Creazione di un oggetto Libro
        Libro libro1 = new Libro(nomeAutore, nrPagine);

        // Ricerca per nome autore
        System.out.println("Vuoi effettuare una ricerca per nome autore? (s/n)");
        String risposta = input.next();
        if (risposta.equalsIgnoreCase("s")) {
            System.out.println("Inserisci il nome dell'autore da cercare: ");
            String autore = input.next();
            Libro libroTrovato = libro1.ricercaPerAutore(autore);
            if (libroTrovato != null) {
                System.out.println("Libro trovato: " + libroTrovato.nomeAutore + " " + libroTrovato.nrPagine);
            } else {
                System.out.println("Libro non trovato");
            }
        } else {
            return;
        }

        // Ricerca per numero massimo di pagine
        System.out.println("Vuoi effettuare una ricerca per numero di pagine? (s/n)");
        risposta = input.next();
        if (risposta.equalsIgnoreCase("s")) {
            System.out.println("Inserisci il numero massimo di pagine: ");
            int maxPagine = input.nextInt();
            Libro libroTrovato = libro1.ricercaPerMassimoNumeroPagine(maxPagine);
            if (libroTrovato != null) {
                System.out.println("Libro trovato: " + libroTrovato.nomeAutore + " " + libroTrovato.nrPagine);
            } else {
                System.out.println("Libro non trovato");
            }
        } else {
            return;
        }
    }
}

class Libro {
    String nomeAutore; // Nome dell'autore del libro
    int nrPagine; // Numero di pagine del libro

    // Costruttore della classe Libro
    public Libro(String nomeAutore_plc, int nrPagine_plc) {
        this.nomeAutore = nomeAutore_plc;
        this.nrPagine = nrPagine_plc;
    }

    // Metodo per la ricerca di un libro per autore
    public Libro ricercaPerAutore(String autore) {
        if (this.nomeAutore.equalsIgnoreCase(autore)) {
            return this;
        }
        return null;
    }

    // Metodo per la ricerca di un libro per il numero massimo di pagine
    public Libro ricercaPerMassimoNumeroPagine(int numeroPagine) {
        if (this.nrPagine <= numeroPagine) {
            return this;
        }
        return null;
    }
}