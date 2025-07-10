package com.wjf.demo.java8base.exception;

/**
 * @author JF
 * @created 2025/6/22 15:50
 * @description
 */

class MyException extends Exception{

}
class MyException2 extends Exception{

}

public class ExceptionTest{
    // 异常说明
    static void e() throws MyException {
        throw new MyException();
    }
    static void e2() throws MyException {
        throw new MyException();
    }
    public static void test1(String[] args) {
        try {
            e();
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *  异常丢失场景1
     */
    public static void exceptionLoseCase1() {
        try {
            try {
                e();
            }finally {
                e2();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  异常丢失场景2
     */
    public static void exceptionLoseCase2() {
        try {
            throw new RuntimeException();
        }finally {
            return;
        }
    }

    public static void main(String[] args) {
        exceptionLoseCase1();
    }
}