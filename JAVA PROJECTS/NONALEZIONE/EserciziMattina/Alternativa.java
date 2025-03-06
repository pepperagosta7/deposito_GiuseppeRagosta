package NONALEZIONE.EserciziMattina;

import java.util.ArrayList;
import java.util.Scanner;

class Menu2 {
    String ingredienti; // Ingredienti del piatto
    double prezzo; // Prezzo del piatto
    String chef; // Nome dello chef

    public Menu2(String ingredienti, double prezzo, String chef) {
        this.ingredienti = ingredienti; // Inizializza gli ingredienti del piatto
        this.prezzo = prezzo; // Inizializza il prezzo del piatto
        this.chef = chef; // Inizializza il nome dello chef
    }
}

class Ordinazione2 {
    ArrayList<Menu2> piatto; // Lista dei piatti ordinati
    double totale; // Totale dell'ordinazione

    public Ordinazione2() {
        this.piatto = new ArrayList<>(); // Inizializza la lista dei piatti ordinati
        this.totale = 0; // Inizializza il totale dell'ordinazione
    }

    public void aggiungiMenu(Menu2 piatto) {
        this.piatto.add(piatto); // Aggiunge un piatto alla lista dei piatti ordinati
        this.totale += piatto.prezzo; // Aggiunge il prezzo del piatto al totale
    }

    public void stampa() {
        for (Menu2 menu : this.piatto) { // Stampa i piatti ordinati
            System.out.println(menu.ingredienti + " " + menu.prezzo + " " + menu.chef);
        }
        System.out.println("Totale: " + this.totale); // Stampa il totale dell'ordinazione
    }
}

public class Alternativa {
    public static void main(String[] args) {
        Ordinazione2 ordinazione = new Ordinazione2(); // Crea una nuova ordinazione
        Scanner scanner = new Scanner(System.in);

        while (true) { // Ciclo infinito per l'inserimento dei piatti
            System.out.println("Inserisci gli ingredienti del piatto: ");
            String ingredienti = scanner.nextLine(); // Legge gli ingredienti del piatto
            System.out.println("Inserisci il prezzo del piatto: ");
            double prezzo = scanner.nextDouble(); // Legge il prezzo del piatto
            scanner.nextLine(); // Consuma il newline rimasto nel buffer
            System.out.println("Inserisci il nome dello chef: ");
            String chef = scanner.nextLine(); // Legge il nome dello chef

            Menu2 menu = new Menu2(ingredienti, prezzo, chef); // Crea un nuovo piatto
            ordinazione.aggiungiMenu(menu); // Aggiunge il piatto all'ordinazione

            System.out.println("Vuoi aggiungere un altro piatto? (s/n)");
            String risposta = scanner.nextLine(); // Legge la risposta dell'utente
            if (risposta.equals("n")) {
                break; // Esce dal ciclo se l'utente digita 'n'
            }
        }

        ordinazione.stampa(); // Stampa l'ordinazione
        scanner.close(); // Chiude lo scanner
    }
}