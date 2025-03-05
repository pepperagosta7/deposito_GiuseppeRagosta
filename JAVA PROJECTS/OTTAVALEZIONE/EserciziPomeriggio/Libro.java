package OTTAVALEZIONE.EserciziPomeriggio;

public class Libro {

    private String titolo;
    private String autore;
    private int copieDisponibili;
    private int copieInPrestito;

    public Libro(String titolo, String autore, int copieDisponibili) {
        this.titolo = titolo;
        this.autore = autore;
        this.copieDisponibili = copieDisponibili;
        this.copieInPrestito = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getCopieDisponibili() {
        return copieDisponibili;
    }

    public int getCopieInPrestito() {
        return copieInPrestito;
    }

    public void aggiungiCopie(int copie) {
        this.copieDisponibili += copie;
    }

    public void prestaCopia() {
        if (copieDisponibili > 0) {
            copieDisponibili--;
            copieInPrestito++;
        }
    }

    public void restituisciCopia() {
        if (copieInPrestito > 0) {
            copieDisponibili++;
            copieInPrestito--;
        }
    }

    @Override
    public String toString() {
        return titolo + " di " + autore + " Disponibili: " + copieDisponibili + ", In prestito: " + copieInPrestito;
    }
}