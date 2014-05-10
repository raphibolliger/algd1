package ch.fhnw.algd1.aufgabe4;

/**
 * Erstellt von Raphael Bolliger am 03.04.14.
 * Version : 1.0.0
 * Modul: algd1
 */

public class Skyscrapers {

    public static void main(String[] args)
    {
        int[][] testData1 = createTestArray(4);
        int[][] resultData1 = calculateView(testData1);
        printMultiArray(resultData1);

        System.out.println();

        int[][] testData2 = {{4,2,1,3},{2,3,4,1},{3,1,2,4},{1,4,3,2}};
        int[][] resultData2 = calculateView(testData2);
        printMultiArray(resultData2);
    }

    /**
     * Aufgabe 1a)
     * Erstellt ein Mehrdimensionales array mit geordneten Zahlen.
     *
     * @param size gibt die grässe des Arrays an (NxN).
     * @return gibt das gefüllte array zurück.
     */
    public static int[][] createTestArray(int size)
    {
        int[][] array = new int[size][size];

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                if (i == 0)
                {
                    array[i][j] = j;
                }
                else
                {
                    array[i][j] = array[i-1][j]%size;
                }
                array[i][j] += 1;
            }
        }

        return array;
    }

    /**
     * Aufgabe 1b)
     * Erstellt zuerst ein grössers array um die gerechneten Zahlenwerte in den äussersten
     * Reihen und Spalten zu speichern.
     *
     * @param array multidimensionales array mit generierten Zahlenwerten
     * @return ein vergrössertes Array mit den Berechneten werten.
     */

    public static int[][] calculateView(int[][] array)
    {
        int[][] finalArray = new int[array.length+2][array.length+2];

        // initialize new array with given array
        for (int i = 1; i < array.length+1; i++)
        {
            for (int j = 1; j < array.length+1; j++)
            {
                finalArray[i][j] = array[i-1][j-1];
            }
        }

        // calculate rows & columns
        for (int i = 0; i < array.length; i++)
        {
            finalArray[i+1][0] = calculateLeftSide(array, i);
            finalArray[i+1][finalArray.length-1] = calculateRightSide(array, i);
            finalArray[0][i+1] = calculateTop(array, i);
            finalArray[finalArray.length-1][i+1] = calculateBottom(array, i);
        }
        return finalArray;

    }

    public static int calculateLeftSide(int[][] array, int row)
    {
        int anzBuildings = 1;
        int biggest = array[row][0];
        for (int i = 0; i < array[row].length-1; i++)
        {
            if (array[row][i+1] > biggest)
            {
                biggest = array[row][i+1];
                anzBuildings++;
            }
        }
        return anzBuildings;
    }

    public static int calculateRightSide(int[][] array, int row)
    {
        int anzBuildings = 1;
        int biggest = array[row][array[row].length-1];
        for (int i = array[row].length-1; i > 0; i--)
        {
            if (biggest < array[row][i-1])
            {
                biggest = array[row][i-1];
                anzBuildings++;
            }
        }
        return anzBuildings;
    }

    public static int calculateTop(int[][] array, int column)
    {
        int anzBuildings = 1;
        int biggest = array[0][column];
        for (int i = 0; i < array.length-1; i++)
        {
            if (array[i+1][column] > biggest)
            {
                biggest = array[i+1][column];
                anzBuildings++;
            }
        }
        return anzBuildings;
    }

    public static int calculateBottom(int[][] array, int column)
    {
        int anzBuildings = 1;
        int biggest = array[array.length-1][column];
        for (int i = array.length-1; i > 0; i--)
        {
            if (biggest < array[i-1][column])
            {
                biggest = array[i-1][column];
                anzBuildings++;
            }
        }
        return anzBuildings;
    }

    /**
     * Ergänzung zu Aufgabe 1b)
     * Stellt das Berechnete array in der Konsole dar.
     *
     * @param array berechnetes multidimensionales array.
     */
    public static void printMultiArray(int[][] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Aufgabe 1c)
     * Generierung eines Beliebigen gültigen arrays für die Aufgabe 1b)
     *
     * @param size grösse (NxN) für das Array
     * @return gibt das mit Random gefüllte mehrdimensionale array zurück.
     */
    public static int[][] createRandomTestArray(int size)
    {
        int[][] array = new int[size][size];

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                // Anstatt die Zahlen hier der reihenfolge nach zu generieren muss die erste Zeile mit
                // Random werten zwischen 1 und size initaliisert werden, jeder wert darf nur einmal
                // vorkommen.

                // Anschliessend kann die zweite Zeile mit Random werten generiert werden, es ist darauf zu
                // achten, dass alle vorhergenden werte, nicht nocheinmal verwendet werden.

                // Dieser Schritt ist n mal zu wiederholen.

                // Schlussendlich braucht es zwei for-Schleifen, die anzahl Random berechnungen und
                // Prüfungen ob ein wert bereits vorhanden ist, sind jedoch schwierig abzuschätzen.
            }
        }
        return array;
    }
}
