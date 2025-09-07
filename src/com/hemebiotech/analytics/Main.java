package com.hemebiotech.analytics;

public class Main {

    public static void main(String[] args) {
        // Créer le lecteur pour lire les symptômes depuis un fichier
        ISymptomReader reader = new ReadSymptomDataFromFile(
            "C:\\Users\\diatt\\eclipse-workspace\\hemebiotech\\src\\symptoms.txt"
        );

        // Créer l'écrivain pour écrire les résultats
        ISymptomWriter writer = new WriteSymptomDataToFile(
            "C:\\Users\\diatt\\eclipse-workspace\\hemebiotech\\result.out"
        );

        // Créer l'objet AnalyticsCounter
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // Exécuter le traitement complet
        counter.execute();

        System.out.println("Traitement terminé !");
    }
}
