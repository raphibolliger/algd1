package ch.fhnw.algd1.aufgabe8;

class MagQuadrat {
    private int reihe;
    private int spalte;
    private final int kLaenge;
    private final int max;
    private int[][] quadrat;

    public MagQuadrat(int kantenLaenge) {
        this.kLaenge = kantenLaenge;
        this.quadrat = new int[kLaenge][kLaenge];
        this.reihe = 0;
        this.spalte = kLaenge / 2;
        this.max = kLaenge - 1;
        init();
    }

    private void init() {
        for (int iReihe = 0; iReihe < kLaenge; iReihe++) {
            for (int iSpalte = 0; iSpalte < kLaenge; iSpalte++)
                quadrat[iReihe][iSpalte] = 0;
        }

        for (int zahl = 1; zahl <= kLaenge * kLaenge; zahl++) {
            quadrat[reihe][spalte] = zahl;
            moveNext();
        }
    }

    private boolean isBelegt(int reihe, int spalte) {
        return quadrat[reihe][spalte] > 0;
    }

    private void moveNext() {
        int neuReihe, neuSpalte;
        if (reihe == 0 && spalte == max) {
            neuReihe = reihe + 1;
            neuSpalte = spalte;
        } else if (reihe == 0) {
            neuReihe = max;
            neuSpalte = spalte + 1;
        } else if (spalte == max) {
            neuSpalte = 0;
            neuReihe = reihe - 1;
        } else {
            neuReihe = reihe - 1;
            neuSpalte = spalte + 1;
        }
        if (isBelegt(neuReihe,neuSpalte)) {
            neuReihe = reihe+1;
            neuSpalte = spalte;
        }
        reihe = neuReihe;
        spalte = neuSpalte;

    }

    public void aus() {
        for (int reihe = 0; reihe < kLaenge; reihe++) {
            for (int spalte = 0; spalte < kLaenge; spalte++) {
                System.out.printf("%2d", quadrat[reihe][spalte]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new MagQuadrat(3).ausgabe();
    }

    // ab hier nicht mehr eigentlich wichtig, nur zur kontrolle.
    public void ausgabe() {
        for (int reihe = 0; reihe < quadrat.length; reihe++) {
            System.out.print("   |");
            for (int spalte = 0; spalte < quadrat.length; spalte++) {
                int zelle = quadrat[reihe][spalte];
                System.out.printf("%3d ", zelle);
            }
            System.out.print("|" + reihenSumme(reihe));
            System.out.println();
        }
        System.out.print("---+");
        for (int i = 0; i < kLaenge; i++)
            System.out.print("----");
        System.out.print("+---");
        System.out.println();
        System.out.printf("%3d|", diagonalSumme2());
        for (int spalte = 0; spalte < quadrat.length; spalte++)
            System.out.printf("%3d ", spaltenSumme(spalte));
        System.out.print("|");
        System.out.printf("%3d ", diagonalSumme());
    }

    private int diagonalSumme() {
        int summe = 0;
        for (int i = 0; i < quadrat.length; i++)
            summe += quadrat[i][i];
        return summe;
    }

    private int diagonalSumme2() {
        int summe = 0;
        for (int i = max; i >= 0; i--)
            summe += quadrat[i][i];
        return summe;
    }

    private int spaltenSumme(int spalte) {
        int summe = 0;
        for (int reihe = 0; reihe < quadrat.length; reihe++)
            summe += quadrat[reihe][spalte];
        return summe;

    }

    private int reihenSumme(int reihe) {
        int summe = 0;
        for (int zahl : quadrat[reihe])
            summe += zahl;
        return summe;
    }
}
