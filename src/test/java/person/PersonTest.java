package person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PersonTest {
    public static final String DEFAULT_NAME = "Васисуалий";
    public static double DEFAULT_AGE = 25;
    public static final String OTHER_NAME = "Остап";
    public static final String OTHER_AGE = "День рожденья, сегодня мне " + (DEFAULT_AGE + 1);
    public final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Test
    public void allArgsConstructorTest() {
        Person person = new Person(DEFAULT_NAME, DEFAULT_AGE);

        Assertions.assertEquals(DEFAULT_NAME, person.getName());
        Assertions.assertEquals(DEFAULT_AGE, person.getAge());
    }

    @Test
    public void oneArgConstructorTest() {
        Person person = new Person(DEFAULT_AGE);

        Assertions.assertEquals(DEFAULT_AGE, person.getAge());
    }

    @Test
    public void setterTest() {
        Person person = new Person(DEFAULT_NAME, DEFAULT_AGE);
        person.setName(OTHER_NAME);
        Assertions.assertEquals(OTHER_NAME, person.getName());
    }

    @Test
    public void birthdayTest() {
        Person person = new Person(DEFAULT_NAME, DEFAULT_AGE);

        PrintStream old = System.out;
        System.setOut(new PrintStream(output));
        person.birthday();
        Assertions.assertEquals(output.toString(), OTHER_AGE);
        System.setOut(old);
    }

    @Test
    public void isOverEighteenTest() {
        Person person = new Person(DEFAULT_NAME, DEFAULT_AGE);
        Assertions.assertTrue(person.takeBeer(), String.valueOf(true));
        person.setAge(14);
        Assertions.assertFalse(person.takeBeer(), String.valueOf(false));
    }

}
