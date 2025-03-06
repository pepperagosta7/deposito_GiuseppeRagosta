package NONALEZIONE.EserciziPomeriggio.SubFolderEsercizio;

import NONALEZIONE.EserciziPomeriggio.SubFolderEsercizio.Interfaces.*;

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
    private String dataScadenza;

    public ProdottoAlimentare(String codice, String nome, double prezzo, String dataScadenza) {
        super(codice, nome, prezzo);
        this.dataScadenza = dataScadenza;
    }

    public boolean isInScadenza() {
        // Semplificazione: considera in scadenza se la data contiene "2023"
        return dataScadenza.contains("2023");
    }

    public double calcolaSconto() {
        return isInScadenza() ? prezzo * 0.20 : 0;
    }

    @Override
    public String getDettagli() {
        return "Prodotto Alimentare: " + nome + ", Scadenza: " + dataScadenza;
    }
}

// Classe derivata per prodotti elettronici
class ProdottoElettronico extends Prodotto implements IGarantibile {
    private int garanziaMesi;
    private String dataAcquisto;

    public ProdottoElettronico(String codice, String nome, double prezzo, int garanziaMesi, String dataAcquisto) {
        super(codice, nome, prezzo);
        this.garanziaMesi = garanziaMesi;
        this.dataAcquisto = dataAcquisto;
    }

    public boolean isInGaranzia() {
        // Semplificazione: considera in garanzia se la data contiene "2023"
        return dataAcquisto.contains("2023");
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
    private String dataAcquisto;

    public ProdottoAbbigliamento(String codice, String nome, double prezzo, String taglia, String materiale, String dataAcquisto) {
        super(codice, nome, prezzo);
        this.taglia = taglia;
        this.materiale = materiale;
        this.dataAcquisto = dataAcquisto;
    }

    public boolean isRestituibile() {
        // Semplificazione: considera restituibile se la data contiene "2023"
        return dataAcquisto.contains("2023");
    }

    @Override
    public String getDettagli() {
        return "Prodotto Abbigliamento: " + nome + ", Taglia: " + taglia + ", Materiale: " + materiale;
    }
}