package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public class TrackerSingleFinalClass {

    private Tracker tracker;

    private TrackerSingleFinalClass() {
        this.tracker = new Tracker();
    }

    public Tracker getTracker() {
        return tracker;
    }

    public static TrackerSingleFinalClass getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleFinalClass INSTANCE = new TrackerSingleFinalClass();
    }
}