package ru.job4j.collection;

import java.util.List;

public class Article {
    public static boolean generateBy(String originText, String duplicateText) {
        List<String> originList = List.of(originText.split("\\s*(\\s|,|!|\\.)\\s*"));
        List<String> duplicateList = List.of(duplicateText.split("\\s*(\\s|,|!|\\.)\\s*"));
        boolean rsl = true;
        for (String word : duplicateList) {
            if (!originList.contains(word)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}