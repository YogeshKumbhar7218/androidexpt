package com.example.multithreading;

public class ThreadClass extends Thread{
    public String name;
    public ThreadClass(String name){
        this.name=name;
    }
    public void run(){
        for(int i=1;i<10;i++){
            // the thread will sleep for the 500 milli seconds
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(e);
            }

            System.out.print(i);
            System.out.println("       =>"+this.name);
        }
    }
}
