package p2;

import java.util.ArrayList;
import java.util.List;

//for循环内list添加对象 如何节省内存
public class Main {
    public static void main(String[] args) {
        Person p1= new Person("张飞","1");
        Person p2= new Person("赵云","2");
        Person p3= new Person("刘备","3");
        Person p4= new Person("关羽","4");
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        Person p;
//        Person p5= new Person("曹操","5");
//        Person p6= new Person("李虎","6");
        List<Person> personList2 = new ArrayList<>();
        for (Person person : personList) {
            p= new Person(person.getName(),person.getAge());
            personList2.add(p);
        }

        for (Person person : personList2) {
            System.out.println(person);
        }
    }
}
