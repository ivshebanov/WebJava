package a.b.c.d;

import a.b.Dog;

/**
 * Created by iliashebanov on 04.03.17.
 */

public class Spaniel implements Dog {
    String color;
    int size;
    int weight;

    public void gav() {
        System.out.println("гав-гав-гав");
    }

    @Override
    public void sleep() {
        System.out.println("собака спит");
    }

}
