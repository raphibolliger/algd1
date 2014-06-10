package ch.fhnw.algd1.aufgabe8;

public class Main {

    public static void main(String[] args)
    {
        int[][] test = {{0,1,3,2,2,0},{1,0,0,0,0,2},{3,0,0,0,0,2},{2,0,0,0,0,1},{2,0,0,0,0,3},{0,3,1,2,2,0}};

        Skyscrapers skyscrapers = new Skyscrapers(test);
        skyscrapers.printField();

        //Zahlenquadrat zahlenquadrat = new Zahlenquadrat();
        //zahlenquadrat.CreateArray();
    }

}
