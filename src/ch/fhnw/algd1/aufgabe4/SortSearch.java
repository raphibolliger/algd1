package ch.fhnw.algd1.aufgabe4;

import java.util.Arrays;

/**
 * Erstellt von raphi am 07.04.14.
 * Version : 1.0.0
 * Modul: algd1
 */

public class SortSearch {

    /**
     * Aufgabe 2c)
     * Einige Testfälle
     *
     * @param args
     */
    public static void main(String[] args)
    {
        double[] sortArray1 = {1.1,5.3,3.4,2.6,4.3};
        double[] sortArray2 = {5,8,1,4,9,3,4,7,8,0,4,2,4,5,3};

        double[] searchArray1 = {1.4, 2.6, 3.8, 4.2, 5.7, 6.8, 7.2, 8.4, 9.6};
        double[] searchArray2 = {1.4, 2.6, 2.7, 3.1, 3.8, 4.2, 5.7, 6.8, 7.2, 8.4, 9.6};

        printArray(insertionSort(sortArray1));
        printArray(insertionSort(sortArray2));

        System.out.println(binarySearch(searchArray1, 5.7));
        System.out.println(binarySearch(searchArray1, 36));
        System.out.println(binarySearch(searchArray2, 3.1));
        System.out.println(binarySearch(searchArray2, 3.9));
    }

    /**
     * Aufgabe 2a)
     * Insertion Sort implementiert wie bereits in der Stunde besprochen.
     *
     * @param array unsortiertes double array
     * @return sortiertes double array
     */
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

    /**
     * Aufgabe 2b)
     * binarySearch implementiert wie bereits in der Stunde besprochen.
     *
     * @param array double array beliebiger grösse
     * @param x gesuchte Zahl
     * @return -1 wenn Zahl nicht gefunden ansonseten den index des arrays
     */
    public static int binarySearch(double[] array, double x)
    {
        int first = 0;
        int last = array.length-1;
        int m;

        while (first <= last)
        {
            m = (first + last) >>> 1; // same as x/2
            if (array[m] == x) { return m; }
            else if (array[m] < x) { first = m+1; }
            else { last = m-1; }
        }
        return -1;
    }

    /**
     * Ergänzung zur Aufgabe 2
     * Gibt ein Array in der Konsole aus.
     *
     * @param array
     */
    public static void printArray(double[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]+"|");
        }
        System.out.println();
    }


}
