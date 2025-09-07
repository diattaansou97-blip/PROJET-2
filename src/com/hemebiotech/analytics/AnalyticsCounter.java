package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;

    public static void main(String[] args) {
        String filepath = "C:\\Users\\diatt\\eclipse-workspace\\hemebiotech\\src\\symptoms.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line = reader.readLine();

            // Lecture du fichier ligne par ligne
            while (line != null) {
                System.out.println("Symptom from file: " + line);

                if (line.equals("headache")) {
                    headacheCount++;
                } else if (line.equals("rash")) { // corrigé
                    rashCount++;
                } else if (line.contains("pupils")) {
                    pupilCount++;
                }

                line = reader.readLine(); // lire la ligne suivante
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier : " + e.getMessage());
        }

        // Écriture des résultats dans result.out
        try (FileWriter writer = new FileWriter("result.out")) {
            writer.write("headache: " + headacheCount + "\n");
            writer.write("rash: " + rashCount + "\n");
            writer.write("dilated pupils: " + pupilCount + "\n");
        } catch (IOException e) {
            System.err.println("Erreur d'écriture du fichier : " + e.getMessage());
        }
    }
}
