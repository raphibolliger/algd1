package ch.fhnw.algd1.diverses;

/**
 * Created by raphi on 18.03.14.
 */
public class Main {

    public static void main(String[] args)
    {

        final int n = 100000;

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int)(Math.random() * Integer.MAX_VALUE);
        }

        int[] test = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        int testx = 8;

        boolean test1 = binarySearch(test,testx);

        double[] selectionSortTest = {1,2,3,4,5,6,7,8,9,10,2,4,6,7,2,2,3,4,5,12,13,14,15,16,17};
        double[] insertionSortTest = {1,2,3,4,5,6,7,8,9,10,2,4,6,7,2,2,3,4,5,12,13,14,15,16,17};

        selectionSort(selectionSortTest);
        insertionSort(insertionSortTest);

        int[] a1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        int[] a2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};

        Merge merge = new Merge(a1, a2);

        int result[] = merge.mergeArrays();

        System.out.println(result);
    }


    // Lineare suche im Array Variante 1
    public boolean searchArray1(int[] array, int x)
    {
        int i = 0;
        while (i < array.length && array[i] != x) i++;
        return i < array.length;
    }

    // Lineare suche im Array Variante 2 (besser)
    public boolean searchArray2(int[] array, int x)
    {
        boolean found;
        int l = array.length-1;

        if (array[l] == x)
        {
            found = true;
        }
        else
        {
            int temp = array[l];
            array[l] = temp;
            int i = 0;
            while (array[i] != x) i++;
            found = i < l;
            array[l] = temp;
        }
        return found;
    }

    // Binary Search
    public static boolean binarySearch(int[] array, int x)
    {
        int first = 0;
        int last = array.length-1;
        int m;

        while (first <= last)
        {
            m = (first + last) >>> 1; // same as x/2
            if (array[m] == x) { return true; }
            else if (array[m] < x) { first = m+1; }
            else { last = m-1; }
        }
        return false;
    }

    // selection sort
    public static double[] selectionSort(double[] array)
    {

        for (int first = 0; first < array.length-1; first++)
        {
            int m = first;
            double min = array[m];
            for (int i = first+1; i < array.length; i++)
            {
                if (array[i] < min)
                {
                    m = i;
                    min = array[m];
                }
            }
            array[m] = array[first];
            array[first] = min;
        }
        return array;
    }

    // insertion sort
    public static double[] insertionSort(double[] array)
    {
        for (int pos = 1; pos < array.length; pos++)
        {
            double x = array[pos];
            int j = pos-1;
            while (j >= 0 && x < array[j])
            {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = x;
        }
        return array;
    }


}
