package ilya;
/*Шебанов Илья Владимирович, ivshebanov@gmail.com, 2017 год*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Calculating {
    private double chanceMutation = 0.2D;//вероятность мутации
    private int maxCountPopulation = 200;//максимальное колличество популяций
    private int typeCross = 0;//тип скрещивания 0, 1, 2
    private int countIndivid; //колличество особей в популяции
    private int[][] tabl;
    private int countArc = 1;
    private int startIndex = 1;
    private int endIndex;
    private int numberPopulation = 0;
    private Chromos mainChromo;
    private List<Chromos> population = new ArrayList();
    private List<Chromos> selectedPopulation = new ArrayList();
    private List<Chromos> childPopulation = new ArrayList();
    private List<Chromos> newPopulation = new ArrayList();

    Calculating() {
        this(1, 5);
    }

    Calculating(int start, int end) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(new File("tabl")));
            ArrayList listStr = new ArrayList();
            while (true) {
                String temp = fileReader.readLine();
                if (temp == null || temp.equals("")) {
                    this.countIndivid = this.countArc + 1;
                    this.endIndex = this.countArc;
                    if (this.countArc < 3) {
                        System.out.println("Введена неверная таблица");
                        System.exit(0);
                    }
                    this.tabl = new int[this.countArc][this.countArc];
                    int j = 0;
                    int countSplit = 0;
                    for (Object aListStr : listStr) {
                        String s = (String) aListStr;
                        ++j;
                        String[] splitStr = s.split(" ");
                        int var10000 = splitStr.length;
                        ++countSplit;
                        if (var10000 != countSplit) {
                            System.out.println("Введена неверная таблица");
                            System.exit(0);
                        }
                        for (int i = 0; i < splitStr.length; ++i) {
                            String str = splitStr[i];
                            int graphInt;
                            try {
                                graphInt = Integer.parseInt(str);
                            } catch (NumberFormatException var15) {
                                graphInt = 10000;
                            }

                            this.tabl[j][i] = graphInt;
                            this.tabl[i][j] = graphInt;
                        }
                    }
                    break;
                }
                ++this.countArc;
                listStr.add(temp);
            }
        } catch (IOException var16) {
            var16.printStackTrace();
        }
        this.startIndex = start;
        this.endIndex = end;
        this.createPopulation();
        System.out.println("Шебанов Илья Владимирович, ivshebanov@gmail.com, 2017 год");
        System.out.println("---------------------------------------------------------");
        printTabl();
        System.out.println("---------------------------------------------------------");
    }

    private void printTabl() {
        StringBuilder strB = new StringBuilder();
        for (int[] aGraph : this.tabl) {
            for (int j = 0; j < this.tabl.length; ++j) {
                strB.append(aGraph[j]).append("\t");
            }
            strB.append("\n");
        }
        System.out.println(strB.toString());
    }

    private void createPopulation() {
        while (this.population.size() != this.countIndivid) {
            this.mainChromo = new Chromos(this.startIndex, this.endIndex, this.countArc);
            this.population.add(this.mainChromo);
        }
        this.clearRepeate(this.population);
        this.sort(this.population);
    }

    private void getStrAllPopulation(int key) {
        PrintStream var10000;
        int i;
        Object[] var10002;
        Iterator var3;
        Chromos chromos;
        switch (key) {
            case 0:
                i = 0;
                if (this.population.size() != 0) {
                    var3 = this.population.iterator();

                    while (var3.hasNext()) {
                        chromos = (Chromos) var3.next();
                        var10000 = System.out;
                        var10002 = new Object[3];
                        ++i;
                        var10002[0] = i;
                        var10002[1] = chromos.getStrChromosome();
                        var10002[2] = this.fitnessFunction(chromos);
                        var10000.printf("H%d: %s Вес --> %d%n", var10002);
                    }
                    return;
                } else {
                    System.out.println("Пустая популяция");
                    break;
                }
            case 1:
                i = 0;
                if (this.selectedPopulation.size() != 0) {
                    var3 = this.selectedPopulation.iterator();
                    while (var3.hasNext()) {
                        chromos = (Chromos) var3.next();
                        var10000 = System.out;
                        var10002 = new Object[3];
                        ++i;
                        var10002[0] = i;
                        var10002[1] = chromos.getStrChromosome();
                        var10002[2] = this.fitnessFunction(chromos);
//                        var10000.printf("H%d: %s Вес --> %d%n", var10002);
                    }
                    return;
                } else {
                    System.out.println("Пустая популяция");
                    break;
                }
            case 2:
                i = 0;
                if (this.childPopulation.size() != 0) {
                    var3 = this.childPopulation.iterator();
                    while (var3.hasNext()) {
                        chromos = (Chromos) var3.next();
                        var10000 = System.out;
                        var10002 = new Object[3];
                        ++i;
                        var10002[0] = i;
                        var10002[1] = chromos.getStrChromosome();
                        var10002[2] = this.fitnessFunction(chromos);
                        var10000.printf("H%d: %s Вес --> %d%n", var10002);
                    }
                    return;
                } else {
                    System.out.println("Пустая популяция");
                    break;
                }
            case 3:
                i = 0;
                if (this.newPopulation.size() != 0) {
                    var3 = this.newPopulation.iterator();

                    while (var3.hasNext()) {
                        chromos = (Chromos) var3.next();
                        var10000 = System.out;
                        var10002 = new Object[3];
                        ++i;
                        var10002[0] = i;
                        var10002[1] = chromos.getStrChromosome();
                        var10002[2] = this.fitnessFunction(chromos);
                        var10000.printf("H%d: %s Вес --> %d%n", var10002);
                    }
                } else {
                    System.out.println("Пустая популяция");
                }
        }
    }

    private int fitnessFunction(Chromos chromos) {
        int sum = 0;
        Integer[] arrayGens = chromos.getGens();
        for (int i = 0; i < arrayGens.length - 1; ++i) {
            sum += this.tabl[arrayGens[i] - 1][arrayGens[i + 1] - 1];
        }
        return sum;
    }

    private void selection() {
        int count = ThreadLocalRandom.current().nextInt(Math.abs(this.population.size() == this.countArc ? this.population.size() + 1 - this.countArc : this.population.size() - this.countArc)) + this.countArc;
        this.selectedPopulation.clear();
        this.selectedPopulation.addAll(this.population);
        int count2 = 0;
        for (Object m : this.population) {
            if (count2 < count) {
                ++count2;
            } else {
                this.selectedPopulation.remove(m);
            }
        }
        this.clearRepeate(this.selectedPopulation);
        this.sort(this.selectedPopulation);
        this.getStrAllPopulation(1);
    }

    private void crossing() {
        switch (this.typeCross) {
            case 1:
                this.crossingChromosome(2);
                break;
            case 2:
                this.crossingChromosome(3 + ThreadLocalRandom.current().nextInt(this.countArc - 3));
                break;
            default:
                this.crossingChromosome(1);
        }

    }

    private void crossingChromosome(int i) {
        if (this.selectedPopulation.size() != 0) {
            this.childPopulation.clear();
            List<Integer> listPoint = new ArrayList();
            int j = 0;
            int first;
            while (j < i) {
                first = ThreadLocalRandom.current().nextInt(this.countArc - 1);
                if (!listPoint.contains(first)) {
                    listPoint.add(first);
                    ++j;
                }
            }
            listPoint.add(this.countArc - 1);
            Collections.sort(listPoint);
            System.out.print("Точки скрещивания  --> ");

            for (Object integ : listPoint) {
                if ((Integer) integ != this.countArc - 1) {
                    System.out.print(integ + " ");
                }
            }
            System.out.println();
            first = 1;
            Iterator var20 = this.selectedPopulation.iterator();
            if (var20.hasNext()) {
                Chromos chromos1 = (Chromos) var20.next();
                Iterator var7 = this.selectedPopulation.iterator();
                label74:
                while (true) {
                    while (true) {
                        if (!var7.hasNext()) {
                            break label74;
                        }
                        Chromos chromos2 = (Chromos) var7.next();
                        if (first == 1) {
                            ++first;
                        } else {
                            Integer[] c1 = chromos1.getGens().clone();
                            Integer[] c2 = chromos2.getGens().clone();
                            Integer[] buff1 = new Integer[this.countArc];
                            Integer[] buff2 = new Integer[this.countArc];
                            int countEven = 1;
                            int endIndex = -1;
                            Iterator var16 = listPoint.iterator();
                            while (true) {
                                while (var16.hasNext()) {
                                    int intPoint = (Integer) var16.next();
                                    int startIndex = endIndex + 1;
                                    endIndex = intPoint;
                                    if (countEven % 2 != 0) {
                                        ++countEven;
                                    } else {
                                        ++countEven;
                                        for (int k = startIndex; k <= endIndex; ++k) {
                                            buff1[k] = c1[k];
                                            buff2[k] = c2[k];
                                        }
                                    }
                                }
                                for (int k = 0; k < this.countArc; ++k) {
                                    if (buff1[k] != null) {
                                        c2[k] = buff1[k];
                                    }
                                    if (buff2[k] != null) {
                                        c1[k] = buff2[k];
                                    }
                                }
                                this.mainChromo = new Chromos(this.startIndex, this.endIndex, c1);
                                this.childPopulation.add(this.mainChromo);
                                this.mainChromo = new Chromos(this.startIndex, this.endIndex, c2);
                                this.childPopulation.add(this.mainChromo);
                                break;
                            }
                        }
                    }
                }
            }
            this.clearRepeate(this.childPopulation);
            this.sort(this.childPopulation);
            System.out.println("Популяция детей: ");
            this.getStrAllPopulation(2);
            System.out.println();
        }
    }

    private void clearRepeate(List<Chromos> listCromo) {
        List<Chromos> deleteList = new ArrayList();
        for (int i = 0; i < listCromo.size(); ++i) {
            for (int j = 0; j < listCromo.size(); ++j) {
                if (i != j && ((Chromos) listCromo.get(i)).compare((Chromos) listCromo.get(j))) {
                    deleteList.add(listCromo.get(j));
                }
            }
            listCromo.removeAll(deleteList);
            deleteList.clear();
        }

    }

    private void reduction() {
        this.newPopulation.clear();
        this.newPopulation.addAll(this.population);
        this.newPopulation.addAll(this.childPopulation);
        this.clearRepeate(this.newPopulation);
        this.sort(this.newPopulation);
        int i = this.countIndivid;
        while (i < this.newPopulation.size()) {
            this.newPopulation.remove(i);
        }
        this.population.clear();
        this.population.addAll(this.newPopulation);
        while (this.population.size() < this.countIndivid) {
            this.population.add(new Chromos(this.startIndex, this.endIndex, (Integer[]) this.mainChromo.randomGens().clone()));
        }
        this.mutation(this.population);
        this.clearRepeate(this.population);
        this.sort(this.population);
        System.out.println("Новая популяция родителей: ");
        this.getStrAllPopulation(0);
        System.out.println();
    }

    private void sort(List<Chromos> listChrom) {
        listChrom.sort((o1, o2) -> {
            int chro1 = Calculating.this.fitnessFunction(o1);
            int chro2 = Calculating.this.fitnessFunction(o2);
            return chro1 - chro2;
        });
    }

    private void mutation(List<Chromos> listChrom) {
        for (Chromos aListChrom : listChrom) {
            if (ThreadLocalRandom.current().nextDouble() <= this.chanceMutation) {
                Integer[] copyGens = aListChrom.getGens();
                boolean checkMutation = false;
                while (!checkMutation) {
                    int mutationGen = ThreadLocalRandom.current().nextInt(1, this.countArc + 1);
                    int temp2 = ThreadLocalRandom.current().nextInt(1, this.countArc - 1);
                    if (copyGens[temp2] == mutationGen) {
                        checkMutation = false;
                    } else {
                        copyGens[temp2] = mutationGen;
                        checkMutation = true;
                    }
                }
            }
        }

    }

    public void setCountIndivid(int i) {
        this.countIndivid = i;
    }

    public void start(int countCicle) {
        for (int i = 0; i < countCicle; ++i) {
            if (this.numberPopulation == this.maxCountPopulation) {
                System.exit(0);
            }
            System.out.println("Поколение №" + ++this.numberPopulation);
            System.out.println("Начальная популяция: ");
            this.getStrAllPopulation(0);
            System.out.println();
            this.selection();
            this.crossing();
            this.reduction();
            System.out.println("Наилучшая особь в поколении №" + this.numberPopulation + ": " + this.population.get(0).getStrChromosome() + ". Вес --> " + this.fitnessFunction(this.population.get(0)));
        }
    }
}
