package hu.progmatic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTryWithResources {
    public static void main(String[] args) {
        try {
            List<Eredmeny> eredmenyek = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("helsinki.txt"))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
