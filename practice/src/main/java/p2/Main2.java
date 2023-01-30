package p2;

import java.util.ArrayList;
import java.util.List;

//for循环内list添加对象 如何节省内存 推荐方法二 、减少栈的创建次数
public class Main2 {
    public static void main(String[] args) {
        method1();
        method2();
    }
    private static void method1() {
        List<Person> personList = new ArrayList<>();
        long startCheckSkin = System.currentTimeMillis();
        for (int i=0; i<1000000 ;i++){
            Person person = new Person("姓名编码"+ i,i+"");
            personList.add(person);
        }
        long endCheckSkin = System.currentTimeMillis();
        System.out.println("方法一" + (endCheckSkin - startCheckSkin) + "毫秒");
    }

    private static void method2() {
        List<Person> personList = new ArrayList<>();
        long startCheckSkin = System.currentTimeMillis();
        Person p;
        for (int i=0; i<1000000 ;i++){
            p = new Person("姓名编码"+ i,i+"");
            personList.add(p);
        }
        long endCheckSkin = System.currentTimeMillis();
        System.out.println("方法二" + (endCheckSkin - startCheckSkin) + "毫秒");
    }

}
