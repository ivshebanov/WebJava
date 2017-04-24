package my.rusystemres;

public class Main {


    public static void main(String[] args) {
        class Dog {
            private int summa;

            <T extends Number> void sum(T a) {
                for (int i = 0; i <= a.intValue(); i++) {
                    summa = summa + i;
                }
            }

            int getSumma() {
                return summa;
            }
        }
        Dog dog = new Dog();
        dog.sum(4);
        dog.sum(4.);
        dog.sum(4L);
        System.out.println("Сумма чисел " + dog.getSumma());
    }
}
