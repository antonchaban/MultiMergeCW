package kpi.fict.chaban.tests.sequential;

import kpi.fict.chaban.sequential.SeqMergeSorter;
import kpi.fict.chaban.tools.ArrayTools;

public class SeqTest {
    public static void main(String[] args) {
//        checkCorrectness();
        measureTime();
    }

    public static void checkCorrectness() {
        var arrayGenerator = new ArrayTools(100);
        var array = arrayGenerator.generate();
        System.out.println("Array to sort:");
        ArrayTools.printArray(array);
        System.out.println("#######");
        var seqCalc = new SeqMergeSorter();
        seqCalc.mergeSort(array);
        ArrayTools.printArray(array);
        if (!ArrayTools.isSorted(array))
            System.err.println("Array not sorted");
        else System.out.println("Array is sorted");
    }

    public static void measureTime(){
        var SIZES = new int[]{25_000, 50_000, 100_000, 500_000, 1_000_000, 5_000_000, 10_000_000, 15_000_000, 20_000_000
                , 30_000_000, 50_000_000, 100_000_000, 150_000_000};
        for (int size : SIZES) {
            checkTime(size);
        }
    }

    private static void checkTime(int size) {
        var arrayGenerator = new ArrayTools(size);
        var array = arrayGenerator.generate();
        var seqCalc = new SeqMergeSorter();
        var start = System.currentTimeMillis();
        seqCalc.mergeSort(array);
        System.out.println("Time spent: " + (System.currentTimeMillis() - start) + " ms, for size " + size);
        if (!ArrayTools.isSorted(array))
            System.err.println("Array not sorted");
        else System.out.println("Array is sorted");
    }
}


