package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AscItemSortTest {

    @Test
    public void compare() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "fff"));
        items.add(new Item(3, "aaa"));
        items.add(new Item(2, "ccc"));

        Collections.sort(items, new AscItemSort());
        List<Item> expected = Arrays.asList(
                new Item(1, "fff"),
                new Item(2, "ccc"),
                new Item(3, "aaa")
        );
        assertThat(items, is(expected));
    }
}