package p10;

import java.util.ArrayList;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("小米");
        person.setAge("11");
        Person person2 = null;
        System.out.println(Optional.ofNullable(person).map(p ->p.getName()).orElse("xxxx"));
        Optional.ofNullable(person).ifPresent(p -> {System.out.println(p.getName());});

        ArrayList<Person> people = new ArrayList<>();
        System.out.println(people.get(0));

    }
}
