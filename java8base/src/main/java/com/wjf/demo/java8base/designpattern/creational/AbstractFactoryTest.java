package com.wjf.demo.java8base.designpattern.creational;

/**
 * @author JF
 * @created 2025/8/13 15:28
 * @description
 */

abstract class AirConditioner {
    abstract void makeCold();
}
abstract class WashingMachine{
    abstract void washClothes();
}
class HaierAirConditioner extends AirConditioner{
    @Override
    void makeCold() {

    }
}
class MideaAirConditioner extends AirConditioner{
    @Override
    void makeCold() {

    }
}
class HaierWashingMachine extends WashingMachine{
    @Override
    void washClothes() {

    }
}
class MideaWashingMachine extends WashingMachine{
    @Override
    void washClothes() {

    }
}

abstract class DianqiFactory{
    abstract AirConditioner produceAirConditioner();
    abstract WashingMachine produceWashingMachine();
}

class HaierDianqiFactory extends DianqiFactory{

    @Override
    AirConditioner produceAirConditioner() {
        return new HaierAirConditioner();
    }

    @Override
    WashingMachine produceWashingMachine() {
        return new HaierWashingMachine();
    }
}

class MideaDianqiFactory extends DianqiFactory{

    @Override
    AirConditioner produceAirConditioner() {
        return new MideaAirConditioner();
    }

    @Override
    WashingMachine produceWashingMachine() {
        return new MideaWashingMachine();
    }
}

public class AbstractFactoryTest {
    public static void main(String[] args) {
        DianqiFactory mideaDianqiFactory = new MideaDianqiFactory();
        DianqiFactory haierDianqiFactory = new HaierDianqiFactory();

        AirConditioner airConditioner = mideaDianqiFactory.produceAirConditioner();

        WashingMachine washingMachine = haierDianqiFactory.produceWashingMachine();
    }
    
}
