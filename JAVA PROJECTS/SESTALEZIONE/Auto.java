package SESTALEZIONE;

public class Auto {
    
    public String modello;
    public String colore;
    public int velocità;

    //Costruttore
    public Auto(String modello, String colore) {
        this.modello = modello;
        this.colore = colore;
        this.velocità = 0; //Velocità iniziale
    }

    //Metodo per accelerare
    public void accelera(int incremento){
        velocità += incremento;
        System.out.println("L'auto " + modello + " ha accelerato. Velocità attuale: " + velocità + " km/h");
    }

    //Metodo per frenare
    public void frena(int decremento){
        velocità -= decremento;
        if (velocità < 0) {
            velocità = 0;
        }
        System.out.println("L'auto " + modello + " ha frenato. Velocità attuale: " + velocità + " km/h");
    }
}
