package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public class TrackerSingleFinalClass {

    private TrackerSingleFinalClass() {
    }

    public static TrackerSingleFinalClass getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleFinalClass INSTANCE = new TrackerSingleFinalClass();
    }
}