package com.example.demo;

public class IncrementDec {
    public static void main (String[] args) {
        int x=10;
        int y=++x;
        System.out.println("pre increment "+y);//pre increment example
        int a=10;
        int b=a++;
        System.out.println("post increment "+b);//post increment example
        int t=10;
        int s=--t;
        System.out.println("pre decrement "+s);//pre decrement example
        int d=10;
        int c=d++;
        System.out.println("post decrement "+c);//post decrement example
        int n=10;
        int r=n++;
        System.out.println(r);
        int g=r++;
        System.out.println(g);
        int f=++g;
        System.out.println(f);
    }
}
