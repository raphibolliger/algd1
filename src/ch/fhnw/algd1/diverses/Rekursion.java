package ch.fhnw.algd1.diverses;

public class Rekursion {

    public int rek(int x)
    {
        if( x<= 1)
        {
            return 1;
        }
        else
        {
            return x * rek(x-1);
        }
    }

}
