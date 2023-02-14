package p13;

import java.util.ArrayList;
import java.util.List;

//所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的 <E>）。
//        每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
//        类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
//        泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像 int、double、char 等）。
//        java 中泛型标记符：
//
//        E - Element (在集合中使用，因为集合中存放的是元素)
//        T - Type（Java 类）
//        K - Key（键）
//        V - Value（值）
//        N - Number（数值类型）
//        ？ - 表示不确定的 java 类型
public class  FanXinDemo2<T> {

    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
