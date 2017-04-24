package my.rusystemres;

public class Main {

    public static void main(String[] args) {
        int catNumber;
        int zero;
        catNumber = 1;
        zero = 0;
        String[] catNanes = {"1", "2", "3"};
        try {
            int result = catNumber / zero;

        } catch (ArithmeticException ex) {
            System.out.println(ex.toString() + "На 0 делить нельзя");
            try {
                catNanes[3] = "12";
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.toString() + "выход за пределы массива");
            }
        } finally {
            System.out.println("finally");
        }
    }
}
