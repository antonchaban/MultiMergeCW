package kpi.fict.chaban.parallel;

import lombok.AllArgsConstructor;

import java.util.concurrent.RecursiveAction;

@AllArgsConstructor
public class ParallelMergeSorter extends RecursiveAction {
    private int[] arr;

    @Override
    protected void compute() {
        var size = arr.length;

        if (size < 2) {
            return;
        }
        var mid = size / 2;

        var left = new int[mid];
        System.arraycopy(arr, 0, left, 0, mid);

        var right = new int[arr.length - mid];
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        invokeAll(new ParallelMergeSorter(left), new ParallelMergeSorter(right));
        merge(left, right);
    }


    private void merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

}
