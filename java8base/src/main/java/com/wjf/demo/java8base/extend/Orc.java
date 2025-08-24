package com.wjf.demo.java8base.extend;

import lombok.Data;

/**
 * @author JF
 * @created 2025/7/27 21:40
 * @description
 */

class Villain {
    private String name;

    protected void set(String nm){
        name = nm;
    }

    public Villain(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "I'm a Villain and my name is " + name;
    }
}

public class Orc extends Villain{
//    private String name;
    private int orcNumber;
    public Orc(String name, int orcNumber){
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber){
        set(name);
//        this.name = "[" + name + "]";
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
//        return "Orc " + orcNumber + " this.name " + name + ": " + super.toString();
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Limburger", 12);
        System.out.println(orc);
        orc.change("Bob", 19);
        System.out.println(orc);
    }
}
