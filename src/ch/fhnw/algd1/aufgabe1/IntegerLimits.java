package ch.fhnw.algd1.aufgabe1;

/**
 * Created by raphi on 03.03.14.
 */
public class IntegerLimits {

    public static void main(String[] args)
    {
        int var = 1;
        System.out.println(var * 265);

        for (int i = 0;i < 10; i++)
        {
            var = var * 256;
        }

        System.out.println("Integer Limits");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println("Long Limits");
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
    }
}
