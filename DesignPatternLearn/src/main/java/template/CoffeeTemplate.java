package template;

/**
 * @Description: 模板类
 * 模板模式（Template Method Pattern）是23种设计模式中的一种。它属于行为型设计模式，用于定义算法的框架结构，将一些步骤的具体实现留给子类来完成。在模板模式中，一个算法的骨架由一个抽象类定义，而具体的步骤则由子类实现。
 * 模板模式的核心思想是定义一个算法的骨架，将一些步骤的具体实现延迟到子类中，使得子类可以在不改变算法结构的情况下重新定义某些步骤的具体实现。
 * 这种模式在实际应用中常见，例如在编程中的模板方法可以在一个抽象类中定义一个算法的骨架，而在具体子类中实现具体的步骤。这样可以提高代码的复用性，同时保持算法的一致性。
 *
 * 钩子方法（Hook Method）是在设计模式中一种用于控制算法流程的手段。它是在模板模式（Template Method Pattern）中经常使用的一种概念。
 * 在模板模式中，模板方法定义了算法的骨架，其中包含一些固定的步骤，而某些步骤的具体实现可以由子类进行扩展。这些可以由子类扩展的步骤就是钩子方法。钩子方法是一种默认实现为空或提供默认行为的方法，子类可以选择性地覆盖或扩展这些方法，从而影响算法的流程。
 * 通过使用钩子方法，可以在不改变算法整体结构的情况下，让子类有选择地参与到算法的执行过程中。这种机制使得模板模式更加灵活，适应不同的需求场景。
 * 总的来说，钩子方法是在算法骨架中留给子类的可选实现的方法，通过这些方法子类可以对算法的某些部分进行定制。
 * @Author zhengqiang
 * @Date 2024/2/23
 */
public abstract class CoffeeTemplate {
    // 模板方法
    final void prepareCoffee() {
        boilWater();
        brewCoffeeGrounds();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // 具体步骤的抽象方法
    abstract void boilWater();

    abstract void brewCoffeeGrounds();

    abstract void pourInCup();

    abstract void addCondiments();

    // 钩子方法，控制是否添加调料
    boolean customerWantsCondiments() {
        return true;
    }
}

