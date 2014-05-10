package ch.fhnw.algd1.diverses.objektverwaltung;

public interface ILager {

    public int size(); // gibt die Anzahl Objekte im Lager zurück
    public Object get (int pos); //gibt das Objekt an der Position pos zurück
    public int insert(Object obj); // fügt ein Objekt in die erste freie Lagerposition ein
    public Object remove(int pos); // entfernt ein Objekt aus dem Lager
    public int search(Object obj); // sucht die Lagerstelle eines Objektes

}
