package ch.fhnw.algd1.aufgabe8;

public class Skyscrapers {

    private int[][] skyscrapersField;

    public Skyscrapers(int[][] field)
    {
        skyscrapersField = field;
    }

    public void fillField(int x, int y)
    {
        if (x == skyscrapersField.length && y == skyscrapersField.length)
        {
            printField();
            return;
        }
        else
        {
            if (check())
                fillField(x+1, y+1);
            else
                fillField(x-1, y-1);
        }

    }

    public boolean check()
    {
        return true;
    }

    public void printField()
    {
        System.out.println();
        for (int i = 0; i < skyscrapersField.length; i++)
        {
            for (int j = 0; j < skyscrapersField[i].length; j++)
            {
                System.out.print(skyscrapersField[i][j]+ " | ");
            }
            System.out.println();
        }
    }

}
