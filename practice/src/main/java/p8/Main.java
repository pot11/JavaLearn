package p8;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("1", "2");
        Person person1 = new Person("2", "2");
        Person person2 = new Person("3", "3");
        Person person3 = new Person("4", "4");
        List<Person> personList = new ArrayList<>();
        Collections.addAll(personList, person, person1, person2, person3);
//        personList.forEach(t -> {
//            System.out.println(t.getAge());
//        });

        Map<String, List<Person>> collect1 = personList.stream().collect(Collectors.groupingBy(P -> {
            return person.getAge();
        }));


        Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getName));
        System.out.println(collect);

    }
}
