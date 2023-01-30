package p10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main5 {
    public static void main(String[] args) {
        Person p = new Person("xx","11");

        String a = null;
        List<Person> people = Collections.singletonList(p);
        List<String> strings = Collections.singletonList(a);
        System.out.println(strings);
    }
}
