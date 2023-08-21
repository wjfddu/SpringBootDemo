package com.wjf.demo.java8base.java8features;

import javax.swing.text.View;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * 概述
 *
 * Java 8 引入的 Lambda 表达式的主要作用就是简化部分匿名内部类的写法。
 *
 * 能够使用 Lambda 表达式的一个重要依据是必须有相应的函数接口。所谓函数接口，是指内部有且仅有一个抽象方法的接口。
 *
 * Lambda 表达式的另一个依据是类型推断机制。在上下文信息足够的情况下，编译器可以推断出参数表的类型，而不需要显式指名。
 */
public class LambdaTest {

    /**
     * 无参函数的简写
     */
    public void m1(){
        // 在 Java 7 及之前版本，我们一般可以这样使用：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
                System.out.println("Jimmy");
            }
        }).start();

        // 从 Java 8 开始，无参函数的匿名内部类可以简写成如下方式：() -> { 执行语句 }
        // 这样接口名和函数名就可以省掉了。那么，上面的示例可以简写成：
        new Thread(() -> {
            System.out.println("Hello");
            System.out.println("Jimmy");
        }).start();

        // 当只有一条语句时，可以简写成：() -> 表达式，注意这里使用的是表达式，并不是语句，也就是说不需要在语句末尾加分号。
        new Thread(() -> System.out.println("Hello")).start();
    }

    /**
     * 单参函数的简写
     */
    public void m3(){
        // 单参函数的参数列表的括号可以省略，其他无异
        Predicate<Integer> p = i -> i > 0;
    }

    /**
     * 多参函数的简写
     */
    public void m2(){
        // 在 Java 7 及之前的版本，当我们对一个集合进行排序时，通常可以这么写：
        List<Integer> list = Arrays.asList(1, 2, 3);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        // 从 Java 8 开始，多参函数的匿名内部类可以简写成如下方式：([类名1]变量名1, [类名2]变量名2 [, ...]) -> { 执行语句 }，
        // 当只有一条执行语句时，可以简写成：([类名1]变量名1, [类名2]变量名2 [, ...]) -> 表达式
        // 同样类名可以省略，但括号不能省略。如果这条语句需要返回值，那么 return 关键字是不需要写的。
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
    }

}
