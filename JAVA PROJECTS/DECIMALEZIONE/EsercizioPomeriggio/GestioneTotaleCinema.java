package DECIMALEZIONE.EsercizioPomeriggio;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestioneTotaleCinema {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Cinema> cinemaList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        // Precarica i dati per i test
        precaricaDati();

        while (true) {
            clear();
            System.out.println("\nMenu Gestione Totale Cinema: \n1. Aggiungi Cinema\n2. Visualizza Cinema\n3. Gestisci Cinema\n4. Esci");
            System.out.print("Scelta: ");
            try {
                int scelta = scanner.nextInt();
                scanner.nextLine();
                switch (scelta) {
                    case 1:
                        aggiungiCinema();
                        break;
                    case 2:
                        visualizzaCinema();
                        break;
                    case 3:
                        gestisciCinema();
                        break;
                    case 4:
                        System.out.println("Uscita...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Errore: Inserire un numero valido.");
                scanner.nextLine();
            }
        }
    }

    private static void aggiungiCinema() {
        System.out.print("Inserisci il nome del cinema: ");
        String nomeCinema = scanner.nextLine();
        Cinema cinema = new Cinema(nomeCinema);
        cinemaList.add(cinema);
        System.out.println("Cinema aggiunto con successo.");
    }

    private static void visualizzaCinema() {
        if (cinemaList.isEmpty()) {
            System.out.println("Nessun cinema disponibile.");
            return;
        }

        System.out.println("Cinema disponibili:");
        for (int i = 0; i < cinemaList.size(); i++) {
            System.out.println((i + 1) + ". " + cinemaList.get(i).getNome());
        }
    }

    private static void gestisciCinema() throws InterruptedException {
        visualizzaCinema();
        if (cinemaList.isEmpty()) {
            return;
        }

        System.out.print("Seleziona il numero del cinema da gestire: ");
        int scelta = scanner.nextInt();
        scanner.nextLine();

        if (scelta < 1 || scelta > cinemaList.size()) {
            System.out.println("Scelta non valida.");
            return;
        }

        Cinema cinema = cinemaList.get(scelta - 1);
        cinema.menuPrincipale();
    }

    private static void precaricaDati() {
        Cinema cinema1 = new Cinema("Cinema Centrale");
        Cinema cinema2 = new Cinema("Cinema Nord");
        cinemaList.add(cinema1);
        cinemaList.add(cinema2);

        GestoreCinema gestore1 = new GestoreCinema("admin1", "password1");
        GestoreCinema gestore2 = new GestoreCinema("admin2", "password2");

        cinema1.aggiungiGestore(gestore1);
        cinema2.aggiungiGestore(gestore2);

        try {
            gestore1.aggiungiSalaFilm(new SalaFilm(100, 1, "Oppenheimer", "21:00"));
            gestore2.aggiungiSalaFilm(new SalaFilm(150, 2, "Dune 2", "20:00"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void clear() throws InterruptedException {
        Thread.sleep(2500);
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}

class Cinema {
    private String nome;
    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<Cliente> clienti = new ArrayList<>();
    private ArrayList<GestoreCinema> gestori = new ArrayList<>();
    private Cliente clienteLoggato = null;
    private GestoreCinema gestoreLoggato = null;

    public Cinema(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void aggiungiGestore(GestoreCinema gestore) {
        gestori.add(gestore);
    }

    public void menuPrincipale() throws InterruptedException {
        while (true) {
            clear();
            System.out.println("\nMenu Principale: \n1. Menu Cliente\n2. Menu Gestore\n3. Esci");
            System.out.print("Scelta: ");
            try {
                int scelta = scanner.nextInt();
                scanner.nextLine();
                switch (scelta) {
                    case 1:
                        menuCliente();
                        break;
                    case 2:
                        menuGestore();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Errore: Inserire un numero valido.");
                scanner.nextLine();
            }
        }
    }

    private void menuCliente() throws InterruptedException {
        boolean exit = false;
        while (!exit) {
            clear();
            System.out.println("\nMenu Cliente: \n1. Registra Cliente\n2. Login Cliente\n3. Prenota Biglietto\n4. Logout Cliente\n5. Torna al Menu Principale");
            System.out.print("Scelta: ");
            try {
                int scelta = scanner.nextInt();
                scanner.nextLine();
                switch (scelta) {
                    case 1:
                        registraCliente();
                        break;
                    case 2:
                        loginCliente();
                        break;
                    case 3:
                        prenotaBiglietto();
                        break;
                    case 4:
                        logoutCliente();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Errore: Inserire un numero valido.");
                scanner.nextLine();
            }
        }
    }

    private void menuGestore() throws InterruptedException {
        boolean exit = false;
        while (!exit) {
            clear();
            System.out.println("\nMenu Gestore: \n1. Registra Gestore\n2. Login Gestore\n3. Aggiungi Film\n4. Logout Gestore\n5. Torna al Menu Principale");
            System.out.print("Scelta: ");
            try {
                int scelta = scanner.nextInt();
                scanner.nextLine();
                switch (scelta) {
                    case 1:
                        registraGestore();
                        break;
                    case 2:
                        loginGestore();
                        break;
                    case 3:
                        aggiungiFilm();
                        break;
                    case 4:
                        logoutGestore();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Errore: Inserire un numero valido.");
                scanner.nextLine();
            }
        }
    }

    private void registraCliente() {
        System.out.print("Inserisci username: ");
        String user = scanner.nextLine();
        System.out.print("Inserisci password: ");
        String pass = scanner.nextLine();
        clienti.add(new Cliente(user, pass, 50));
        System.out.println("Cliente registrato con successo.");
    }

    private void loginCliente() {
        System.out.print("Inserisci username: ");
        String user = scanner.nextLine();
        System.out.print("Inserisci password: ");
        String pass = scanner.nextLine();
        for (Cliente cliente : clienti) {
            if (cliente.login(user, pass)) {
                clienteLoggato = cliente;
                return;
            }
        }
        System.out.println("Cliente non trovato.");
    }

    private void prenotaBiglietto() {
        if (gestori.isEmpty()) {
            System.out.println("Nessun film disponibile.");
            return;
        }

        if (gestoreLoggato == null) {
            System.out.println("Nessun gestore loggato.");
            return;
        }
        GestoreCinema gestore = gestoreLoggato;
        ArrayList<SalaFilm> sale = gestore.getSale();

        if (sale.isEmpty()) {
            System.out.println("Nessun film disponibile.");
            return;
        }

        System.out.println("Film disponibili:");
        for (SalaFilm sala : sale) {
            sala.mostraDettagliFilm();
        }

        System.out.print("Inserisci il nome del film che vuoi prenotare: ");
        String nomeFilm = scanner.nextLine();

        SalaFilm salaScelta = null;
        for (SalaFilm sala : sale) {
            if (sala.getNomeFilm().equalsIgnoreCase(nomeFilm)) {
                salaScelta = sala;
                break;
            }
        }

        if (salaScelta == null) {
            System.out.println("Film non trovato.");
            return;
        }

        System.out.print("Quanti biglietti vuoi prenotare? ");
        int posti = scanner.nextInt();
        scanner.nextLine();

        if (clienteLoggato != null) {
            clienteLoggato.prenotaBiglietto(posti);
        } else {
            System.out.println("Nessun cliente loggato.");
        }
    }

    private void registraGestore() {
        System.out.print("Inserisci username: ");
        String user = scanner.nextLine();
        System.out.print("Inserisci password: ");
        String pass = scanner.nextLine();
        gestori.add(new GestoreCinema(user, pass));
        System.out.println("Gestore registrato con successo.");
    }

    private void loginGestore() {
        System.out.print("Inserisci username: ");
        String user = scanner.nextLine();
        System.out.print("Inserisci password: ");
        String pass = scanner.nextLine();
        for (GestoreCinema gestore : gestori) {
            if (gestore.login(user, pass)) {
                gestoreLoggato = gestore;
                return;
            }
        }
        System.out.println("Gestore non trovato.");
    }

    private void aggiungiFilm() {
        if (gestoreLoggato == null) {
            System.out.println("Nessun gestore loggato.");
            return;
        }

        System.out.print("Nome del film: ");
        String film = scanner.nextLine();
        System.out.print("Numero sala: ");
        int numSala = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Orario proiezione: ");
        String orario = scanner.nextLine();
        gestoreLoggato.aggiungiSalaFilm(new SalaFilm(100, numSala, film, orario));
    }

    private void logoutCliente() {
        if (clienteLoggato != null) {
            clienteLoggato.logout();
            clienteLoggato = null;
        } else {
            System.out.println("Nessun cliente loggato.");
        }
    }

    private void logoutGestore() {
        if (gestoreLoggato != null) {
            gestoreLoggato.logout();
            gestoreLoggato = null;
        } else {
            System.out.println("Nessun gestore loggato.");
        }
    }

    private void clear() throws InterruptedException {
        Thread.sleep(2500);
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}

class GestoreCinema extends Utente {
    private ArrayList<SalaFilm> sale;

    public GestoreCinema(String nomeUtente, String password) {
        super(nomeUtente, password);
        this.sale = new ArrayList<>();
    }

    public ArrayList<SalaFilm> getSale() {
        return sale;
    }

    public void setSale(ArrayList<SalaFilm> sale) {
        this.sale = sale;
    }

    public void aggiungiSalaFilm(SalaFilm sala) {
        sale.add(sala);
        System.out.println("Film aggiunto: \"" + sala.getNomeFilm() + "\" in Sala " + sala.getNumeroSala() + ", ore " + sala.getOrarioProiezione());
    }
}
class SalaFilm extends Sala {
    private String nomeFilm;
    private String orarioProiezione;

    public SalaFilm(int numeroPosti, int numeroSala, String nomeFilm, String orarioProiezione) {
        super(numeroPosti, numeroSala);
        this.nomeFilm = nomeFilm;
        this.orarioProiezione = orarioProiezione;
    }

    public String getNomeFilm() {
        return nomeFilm;
    }

    public void setNomeFilm(String nomeFilm) {
        this.nomeFilm = nomeFilm;
    }

    public String getOrarioProiezione() {
        return orarioProiezione;
    }

    public void setOrarioProiezione(String orarioProiezione) {
        this.orarioProiezione = orarioProiezione;
    }

    public void mostraDettagliFilm() {
        System.out.println("Film: " + nomeFilm + ", Orario: " + orarioProiezione + ", Sala: " + getNumeroSala());
    }
}
abstract class Sala {
    private int numeroPosti;
    private int numeroSala;

    public Sala(int numeroPosti, int numeroSala) {
        this.numeroPosti = numeroPosti;
        this.numeroSala = numeroSala;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }
}
class Cliente extends Utente {
    private int postiDisponibili;

    public Cliente(String nomeUtente, String password, int postiDisponibili) {
        super(nomeUtente, password);
        this.postiDisponibili = postiDisponibili;
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    public void setPostiDisponibili(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    public void prenotaBiglietto(int numeroPosti) {
        if (numeroPosti > 0 && numeroPosti <= postiDisponibili) {
            postiDisponibili -= numeroPosti;
            System.out.println("Prenotazione confermata. Posti rimanenti: " + postiDisponibili);
        } else {
            System.out.println("Prenotazione non riuscita. Posti insufficienti.");
        }
    }
}
abstract class Utente {
    private String nomeUtente;
    private String password;
    private boolean isLogged;

    public Utente(String nomeUtente, String password) {
        this.nomeUtente = nomeUtente;
        this.password = password;
        this.isLogged = false;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public boolean login(String nomeUtente, String password) {
        if (this.nomeUtente.equals(nomeUtente) && this.password.equals(password)) {
            isLogged = true;
            System.out.println("Login effettuato con successo.");
            return true;
        } else {
            System.out.println("Credenziali errate.");
            return false;
        }
    }

    public void logout() {
        if (isLogged) {
            isLogged = false;
            System.out.println("Logout effettuato con successo.");
        } else {
            System.out.println("L'utente non è loggato.");
        }
    }
}