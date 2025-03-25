package se.thinkcode.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FamilyTest {
    private final Family family = new Family();
    private Person malin;

    @BeforeEach
    void setUp() {
        Person farfar = new Person(null, null, "John");
        Person farmor = new Person(null, null, "Inga");
        Person far = new Person(farfar, farmor, "Carl-Johan");

        Person morfar = new Person(null, null, "Ruben");
        Person mormor = new Person(null, null, "Brita");
        Person mor = new Person(morfar, mormor, "Siv");

        malin = new Person(far, mor, "Malin");
    }

    @Test
    void should_look_at_a_family_tree() {
        family.print(malin);
    }

    @Test
    void should_find_longest_name_of_family_tree() {
        String actual = family.longestName(malin);

        assertThat(actual).isEqualTo("Carl-Johan");
    }
}
