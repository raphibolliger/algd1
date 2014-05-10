package ch.fhnw.algd1.aufgabe1;

/**
 * Created by raphi on 03.03.14.
 */

public class FloatPrecision {

    public static void main(String[] args)
    {
        // Calculate float numbers
        float var1 = 1;
        System.out.println(var1 * 256);

        int floatCounter = 0;
        while (!Float.isInfinite(var1))
        {
            floatCounter++;
            var1 = var1 * 256;
        }
        System.out.println(floatCounter);

        // Calculate double numbers
        double var2 = 1;
        System.out.println(var2 * 256);

        int doubleCounter = 0;
        while (!Double.isInfinite(var2))
        {
            doubleCounter++;
            var2 = var2 * 256;
        }
        System.out.println(doubleCounter);

        // Precision with big float numbers
        float testNumber1 = 1000000000;
        float testNumber2 = 1000000001;

        System.out.println(testNumber2 - testNumber1);
        System.out.println(testNumber1 == testNumber2);

        // Precision with big double numbers
        double testNumber3 = 1000000000;
        double testNumber4 = 1000000001;

        System.out.println(testNumber4 - testNumber3);
        System.out.println(testNumber3 == testNumber4);

        // Precision with big int numbers
        int testNumber5 = 1000000000;
        int testNumber6 = 1000000001;

        System.out.println(testNumber6 - testNumber5);
        System.out.println(testNumber5 == testNumber6);


        float zahl1 = 1;
        float zahl2 = zahl1 + 1;
        int zahlCounter = 0;

        while (!(zahl1 == zahl2))
        {
            zahlCounter++;
            zahl1++;
            zahl2++;
        }
        System.out.println(zahlCounter);

        float zahl3 = 16777216;
        float zahl4 = 16777217;

        System.out.println(zahl3 == zahl4);

        boolean x;
        double a = 1.2;

        x = a == a++ | a != a++;

        double xx = 1/0.0*0;
        double xy = 1/0*0;

    }
}
