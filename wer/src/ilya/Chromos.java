package ilya;
/*Шебанов Илья Владимирович, ivshebanov@gmail.com, 2017 год*/

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Chromos {
    private int startGen;
    private int endGen;
    private Integer[] genArr;
    private Random random = new Random();

    private Chromos() {
    }

    Chromos(int start, int end, int count) {
        this.startGen = start;
        this.endGen = end;
        this.genArr = new Integer[count];
        this.genArr = this.randomGens().clone();
    }

    Chromos(int start, int end, Integer[] integers) {
        this.startGen = start;
        this.endGen = end;
        this.genArr = integers;
    }

    Integer[] getGens() {
        return this.genArr;
    }

    String getStrChromosome() {
        StringBuilder strB = new StringBuilder();
        Integer[] var2 = this.genArr;
        for (Integer aVar2 : var2) {
            int i = aVar2;
            strB.append(i).append(" ");
        }
        return strB.toString();
    }

    boolean compare(Chromos chromos) {
        Integer[] chromo1 = this.genArr.clone();
        Integer[] chromo2 = chromos.getGens().clone();
        for (int i = 0; i < chromo1.length; ++i) {
            if (chromo1[i].intValue() != chromo2[i].intValue()) {
                return false;
            }
        }
        return true;
    }

    Integer[] randomGens() {
        Integer[] tempGens = new Integer[this.genArr.length];
        tempGens[0] = this.startGen;
        tempGens[tempGens.length - 1] = this.endGen;
        int i = 1;
        while (i < tempGens.length - 1) {
            int number = this.random.nextInt(tempGens.length) + 1;
            List<Integer> list = Arrays.asList(tempGens);
            if (!list.contains(number)) {
                tempGens[i] = number;
                ++i;
            }
        }
        return tempGens;
    }
}
