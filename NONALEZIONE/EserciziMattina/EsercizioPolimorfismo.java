package NONALEZIONE.EserciziMattina;

class Persona{
    String nome;
    int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public void saluta(){
        System.out.println("Ciao, sono " + nome + " e ho " + eta + " anni.");
    }
}

class Pirata extends Persona{

    String nomePirata;

    public Pirata(String nome, int eta, String nomePirata) {
        super(nome, eta);
        this.nomePirata = nomePirata;
    }

    public void saluta() {
        System.out.println("Ahoy, sono " + nomePirata + " e ho " + eta + " anni.");
    }
}

public class EsercizioPolimorfismo {
    public static void main(String[] args) {
        
        Persona persona = new Persona("Mario", 30);
        Persona persona2 = new Persona ("Luca", 25);
        Pirata pirata = new Pirata("Mario", 30, "Capitan Uncino");

        persona.saluta();
        persona2.saluta();
        pirata.saluta();
    }
}
