package kpi.fict.chaban;

import kpi.fict.chaban.parallel.ParallelMergeSorter;
import kpi.fict.chaban.sequential.SeqMergeSorter;
import kpi.fict.chaban.tools.ArrayGenerator;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        var arrayGenerator = new ArrayGenerator(30_000_000);
        var array = arrayGenerator.generate();
        var array2 = new int[array.length];
        System.arraycopy(array, 0, array2, 0, array.length);

/*        ArrayPrinter.printArray(array);
        System.out.println("\n");
        ArrayPrinter.printArray(array2);*/

        System.out.println();
        System.out.println("########");
        var start = System.currentTimeMillis();
        var seqCalc = new SeqMergeSorter();
        seqCalc.mergeSort(array);
//        ArrayPrinter.printArray(array);
        System.out.println("Time taken seq: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        var fjPool = ForkJoinPool.commonPool();
        fjPool.invoke(new ParallelMergeSorter(array2));
        System.out.println("Time taken par: " + (System.currentTimeMillis() - start));
        System.out.println(ArrayGenerator.isSorted(array));
        System.out.println(ArrayGenerator.isSorted(array2));

    }
}