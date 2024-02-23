package template;

/**
 * @Description: 模板模式
 * @Author zhengqiang
 * @Date 2024/2/23
 */
public class Main {
    /**
     * 注：在Java中，当一个子类继承了父类并重写了某个方法时，子类的对象在调用这个方法时会执行子类重写的版本。这就是所谓的方法覆盖（method overriding）。
     * 在示例中，CoffeeWithHook 类继承了 CoffeeTemplate 类，并重写了 customerWantsCondiments 方法。因此，在创建 CoffeeWithHook 的实例并调用 prepareCoffee 方法时，customerWantsCondiments 方法的执行是基于子类的重写版本而不是父类的实现。
     *
     * @param args
     */
    public static void main(String[] args) {
        // 制作咖啡
        System.out.println("Making plain coffee:");
//        CoffeeTemplate plainCoffee = new CoffeeTemplate() {
//            // 实现具体步骤
//            void boilWater() {
//                System.out.println("Boiling water");
//            }
//
//            void brewCoffeeGrounds() {
//                System.out.println("Brewing coffee grounds");
//            }
//
//            void pourInCup() {
//                System.out.println("Pouring coffee into cup");
//            }
//
//            void addCondiments() {
//                // 不添加调料
//            }
//        };
//        plainCoffee.prepareCoffee();

        System.out.println("\nMaking coffee with hook:");
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();
        coffeeWithHook.prepareCoffee();
    }
}
