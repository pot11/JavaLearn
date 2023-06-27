package step01;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建容器，存放bean，注册、获取bean
 */
public class BeanFactory {
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 注册bean
     * @param beanName
     * @param beanDefinition
     */
    public void registBean(String beanName,BeanDefinition beanDefinition){
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 获取bean
     * @param beanName
     * @return
     */
    public Object getBean(String beanName){
        return beanDefinitionMap.get(beanName).getBean();
    }
}
