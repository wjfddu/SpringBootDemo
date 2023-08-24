package com.wjf.demo.java8base.generic;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

// 来源：https://blog.csdn.net/qq_38074398/article/details/131051623
// 参考价值：https://www.yii666.com/blog/283247.html
//         https://blog.csdn.net/weixin_45970271/article/details/125031446
/**
 *
 *
 * 协变，逆变，抗变等概念是从数学中来的，在编程语言Java/Kotlin/C#中主要应用在泛型上。描述的是两个类型集合之间的继承关系。
 *
 * 在Java/Kotlin/C#中，由于Dog是Animal的子类型，那么List<Dog>也是List<Animal>的子类型吗？实则不然，两个列表是两个完全不同的类型。协变、逆变、抗变描述的就是两个类型集合间的关系。
 *
 * 协变(Covariance)：List<Dog>是List<Animal>的子类型
 *      代价：无法添加元素，只能获取元素，因此协变只能作为生产者，向外提供数据。
 * 逆变(Contravariance): List<Animal>是List<Dog>的子类型
 * 抗变(Invariant): List<Animal>与List<Dog>二者间没有任何继承关系
 *
 * 协变、逆变小结
 * 协变体现在方法的返回值类型为泛型类型时。
 * 逆变体现在方法的参数类型为泛型类型时。
 * 如下：
 * 只读取，且类型满足协变关系，使用 ? extends T
 * 只写入，且类型满足逆变关系，使用 ? super T
 *
 */
public class GenericTest {

    /**
     * 数组的协变
     * 由于历史原因，数组是默认支持协变的。
     *
     */
    public void m1(){
        // 将一个子类型数组的引用，协变后成功赋值给了父类型的数组引用。就会引发通过 objArr 对 strArr 赋值了一个其他子类型的元素，比如 Integer 10。
        // 所以 java 语言在运行时会检查并抛出 ArrayStoreException。很明显这种只能在运行时才暴露问题的机制很不友好，这种代码不应该被成功编译，或者就不支持协变这种机制。
        Object[] objArr = new Object[2];
        String[] strArr = new String[] {"A"};
        objArr = strArr;
        // objArr[0] = 1; // 编译通过，但运行时会抛出：ArrayStoreException
        objArr[0] = "B"; // success
        System.out.println(objArr[0]);
    }

    // java 在泛型编程中的做法是，支持协变与逆变这两种特性，并同时在编译期检查数据类型的正确性。

    /**
     * 泛型不同数组，默认是具有抗变性的。
     */
    public void m2(){
        List<Object> objList = new ArrayList<>();
        List<String> strList = new ArrayList<>();

        // objList = strList; 编译失败

        // 比如上面的例子，即使 String 是 Object 的子类，但也无法直接扩展为 List<Object>。如果可以这么做，就会发生数组的 ArrayStoreException 的情况：
        // objList = strList;
        // objList.add(100);
        // String str = objList.get(0);

        // 就如开头时提到的：List<String> 与 List<Object> 就是两种不同的类型（虽然 String 与 Object 存在继承关系），二者类型没有任何关系。
        // 这样虽然代码上安全了许多，但大大降低了代码的灵活性。如有些场景，为了代码的通用性，仍需要协变、逆变的这种特性打破泛型的抗变性，使得可以处理更多泛型类型的数据。
        // 不然处理一些含有泛型的数据时，是很难做到更好的兼容的，只能针对于每种泛型类型都编写一个方法
    }

    static class MyArrayList extends ArrayList<Double> {
        @Override
        public boolean add(Double d) {
            return super.add(d);
        }
    }

    /**
     * 泛型类型的协变
     * 前面说到在泛型中默认具有抗变性，那么如何打破这种限制？上界限定符: ? extends T
     */
    public void m3(){
        List<Double> dList = new ArrayList<>();
        List<? extends Number> nList = new ArrayList<Number>();
        List<? extends Number> nList2 = new ArrayList<Double>();

        // List<? extends Number> nList2 = new ArrayList<Object>(); // 编译失败

        nList = dList;
        nList2 = dList;
        // nList = dList 编译通过！那么是否还会存在类似数组的 ArrayStoreException 的情况吗？我们尝试在 nList 中分别添加 Double、Integer 元素。
        // nList.add(1.23D); // 编译失败
        // nList.add(123); // 编译失败

        // 协变的限制（代价）：无法再向 list 中添加协变前（没有 ? extends 修饰时）能正常添加的数据
        // 只是泛型的做法更加直接，无论这个元素的类型是否为正确的，都不让添加，避免存储异常。

        // !!! 为何不能添加？
        // 要知道为什么，我们首先需要了解Java当中桥接方法的来由。
        // 首先，我们肯定知道ArrayList类中的add方法的原型是下面这样的
        // public boolean add(E e)
        // 在Java当中，是在编译时去进行类型擦除的，在运行时并无泛型类型一说。也就是说，该原型方法，会被抹掉成为
        // public boolean add(Object e)


        // 协变的好处
        // 可以正常的获取元素，元素类型为协变父类型：Number。
        Number number = nList.get(0);
    }

    /**
     * 协变&逆变生效的位置
      */
    static class AnimalFactory<T> {
        public T provide() {return null;}
        public void receive(T t) {}
    }

    static class Animal {}

    static class Cat extends Animal {}

    static class Dog extends Animal {}

    /**
     * 协变生效的位置：方法形参 & 返回值
     */
    public static void test1() {
        // 协变前
        AnimalFactory<Animal> factory = new AnimalFactory<>();
        Animal provide1 = factory.provide();
        factory.receive(new Cat());

        // 协变后
        AnimalFactory<? extends Animal> factory2 = new AnimalFactory<>();
        Animal provide2 = factory2.provide(); // 返回值类型为泛型类型
        // factory2.receive(new Animal()); // 方法形参为泛型类型 (编译失败)
        factory2.receive(null); // null 是一种特殊情况

        // factory2 的泛型类型已经从 Animal 协变为了 ? extends Animal，使得含有泛型类型形参 与 返回值的方法发生了改变。
        // 1.含有泛型类型返回值的方法：可以正常获取
        // 2.含有泛型类型形参的方法：无法在传入任何非 null 的实例
    }

    /**
     * 协变的应用
      */
    public static void main3(String[] args) {
        List<Byte> bList = new ArrayList<>();
        bList.add((byte) 1);
        bList.add((byte) 2);

        List<Double> dList = new ArrayList<>();
        dList.add(1D);
        dList.add(2D);

        double v1 = sum2Double(bList);
        double v2 = sum2Double(dList);

        System.out.println("v1:" + v1 + "\tv2:" + v2);
    }

    static double sum2Double(List<? extends Number> numbers) {
        double res = 0;
        for (Number number : numbers) {
            res += number.doubleValue();
        }
        return res;
    }

    /**
     * 泛型类型的逆变
     * 逆变与协变是相对的，表示泛型类型可为指定类型自身及其父类。通过下界限定符: ? super T 进行声明。
     */
    public void m4(){
        // 逆变的好出
        List<Object> objList = new ArrayList<>();
        List<? super Number> nList = new ArrayList<Number>();
        List<? super Number> nList2 = new ArrayList<Object>();

        // List<? super Number> nList2 = new ArrayList<Double>(); // 编译失败

        nList = objList;
        // nList = objList 编译通过！那么是否还会存在类似数组的 ArrayStoreException 的情况吗？我们尝试在 nList 中分别添加 Number 、Object 元素。

        nList.add(new Number() {
            @Override
            public int intValue() {
                return 0;
            }

            @Override
            public long longValue() {
                return 0;
            }

            @Override
            public float floatValue() {
                return 0;
            }

            @Override
            public double doubleValue() {
                return 0;
            }
        });
        nList.add(1.23D);

        // nList.add(new Object()); // 编译失败

        // 启用逆变后，可以正常的在列表中添加元素，但可添加的元素类型为泛型类型自身及其子类型。
        // 之所以能够添加泛型类型的子类类型元素，是因为下界限定符限定列表中的元素类型为泛型类型的父类类型，而泛型类型的子类也一定是泛型类型父类的子类。

        // 逆变的限制
        // 无法再正常获取元素，因为不知道元素类型究竟是泛型类型的哪个父类型。这正是逆变的代价：无法再获取 list 中协变前（没有 ? super 修饰时）能正常获取的数据。

        // Number n = nList.get(0); // 编译失败

        // 但 Object 是一种特殊情况，因为它是一切对象的父类。
        Object obj = nList.get(0);
    }


    /**
     * 逆变生效的位置：方法形参 & 返回值
     */
    public static void test2() {
        // 逆变前
        AnimalFactory<Animal> factory1 = new AnimalFactory<>();
        Animal provide1 = factory1.provide();
        factory1.receive(new Cat());

        // 逆变后
        AnimalFactory<? super Animal> factory2 = new AnimalFactory<>();
        // Animal provide2 = factory2.provide(); // 返回值类型为泛型类型 (编译失败)
        // factory2.receive(new Object()); // 方法形参为泛型类型的父类 (编译失败)
        factory2.receive(new Animal()); // 方法形参为泛型类型自身
        factory2.receive(new Cat()); // 方法形参为泛型类型的子类
    }



    /**
     * ================================================================================================================
     * 逆变的应用
     */
    static <T> Collection<T> remove(Collection<T> col, Predicate<? super T> filter) {
        List<T> removeList = new ArrayList<>();
        for (T t : col) {
            if (filter.test(t)) {
                removeList.add(t);
            }
        }
        col.removeAll(removeList);
        return col;
    }

    /**
     * 编写一个方法，可以对泛型类型为 Number 的列表进行数据过滤
     */
    private static void filterNumberLessthan1(){
        List<Number> list = new ArrayList<>();
        list.add(1);
        list.add(10.1D);
        list.add(0.1D);
        list.add(10L);

        Predicate<? super Number> p = number -> {
            int i = number.intValue();
            return i < 1;
        };

        Collection<Number> remaining = remove(list, p);
        remaining.stream().forEach(number -> System.out.println(number));
    }

    public static void main(String[] args) {
        filterNumberLessthan1();
    }

    /**
     * 协变与逆变的结合应用
     */
    public static void main2(String[] args) {
        List<Integer> list1 = Lists.newArrayList(1, 2, 3);
        List<Integer> list2 = Lists.newArrayList(4, 5, 6);
        copy(list1, list2);
        System.out.println(list1); // [1, 2, 3]
        System.out.println(list2); // [1, 2, 3, 4, 5, 6]
    }

    /**
     * 读 <? extends T> src，写 <? super T> dest
     * @param src
     * @param dest
     * @param <T>
     */
    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        int size = src.size();
        for (int i = 0; i < size; i++) {
            dest.add(i, src.get(i)); // 读src，写dest
        }
    }

    /**
     * 任意通配符
     * 通配符 ?，表示任意类型。仅有协变、逆变的两种特殊情况。
     */
    public static void any(List<?> list) {
        Object o = list.get(0);
        list.add(0, null);
        // list.add(0, new Object()); // 编译失败
    }

    /**
     *  extends 通配符的其他应用
     *  应用一：另一种方法形参类型限定
     */
    // 限定泛型类型为 Animal 与其子类型，返回值类型只能为 Animal。语义同 createAnimal2
    public static Animal createAnimal1(Class<? extends Animal> animalClass) {
        try {
            return animalClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 限定泛型类型为 Animal 与其子类型，返回值类型只能为 Animal。语义同 createAnimal1
    public static <T extends Animal> Animal createAnimal2(Class<T> animalClass) {
        try {
            return animalClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 限定泛型类型为 Animal 与其子类型，返回值类型可以为具体的传入的 T 类型，而不是只能返回 Animal 类型
    public static <T extends Animal> T createAnimal3(Class<? extends T> animalClass) {
        try {
            return animalClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void extendsTest1() {
        Animal cat1 = createAnimal1(Cat.class);
        Animal dog1 = createAnimal1(Dog.class);
        Animal animal1 = createAnimal1(Animal.class);

        Animal cat2 = createAnimal2(Cat.class);
        Animal dog2 = createAnimal2(Dog.class);
        Animal animal2 = createAnimal2(Animal.class);

        Cat cat3 = createAnimal3(Cat.class);
        Dog dog3 = createAnimal3(Dog.class);
        Animal animal3 = createAnimal3(Animal.class);
    }

    /**
     * extends 通配符的其他应用
     * 应用二：应用在类、接口泛型
     */
    abstract static class Person {
        public void born() { System.out.println("嘤嘤嘤"); }
    }

    static class Man extends Person {}

    static class Woman extends Person {}

    static class PersonFactory<T extends Person> {
        public T create(Class<T> personClass) {
            try {
                T t = personClass.newInstance();
                t.born();
                return t;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void extendsTest2() {
        PersonFactory<Man> manFactory = new PersonFactory<>();
        Man man = manFactory.create(Man.class);
        // manFactory.create(Woman.class); // 编译失败

        PersonFactory<Woman> womanFactory = new PersonFactory<>();
        Woman woman = womanFactory.create(Woman.class);
        // womanFactory.create(Man.class); // 编译失败
    }

}
