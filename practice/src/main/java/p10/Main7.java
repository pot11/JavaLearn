package p10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main7 {
    public static void main(String[] args) {
//        Person p = new Person("xx","11");
//
//        String a = null;
//        List<Person> peopleList = new ArrayList<>();
//        List<Person> sonList = new ArrayList<>();

//        List<String> list = Arrays.asList("hello","world");
//        List<String[]> collect = list.stream().map(t -> t.split(" ")).distinct().collect(Collectors.toList());
//        System.out.println(collect);

        Stream<String> stream = Arrays.stream(new String[]{"hello", "world"});
        List<Stream<String>> collect = stream.map(t -> t.split("")).map(Arrays::stream).distinct().collect(Collectors.toList());
        List<String> collect1 = stream.map(t -> t.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());

    }
}
