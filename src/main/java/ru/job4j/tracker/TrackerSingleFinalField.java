package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public class TrackerSingleFinalField {

    private static final TrackerSingleFinalField INSTANCE = new TrackerSingleFinalField();

    private TrackerSingleFinalField() {
    }

    public static TrackerSingleFinalField getInstance() {
        return INSTANCE;
    }

}