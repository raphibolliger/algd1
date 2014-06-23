package ch.fhnw.algd1.aufgabe9;

import java.util.Random;

public class Quicksort {

    public void quickSort(double[] array, int l, int r)
    {
        if (l < r)
        {
            int p = divideArray(array, l, r);
            quickSort(array, l, p - 1);
            quickSort(array, p, r);
        }
    }

    private int divideArray(double[] array, int l, int r)
    {
        int i = l;
        int j = r;
        double p = array[randomInt(l, r)];

        do {
            while (array[i] < p) i++;
            while (array[j] > p) j--;
            if (i <= j)
            {
                swap(array, i, j);
                i++;
                j--;
            }
        } while (i < j);

        return i;
    }

    public void swap(double[] array, int i, int j)
    {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int randomInt(int min, int max)
    {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void main(String[] args)
    {
        final int count = 1000000;

        Quicksort quicksort = new Quicksort();

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

        // Sort random
        start = System.currentTimeMillis();
        quicksort.quickSort(random, 0, random.length-1);
        end = System.currentTimeMillis();
        long zeit1 = end - start;
        System.out.println("Randomzeit: "+ zeit1);

        // Sort same
        start = System.currentTimeMillis();
        quicksort.quickSort(same, 0, random.length-1);
        end = System.currentTimeMillis();
        long zeit2 = end - start;
        System.out.println("Samezeit: "+ zeit2);

        // Sort sortet
        start = System.currentTimeMillis();
        quicksort.quickSort(random, 0, random.length-1);
        end = System.currentTimeMillis();
        long zeit3 = end - start;
        System.out.println("Sortedzeit: "+ zeit3);

        // Sort reverse sorted array
        start = System.currentTimeMillis();
        quicksort.quickSort(reverseRandomSorted, 0, reverseRandomSorted.length-1);
        end = System.currentTimeMillis();
        long zeit4 = end - start;
        System.out.println("ReverseSortedzeit: "+ zeit4);
    }



}
