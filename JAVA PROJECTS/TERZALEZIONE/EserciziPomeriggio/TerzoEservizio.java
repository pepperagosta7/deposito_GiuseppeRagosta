package TERZALEZIONE.EserciziPomeriggio;

import java.util.*;

public class TerzoEservizio {
    
    public static void main(String[] args){

        //creazione di un numero casuale tramite costruttore Random
        System.out.println("GIOCHIAMO! Ora genero un numero da 1 a 100 e tu dovrai indovinarlo.");
        Random rand = new Random();
        int numCasuale = rand.nextInt(100)+1;

        //utente inserisce un numero
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un numero da 1 a 100");
        int numeroUtente = in.nextInt();

        //verifica della corrispondenza dei numeri finchè non sono uguali
        while (numeroUtente != numCasuale){
            if (numeroUtente <= numCasuale){
                System.out.println("Troppo basso, inserisci un nuovo numero.");
                numeroUtente = in.nextInt();
            }
            else {
                System.out.println("Troppo alto, inserisci un nuovo numero.");
                numeroUtente = in.nextInt();
            }
        }

        //corrispondenza trovata
        if (numeroUtente == numCasuale){
            System.out.println("Congratulazioni, vuoi giocare ancora?");
        }

        in.close();
    }
}
