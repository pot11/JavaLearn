import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDemo01 {
    @Test
    public void method1() {
        System.out.println("测试用例方法1");

    }
    @Before()
    public void method2() {
        System.out.println("测试用例方法2");
    }
}
