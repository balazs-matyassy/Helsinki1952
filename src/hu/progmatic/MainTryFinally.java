package hu.progmatic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainTryFinally {
    public static void main(String[] args) {
        try {
            // 1. fájl beolvasása
            List<Eredmeny> eredmenyek = new ArrayList<>();

            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader("helsinki.txt"));

                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);

                    /* if (line.startsWith("3")) {
                        throw new IOException();
                    } */
                }
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

            // 2. fájl "feldolgozása"
            System.out.println("Ez nem fut le hiba esetében.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
