package ch.fhnw.algd1.aufgabe9;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Boersenkurse {

    private int posStart = 0;
    private int posEnd = 0;

    public int getPosStart()
    {
        return posStart;
    }

    public int getPosEnd()
    {
        return posEnd;
    }

    public float calculateInOut(float[] array)
    {
        if (array.length == 1)
        {
            return array[0];
        }

        float[] a1 = Arrays.copyOfRange(array, 0, array.length/2);
        float[] a2 = Arrays.copyOfRange(array, (array.length/2), array.length);

        float i1 = calculateInOut(a1);
        float i2 = calculateInOut(a2);

        float lsum = 0;
        float lmax = 0;
        for (int i = (array.length/2)-1; i >= 0; i--)
        {
            lsum += array[i];
            if (lsum > lmax)
            {
                lmax = lsum;
                this.posStart = i;
            }
        }

        float rsum = 0;
        float rmax = 0;
        for (int i = array.length/2; i < array.length; i++)
        {
            rsum += array[i];
            if (rsum > rmax)
            {
                rmax = rsum;
                this.posEnd = i;
            }
        }

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

    public float[] importData()
    {
        float[] array = new float[0];
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream("/Daten/boersenkurse.dat"));
            array = (float[])inputStream.readObject();
        }
        catch (ClassNotFoundException e1)
        {
            e1.printStackTrace();
        }
        catch (IOException e2)
        {
            e2.printStackTrace();
        }
        return array;
    }

    public void exportData(float[] array)
    {
        try
        {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("/Daten/boersenkurse.dat"));
            outputStream.writeObject(array);
        }
        catch (FileNotFoundException e1)
        {
            e1.printStackTrace();
        }
        catch (IOException e2)
        {
            e2.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Boersenkurse boersenkurse = new Boersenkurse();
        float[] testKurse = {1.2f, -4.5f, 5.6f, 3.4f, -2.6f, 4.7f, 5.7f, -1.6f, 4.6f, -12.3f};
        float[] kurse = boersenkurse.generateValues(100000);

        boersenkurse.exportData(kurse);
        float[] arrayImport = boersenkurse.importData();

        System.out.println(boersenkurse.calculateInOut(kurse));
        System.out.println("Einstieg: " + boersenkurse.getPosStart());
        System.out.print("Ausstieg: "+ boersenkurse.getPosEnd());
    }

}
