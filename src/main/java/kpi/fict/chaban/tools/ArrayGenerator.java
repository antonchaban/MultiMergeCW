package kpi.fict.chaban.tools;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@RequiredArgsConstructor
public class ArrayGenerator {
    private final int size;
    private int[] array;

    public int[] generate() {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int)(Math.random() * 100);
        }
        return array;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }
}
