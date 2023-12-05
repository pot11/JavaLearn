package p19;

/**
 * @Description:
 * @Author zhengqiang
 * @Date 2023/11/10
 */
import java.util.Arrays;
import java.util.List;

public class AllMatchDemo {
    public static void main(String[] args) {
        // 创建两个列表
        List<String> cppOrderList = Arrays.asList("B", "C");
        List<String> impOrderList = Arrays.asList("A", "B", "C");

        // 演示 allMatch
        boolean elementsMatch = cppOrderList.stream()
                .allMatch(cppOrder -> impOrderList.stream()
                        .anyMatch(impOrder -> cppOrder.equals(impOrder))
                );

        // 输出结果
        System.out.println("Elements match: " + elementsMatch);
    }
}

