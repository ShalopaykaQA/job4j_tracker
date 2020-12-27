package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.util.*;

public class AscItemSort implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        int id1 = o1.getId();
        int id2 = o2.getId();
        return Integer.compare(id1, id2);
    }
}