package ch.fhnw.algd1.aufgabe1;

/**
 * Created by raphi on 03.03.14.
 */
public class DataTypes {

    private static int i;
    private static byte bi;
    private static long l;
    private static char c;
    private static boolean b;
    private static float f;
    private static double d;

    public static void main(String[] args)
    {
        i = 97;
        c = (char)i;
        c = '\n';
        i = c;

        l = -20%6;

        b = (1/10) == 0.1;


    }

}
