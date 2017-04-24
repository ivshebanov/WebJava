package my.rusystemres;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add("Васька");
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.toString());
        }
        System.out.println(arrayList.get(1));
    }
}

