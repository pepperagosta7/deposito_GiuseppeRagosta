package OTTAVALEZIONE.EserciziPomeriggio;

class InnerClass {
    int x = 10;
    class Classedentro{
        int y = 5;
        public class Main2{
            public static void main(String[] args) {
                InnerClass innerClass = new InnerClass();
                InnerClass.Classedentro classedentro = innerClass.new Classedentro();
                System.out.println(innerClass.x);
                System.out.println(classedentro.y);
            }
        }
    }
}
