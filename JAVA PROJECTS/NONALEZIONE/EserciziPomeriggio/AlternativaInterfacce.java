package NONALEZIONE.EserciziPomeriggio;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.text.ParseException;

// Interfaccia generale IProdotto
interface IProdotto {
    double getPrezzo();
    String getDettagli();
}

// Interfacce specifiche per comportamenti extra
interface IScontabile {
    boolean isInScadenza();
    double calcolaSconto();
}

interface IGarantibile {
    boolean isInGaranzia();
}

interface IRestituibile {
    boolean puoEssereRestituito();
}

// Classe base Prodotto
abstract class Prodotto implements IProdotto {
    protected String codice;
    protected String nome;
    protected double prezzo;

    public Prodotto(String codice, String nome, double prezzo) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public abstract String getDettagli();
}

// Classe derivata per prodotti alimentari
class ProdottoAlimentare extends Prodotto implements IScontabile {
    private Date dataScadenza;

    public ProdottoAlimentare(String codice, String nome, double prezzo, String dataScadenza) throws ParseException {
        super(codice, nome, prezzo);
        this.dataScadenza = new SimpleDateFormat("yyyy-MM-dd").parse(dataScadenza);
    }

    public boolean isInScadenza() {
        Calendar oggi = Calendar.getInstance();
        Calendar scadenza = Calendar.getInstance();
        scadenza.setTime(dataScadenza);
        long diff = (scadenza.getTimeInMillis() - oggi.getTimeInMillis()) / (1000 * 60 * 60 * 24);
        return diff <= 7;
    }

    public double calcolaSconto() {
        return isInScadenza() ? prezzo * 0.20 : 0;
    }

    @Override
    public String getDettagli() {
        return "Prodotto Alimentare: " + nome + ", Scadenza: " + new SimpleDateFormat("yyyy-MM-dd").format(dataScadenza);
    }
}

// Classe derivata per prodotti elettronici
class ProdottoElettronico extends Prodotto implements IGarantibile {
    private int garanziaMesi;
    private Date dataAcquisto;

    public ProdottoElettronico(String codice, String nome, double prezzo, int garanziaMesi, String dataAcquisto) throws ParseException {
        super(codice, nome, prezzo);
        this.garanziaMesi = garanziaMesi;
        this.dataAcquisto = new SimpleDateFormat("yyyy-MM-dd").parse(dataAcquisto);
    }

    public boolean isInGaranzia() {
        Calendar scadenzaGaranzia = Calendar.getInstance();
        scadenzaGaranzia.setTime(dataAcquisto);
        scadenzaGaranzia.add(Calendar.MONTH, garanziaMesi);
        return new Date().before(scadenzaGaranzia.getTime());
    }

    @Override
    public String getDettagli() {
        return "Prodotto Elettronico: " + nome + ", Garanzia: " + garanziaMesi + " mesi";
    }
}

// Classe derivata per prodotti di abbigliamento
class ProdottoAbbigliamento extends Prodotto implements IRestituibile {
    private String taglia;
    private String materiale;
    private Date dataAcquisto;

    public ProdottoAbbigliamento(String codice, String nome, double prezzo, String taglia, String materiale, String dataAcquisto) throws ParseException {
        super(codice, nome, prezzo);
        this.taglia = taglia;
        this.materiale = materiale;
        this.dataAcquisto = new SimpleDateFormat("yyyy-MM-dd").parse(dataAcquisto);
    }

    public boolean puoEssereRestituito() {
        Calendar scadenzaReso = Calendar.getInstance();
        scadenzaReso.setTime(dataAcquisto);
        scadenzaReso.add(Calendar.DAY_OF_MONTH, 30);
        return new Date().before(scadenzaReso.getTime());
    }

    @Override
    public String getDettagli() {
        return "Prodotto Abbigliamento: " + nome + ", Taglia: " + taglia + ", Materiale: " + materiale;
    }
}

// Classe principale con menu
public class AlternativaInterfacce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Aggiungi un prodotto alimentare");
            System.out.println("2. Aggiungi un prodotto elettronico");
            System.out.println("3. Aggiungi un prodotto di abbigliamento");
            System.out.println("4. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (scelta) {
                    case 1:
                        System.out.print("Inserisci codice: ");
                        String codiceA = scanner.nextLine();
                        System.out.print("Inserisci nome: ");
                        String nomeA = scanner.nextLine();
                        System.out.print("Inserisci prezzo: ");
                        double prezzoA = scanner.nextDouble();
                        scanner.nextLine(); // Consuma il newline rimasto nel buffer
                        System.out.print("Inserisci data di scadenza (yyyy-MM-dd): ");
                        String scadenzaA = scanner.nextLine();
                        ProdottoAlimentare pa = new ProdottoAlimentare(codiceA, nomeA, prezzoA, scadenzaA);
                        System.out.println(pa.getDettagli());
                        if (pa.isInScadenza()) {
                            System.out.println("Il prodotto è in scadenza. Sconto applicabile: " + pa.calcolaSconto());
                        }
                        break;

                    case 2:
                        System.out.print("Inserisci codice: ");
                        String codiceE = scanner.nextLine();
                        System.out.print("Inserisci nome: ");
                        String nomeE = scanner.nextLine();
                        System.out.print("Inserisci prezzo: ");
                        double prezzoE = scanner.nextDouble();
                        System.out.print("Inserisci garanzia in mesi: ");
                        int garanziaE = scanner.nextInt();
                        scanner.nextLine(); // Consuma il newline rimasto nel buffer
                        System.out.print("Inserisci data di acquisto (yyyy-MM-dd): ");
                        String dataAcquistoE = scanner.nextLine();
                        ProdottoElettronico pe = new ProdottoElettronico(codiceE, nomeE, prezzoE, garanziaE, dataAcquistoE);
                        System.out.println(pe.getDettagli());
                        if (pe.isInGaranzia()) {
                            System.out.println("Il prodotto è ancora in garanzia.");
                        } else {
                            System.out.println("Il prodotto non è più in garanzia.");
                        }
                        break;

                    case 3:
                        System.out.print("Inserisci codice: ");
                        String codiceAb = scanner.nextLine();
                        System.out.print("Inserisci nome: ");
                        String nomeAb = scanner.nextLine();
                        System.out.print("Inserisci prezzo: ");
                        double prezzoAb = scanner.nextDouble();
                        scanner.nextLine(); // Consuma il newline rimasto nel buffer
                        System.out.print("Inserisci taglia: ");
                        String taglia = scanner.nextLine();
                        System.out.print("Inserisci materiale: ");
                        String materiale = scanner.nextLine();
                        System.out.print("Inserisci data di acquisto (yyyy-MM-dd): ");
                        String dataAcquistoAb = scanner.nextLine();
                        ProdottoAbbigliamento pab = new ProdottoAbbigliamento(codiceAb, nomeAb, prezzoAb, taglia, materiale, dataAcquistoAb);
                        System.out.println(pab.getDettagli());
                        if (pab.puoEssereRestituito()) {
                            System.out.println("Il prodotto può essere restituito.");
                        } else {
                            System.out.println("Il periodo di restituzione è scaduto.");
                        }
                        break;

                    case 4:
                        exit = true;
                        break;

                    default:
                        System.out.println("Scelta non valida. Riprova.");
                }
            } catch (ParseException e) {
                System.out.println("Errore nel formato della data. Usa il formato yyyy-MM-dd.");
            } catch (Exception e) {
                System.out.println("Errore nell'inserimento dei dati.");
            }
        }
        scanner.close();
    }
}