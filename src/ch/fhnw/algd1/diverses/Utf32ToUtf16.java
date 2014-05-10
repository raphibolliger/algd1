package ch.fhnw.algd1.diverses;

/**
 * Created by raphi on 27.04.14.
 */
public class Utf32ToUtf16 {

    public static void main(String[] args)
    {
        int zeichen = 0x10FFFF;

        char[] solution = utf32ToUtf16(zeichen);
    }

    public static char[] utf32ToUtf16(int c)
    {
        char[] temp = new char[2];

        if (c > 0xFFFF)
        {
            // minus 10'000 zu beginn der berechnung
            c = c - 0x10000;

            // Wird die berechnung von Hand vorgenommen wird das Bitmuster des errechneten werts in der mitte
            // geteilt, hier wird das beim rechten teil mit dem & operator und im linken teil mit dem
            // vorzeichenlosen Shift operator erledigt
            int c1 = (c & 0x03FF); // rechter teil mit 0x3FF verknüpfen dann sind links alls 0
            int c2 = (c >>> 10); // shiftn um 10 stellen nach rechts dann sind links alles 0

            // Zu diesen erhaltenen Werten müssen die Konstanten D2 und D3 hinzugefügt werden, diese sind definiert
            // als D2 = 0xD800 und D3 = 0xDC00
            temp[0] = (char)(c1 + 0xD800);
            temp[1] = (char)(c2 + 0xDC00);
        }
        else
        {
            temp[0] = (char)c;
        }
        return temp;
    }
}
