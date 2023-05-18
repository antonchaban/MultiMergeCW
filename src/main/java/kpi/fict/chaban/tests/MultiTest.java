package kpi.fict.chaban.tests;

import kpi.fict.chaban.parallel.ParallelMergeSorter;
import kpi.fict.chaban.sequential.SeqMergeSorter;
import kpi.fict.chaban.tools.ArrayTools;

import java.util.concurrent.ForkJoinPool;

public class MultiTest {
    public static void main(String[] args) {
        compareSpeed();
    }

    public static void compareSpeed() {
        var SIZES = new int[]{25_000, 50_000, 100_000, 500_000, 1_000_000, 5_000_000, 10_000_000, 15_000_000, 20_000_000
                , 30_000_000, 50_000_000, 100_000_000};
        for (int size : SIZES) {
            compareSpeed(size);
        }
    }

    private static void compareSpeed(int size) {
        var arrayGenerator = new ArrayTools(size);
        var arraySeq = arrayGenerator.generate();
        var arrayPar = new int[arraySeq.length];
        System.arraycopy(arraySeq, 0, arrayPar, 0, arraySeq.length);

        System.out.println("########");
        var start = System.currentTimeMillis();
        var seqCalc = new SeqMergeSorter();
        seqCalc.mergeSort(arraySeq);
        System.out.println("Time taken seq: " + (System.currentTimeMillis() - start) + " ms, for size " + size);
        start = System.currentTimeMillis();
        var fjPool = new ForkJoinPool(16);
        fjPool.invoke(new ParallelMergeSorter(arrayPar));
        System.out.println("Time taken par: " + (System.currentTimeMillis() - start) + " ms, for size " + size
                + " with " + fjPool.getParallelism() + " threads");
    }

}
