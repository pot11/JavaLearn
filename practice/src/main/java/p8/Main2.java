package p8;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();
        Person person= new Person("11","11");
        list1.add(person);
        list2.add(person);
        list1.get(0).setAge("22");
        System.out.println(list2.get(0));

    }
}
