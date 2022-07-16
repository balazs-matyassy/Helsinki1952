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
        // 5. számított getterek megvalósítása (alternatíva: statikus segédmetódus)
        // 6. toString megvalósítása (alternatíva: külső logika), megtanítjuk az objektumokat szöveges visszaadni magukat
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

    // "külső" getter
    private static int getOlimpiaiPont(int helyezes) {
        switch (helyezes) {
            case 1:
                return 7;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            default:
                return 0;
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
