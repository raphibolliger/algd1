package ch.fhnw.algd1.diverses.rekursion;
/**
 * Write a description of class Springer here.
 * 
 * @author C. Stamm 
 * @version 1
 */
public class Springer {
    private boolean[][] m_brett;    // Schachbrett: true = Springer hat das Feld besucht
    private int m_n;                // Gr�sse des Schachbretts
    public  int m_max;              // Maximale Rekursionstiefe
    
    Springer(int n) {
        // erzeuge schachbrett
        m_brett = new boolean[n][n];
        m_n = n;
        m_max = 0;
    }
    
    public boolean move(int i, int j, int count) {
        if (i >= 0 && i < m_n && j >= 0 && j < m_n) {
            // innerhalb des brettes
            if (m_brett[i][j]) {
                // schon besucht
                return false;
            } else {
                // position noch nicht besucht, markiere sie als besucht
                //System.out.print("(" + i + "," + j + ")");
                m_brett[i][j] = true;
                count++;
                if (count > m_max) m_max = count;
                if (count == m_n*m_n) {
                    // das war die letzte freie position
                    // springerweg gefunden --> gebe z�ge aus
                    System.out.print("(" + i + "," + j + ") ");
                    return true;
                } else {
                    boolean ok;
                    //probiere 8 m�gliche folgez�ge
                    ok = move(i - 1, j + 2, count);
                    if (!ok) ok = move(i + 1, j + 2, count);
                    if (!ok) ok = move(i + 2, j + 1, count);
                    if (!ok) ok = move(i + 2, j - 1, count);
                    if (!ok) ok = move(i + 1, j - 2, count);
                    if (!ok) ok = move(i - 1, j - 2, count);
                    if (!ok) ok = move(i - 2, j - 1, count);
                    if (!ok) ok = move(i - 2, j + 1, count);
                    if (ok) {
                        // springerweg gefunden --> gebe z�ge aus
                        System.out.print("(" + i + "," + j + ") ");
                    } else {
                        // keinen folgezug gefunden --> backtrack: nehme letzten zug zur�ck
                        //System.out.print(" backtrack " + count);
                        m_brett[i][j] = false;
                        count--;
                    }
                    return ok;
                }
            }
        } else {
            // ausserhalb des brettes
            return false;
        }
    }
    
    public static void main(String[] args) {
        Springer springer = new Springer(8);

        System.out.println("Suche Springerweg auf Brett der Groesse " + springer.m_n + "x" + springer.m_n);
        if (springer.move(0, 0, 0)) {
            System.out.println();
            System.out.println("Springerweg gefunden");
        } else {
            System.out.println("Kein Springerweg vorhanden");
            System.out.println(springer.m_max + " Positionen gefunden");
        }
    }
}
/*
Suche Springerweg auf Brett der Groesse 8x8
(7,0) (5,1) (3,0) (1,1) (0,3) (2,4) (3,2) (4,0) (2,1) (0,2) (1,0) (2,2) (4,1) (2
,0) (0,1) (1,3) (3,4) (4,6) (6,7) (7,5) (6,3) (7,1) (5,0) (4,2) (2,3) (3,1) (4,3
) (3,5) (1,4) (0,6) (2,7) (1,5) (0,7) (2,6) (0,5) (1,7) (2,5) (3,3) (4,5) (5,3)
(6,1) (7,3) (5,4) (6,2) (7,4) (6,6) (4,7) (5,5) (3,6) (4,4) (5,2) (6,0) (7,2) (6
,4) (7,6) (5,7) (6,5) (7,7) (5,6) (3,7) (1,6) (0,4) (1,2) (0,0)
*/