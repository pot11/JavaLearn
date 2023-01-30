package lambda01;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class Main {
    public static void main(String[] args) {
//        method1();
//        method2();
//        method3();
//        method4();
        method5();
        method6();
    }

    private static void method6() {
    }
    private static void method5() {
//        foreachArr(new IntConsumer() {
//            @Override
//            public void accept(int value) {
//                System.out.println(value);
//            }
//        });

        foreachArr((int value) ->{
            System.out.println(value);
        });
    }

    public static void foreachArr(IntConsumer consumer){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            consumer.accept(i);
        }
    }

    private static void method4() {
//        Integer result = typeConver(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return Integer.valueOf(s);
//            }
//        });
//        System.out.println(result);

        Integer result = typeConver((String s)-> {
            return Integer.valueOf(s);
        });
        System.out.println(result);

    }
    public static <R> R typeConver(Function<String, R> function){
        String str ="1111";
        R result = function.apply(str);
        return result;
    }


    private static void method3() {
//        printNum(new IntPredicate() {
//            @Override
//            public boolean test(int value) {
//                return value%2 == 0;
//            }
//        });

        printNum((int value) ->{
            return value%2 == 0;
        });

    }
    public static void printNum(IntPredicate predicate){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            if(predicate.test(i)){
                System.out.println(i);
            }
        }
    }

    private static void method2() {
//        int result= calculateNum(new IntBinaryOperator() {
//            @Override
//            public int applyAsInt(int left, int right) {
//                return left + right;
//            }
//        });
//        System.out.println(result);

        int result= calculateNum((int left, int right) -> {
            return left + right;
        });
        System.out.println(result);
    }

    public static int calculateNum(IntBinaryOperator operator){
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a ,b);
    }

    private static void method1() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("线程运行");
//            }
//        }).start();

        new Thread(() -> {
            System.out.println("线程运行");
        }).start();
    }
}
