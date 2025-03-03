package SESTALEZIONE;

public class TestAuto {
    
    public static void main(String[] args){

        //Creazione di un oggetto della classe Auto
        Auto auto = new Auto("Ferrari", "Rosso");

        //Utilizzo dei metodi della classe Auto
        System.out.println("Modello: " + auto.modello);
        System.out.println("Colore: " + auto.colore);

        auto.accelera(50);
        auto.accelera(20);  
        auto.frena(30);
        auto.frena(50);

    }
}
