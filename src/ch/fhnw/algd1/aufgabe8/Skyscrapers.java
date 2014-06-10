package ch.fhnw.algd1.aufgabe8;

public class Skyscrapers {

    private int[][] skyscrapersField;

    public Skyscrapers(int[][] field)
    {
        skyscrapersField = field;
    }

    public void fillField(int x, int y)
    {
        if ()

    }

    public boolean check()
    {

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
