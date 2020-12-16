package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public enum TrackerSingleEnum {
    INSTANCE;

    private final Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}
