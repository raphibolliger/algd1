package ch.fhnw.algd1.diverses;

/**
 * Created by raphi on 22.04.14.
 */

public class pruefung {

    public static void main(String[] args)
    {
        // Test zur Mehtothe utfToLatin1String
        String string = new String("\u0041\uD800\uDF84\u0042\u03A9");
        byte[] b = utfToLatin1String(string);

        // Test zur Methode sort
        byte[] a = new byte[]{20,-45,54,2,3,67,-128,5,3,2,127,12,-76,3,2,3,5,6,8,-128,2,4,6,4,6,8};
        a = sort(a);
    }

    /**
     * Konvertierung eines Strings von UTF16 to Latin1 der String ist in einem korrekten UTF16 Format
     * @param s korrekte UTF16 Code sequenz
     * @return byte array mit der korrekten Zeichenfolge, nicht darstellbare zeichen werden mit einem ? ersetzt
     */

    public static byte[] utfToLatin1String(String s)
    {
        byte[] temp = new byte[s.length()];

        // Wird nur gebraucht damit überall im array eine 0 steht.
        for (int i = 0; i < temp.length; i++)
        {
            temp[i] = '0';
        }

        int counter = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) >= 55296)
            {
                temp[counter] = '?';
                i++;
            }
            else
            {
                if (s.charAt(i) > 127)
                    temp[counter] = '?';
                else
                    temp[counter] = (byte)s.charAt(i);
            }
            counter++;
        }
        return temp;
    }

    /**
     * Verbesserter Algorithmus zur Sortierung eines Byte-Arrays
     * @param a array mit byte Werten
     * @return sortiertes byte array
     */

    public static byte[] sort(byte[] a)
    {
        int[] t = new int[256];

        for (int i = 0; i < t.length; i++)
        {
            int numberCount = 0;
            for (int j = 0; j < a.length; j++)
            {
                if (a[j] == i-128) numberCount++;
            }
            t[i] = numberCount;
        }

        int position = 0;
        for (int i = 0; i < t.length; i++)
        {
            for (int j = 0; j < t[i]; j++)
            {
                a[position] = (byte)(i-128);
                position++;
            }
        }
        return a;
    }
}
