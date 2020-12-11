package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item("Zayava");
        tracker.add(item);
        Item item1 = new Item("Zayava1");
        tracker.add(item1);
        Item item2 = new Item("Zayava2");
        tracker.add(item2);
        Item item3 = new Item("Zayava3");
        tracker.add(item3);
        Item item4 = new Item("Zayava4");
        tracker.add(item4);
        Item item5 = new Item("Zayava");
        tracker.add(item5);
        Item item6 = new Item("Zayava");
        tracker.add(item6);
        Item item7 = new Item("Zayava");
        tracker.add(item7);
        Item item8 = new Item("Zayava");
        tracker.add(item8);
        System.out.println(tracker.findById(9));
    }
}