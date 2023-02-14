package p12;

public class FinalStaticDemo {
    public static void main(String[] args) {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
//        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
//        System.out.println(myClass2.j);
        myClass2.j = 2;
        System.out.println(myClass2.j);

//        method2();
    }

    private static void method2() {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
    }


}
