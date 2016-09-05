package main.java.arrays;

/**
 * Created by muthu on 9/5/16.
 */
import java.util.Arrays;

public class ArrayToolbox {
    public boolean isSorted(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int minimum(int[] a) {
        int min = 0;
        
        if (a.length == 0) {
            throw new RuntimeException();
        } else {
            min = a[0];
        }
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        
        return min;
    }
    
    public double mean(double[] a) {
        double sum = 0;
        
        if (a.length == 0) {
            return 0;
        } else {
            for(double d: a) {
                sum += d;
            }
        }
        
        return sum / a.length;
    }

    // this is buggy! fix!
    public int[] withoutDuplicates(int[] a) {
        if (a.length == 0) {
            return a;
        }

        Arrays.sort(a);
        int[] deDuped = new int[a.length];
        int deDupeIndex = 0;

        for(int i = 0; i < a.length; i++) {
            if (!existsInArray(deDuped, a[i])) {
                deDuped[deDupeIndex] = a[i];
                deDupeIndex += 1;
            }
        }
        return deDuped;
    }

    public boolean existsInArray(int[] a, int num) {
        if (a.length != 0) {
            for(int i = 0; i < a.length; i++) {
                if (a[i] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public void print(int[] a) {
        if (a.length == 0) {
            System.out.print("[");
        } else {
            System.out.printf("[%d", a[0]);
        }

        for (int i = 1; i < a.length; i++) {
            System.out.printf(", %d", a[i]);
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ArrayToolbox arrayToolbox = new ArrayToolbox();

        // tests for isSorted(int[] a)
        System.out.println(arrayToolbox.isSorted(new int[] {}));
        System.out.println(arrayToolbox.isSorted(new int[] {-1, 0, 1}));
        System.out.println(arrayToolbox.isSorted(new int[] {-1, 0, 1, -1}));
        System.out.println(arrayToolbox.isSorted(new int[] {2, 3, 1}));
        System.out.println(arrayToolbox.isSorted(new int[] {1, 1, 1}));
        System.out.println(arrayToolbox.isSorted(new int[] {1, 1, 2, 3}));

        // tests for minimum(int[] a)
//        System.out.println(arrayToolbox.minimum(new int[] {}));
        System.out.println(arrayToolbox.minimum(new int[] {-1, 0, 1}));
        System.out.println(arrayToolbox.minimum(new int[] {-1, 0, 1, -1}));
        System.out.println(arrayToolbox.minimum(new int[] {2, 3, 1}));
        System.out.println(arrayToolbox.minimum(new int[] {1, 1, 1}));
        System.out.println(arrayToolbox.minimum(new int[] {1, 1, 2, 3}));

        // tests for mean(double[] a)
        System.out.println(arrayToolbox.mean(new double[] {}));
        System.out.println(arrayToolbox.mean(new double[] {-1, 0, 1}));
        System.out.println(arrayToolbox.mean(new double[] {-1, 0, 1, -1}));
        System.out.println(arrayToolbox.mean(new double[] {2, 3, 1}));
        System.out.println(arrayToolbox.mean(new double[] {1, 1, 1}));
        System.out.println(arrayToolbox.mean(new double[] {1, 1, 2, 3}));

        // tests for de-duplication
        arrayToolbox.print(arrayToolbox.withoutDuplicates(new int[] {}));
        arrayToolbox.print(arrayToolbox.withoutDuplicates(new int[] {1, 2}));
        arrayToolbox.print(arrayToolbox.withoutDuplicates(new int[] {0, 0}));
        arrayToolbox.print(arrayToolbox.withoutDuplicates(new int[] {-1, 0, 1, 2, 2, -1}));
    }
}
