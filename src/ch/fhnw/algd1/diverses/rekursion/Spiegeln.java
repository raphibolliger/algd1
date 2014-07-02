package ch.fhnw.algd1.diverses.rekursion;

import java.io.*;

public class Spiegeln {
	public static void eingabe() throws IOException {
		int c = System.in.read();
		if (c == '\n') {
			System.out.print("Ausgabe: ");
		} else {
			eingabe();
			System.out.print((char)c);
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.print("Eingabe: ");
		eingabe();
	}
}