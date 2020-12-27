package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DescItemSortTest {
    @Test
    public void compare() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "fff"));
        items.add(new Item(3, "aaa"));
        items.add(new Item(2, "ccc"));

        Collections.sort(items, new DescItemSort());
        List<Item> expected = Arrays.asList(
                new Item(3, "aaa"),
                new Item(2, "ccc"),
                new Item(1, "fff")
        );
        assertThat(items, is(expected));
    }
}