package OTTAVALEZIONE.EserciziPomeriggio;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        Biblioteca biblioteca = new Biblioteca();
        Menu menu = new Menu();
        menu.mostraMenuPrincipale(scanner, biblioteca);
        scanner.close();
    }
}
