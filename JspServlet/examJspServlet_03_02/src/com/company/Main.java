package com.company;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[12];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 31) - 15);
            System.out.print(array[i] + ", ");
        }
        int sum = 0;
        for (int anArray : array) {
            sum += anArray;
        }
        System.out.println();
        System.out.println(sum);
    }
}
