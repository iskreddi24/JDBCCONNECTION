package com.example.demo;

public class Constructor {
    String name;
    int age;
    public Constructor(){
       this.name="siva";
       this.age=22;

    }

    public static void main (String[] args) {
        Constructor myObj=new Constructor();
        System.out.println(myObj.age);
        System.out.println(myObj.name);
    }
}
