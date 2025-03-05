package OTTAVALEZIONE.EserciziPomeriggio;

import java.util.Scanner;

public class Menu {
    private String titolo;
    private String autore;
    private int copie;

    // Metodo per il menu principale
    public void mostraMenuPrincipale(Scanner scanner, Biblioteca biblioteca) throws InterruptedException {
        int scelta;

        boolean exitMainMenu = false;

        while (!exitMainMenu) {
            clear();
            stampaMenuPrincipale();
            scelta = getInt(scanner);

            switch (scelta) {
                case 1:
                    biblioteca.stampaLibriDisponibili();
                    break;

                case 2:
                    System.out.print("Inserisci il titolo del libro: ");
                    titolo = controlloInputStringhe(scanner);

                    System.out.print("Inserisci l'autore del libro: ");
                    autore = controlloInputStringhe(scanner);

                    System.out.print("Inserisci il numero di copie del libro: ");
                    copie = getInt(scanner);

                    biblioteca.aggiungiLibro(titolo, autore, copie);
                    break;

                case 3:
                    System.out.print("Inserisci il titolo del libro da rimuovere: ");
                    titolo = controlloInputStringhe(scanner);

                    biblioteca.rimuoviLibro("1984");
                    break;

                case 4:
                    System.out.print("Inserisci il titolo del libro da richiedere in prestito: ");
                    titolo = controlloInputStringhe(scanner);
                    biblioteca.prestaLibro(titolo);
                    break;

                case 5:
                    System.out.print("Inserisci il titolo del libro da restituire: ");
                    titolo = controlloInputStringhe(scanner);

                    biblioteca.restituisciLibro(titolo);
                    break;

                case 0:
                    System.out.println("ARRIVEDERCI CARO CIUCCIO E SEMPRE FORZA NAPOLI!!!");
                    exitMainMenu = true;
                    break;
                default:
                    System.out.println("Opzione non valida! Riprova.");
            }
        }
    }

    // Metodo di stampa del menu principale
    public void stampaMenuPrincipale() {
        System.out.println("\n================================");
        System.out.println("         BENVENUTO NELLA BIBLIOTECA DEL NAPOLI        ");
        System.out.println("================================");
        System.out.println(" 1. Mostra libri disponibili");
        System.out.println(" 2. Aggiungi un nuovo libro");
        System.out.println(" 3. Rimuovi un libro");
        System.out.println(" 4. Effettua un prestito");
        System.out.println(" 5. Effettua una restituzione");
        System.out.println(" 0. Esci");
        System.out.println("================================");
        System.out.print("Scegli un'opzione (0-5): ");
    }

    // Metodo per il controllo di un int
    public int getInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserire un numero intero valido.");
            }
        }
    }

    // Metodo per controllare che l'input stringa non sia vuoto
    public static String controlloInputStringhe(Scanner scanner) {
        while (true) {
            String valore = scanner.nextLine().trim();
            if (!valore.isEmpty()) {
                return valore; // Restituisce il valore solo se non è vuoto
            }
            System.out.print("Input non valido. Inserisci un testo: ");
        }
    }

    private static void clear() throws InterruptedException {
        Thread.sleep(3000);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}