package ch.fhnw.algd1.aufgabe8;

public class Zahlenquadrat
{
    private int[][] zahlenQuadrat;

    public Zahlenquadrat(int[][] zahlen)
    {
        zahlenQuadrat = zahlen;
    }

    public void calculateMin(int x, int y)
    {
        if (x == 2 && y == 2) // gilt nur für ein 3x3 feld
        {
            printQuadrat();
            return;
        }
        else
        {
            // habe hier lange versucht dies mit dem Ansatz für magische Quadrate zu lösen
            // dies ist aber, nach absprache mit Kollegen nicht die richtige lösung ?!?
        }
    }

    public void printQuadrat()
    {
        System.out.println();
        for (int i = 0; i < zahlenQuadrat.length; i++)
        {
            for (int j = 0; j < zahlenQuadrat[i].length; j++)
            {
                System.out.print(zahlenQuadrat[i][j]+ " | ");
            }
            System.out.println();
        }
    }

}