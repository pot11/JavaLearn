import bean.UserService;
import org.junit.Test;
import step01.BeanDefinition;
import step01.BeanFactory;

public class ApiTest {
    @Test
    public void testDemo(){
        //创建bean工厂
        BeanFactory beanFactory = new BeanFactory();
        //创建bean定义
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        //beanFactory注册bean
        beanFactory.registBean("user", beanDefinition);
        //beanFactory获取bean
//        ((UserService) beanFactory.getBean("user")).print();
        UserService user = (UserService) beanFactory.getBean("user");
        user.print();
    }


}
