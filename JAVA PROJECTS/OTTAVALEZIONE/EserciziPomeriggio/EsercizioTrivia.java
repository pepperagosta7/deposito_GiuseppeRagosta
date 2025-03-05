package OTTAVALEZIONE.EserciziPomeriggio;

class Adulto {
    private String nome;
    private Figlio figlio1;
    private Figlio figlio2;

    public Adulto(String nome, String nomeFiglio1, int etaFiglio1, String nomeFiglio2, int etaFiglio2) {
        this.nome = nome;
        this.figlio1 = new Figlio(nomeFiglio1, etaFiglio1);
        this.figlio2 = new Figlio(nomeFiglio2, etaFiglio2);
    }

    public void stampaFamiglia() {
        System.out.println("Genitore: " + nome);
        System.out.println(figlio1);
        System.out.println(figlio2);
    }

    class Figlio {
        private String nome;
        private int eta;

        public Figlio(String nome, int eta) {
            this.nome = nome;
            this.eta = eta;
        }

        public int getEta() {
            return eta;
        }

        @Override
        public String toString() {
            return "Figlio: " + nome + ", Eta: " + eta;
        }
    }
}

public class EsercizioTrivia {
    public static void main(String[] args) {
        Adulto genitore1 = new Adulto("Luca", "Marco", 10, "Giulia", 8);
        Adulto genitore2 = new Adulto("Maria", "Anna", 12, "Paolo", 6);

        System.out.println("Famiglia 1:");
        genitore1.stampaFamiglia();
        
        System.out.println("\nFamiglia 2:");
        genitore2.stampaFamiglia();
    }
}
