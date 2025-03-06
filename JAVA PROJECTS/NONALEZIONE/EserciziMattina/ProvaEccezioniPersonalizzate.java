package NONALEZIONE.EserciziMattina;

public class ProvaEccezioniPersonalizzate extends Exception{
    public ProvaEccezioniPersonalizzate(String message){
        super(message);
    }

    public static void main(String[] args) {
        try {
            throw new ProvaEccezioniPersonalizzate("Eccezione personalizzata");
        } catch (ProvaEccezioniPersonalizzate e) {
            System.out.println("Eccezione catturata: " + e.getMessage());
        }
    }
}
