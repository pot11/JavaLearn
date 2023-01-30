package p10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main6 {
    public static void main(String[] args) {
        Person p = new Person("xx","11");

        String a = null;
        List<Person> peopleList = new ArrayList<>();
        List<Person> sonList = new ArrayList<>();
        peopleList.addAll(sonList);
        List<Person> collect = peopleList.stream().skip(1).collect(Collectors.toList());
//        peopleList.addAll(null);
//        for (Person person : peopleList) {
//            System.out.println(person);
//        }
        for (Person person : collect) {
            System.out.println(person);

        }
    }
}
