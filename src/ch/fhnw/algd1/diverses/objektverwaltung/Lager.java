package ch.fhnw.algd1.diverses.objektverwaltung;

public class Lager implements ILager {

    private Object[] lagerSpaces;
    private int m_free;
    private int m_size;

    public Lager(int lagerSize)
    {
        lagerSpaces = new Object[lagerSize];
        m_free = 0;
        m_size = 0;
    }

    @Override
    public int size()
    {
        return m_size;
    }

    @Override
    public Object get(int pos)
    {
        return null;
    }

    @Override
    public int insert(Object obj)
    {
        if (m_free < lagerSpaces.length)
        {
            lagerSpaces[m_free] = obj;

            int i = m_free+1;
            while (lagerSpaces[i] != null)
            {

            }

        }
    }

    @Override
    public Object remove(int pos)
    {
        return null;
    }

    @Override
    public int search(Object obj)
    {
        int i = 0;
        int objCounter = 0;
        while (objCounter <= m_size)
        {
            if (lagerSpaces[i] != null)
            {
                objCounter++;
                if (lagerSpaces[i].equals(obj))
                    return i;
            }
            i++;
        }
        return -1;
    }
}
