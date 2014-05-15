package ch.fhnw.algd1.aufgabe7;

public class Kolmogorow
{
    /**
     * Generates a console output like 10100100010000..... with the length of stringLength
     * @param stringLength
     */
    public void generateString1(int stringLength)
    {
        int totalNumberCounter = 0;
        int outerCounter = 1;
        while (totalNumberCounter < stringLength)
        {
            System.out.print("1");
            totalNumberCounter++;
            int innerCounter = 0;
            while (totalNumberCounter < stringLength && innerCounter < outerCounter)
            {
                System.out.print("0");
                totalNumberCounter++;
                innerCounter++;
            }
            outerCounter++;
        }
    }


    public void generateString2(int stringLength)
    {
        int totalNumberCounter = 0;
        int counter = 2;
        boolean switcher = true;

        while (totalNumberCounter < stringLength)
        {
            int fibNumber = fibonacciNumber(counter);
            int innerCounter = 0;
            while (totalNumberCounter < stringLength && innerCounter < fibNumber)
            {
                if (switcher)
                {
                    System.out.print("1");
                }
                else
                {
                    System.out.print("0");
                }
                innerCounter++;
                totalNumberCounter++;
            }
            counter++;
            switcher = !switcher;
        }

    }

    public void generateString3()
    {

    }


    public int fibonacciNumber(int n) {
        if(n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciNumber(n-1) + fibonacciNumber(n-2); //der rekursive Aufruf
        }
    }


}
