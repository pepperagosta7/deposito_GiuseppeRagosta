package TERZALEZIONE.EserciziMattina;

import java.util.*;

public class SecondoEsercizio {
    
    public static void main(String[] agrs){

        //creazione degli scanner
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);

        //inserimento dei numeri
        System.out.println("Inserisci il primo numero: ");
        int x = in.nextInt();
        System.out.println("Inserisci il secondo numero: ");
        int y = in2.nextInt();

        //esito del confronto
        if (x > y) System.out.println("Il primo numero è maggiore");
        else if (x == y) System.out.println("I numeri sono uguali");
        else System.out.println("Il secondo numero è maggiore");

        in.close();;
        in2.close();
    }
}
