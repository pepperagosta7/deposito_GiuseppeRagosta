package QUARTALEZIONE.EserciziMattina;

import java.util.Scanner;

public class Esercizioarray_prova {
    
    public static void main (String[] args) {
        
        Scanner in = new Scanner(System.in);
        int[] array_prova = {0,0,0};
        int count = 0;

        while (count < 3) {

            //Riempimento dell'array con input utente
            for (int i = 0; i < array_prova.length; i++) {
                System.out.print("Inserisci il numero: ");
                array_prova[i] = in.nextInt();
            }

            //Controllo e stampa dei valori maggiori di 100
            for (int numero : array_prova) {
                if (numero > 100) {
                    System.out.println(numero);
                    count++; //Incrementa il contatore ogni volta che viene stampato un valore > 100
                }
            }
        }

        System.out.println("End of task");
        in.close();
    }
}
