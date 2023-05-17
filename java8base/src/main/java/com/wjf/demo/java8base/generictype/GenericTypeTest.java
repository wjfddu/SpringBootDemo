package com.wjf.demo.java8base.generictype;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeTest {

    public static List<Animal> getAnimalList(){
        List<Animal> list = new ArrayList<>();
        list.add(new Animal());
        list.add(new Dog());
        list.add(new Person());
        list.add(new Man());
        return list;
    }

    public static List<Person> getPersonList(){
        List<Person> list = new ArrayList<>();
        list.add(new Person());
        list.add(new Man());
        return list;
    }

    public static List<Man> getManList(){
        List<Man> list = new ArrayList<>();
        list.add(new Man());
        return list;
    }

    public static void printAnimals(List<? extends Animal> animalList){
        animalList.forEach((Animal animal) -> System.out.println(animal));
    }

    public static void printAnimals2(List<? super Person> animalList){
        animalList.forEach((Object o) -> System.out.println(o));
    }

    public static void main(String[] args) {
        printAnimals(getAnimalList());
        printAnimals2(getAnimalList());
        printAnimals2(getPersonList());
//        printAnimals2(getManList()); 编译报错
    }
}
