package person;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
    private String name;
    private double age;

    public Person(double age) {
        this.age = age;
    }

    public void birthday() {
        System.out.print("День рожденья, сегодня мне " + (age + 1));
    }

    public boolean takeBeer() {
        if (age < 18) return false;
        return true;
    }
}
