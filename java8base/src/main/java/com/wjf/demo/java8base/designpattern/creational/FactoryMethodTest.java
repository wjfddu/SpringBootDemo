package com.wjf.demo.java8base.designpattern.creational;


/**
 * @author JF
 * @created 2025/8/13 15:27
 * @description
 *
 * 定义抽象工厂 用来创建 抽象产品
 * 一句话：具体的产品 由 具体的工厂类创建
 * 在工厂方法模式中，核心的工厂类不再负责所有产品的创建，而是将具体创建工作交给子类去做。
 * 这个核心类仅仅负责给出具体工厂必须实现的接口，而不负责哪一个产品类被实例化这种细节，这使得工厂方法模式可以允许系统在不修改工厂角色的情况下引进新产品。
 */
// 抽象工厂
abstract class Factory {
    abstract Product createProduct(); // 工厂方法
}

class ProductAFactory extends Factory{
    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ProductBFactory extends Factory{
    @Override
    Product createProduct() {
        return new ProductB();
    }
}

public class FactoryMethodTest {
    public static void main(String[] args) {
        Product product = new ProductAFactory().createProduct();
    }
}
interface I{
    interface J{

    }
}