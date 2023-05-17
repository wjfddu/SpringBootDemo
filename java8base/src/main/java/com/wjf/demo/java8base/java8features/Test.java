package com.wjf.demo.java8base.java8features;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        // lambda表达式
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        consumer.accept("爱与被爱的区别");
//
//        Consumer<String> consumer1 = s -> System.out.println(s);;
//        consumer1.accept("接受爱不一定爱对方，爱一定付出真心爱");

//        // Function 函数型接口
//        Function function = i -> i;
//        System.out.println(function.apply(1111));
//
//        // Consumer 消费型接口
//        Consumer<Integer> c = s -> System.out.println(s);
//        c.accept(122);

//        // Supplier 供给型接口
//        Supplier<String> s = () -> "11";
//        System.out.println(s.get());

        // Predicate 断定型接口
//        Predicate<Integer> p = a -> a>1;
//        System.out.println(p.test(1));

        //        List<String> names2 = new ArrayList<String>();
//        names2.add("Google ");
//        names2.add("W3CSchool ");
//        names2.add("Taobao ");
//        names2.add("Baidu ");
//        names2.add("Sina ");
//
//        Collections.sort(names2, (s1, s2) -> s1.compareTo(s2));
//        System.out.println(names2);

        // 方法引用
//        Consumer<String> c = System.out::println;
//        c.accept("23232323");

//        Function<String, Integer> f1 = s -> new Integer(s);
//        f1.apply("221123");
//        Function<String, Integer> f2 = Integer::new;  构造器引用
//
//        Consumer<Integer> c = System.out::println;
//        c.accept(f2.apply("8888888"));

//        Function<Integer,Integer[]> f1 = (num) ->new Integer[num];
//        Function<Integer, Integer[]> f2 = Integer[]::new;
    }
}
