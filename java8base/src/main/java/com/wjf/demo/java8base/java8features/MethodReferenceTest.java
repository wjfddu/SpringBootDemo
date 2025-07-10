package com.wjf.demo.java8base.java8features;

import java.util.*;
import java.util.function.Function;

// 来源：https://baijiahao.baidu.com/s?id=1649928629451917925&wfr=spider&for=pc

/**
 * 在我们使用 Lambda 表达式的时候，如果“->”的右边要执行的表达式只是调用一个类已有的方法，那么就可以用「方法引用」来替代 Lambda 表达式。
 *
 * 方法引用可以分为 4 类：
 *  引用静态方法；
 *  引用对象的方法；
 *  引用类的方法；
 *  引用构造方法。
 */
public class MethodReferenceTest {

    private static class Utils {
        public static int compare(Integer o1, Integer o2){
            return o1.compareTo(o2);
        }
    }

    private class MyClass {
        public MyClass() {
        }
        public MyClass(Integer integer) {
        }

        public int compare(Integer o1, Integer o2){
            return o1.compareTo(o2);
        }
    }

    /**
     * 引用静态方法
     * 当我们要执行的表达式是调用某个类的静态方法，并且这个静态方法的参数列表和接口里抽象函数的参数列表一一对应时，我们可以采用引用静态方法的格式。
     *
     * 假如 Lambda 表达式符合如下格式：
     *
     * ([变量1, 变量2, ...]) -> 类名.静态方法名([变量1, 变量2, ...])
     *
     * 我们可以简写成如下格式：
     *
     * 类名::静态方法名
     *
     * 注意这里静态方法名后面不需要加括号，也不用加参数，因为编译器都可以推断出来。
     */
    public void m1(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        // 一般的 Lambda 表达式可以这样写：
        Collections.sort(list, (o1, o2) -> Utils.compare(o1, o2));
        
        // 如果采用方法引用的方式，可以简写成这样：
        Collections.sort(list, Utils::compare);
    }

    public int compare(Integer o1, Integer o2){
        return o1.compareTo(o2);
    }

    /**
     * 引用对象的方法
     * 当我们要执行的表达式是调用某个对象的方法，并且这个方法的参数列表和接口里抽象函数的参数列表一一对应时，我们就可以采用引用对象的方法的格式。
     *
     * 假如 Lambda 表达式符合如下格式：
     *
     * ([变量1, 变量2, ...]) -> 对象引用.方法名([变量1, 变量2, ...])
     *
     * 我们可以简写成如下格式：
     *
     * 对象引用::方法名
     */
    public void m2(){
        List<Integer> list = Arrays.asList(1, 2, 3);

        // 当我们创建一个该类的对象，并在 Lambda 表达式中使用该对象的方法时，一般可以这么写：
        MyClass myClass = new MyClass();
        Collections.sort(list, (o1, o2) -> myClass.compare(o1, o2));

        // 那么采用方法引用的方式，可以这样简写：
        Collections.sort(list, myClass::compare);

        // 此外，当我们要执行的表达式是调用 Lambda 表达式所在的类的方法时，我们还可以采用如下格式：this::方法名
        Collections.sort(list, this::compare);
    }

    /**
     * 引用类的方法
     * 引用类的方法所采用的参数对应形式与上两种略有不同。如果 Lambda 表达式的 “->” 的右边要执行的表达式是调用的 “->” 的左边第一个参数的某个实例方法，
     * 并且从第二个参数开始（或无参）对应到该实例方法的参数列表时，就可以使用这种方法。
     *
     * 假如我们的 Lambda 表达式符合如下格式：
     *
     * (变量1 [, 变量2, ...]) -> 变量1.实例方法([变量2, ...])
     *
     * 那么我们的代码就可以简写成：
     *
     * 变量1对应的类名::实例方法名
     *
     */
    public void m3(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        // 当我们使用的 Lambda 表达式是这样时：
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));

        // 就可以简写成这样：
        Collections.sort(list, Integer::compareTo);
    }

    /**
     * 引用构造方法
     * 当我们要执行的表达式是新建一个对象，并且这个对象的构造方法的参数列表和接口里函数的参数列表一一对应时，我们就可以采用「引用构造方法」的格式。
     *
     * 假如我们的 Lambda 表达式符合如下格式：
     *
     * ([变量1, 变量2, ...]) -> new 类名([变量1, 变量2, ...])
     *
     * 我们就可以简写成如下格式：
     *
     * 类名::new
     */
    public void m4(){
        Function<Integer, ArrayList> function;
        // 我们用这个接口来实现一个功能，创建一个指定大小的 ArrayList。
        function = new Function<Integer, ArrayList>(){
            @Override
            public ArrayList apply(Integer n) {
                return new ArrayList(n);
            }
        };
        List list = function.apply(10);

        // 使用 Lambda 表达式，我们一般可以这样写：
        function = n -> new ArrayList(n);

        // 使用「引用构造方法」的方式，我们可以简写成这样：
        function = ArrayList::new;
    }

    public void m5(){
        Function<Integer, MyClass> function;
        function = MyClass::new;
    }
}
