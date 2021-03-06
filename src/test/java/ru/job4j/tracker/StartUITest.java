package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        Input input = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction());
        Input input = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "1"}
        );
        new StartUI(out).init(input, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show all items" + LN
                        + "1. Exit Program" + LN
                        + "=== All items ====" + LN
                        + "Menu." + LN
                        + "0. Show all items" + LN
                        + "1. Exit Program" + LN
        ));
    }

    @Test
    public void whenFindByIdEmpty() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                        + "0. Find item by Id" + LN
                        + "1. Exit Program" + LN
                        + "=== Find item by Id ===" + LN
                        + "Items with this id was not found" + LN
                        + "Menu." + LN
                        + "0. Find item by Id" + LN
                        + "1. Exit Program" + LN
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        Input input = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                        + "0. Find item by Id" + LN
                        + "1. Exit Program" + LN
                        + "=== Find item by Id ===" + LN
                        + "Item{"
                        + "id="
                        + item.getId()
                        + ", name='"
                        + item.getName() + '\''
                        + "}" + LN
                        + "Menu." + LN
                        + "0. Find item by Id" + LN
                        + "1. Exit Program" + LN
        ));
    }

    @Test
    public void whenFindByNameEmpty() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "test name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                        + "0. Find items by name" + LN
                        + "1. Exit Program" + LN
                        + "=== Find item by name ===" + LN
                        + "No items with this name were found" + LN
                        + "Menu." + LN
                        + "0. Find items by name" + LN
                        + "1. Exit Program" + LN
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        Input input = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                        + "0. Find items by name" + LN
                        + "1. Exit Program" + LN
                        + "=== Find item by name ===" + LN
                        + "Item{"
                        + "id="
                        + item.getId()
                        + ", name='"
                        + item.getName() + '\''
                        + "}" + LN
                        + "Menu." + LN
                        + "0. Find items by name" + LN
                        + "1. Exit Program" + LN
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit Program%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit Program%n"
                )
        ));
    }
}