import org.junit.Test;
import sun.net.spi.nameservice.dns.DNSNameService;

public class TestDemo03 {
    @Test
    public void test01() {
        //三个类加载器的关系
        //父子关系
        ClassLoader c1 = TestDemo03.class.getClassLoader();
        System.out.println(c1);
        ClassLoader c2 = c1.getParent();
        System.out.println(c2);
        ClassLoader c3 = c2.getParent();
        System.out.println(c3);
    }

    @Test
    public void app(){
        ClassLoader c1 = TestDemo03.class.getClassLoader();
        System.out.println(c1);
    }
    @Test
    public void ext(){
        ClassLoader c1 = DNSNameService.class.getClassLoader();
        System.out.println(c1);
    }
    @Test
    public void boot(){
    //引导类加载器,不是类,JVM内部,返回值null
        ClassLoader cl = String.class.getClassLoader();
        System.out.println(cl);
    }


}
