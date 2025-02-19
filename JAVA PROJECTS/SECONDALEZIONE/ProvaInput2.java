package SECONDALEZIONE;

import java.util.Scanner;

public class ProvaInput2 {
    
     public static void main(String[] args){

        //Creazione degli oggetti scanner
        Scanner myObj = new Scanner(System.in);
        Scanner myObj2 = new Scanner(System.in);

        //input
        System.out.println("Enter string: ");
        String stringa = myObj.nextLine();

        System.out.println("Enter integer: ");
        int intero = myObj2.nextInt();

        System.out.println("Enter flag: ");
        boolean flag = myObj2.nextBoolean();

        //Stampa degli input
        System.out.println(stringa);
        System.out.println(intero);
        System.out.println(flag);

        myObj.close();
        myObj2.close();
     }

}
