package com.wjf.demo.java8base.generic._new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JF
 * @created 2025/8/21 16:58
 * @description
 */

class Fruit {
    @Override
    public String toString() {
        return "fruit";
    }
}

class Apple extends Fruit{
    @Override
    public String toString() {
        return "apple";
    }
}

class Orange extends Fruit{
    @Override
    public String toString() {
        return "orange";
    }
}

public class WhyNotAddExample {
    public static void main(String[] args) {
        // 创建不同类型的列表
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());

        List<Orange> oranges = new ArrayList<>();
        oranges.add(new Orange());

        // 这些调用都是合法的
        processFruits(apples);   // List<Apple> 赋值给 List<? extends Fruit>
        processFruits(oranges);  // List<Orange> 赋值给 List<? extends Fruit>

//        List<Object> objects = new ArrayList<>();
//        processFruits(objects);

        // 演示问题：如果允许添加会发生什么
        demonstrateTheProblem(apples);
    }

    public static void processFruits(List<? extends Fruit> fruits) {
        // 这里 fruits 可能是 List<Apple>, List<Orange>, List<Fruit> 等

        // 读取是安全的 - 我们知道所有元素至少是 Fruit
        Fruit firstFruit = fruits.get(0);
        System.out.println("First fruit: " + firstFruit);
//        fruits.contains()
        // 但为什么不能添加？
        // fruits.add(new Apple());  // 编译错误
        // fruits.add(new Orange()); // 编译错误
        // fruits.add(new Fruit());  // 编译错误

        // 唯一可以添加的是 null
        fruits.add(null); // 这是允许的

        System.out.println(fruits);
    }

    // 演示如果允许添加会引发的问题
    public static void demonstrateTheProblem(List<Apple> apples) {
        // 假设我们可以这样做（但实际上不能）
         List<? extends Fruit> fruits = apples; // 这是合法的

        // 如果编译器允许这样写：
        // fruits.add(new Orange()); // 假设这能编译

        // 那么实际上我们就向一个 List<Apple> 中添加了一个 Orange!
        // 这违反了类型安全，会导致 ClassCastException 或其他运行时错误

        // 从 apples 中获取第一个元素，期望是 Apple
        // Apple apple = apples.get(0); // 但如果上面添加了Orange，这里会抛出ClassCastException
    }
    /*
    详细解释
    1. 类型不确定性
    */
    public void addToFruitList(List<? extends Fruit> fruits) {
        // 编译器不知道 fruits 的具体类型是什么：
        // - 可能是 List<Apple>
        // - 可能是 List<Orange>
        // - 可能是 List<Fruit>
        // - 可能是 List<AnyOtherFruitSubclass>

        // 如果我们允许 fruits.add(new Apple())
        // 但 fruits 实际上可能是 List<Orange>
        // 这就向橙子列表中添加了苹果，违反类型安全
    }

    static void m1(){
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);


//         processNumbers(integers); // 编译错误 - 类型不匹配
        processNumbersWildcard(integers); // 正确 - 使用通配符
        processNumbersWildcard(doubles);  // 正确 - 使用通配符
        processNumbersWildcard2(new ArrayList<>());
    }


    // 没有通配符 - 只能接受 List<Number>
    public static void processNumbers(List<Number> numbers) {
        // 处理数字
    }

    // 使用通配符 - 可以接受 List<Integer>, List<Double> 等
    public static void processNumbersWildcard(List<? extends Number> numbers) {
        // 处理任何Number子类的列表
    }

    public static void processNumbersWildcard2(List<? super Number> numbers) {
        // 处理任何Number子类的列表
    }
}
