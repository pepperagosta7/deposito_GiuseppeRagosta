package SETTIMALEZIONE.EserciziPomeriggio;

import java.util.ArrayList;
import java.util.Scanner;

public class Paninoteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner per leggere l'input dell'utente
        while (true) { // Ciclo infinito per il menu
            System.out.println("\nMenu:");
            System.out.println("1. Ordina Piatto Speciale");
            System.out.println("2. Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt(); // Legge la scelta dell'utente
            scanner.nextLine(); // Consuma il newline rimasto nel buffer

            switch (scelta) { // Gestione delle scelte dell'utente
                case 1:
                    PiattoSpeciale piatto = MenuPiatto.creaPiatto(scanner); // Crea un piatto speciale
                    System.out.println("Piatto Speciale ordinato: " + piatto); // Stampa il piatto speciale ordinato
                    System.out.println("Totale: " + piatto.calcolaTotale() + " euro"); // Stampa il totale del piatto speciale
                    break;
                case 2:
                    System.out.println("Uscita dal sistema.");
                    scanner.close(); // Chiude lo scanner
                    return; // Esce dal programma
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
            System.out.println("Grazie per aver ordinato da Paninoteca!");
        }
    }
}

class MenuPiatto {

    public static PiattoSpeciale creaPiatto(Scanner scanner) {
        PiattoSpeciale.mostraIngredientiPrivati(); // Mostra i tipi di pane disponibili
        int sceltaIngredientePrivato;
        String ingredientePrivato = null;
        double prezzoIngredientePrivato = 0;
        boolean ingredienteValido = false;

        do {
            System.out.print("Scegli un tipo di pane (numero): ");
            sceltaIngredientePrivato = scanner.nextInt(); // Legge la scelta del tipo di pane
            scanner.nextLine(); // Consuma il newline rimasto nel buffer

            ingredientePrivato = PiattoSpeciale.getIngredientePrivato(sceltaIngredientePrivato); // Ottiene il tipo di pane scelto
            prezzoIngredientePrivato = PiattoSpeciale.getPrezzoIngredientePrivato(sceltaIngredientePrivato); // Ottiene il prezzo del tipo di pane scelto

            if (ingredientePrivato != null) {
                ingredienteValido = true; // Se il tipo di pane è valido, esce dal ciclo
            } else {
                System.out.println("Ingrediente non valido, riprova.");
            }
        } while (!ingredienteValido);

        ArrayList<String> ingredientiPubbliciSelezionati = new ArrayList<>(); // Lista degli ingredienti pubblici scelti
        PiattoSpeciale.mostraIngredientiPubblici(); // Mostra gli ingredienti pubblici disponibili
        System.out.println("Seleziona gli ingredienti pubblici (digita 'fine' per terminare):");
        while (true) {
            System.out.print("Aggiungi ingrediente pubblico: ");
            String ingredientePubblico = scanner.nextLine(); // Legge l'ingrediente pubblico scelto
            if (ingredientePubblico.equalsIgnoreCase("fine")) {
                break; // Esce dal ciclo se l'utente digita 'fine'
            }
            boolean ingredienteTrovato = false;
            for (String ingrediente : PiattoSpeciale.INGREDIENTI_PUBBLICI) { // Controlla se l'ingrediente pubblico è valido
                if (ingredientePubblico.equalsIgnoreCase(ingrediente)) {
                    ingredientiPubbliciSelezionati.add(ingredientePubblico); // Aggiunge l'ingrediente pubblico alla lista
                    ingredienteTrovato = true;
                    break;
                }
            }
            if (!ingredienteTrovato) {
                System.out.println("Ingrediente non valido, riprova.");
            }
        }

        return new PiattoSpeciale(ingredientePrivato, prezzoIngredientePrivato, ingredientiPubbliciSelezionati); // Crea e restituisce un oggetto PiattoSpeciale
    }
}

class PiattoSpeciale {
    public static final String[] INGREDIENTI_PUBBLICI = {"Lattuga", "Pomodoro", "Formaggio", "Prosciutto"}; // Ingredienti pubblici disponibili
    private static final String[] INGREDIENTI_PRIVATI = {"Panino Normale", "Panino Sesamo"}; // Tipi di pane disponibili
    private static final double[] PREZZI_PRIVATI = {2.0, 2.5}; // Prezzi dei tipi di pane

    private String ingredientePrivato; // Tipo di pane scelto
    private double prezzoIngredientePrivato; // Prezzo del tipo di pane scelto
    private ArrayList<String> ingredientiPubblici; // Lista degli ingredienti pubblici scelti

    public PiattoSpeciale(String ingredientePrivato, double prezzoIngredientePrivato, ArrayList<String> ingredientiPubblici) {
        this.ingredientePrivato = ingredientePrivato; // Inizializza il tipo di pane scelto
        this.prezzoIngredientePrivato = prezzoIngredientePrivato; // Inizializza il prezzo del tipo di pane scelto
        this.ingredientiPubblici = ingredientiPubblici; // Inizializza la lista degli ingredienti pubblici scelti
    }

    public static void mostraIngredientiPubblici() {
        System.out.println("Ingredienti pubblici disponibili:");
        for (String ingrediente : INGREDIENTI_PUBBLICI) { // Stampa gli ingredienti pubblici disponibili
            System.out.println("- " + ingrediente);
        }
    }

    public static void mostraIngredientiPrivati() {
        System.out.println("Tipi di pane disponibili (ingredienti privati):");
        for (int i = 0; i < INGREDIENTI_PRIVATI.length; i++) { // Stampa i tipi di pane disponibili con i relativi prezzi
            System.out.println((i + 1) + ". " + INGREDIENTI_PRIVATI[i] + " - " + PREZZI_PRIVATI[i] + " euro");
        }
    }

    public static String getIngredientePrivato(int scelta) {
        if (scelta > 0 && scelta <= INGREDIENTI_PRIVATI.length) { // Restituisce il tipo di pane scelto
            return INGREDIENTI_PRIVATI[scelta - 1];
        }
        return null; // Restituisce null se la scelta non è valida
    }

    public static double getPrezzoIngredientePrivato(int scelta) {
        if (scelta > 0 && scelta <= PREZZI_PRIVATI.length) { // Restituisce il prezzo del tipo di pane scelto
            return PREZZI_PRIVATI[scelta - 1];
        }
        return 0; // Restituisce 0 se la scelta non è valida
    }

    public double calcolaTotale() {
        return prezzoIngredientePrivato + ingredientiPubblici.size(); // Calcola il totale del piatto (ogni ingrediente pubblico costa 1 euro)
    }

    @Override
    public String toString() {
        return "PiattoSpeciale{" +
                "ingredientePrivato='" + ingredientePrivato + '\'' +
                ", ingredientiPubblici=" + ingredientiPubblici +
                '}'; // Restituisce una rappresentazione testuale del piatto speciale
    }
}