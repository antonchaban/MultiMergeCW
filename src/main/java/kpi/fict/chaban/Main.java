package kpi.fict.chaban;

import kpi.fict.chaban.tools.ArrayGenerator;
import kpi.fict.chaban.tools.ArrayPrinter;

public class Main {
    public static void main(String[] args) {
        var arrayGenerator = new ArrayGenerator(10);
        var array = arrayGenerator.generate();

        ArrayPrinter.printArray(array);
    }
}