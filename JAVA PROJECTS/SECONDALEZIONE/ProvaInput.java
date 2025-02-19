package SECONDALEZIONE;

import java.util.*;


public class ProvaInput {
    
    public static void main(String[] args){

        //Creazione dell'oggetto scanner
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username: ");

        //richiesta dell'username
        String username = myObj.next();
        System.out.println("Username is: " + username);

        myObj.close();
    }
}
