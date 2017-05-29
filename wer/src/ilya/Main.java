package ilya;
/*Шебанов Илья Владимирович, ivshebanov@gmail.com, 2017 год*/
public class Main {

    public static void main(String[] args) {
        Calculating calculating = new Calculating(1, 5);
        System.out.println("Шебанов Илья Владимирович, ivshebanov@gmail.com, 2017 год");
        calculating.printTabl();
        System.out.println("__________________________________________________________");
        calculating.start(1);
    }
}
