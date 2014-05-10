package ch.fhnw.algd1.aufgabe2;

/**
 * Created by raphi on 24.03.14.
 */
public class Main {

    public static void main(String[] args)
    {

        byte[] array = utfToLatin1("äABCü");

    }

    public static byte[] utfToLatin1(String s)
    {
        byte[] latinArray = new byte[s.length()];
        for (int i = 0; i < latinArray.length; i++)
        {
            char c = s.charAt(i);
            if (c > 128 || c < 0)
            {
                c = 63;
            }
            latinArray[i] = (byte)c;
        }
        return latinArray;
    }

    public static int utf32to16(int c, int[] array, int pos)
    {
        int length = 1;

        if (array == null)
        {
            throw new NullPointerException();
        }
        if (!Character.isValidCodePoint(c))
        {
            throw new IllegalArgumentException();
        }

        if (c < 0xFFFF)
        {
            array[pos] = c;
            return 1;
        }

        // definitionen
        int bmp = 0x10000;
        int sr1 = 0xD800;
        int sr2 = 0xDC00;

        // BMP abzeihen
        c -= bmp;

        // c aufsplitten
        int temp1 = c;
        int temp2 = c;

        // shiften -> auseinanderschneiden des int in zwei paare
        int shift1 = temp1 << 10;
        int shift2 = temp2 >>> 10;

        // surrogate-präfix hinzufügen
        shift1 = shift1 | sr1;
        shift2 = shift2 | sr2;

        array[pos] = shift1;
        array[pos+1] = shift2;

        return 2;
    }
}
