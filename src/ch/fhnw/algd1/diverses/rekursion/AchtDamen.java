package ch.fhnw.algd1.diverses.rekursion;
/**
 * Write a description of class AchtDamen here.
 * 
 * @author C. Stamm 
 * @version 1.0
 */
public class AchtDamen
{
    // instance variables
    private int m_n;        // Anzahl Damen
    private byte m_x;       // aktuelle Spalte
    private byte[] m_y;     // Position der Damen
    
    /**
     * Constructor for objects of class AchtDamen
     */
    public AchtDamen(int n)
    {
        //assert n < 128 : n;
        m_n = n;
        m_x = 0;
        m_y = new byte[m_n];
        m_y[m_x] = 0;
    }

    private boolean istBedroht() {
        byte x0 = 0;
        
        while (x0 < m_x) {
            if ((Math.abs(m_y[m_x] - m_y[x0]) == m_x - x0) || (m_y[m_x] == m_y[x0]))
                return true;
            x0++;
        }
        return false;
    }

    public boolean platziereDamen() {
        while (m_x >= 0 && m_x < m_n) {
            while (m_y[m_x] < m_n && istBedroht()) {
                m_y[m_x]++;
            }
            if (m_y[m_x] < m_n) {
                // gehe zur n�chsten Spalte
                m_x++;
                if (m_x < m_n) m_y[m_x] = 0;
            } else {
                // backtracken
                m_x--;
                if (m_x >= 0) m_y[m_x]++;
            }
        }
        return m_x >= 0;
    }
    
    public void print() {
        // gebe Position der Damen aus
        System.out.print("[" + m_y[0]);
        for (int i=1; i < m_n; i++) {
            System.out.print("," + m_y[i]);
        }
        System.out.println("]");
    }
}
