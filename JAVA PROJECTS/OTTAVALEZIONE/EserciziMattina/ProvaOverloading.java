package OTTAVALEZIONE.EserciziMattina;

public class ProvaOverloading {
    
    public int add (int a, int b){
        return a+b;
    }

    public int add (int a, int b, int c){
        return a+b+c;
    }

    public double add (double a, double b){
        return a+b;
    }

    public static void main(String[] args) {
        ProvaOverloading obj = new ProvaOverloading();

        System.out.println(obj.add(10, 20));
        System.out.println(obj.add(10, 20, 30));
        System.out.println(obj.add(10.5, 20.5));
    }
}
