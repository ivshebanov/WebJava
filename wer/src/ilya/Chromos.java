package ilya;
/*Шебанов Илья Владимирович, ivshebanov@gmail.com, 2017 год*/
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Chromos {
    private int startGen;
    private int endGen;
    private Integer[] gens;
    private Random r = new Random();

    private Chromos() {
    }

    protected Chromos(int start, int end, int count) {
        this.startGen = start;
        this.endGen = end;
        this.gens = new Integer[count];
        this.init();
    }

    protected Chromos(int start, int end, Integer[] integers) {
        this.startGen = start;
        this.endGen = end;
        this.gens = integers;
    }

    private void init() {
        this.gens = (Integer[]) this.randomGens().clone();
    }

    protected Integer[] randomGens() {
        Integer[] tempGens = new Integer[this.gens.length];
        tempGens[0] = Integer.valueOf(this.startGen);
        tempGens[tempGens.length - 1] = Integer.valueOf(this.endGen);
        int i = 1;

        while (i < tempGens.length - 1) {
            int number = this.r.nextInt(tempGens.length) + 1;
            List<Integer> list = Arrays.asList(tempGens);
            if (!list.contains(Integer.valueOf(number))) {
                tempGens[i] = Integer.valueOf(number);
                ++i;
            }
        }
        return tempGens;
    }

    protected Integer[] getGens() {
        return this.gens;
    }

    protected String getStrChromosome() {
        StringBuilder strB = new StringBuilder();
        Integer[] var2 = this.gens;
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            int i = var2[var4].intValue();
            strB.append(i).append(" ");
        }

        return strB.toString();
    }

    protected boolean compare(Chromos chromos) {
        Integer[] chromo1 = (Integer[]) this.gens.clone();
        Integer[] chromo2 = (Integer[]) chromos.getGens().clone();

        for (int i = 0; i < chromo1.length; ++i) {
            if (chromo1[i].intValue() != chromo2[i].intValue()) {
                return false;
            }
        }

        return true;
    }
}
