package ru.job4j.tracker;

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