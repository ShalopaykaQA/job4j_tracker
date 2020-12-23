package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public class TrackerSingleFinalClass {

    private Tracker tracker;

    private TrackerSingleFinalClass() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }
}