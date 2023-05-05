package kpi.fict.chaban.sequential;

import kpi.fict.chaban.Sorter;

public class SeqMergeSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        var size = array.length;

        if (size < 2) {
            return array;
        }

        var mid = size / 2;
        var left = new int[mid];
        var right = new int[size - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < size; i++) {
            right[i - mid] = array[i];
        }

        sort(left);
        sort(right);

        merge(array, left, right);
        return array;
    }

    private static void merge(int[] inputArray, int[] left, int[] right) {
        var leftSize = left.length;
        var rightSize = right.length;

        var i = 0;
        var j = 0;
        var k = 0;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                inputArray[k] = left[i];
                i++;
            } else {
                inputArray[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            inputArray[k] = left[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArray[k] = right[j];
            j++;
            k++;
        }

    }
}
