package SETTIMALEZIONE.EserciziPomeriggio;

import java.util.Scanner;

public class GestioneErrori { // Definisce una classe pubblica chiamata GestioneErrori.

    public static void main(String[] args) { // Metodo principale, punto di ingresso del programma.
        
        Scanner in = new Scanner(System.in); // Crea un oggetto Scanner per leggere l'input da tastiera.
        try { // Inizio del blocco try per la gestione delle eccezioni.

            System.out.println("Inserisci il numero di cioccolatini da acquistare: "); // Stampa un messaggio per chiedere l'input all'utente.
            String input = in.nextLine(); // Legge l'input dell'utente come stringa.

            int cioccolatini = Integer.parseInt(input); // Converte l'input in un numero intero.
            
            if (cioccolatini < 0) { // Controlla se il numero inserito è negativo.
                throw new IllegalArgumentException("Il numero di cioccolatini non può essere negativo."); // Lancia un'eccezione se il numero è negativo.
            }

            double prezzo = 1.5; // Definisce il prezzo unitario di un cioccolatino.
            double totale = cioccolatini * prezzo; // Calcola il costo totale.

            // Stampa il numero di cioccolatini acquistati e il costo totale.
            System.out.println("Hai acquistato: " + cioccolatini + " cioccolatini per un costo totale di: " + totale + " euro.");

        } catch (NumberFormatException e) { // Cattura l'eccezione se l'input non è un numero valido.
            System.out.println("Errore: numero non valido.");
        } catch (Exception e) { // Cattura qualsiasi altra eccezione non prevista.
            System.out.println("Errore: " + e.getMessage());
        } finally { // Blocco finally, eseguito sempre, indipendentemente dalla presenza di eccezioni.
            in.close(); // Chiude lo Scanner per evitare perdite di memoria.
        }
    }
}
