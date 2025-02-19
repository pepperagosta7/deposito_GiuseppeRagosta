package TERZALEZIONE.EserciziMattina;

import java.util.*;

public class PrimoEsercizio {
    
    public static void main(String[] args){

        //creazione dello scanner
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un numero intero, che sia negativo, positivo o pari a zero");

        //inserimento del numero
        int x = in.nextInt();

        //esito
        if (x > 0) System.out.println("Il numero è positivo");
        else if (x < 0) System.out.println("Il numero è negativo");
        else if (x == 0)System.out.println("Il numero è zero");
        else System.out.println("coglione");

        in.close();
    }
}
