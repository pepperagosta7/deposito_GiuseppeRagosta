package TERZALEZIONE.EserciziMattina;

import java.util.*;

public class TerzoEsercizio {
    
    public static void main(String[] args){

        //creazione dello scanner
        Scanner in = new Scanner(System.in);
        System.out.println("Sei maggiorenne o minorenne");

        //inserimento dell'eta
        String eta = in.nextLine();

        //confronto delle stringhe ed esito dei risultati
        if (eta.equals("minorenne"))
        System.out.println("Sei minorenne");
        else if (eta.equals("maggiorenne"))
        System.out.println("Sei maggiorenne");
        else
        System.out.println("arrivederci");

        in.close();

    }
}
