package Tas4;

import java.util.Arrays;

public class BubbleSort {
    private static int var;
    public static void bubbleSortVisualization(int[] massive){
        System.out.println(Arrays.toString(massive));
        while (!massiveIsSorted(massive)) {
            for (int i = 0; i < massive.length - 1; i++) {
                if (massive[i] > massive[i + 1]) {
                    var = massive[i + 1];
                    massive[i + 1] = massive[i];
                    massive[i] = var;
                    System.out.println(Arrays.toString(massive));
                }
            }
        }
    }
    public static boolean massiveIsSorted(int[] massive) {
        for (int i = 0; i < massive.length - 1; i++) {
            if (massive[i] > massive[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] m = new int[]{1,76,12,23,56,1,6,56};
        bubbleSortVisualization(m);
    }
}

