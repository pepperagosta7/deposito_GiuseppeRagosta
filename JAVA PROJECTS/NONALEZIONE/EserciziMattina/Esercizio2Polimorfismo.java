package NONALEZIONE.EserciziMattina;

import java.util.ArrayList;
import java.util.Scanner;

class Ingrediente {
    private String nome; // Nome dell'ingrediente

    public Ingrediente(String nome) {
        this.nome = nome; // Inizializza il nome dell'ingrediente
    }

    public String getNome() {
        return nome; // Restituisce il nome dell'ingrediente
    }

    @Override
    public String toString() {
        return nome; // Restituisce una rappresentazione testuale dell'ingrediente
    }
}

class Piatto {
    private ArrayList<Ingrediente> ingredienti; // Lista degli ingredienti del piatto
    private double prezzo; // Prezzo del piatto
    private String chef; // Nome dello chef che ha creato il piatto

    public Piatto(ArrayList<Ingrediente> ingredienti, double prezzo, String chef) {
        this.ingredienti = ingredienti; // Inizializza la lista degli ingredienti
        this.prezzo = prezzo; // Inizializza il prezzo del piatto
        this.chef = chef; // Inizializza il nome dello chef
    }

    public double getPrezzo() {
        return prezzo; // Restituisce il prezzo del piatto
    }

    @Override
    public String toString() {
        return "Piatto{" +
                "ingredienti=" + ingredienti +
                ", prezzo=" + prezzo +
                ", chef='" + chef + '\'' +
                '}'; // Restituisce una rappresentazione testuale del piatto
    }
}

class Menu {
    private ArrayList<Piatto> piatti; // Lista dei piatti nel menu

    public Menu() {
        this.piatti = new ArrayList<>(); // Inizializza la lista dei piatti
    }

    public void aggiungiPiatto(Piatto piatto) {
        piatti.add(piatto); // Aggiunge un piatto alla lista dei piatti
        System.out.println("Piatto aggiunto: " + piatto);
    }

    public void stampa() {
        if (piatti.isEmpty()) {
            System.out.println("Il menu è vuoto.");
        } else {
            System.out.println("Menu:");
            for (int i = 1; i < piatti.size(); i++) {
                System.out.println(i + ". " + piatti.get(i));
            }
        }
    }

    public Piatto getPiatto(int index) {
        if (index >= 0 && index < piatti.size()) {
            return piatti.get(index); // Restituisce il piatto all'indice specificato
        }
        return null; // Restituisce null se l'indice non è valido
    }
}

class Ordinazione {
    private ArrayList<Piatto> piattiOrdinati; // Lista dei piatti ordinati

    public Ordinazione() {
        this.piattiOrdinati = new ArrayList<>(); // Inizializza la lista dei piatti ordinati
    }

    public void aggiungiPiatto(Piatto piatto) {
        piattiOrdinati.add(piatto); // Aggiunge un piatto alla lista dei piatti ordinati
        System.out.println("Piatto ordinato: " + piatto);
    }

    public double calcolaTotale() {
        double totale = 0;
        for (Piatto piatto : piattiOrdinati) {
            totale += piatto.getPrezzo(); // Calcola il totale dei piatti ordinati
        }
        return totale;
    }

    public void stampa() {
        if (piattiOrdinati.isEmpty()) {
            System.out.println("Nessun piatto ordinato.");
        } else {
            System.out.println("Ordinazione:");
            for (Piatto piatto : piattiOrdinati) {
                System.out.println(piatto);
            }
            System.out.println("Totale: " + calcolaTotale() + " euro");
        }
    }
}

public class Esercizio2Polimorfismo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(); // Crea un nuovo menu
        Ordinazione ordinazione = new Ordinazione(); // Crea una nuova ordinazione

        boolean flag = true;
        while (flag) { // Ciclo infinito per il menu
            System.out.println("\nMenu:");
            System.out.println("1. Aggiungi Piatto al Menu");
            System.out.println("2. Stampa Menu");
            System.out.println("3. Aggiungi Piatto all'Ordinazione");
            System.out.println("4. Stampa Ordinazione");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt(); // Legge la scelta dell'utente
            scanner.nextLine(); // Consuma il newline rimasto nel buffer

            switch (scelta) { // Gestione delle scelte dell'utente
                case 1:
                    aggiungiPiattoAlMenu(scanner, menu); // Aggiunge un piatto al menu
                    break;
                case 2:
                    menu.stampa(); // Stampa il menu
                    break;
                case 3:
                    aggiungiPiattoAllOrdinazione(scanner, menu, ordinazione); // Aggiunge un piatto all'ordinazione
                    break;
                case 4:
                    ordinazione.stampa(); // Stampa l'ordinazione
                    break;
                case 5:
                    System.out.println("Uscita dal sistema.");
                    flag = false; // Esce dal ciclo
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
        scanner.close(); // Chiude lo scanner
    }

    private static void aggiungiPiattoAlMenu(Scanner scanner, Menu menu) {
        System.out.print("Inserisci il nome dello chef: ");
        String chef = scanner.nextLine(); // Legge il nome dello chef
        System.out.print("Inserisci il prezzo del piatto: ");
        double prezzo = scanner.nextDouble(); // Legge il prezzo del piatto
        scanner.nextLine(); // Consuma il newline rimasto nel buffer

        ArrayList<Ingrediente> ingredienti = new ArrayList<>(); // Lista degli ingredienti del piatto
        System.out.println("Inserisci gli ingredienti (digita 'fine' per terminare):");
        while (true) {
            System.out.print("Ingrediente: ");
            String nomeIngrediente = scanner.nextLine(); // Legge il nome dell'ingrediente
            if (nomeIngrediente.equalsIgnoreCase("fine")) {
                break; // Esce dal ciclo se l'utente digita 'fine'
            }
            ingredienti.add(new Ingrediente(nomeIngrediente)); // Aggiunge l'ingrediente alla lista
        }

        Piatto piatto = new Piatto(ingredienti, prezzo, chef); // Crea un nuovo piatto
        menu.aggiungiPiatto(piatto); // Aggiunge il piatto al menu
    }

    private static void aggiungiPiattoAllOrdinazione(Scanner scanner, Menu menu, Ordinazione ordinazione) {
        menu.stampa(); // Stampa il menu
        System.out.print("Inserisci l'indice del piatto da ordinare: ");
        int indice = scanner.nextInt(); // Legge l'indice del piatto da ordinare
        scanner.nextLine(); // Consuma il newline rimasto nel buffer
        Piatto piattoOrdinato = menu.getPiatto(indice); // Ottiene il piatto dall'indice
        if (piattoOrdinato != null) {
            ordinazione.aggiungiPiatto(piattoOrdinato); // Aggiunge il piatto all'ordinazione
        } else {
            System.out.println("Indice non valido.");
        }
    }
}