package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.util.Objects;

public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.of(2020, 12, 27, 10, 17, 0);

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {

        this.id = id;

        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public LocalDateTime getCreated() {

        return created;
    }

    @Override
    public String toString() {

        return "Item{"
                + "id="
                + id
                + ", name='"
                + name
                + '\''
                + ", created="
                + created
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id
                && Objects.equals(name, item.name)
                && created.equals(item.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created);
    }
}