package ch.fhnw.algd1.aufgabe8;

public class Zahlenquadrat
{
    int counter = 0;
    int min = 0;

    public int[][] CreateArray()
    {

        int[] numbers = {1,2,3,4,5,6,7,8,9};
        int[][] array = new int[3][3];

        Blubber(numbers, array,0,0);

        System.out.println(counter); // Anzahl = 362880
        System.out.println("Summe: "+min); //Minimum = 436
        return array;
    }

    public int[][] Blubber(int[] numbers, int[][] array, int pos, int pos2)
    {
        if(pos == 3)
        {
            pos = 0;
            pos2++;
        }
        for(int i = numbers.length-1; i >= 0; i--)
        {


            array[pos][pos2] = numbers[i];

            if(pos == 2 && pos2 == 2)
            {
                calculateSum(array);
                counter++;
                //PrintArray(array);
            }

            int[] newNumbers = RemoveNumberAtIndex(numbers, i);
            Blubber(newNumbers,array,pos+1,pos2);
        }
        return array;
    }

    private void calculateSum(int[][] array)
    {
        int[] products = new int[6];

        products[0] = array[0][0] * array[1][0] * array[2][0];
        products[1] = array[0][1] * array[1][1] * array[2][1];
        products[2] = array[0][2] * array[1][2] * array[2][2];
        products[3] = array[0][0] * array[0][1] * array[0][2];
        products[4] = array[1][0] * array[1][1] * array[1][2];
        products[5] = array[2][0] * array[2][1] * array[2][2];

        int sum = products[0] + products[1] + products[2] + products[3] + products[4] + products[5];

        /*
        System.out.println();
        System.out.println();
        System.out.println("Summe: "+sum);
        System.out.println();
        System.out.println();
        */

        if(sum < min || min == 0)
        {
            min = sum;
        }
    }

    private int[] RemoveNumberAtIndex(int[] numbers, int index)
    {
        int[] newNumbers = new int[numbers.length-1];
        for(int i = 0; i < newNumbers.length;i++)
        {
            if(i < index)
                newNumbers[i] = numbers[i];
            else
                newNumbers[i] = numbers[i+1];
        }

        return newNumbers;
    }

    public void PrintArray(int[][] array)
    {
        for(int i = 0; i< array.length;i++)
        {
            for(int j = 0; j < array[i].length;j++)
            {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}