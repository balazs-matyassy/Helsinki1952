package hu.progmatic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainSkeleton {
    public static void main(String[] args) {
        try {
            // 1. adatok beolvasása
            List<Eredmeny> eredmenyek = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("helsinki.txt"))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    Eredmeny eredmeny = new Eredmeny(line);
                    eredmenyek.add(eredmeny);
                }
            }

            // 2. adatok feldolgozása
            System.out.println("Beolvasott adatok száma: " + eredmenyek.size());

            for (Eredmeny eredmeny : eredmenyek) {
                if (eredmeny.getSportag().equals("kajakkenu")) {
                    eredmeny.setSportag("kajak-kenu");
                }
            }

            // 3. adatok kiírása
            try (PrintWriter writer = new PrintWriter("helsinki2.txt")) {
                for (Eredmeny eredmeny : eredmenyek) {
                    // String line = eredmeny.toString();
                    // writer.println(line);
                    writer.println(eredmeny); // toString miatt működik
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
