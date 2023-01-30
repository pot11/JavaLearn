import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDemo02 {
    @Test
    public void method1() {
        List<String> list = new ArrayList<>();
//        list.add("1");
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("是");
        }
    }
}
