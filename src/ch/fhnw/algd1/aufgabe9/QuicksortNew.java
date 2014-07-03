package ch.fhnw.algd1.aufgabe9;

import java.util.Random;

public class QuicksortNew {

    private Random rand = new Random();

    public void quickSort(double[] array, int l, int r)
    {
        if (l < r)
        {
            double pivot = array[randomInt(l, r)];

            int i = l;
            int j = r;

            do {
                while (array[i] < pivot) i++;
                while (array[j] > pivot) j--;
                if (i <= j)
                {
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);

            quickSort(array, l, i - 1);
            quickSort(array, i, r);
        }
    }

    private int randomInt(int min, int max)
    {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public boolean isSorted(double[] array)
    {
        for (int i = 0; i < array.length-1; i++)
        {
            if (array[i] > array[i+1]) return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        final int count = 1000000;

        double[] test = {2.3, 1.2, 4.3, 2.2, 5.8, 7.8, 1.4, 2.1 };

        QuicksortNew quicksort = new QuicksortNew();

        // random double array
        double[] random = new double[count];
        for (int i = 0; i < count; i++)
        {
            random[i] = Math.random();
        }

        // random reverse sorted array
        int countPlus = 0;
        double[] reverseRandomSorted = new double[count];
        for (int i = count-1; i >= 0; i--)
        {
            reverseRandomSorted[countPlus] = random[i];
            countPlus++;
        }

        // same values
        double[] same = new double[count];

        long start = 0;
        long end = 0;
        boolean isSorted = false;

        // Sort random
        System.out.println(quicksort.isSorted(random));

        start = System.currentTimeMillis();
        quicksort.quickSort(random, 0, random.length-1);
        end = System.currentTimeMillis();
        isSorted = quicksort.isSorted(random);
        long zeit1 = end - start;
        System.out.println("Randomzeit: "+ zeit1 +" / Sortiert: " + isSorted);

        // Sort same
        start = System.currentTimeMillis();
        quicksort.quickSort(same, 0, random.length-1);
        end = System.currentTimeMillis();
        isSorted = quicksort.isSorted(same);
        long zeit2 = end - start;
        System.out.println("Samezeit: "+ zeit2 +" / Sortiert: " + isSorted);

        // Sort sortet
        start = System.currentTimeMillis();
        quicksort.quickSort(random, 0, random.length-1);
        end = System.currentTimeMillis();
        isSorted = quicksort.isSorted(random);
        long zeit3 = end - start;
        System.out.println("Sortedzeit: "+ zeit3 +" / Sortiert: " + isSorted);

        // Sort reverse sorted array
        start = System.currentTimeMillis();
        quicksort.quickSort(reverseRandomSorted, 0, reverseRandomSorted.length-1);
        end = System.currentTimeMillis();
        isSorted = quicksort.isSorted(reverseRandomSorted);
        long zeit4 = end - start;
        System.out.println("ReverseSortedzeit: "+ zeit4 +" / Sortiert: " + isSorted);

    }



}
