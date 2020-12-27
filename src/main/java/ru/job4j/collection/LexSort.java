package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = -1;
        String[] string1 = left.split(". ");
        String[] string2 = right.split(". ");
        int num1 = Integer.parseInt(string1[0]);
        int num2 = Integer.parseInt(string2[0]);
        return Integer.compare(num1, num2);
    }
}