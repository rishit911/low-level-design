package com.rishit.lld.designpatterns.creational.singleton;

public class singletonlogger {
    private static singletonlogger instance;

    private singletonlogger(){

    }

    public static singletonlogger getInstance(){
        if(instance==null){
            instance=new singletonlogger();
        }
        return instance;
    }

    public void log(String message){
        System.out.println("[LOG] " + message);
    }
}
