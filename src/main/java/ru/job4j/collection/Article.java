package ru.job4j.collection;

import java.util.HashSet;

public class Article {
    public static boolean generateBy(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split("");
        String[] text = duplicateText.split("");
        HashSet<String> check = new HashSet<>();
        for (String word : origin) {
            check.add(word);
        }
        for (String word : text) {
            if (!check.contains(word)) {
                rsl = false;
            }
        }
        return rsl;
    }
}