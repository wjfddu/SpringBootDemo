package com.wjf.demo.java8base.java8features;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 *
 * 流的来源。 可以是集合，数组，I/O channel，产生器generator 等
 * 将要处理的元素集合看作一种流，流在管道中传输，并且可以在管道的节点上进行处理，比如筛选，排序，聚合等。
 * 元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果。
 *
 * stream() − 为集合创建串行流。
 * parallelStream() − 为集合创建并行流。
 *
 */
public class StreamTest {

    public static void main(String[] args) {
//        filterTest();
//        forEachTest();
//        mapTest();
//        sortedTest();
//        parallelStreamTest();
//        collectorsTest();
        collectorsTest2();
//        statisticsTest();
    }

    /**
     * filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出非空字符串：
     */
    public static void filterTest(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl", null);
        List<String> filtered = strings.stream().filter(string -> string != null && !string.isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }

    /**
     * Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。以下代码片段使用 forEach 输出了10个随机数：
     */
    public static void forEachTest(){
        Random random = new Random();
        random.ints().limit(5).forEach(System.out::println);  // limit 方法用于获取指定数量的流
    }

    /**
     * map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
     */
    public static void mapTest(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5); // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);
    }

    /**
     * sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序
     */
    public static void sortedTest(){
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    /**
     * 并行（parallel）程序
     * parallelStream 是流并行处理程序的代替方法。以下实例我们使用 parallelStream 来输出非空字符串的数量：
     */
    public static void parallelStreamTest(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(string -> string != null && !string.isEmpty()).count();
        System.out.println(String.format("一共%s个非空字符串", count));
    }

    /**
     * Collectors
     * Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
     */
    public static void collectorsTest(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> string != null && !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> string != null && !string.isEmpty()).collect(joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }

    public static void collectorsTest2(){
        List<String> strings = Arrays.asList("abc", "d", "efg", "hi", "jkl");
        String collect = strings.stream().collect(joining(",", " ORDER BY ", " ASC"));
        System.out.println(collect);
    }


    /**
     * 统计
     * 另外，一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
     */
    public static void statisticsTest(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    public static void otherTest(){
        //         Stream.of()

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
