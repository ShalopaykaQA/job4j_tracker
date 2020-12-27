package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenCmpAscByName() {
        Comparator<Job> cmpAscName = new JobAscByName();
        int rsl = cmpAscName.compare(
                new Job("One", 1),
                new Job("Two", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpDescByName() {
        Comparator<Job> cmpDescName = new JobAscByName();
        int rsl = cmpDescName.compare(
                new Job("Two", 1),
                new Job("One", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCmpAscByPriority() {
        Comparator<Job> cmpAscPriority = new JobAscByPriority();
        int rsl = cmpAscPriority.compare(
                new Job("One", 1),
                new Job("Two", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpDescByPriority() {
        Comparator<Job> cmpDescPriority = new JobDescByPriority();
        int rsl = cmpDescPriority.compare(
                new Job("One", 1),
                new Job("Two", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCmpDescByPriority1() {
        Comparator<Job> cmpDescPriority = new JobAscByPriority()
                .thenComparing(new JobAscByName());
        int rsl = cmpDescPriority.compare(
                new Job("One", 1),
                new Job("Two", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmpByNameAndPriority2() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenCmpByPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority()
                .thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenCmpByPriorityAndName1() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority()
                .thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, greaterThan(0));
    }
}
