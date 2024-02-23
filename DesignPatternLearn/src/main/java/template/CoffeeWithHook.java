package template;

import java.util.Scanner;

/**
 * @Description: 具体实现类
 * @Author zhengqiang
 * @Date 2024/2/23
 */
public class CoffeeWithHook extends CoffeeTemplate {
    // 实现具体步骤
    void boilWater() {
        System.out.println("Boiling water");
    }

    void brewCoffeeGrounds() {
        System.out.println("Brewing coffee grounds");
    }

    void pourInCup() {
        System.out.println("Pouring coffee into cup");
    }

    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }

    // 重写钩子方法
    boolean customerWantsCondiments() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to add sugar and milk? (yes/no): ");
        String response = scanner.nextLine().toLowerCase();
        return response.equals("yes");
    }
}
