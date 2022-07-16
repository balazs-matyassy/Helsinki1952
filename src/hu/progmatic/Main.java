package hu.progmatic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. adatfájl bemásolása
        // 2. modell osztály (egy sort tartalmazó) létrehozása
        //   mezők + getterek / setterek
        // 3. konstruktorok és / vagy factory-k létrehozása
        // Eredmeny eredmeny = createEredmeny("1 1 atletika kalapacsvetes");
        // Eredmeny eredmeny2 = new Eredmeny("1 1 uszas 400m_gyorsuszas");
        // 4. fájl beolvása soronként
        try {
            List<Eredmeny> eredmenyek = new ArrayList<>();

            // FileReader: karakterenkénti beolvasás fájlból
            // BufferedReader: soronkénti beolvasás bármilyen Readerből
            // try-with resources:
            // a megnyitott FileReadert lezárja a végén automatikusan
            try (BufferedReader reader = new BufferedReader(new FileReader("helsinki.txt"))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            System.out.println("Ez nem írodik ki hiba esetében.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Factory
    // 1. létrehoz a default konstruktor segítségével egy üres objektumot
    // 2. beállítja a mezőket a setterek segítségével
    private static Eredmeny createEredmeny(String line) {
        String[] parts = line.split(" ");

        Eredmeny eredmeny = new Eredmeny();
        eredmeny.setHelyezes(Integer.parseInt(parts[0]));
        eredmeny.setLetszam(Integer.parseInt(parts[1]));
        eredmeny.setSportag(parts[2]);
        eredmeny.setVersenyszam(parts[3]);

        return eredmeny;
    }
}
