package com.wjf.demo.java8base.designpattern.creational;

import javax.crypto.KeyGenerator;
import java.text.DateFormat;

/**
 * @author JF
 * @created 2025/8/13 15:27
 * @description
 *
 * 简单工厂模式最大的问题在于工厂类的职责相对过重，增加新的产品需要修改工厂类的判断逻辑，这一点与开闭原则是相违背的。
 *
 */

abstract class Product{
    abstract void use();
}

class ProductA extends Product{
    @Override
    void use() {
        System.out.println("use ProductA");
    }
}

class ProductB extends Product{
    @Override
    void use() {
        System.out.println("use ProductB");
    }
}

class ProductFactory{
    public static Product createProduct(String name){
        if("A".equals(name)){
            return new ProductA();
        } else if ("B".equals(name)) {
            return new ProductB();
        }else return null;
    }
}

/**
 * 简单工厂模式又称为静态工厂方法模式，它属于类创建型模式。在简单工厂模式中，可以根据参数的不同返回不同类的实例。
 * 简单工厂模式专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。
 * 简单工厂模式包含三个角色：工厂角色负责实现创建所有实例的内部逻辑；
 *                      抽象产品角色是所创建的所有对象的父类，负责描述所有实例所共有的公共接口；
 *                      具体产品角色是创建目标，所有创建的对象都充当这个角色的某个具体类的实例。
 *
 *  简单工厂模式最大的优点在于实现对象的创建和对象的使用分离，将对象的创建交给专门的工厂类负责，
 *  但是其最大的缺点在于工厂类不够灵活，增加新的具体产品需要修改工厂类的判断逻辑代码，而且产品较多时，工厂方法代码将会非常复杂。
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        Product a = ProductFactory.createProduct("A");
    }
}
