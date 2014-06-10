package ch.fhnw.algd1.diverses;

/**
 * Created by raphi on 10.06.14.
 */
public class Merge {

    private int[] array1;
    private int[] array2;

    public Merge(int[] array1, int[] array2)
    {
        this.array1 = array1;
        this.array2 = array2;
    }

    public int[] mergeArrays()
    {
        int[] mergedArray = new int[array1.length+array2.length];

        int pos1 = 0;
        int pos2 = 0;

        for (int i = 0; i < mergedArray.length; i++)
        {
            if (pos1 > array1.length)
            {
                mergedArray[i] = array2[pos2];
                pos2++;
            }
            else
            {
                if (pos2 > array2.length)
                {
                    mergedArray[i] = array1[pos1];
                    pos1++;
                }
                else
                {
                    if (array1[pos1] > array2[pos2])
                    {
                        mergedArray[i] = array1[pos1];
                        pos1++;
                    }
                    else
                    {
                        mergedArray[i] = array2[pos2];
                        pos2++;
                    }
                }
            }
        }
        return mergedArray;
    }

}
