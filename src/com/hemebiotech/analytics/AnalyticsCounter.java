package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Collections;

public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

    // Constructeur
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    // Méthode principale qui exécute toutes les étapes
    public void execute() {
        List<String> symptoms = getSymptoms();
        Map<String, Integer> counted = countSymptoms(symptoms);
        Map<String, Integer> sorted = sortSymptoms(counted);
        writeSymptoms(sorted);
    }

    // Récupère les symptômes depuis le fichier
    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    }

    // Compte les occurrences de chaque symptôme
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (String s : symptoms) {
            result.put(s, result.getOrDefault(s, 0) + 1);
        }
        return result;
    }

    // Trie les symptômes par ordre alphabétique
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> sorted = new LinkedHashMap<>();
        symptoms.keySet().stream().sorted().forEach(k -> sorted.put(k, symptoms.get(k)));
        return sorted;
    }

    // Écrit le résultat dans le fichier
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}
