package com.wjf.demo.java8base.polymorphism;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author JF
 * @created 2025/8/3 20:38
 * @description
 */


class Glyph {
    void draw(){
        System.out.println("Glyph.draw()");
    }

    Glyph(){
        System.out.println(this);
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph{
    private int radius = 1;

    public RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
        Thread t = new Thread();
        t.start();
//        FutureTask futureTask = new FutureTask<>();
//        CompletableFuture future = CompletableFuture.runAsync();
//        Executors.newCachedThreadPool()

//        ArrayBlockingQueue

    }

}
