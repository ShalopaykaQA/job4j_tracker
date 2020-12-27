package ru.job4j.tracker;

import java.util.Comparator;

public class DescItemSort implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        int id1 = o1.getId();
        int id2 = o2.getId();
        return Integer.compare(id2, id1);
    }
}