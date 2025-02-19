package TERZALEZIONE.EserciziMattina;

import java.util.Scanner;

public class QuintoEsercizio {
    
    public static void main(String[] args){

        //creazione degli scanner
        Scanner credenziali = new Scanner(System.in);
        Scanner numero = new Scanner (System.in);

        //richiesta delle credenziali dalla parte della macchina all'utente
        System.out.println("Inserisci il nome: ");
        String nome = credenziali.nextLine();
        System.out.println("Inserisci il cognome: ");
        String cognome = credenziali.nextLine();
        System.out.println("Inserisci la password: ");
        String password = credenziali.nextLine();

        //richiesta dell'opzione relativa alla modifica delle credenziali
        System.out.println("Scegli una delle tre opzioni per modificare uno dei tre campi");
        int modifica = numero.nextInt();

        //dichiarazione dello switch
        switch(modifica){
            case 1:
                String nomeMod = nome;
                nomeMod = credenziali.nextLine();
                System.out.println(nomeMod + " " + cognome + " " + password);
                break;
            case 2:
                String cognomeMod = cognome;
                cognomeMod = credenziali.nextLine();
                System.out.println(nome + " " + cognomeMod + " " + password);
                break;
            case 3:
                String passwordMod = password;
                passwordMod = credenziali.nextLine();
                System.out.println(nome + " " + cognome + " " + passwordMod);
                break;
        }

        credenziali.close();
        numero.close();
    }
}
