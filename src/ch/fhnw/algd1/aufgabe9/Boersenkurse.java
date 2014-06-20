package ch.fhnw.algd1.aufgabe9;

import java.util.Arrays;
import java.util.Random;

public class Boersenkurse {

    public float calculateSum(float[] array)
    {
        if (array.length == 1)
        {
            return array[0];
        }

        System.out.println(Arrays.toString(array));

        float[] a1 = Arrays.copyOfRange(array, 0, array.length/2);
        float[] a2 = Arrays.copyOfRange(array, (array.length/2), array.length);

        float i1 = calculateSum(a1);
        float i2 = calculateSum(a2);

        float lsum = 0;
        float lmax = 0;
        int posStart = 0;
        for (int i = (array.length/2)-1; i >= 0; i--)
        {
            lsum += array[i];
            if (lsum > lmax)
            {
                lmax = lsum;
                posStart = i;
            }
        }

        //System.out.println("Start: "+posStart);

        float rsum = 0;
        float rmax = 0;
        int posEnd = 0;
        for (int i = array.length/2; i < array.length; i++)
        {
            rsum += array[i];
            if (rsum > rmax)
            {
                rmax = rsum;
                posEnd = i;
            }
        }

        //System.out.println("End: "+posEnd);

        float i3 = lmax+rmax;

        float maxi1i2 = Math.max(i1, i2);
        return Math.max(maxi1i2, i3);
    }

    public float[] generateValues(int anzahl)
    {
        float[] array = new float[anzahl];
        for (int i = 0; i < anzahl; i++)
        {
            Random random = new Random();
            float x = (random.nextFloat())*100;
            if (!random.nextBoolean())
            {
                array[i] = x* -1;
            }
            else
            {
                array[i] = x;
            }
        }
        return array;
    }

    public void importData()
    {

    }

    public void exportData()
    {

    }

    public static void main(String[] args)
    {
        int[] kurse = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
        int[] kurse1 = {300, -10, -10, -10, -10, -10, -10, -10, -10, 100};




        Boersenkurse boersenkurse = new Boersenkurse();
        float[] kurse2 = boersenkurse.generateValues(100000);


        System.out.println(boersenkurse.calculateSum(kurse2));
    }

}
