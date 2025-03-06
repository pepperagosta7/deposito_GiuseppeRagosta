package NONALEZIONE.EserciziPomeriggio;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Veicolo {
    String marca; // Marca del veicolo
    String modello; // Modello del veicolo
    int anno; // Anno di produzione del veicolo

    public Veicolo(String marca, String modello, int anno) {
        this.marca = marca; // Inizializza la marca del veicolo
        this.modello = modello; // Inizializza il modello del veicolo
        this.anno = anno; // Inizializza l'anno di produzione del veicolo
    }

    public int getAnno() {
        return anno; // Restituisce l'anno di produzione del veicolo
    }

    public abstract void mostraDettagli(); // Metodo astratto per mostrare i dettagli del veicolo
}

class Automobile extends Veicolo {
    private int numeroPorte; // Numero di porte dell'automobile
    private String carburante; // Tipo di carburante dell'automobile

    public Automobile(String marca, String modello, int anno, int numeroPorte, String carburante) {
        super(marca, modello, anno); // Chiama il costruttore della classe base Veicolo
        this.numeroPorte = numeroPorte; // Inizializza il numero di porte dell'automobile
        this.carburante = carburante; // Inizializza il tipo di carburante dell'automobile
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Marca: " + marca);
        System.out.println("Modello: " + modello);
        System.out.println("Anno: " + anno);
        System.out.println("Numero porte: " + numeroPorte);
        System.out.println("Carburante: " + carburante);
    }
}

class Moto extends Veicolo {
    private String tipologia; // Tipologia della moto
    private int cilindrata; // Cilindrata della moto

    public Moto(String marca, String modello, int anno, String tipologia, int cilindrata) {
        super(marca, modello, anno); // Chiama il costruttore della classe base Veicolo
        this.tipologia = tipologia; // Inizializza la tipologia della moto
        this.cilindrata = cilindrata; // Inizializza la cilindrata della moto
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Marca: " + marca);
        System.out.println("Modello: " + modello);
        System.out.println("Anno: " + anno);
        System.out.println("Tipologia: " + tipologia);
        System.out.println("Cilindrata: " + cilindrata);
    }
}

class Camion extends Veicolo {
    private double kili; // Tonnellate di carico del camion
    private int assi; // Numero di assi del camion

    public Camion(String marca, String modello, int anno, double kili, int assi) {
        super(marca, modello, anno); // Chiama il costruttore della classe base Veicolo
        this.kili = kili; // Inizializza le tonnellate di carico del camion
        this.assi = assi; // Inizializza il numero di assi del camion
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Marca: " + marca);
        System.out.println("Modello: " + modello);
        System.out.println("Anno: " + anno);
        System.out.println("Tonnellate carico: " + kili);
        System.out.println("Assi: " + assi);
    }
}

class GestoreVeicoli {
    private ArrayList<Veicolo> veicoli; // Lista dei veicoli gestiti

    public GestoreVeicoli() {
        this.veicoli = new ArrayList<>(); // Inizializza la lista dei veicoli
    }

    public void aggiungiVeicolo(Veicolo veicolo) {
        veicoli.add(veicolo); // Aggiunge un veicolo alla lista
        System.out.println("Veicolo aggiunto: " + veicolo.getClass().getSimpleName());
    }

    public void mostraDettagliVeicoli() {
        if (veicoli.isEmpty()) {
            System.out.println("Nessun veicolo presente.");
        } else {
            System.out.println("Dettagli dei veicoli presenti:");
            for (Veicolo veicolo : veicoli) {
                veicolo.mostraDettagli(); // Mostra i dettagli di ogni veicolo
                System.out.println();
            }
        }
    }

    public Veicolo trovaVeicoloPiuVecchio() {
        if (veicoli.isEmpty()) {
            return null;
        }
        Veicolo veicoloPiuVecchio = veicoli.get(0); // Assume che il primo veicolo sia il più vecchio
        for (Veicolo veicolo : veicoli) {
            if (veicolo.getAnno() < veicoloPiuVecchio.getAnno()) {
                veicoloPiuVecchio = veicolo; // Aggiorna il veicolo più vecchio se trova un veicolo con anno inferiore
            }
        }
        return veicoloPiuVecchio; // Restituisce il veicolo più vecchio
    }
}

class OpVeicoli {
    private Scanner scanner; // Scanner per leggere l'input dell'utente
    private GestoreVeicoli gestoreVeicoli; // Gestore dei veicoli

    public OpVeicoli(Scanner scanner, GestoreVeicoli gestoreVeicoli) {
        this.scanner = scanner; // Inizializza lo scanner
        this.gestoreVeicoli = gestoreVeicoli; // Inizializza il gestore dei veicoli
    }

    public void configuraAutomobile() {
        System.out.println("Inserisci la marca: ");
        String marca = scanner.nextLine(); // Legge la marca dell'automobile
        System.out.println("Inserisci il modello: ");
        String modello = scanner.nextLine(); // Legge il modello dell'automobile
        System.out.println("Inserisci l'anno: ");
        int anno = scanner.nextInt(); // Legge l'anno dell'automobile
        scanner.nextLine(); // Consuma il newline rimasto nel buffer
        System.out.println("Inserisci il numero di porte: ");
        int numeroPorte = scanner.nextInt(); // Legge il numero di porte dell'automobile
        scanner.nextLine(); // Consuma il newline rimasto nel buffer
        System.out.println("Inserisci il carburante: ");
        String carburante = scanner.nextLine(); // Legge il tipo di carburante dell'automobile
        Veicolo automobile = new Automobile(marca, modello, anno, numeroPorte, carburante); // Crea un nuovo oggetto Automobile
        gestoreVeicoli.aggiungiVeicolo(automobile); // Aggiunge l'automobile al gestore dei veicoli
    }

    public void configuraMoto() {
        System.out.println("Inserisci la marca: ");
        String marca = scanner.nextLine(); // Legge la marca della moto
        System.out.println("Inserisci il modello: ");
        String modello = scanner.nextLine(); // Legge il modello della moto
        System.out.println("Inserisci l'anno: ");
        int anno = scanner.nextInt(); // Legge l'anno della moto
        scanner.nextLine(); // Consuma il newline rimasto nel buffer
        System.out.println("Inserisci la tipologia: ");
        String tipologia = scanner.nextLine(); // Legge la tipologia della moto
        System.out.println("Inserisci la cilindrata: ");
        int cilindrata = scanner.nextInt(); // Legge la cilindrata della moto
        scanner.nextLine(); // Consuma il newline rimasto nel buffer
        Veicolo moto = new Moto(marca, modello, anno, tipologia, cilindrata); // Crea un nuovo oggetto Moto
        gestoreVeicoli.aggiungiVeicolo(moto); // Aggiunge la moto al gestore dei veicoli
    }

    public void configuraCamion() {
        System.out.println("Inserisci la marca: ");
        String marca = scanner.nextLine(); // Legge la marca del camion
        System.out.println("Inserisci il modello: ");
        String modello = scanner.nextLine(); // Legge il modello del camion
        System.out.println("Inserisci l'anno: ");
        int anno = scanner.nextInt(); // Legge l'anno del camion
        scanner.nextLine(); // Consuma il newline rimasto nel buffer
        System.out.println("Inserisci le tonnellate di carico: ");
        double kili = scanner.nextDouble(); // Legge le tonnellate di carico del camion
        scanner.nextLine(); // Consuma il newline rimasto nel buffer
        System.out.println("Inserisci il numero di assi: ");
        int assi = scanner.nextInt(); // Legge il numero di assi del camion
        scanner.nextLine(); // Consuma il newline rimasto nel buffer
        Veicolo camion = new Camion(marca, modello, anno, kili, assi); // Crea un nuovo oggetto Camion
        gestoreVeicoli.aggiungiVeicolo(camion); // Aggiunge il camion al gestore dei veicoli
    }

    public void ricercaVeicolo() {
        Veicolo veicoloPiuVecchio = gestoreVeicoli.trovaVeicoloPiuVecchio(); // Trova il veicolo più vecchio
        if (veicoloPiuVecchio != null) {
            System.out.println("Il veicolo più vecchio è:");
            veicoloPiuVecchio.mostraDettagli(); // Mostra i dettagli del veicolo più vecchio
        } else {
            System.out.println("Nessun veicolo presente.");
        }
    }
}

public class EsercizioAstrazione {
    static Scanner scanner = new Scanner(System.in); // Scanner per leggere l'input dell'utente
    static GestoreVeicoli gestoreVeicoli = new GestoreVeicoli(); // Crea un nuovo gestore dei veicoli
    static OpVeicoli operazione = new OpVeicoli(scanner, gestoreVeicoli); // Crea un nuovo oggetto OpVeicoli

    public static void main(String[] args) {
        boolean flag = true;

        while (flag) { // Ciclo infinito per il menu
            System.out.println("Scegli un'opzione: ");
            System.out.println("1. Configura Automobile");
            System.out.println("2. Configura Moto");
            System.out.println("3. Configura Camion");
            System.out.println("4. Mostra Dettagli Veicoli");
            System.out.println("5. Trova Veicolo più Vecchio");
            System.out.println("6. Esci");
            int scelta = scanner.nextInt(); // Legge la scelta dell'utente
            scanner.nextLine(); // Consuma il newline rimasto nel buffer

            switch (scelta) { // Gestione delle scelte dell'utente
                case 1:
                    operazione.configuraAutomobile(); // Configura un'automobile
                    break;
                case 2:
                    operazione.configuraMoto(); // Configura una moto
                    break;
                case 3:
                    operazione.configuraCamion(); // Configura un camion
                    break;
                case 4:
                    gestoreVeicoli.mostraDettagliVeicoli(); // Mostra i dettagli dei veicoli
                    break;
                case 5:
                    operazione.ricercaVeicolo(); // Trova il veicolo più vecchio
                    break;
                case 6:
                    System.out.println("Arrivederci!");
                    flag = false; // Esce dal ciclo
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}