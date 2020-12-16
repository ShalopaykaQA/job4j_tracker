package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public class TrackerSingleField {

    private static TrackerSingleField instance;

    private TrackerSingleField() {
    }

    public static TrackerSingleField getInstance() {
        if (instance == null) {
            instance = new TrackerSingleField();
        }
        return instance;
    }

}
