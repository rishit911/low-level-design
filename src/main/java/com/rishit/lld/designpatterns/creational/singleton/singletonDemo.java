package com.rishit.lld.designpatterns.creational.singleton;

public class singletonDemo {
    public static void main(String args[]) {
        singletonlogger logger1 = singletonlogger.getInstance();
        singletonlogger logger2 = singletonlogger.getInstance();

        logger1.log("First log message");
        logger2.log("Second log message");

        System.out.println("Same Instance? " + (logger1 == logger2));
    }
}
