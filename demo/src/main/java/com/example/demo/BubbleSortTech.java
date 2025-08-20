package com.example.demo;

import java.util.Arrays;

public class BubbleSortTech {
    public static void main (String[] args) {
        int arr[]={10,9,8,7,6,5,4,3,2,1};
        int n=arr.length;
        for(int i=1;i<n;i++){
            for(int j=1;j<n-i+1;j++){
                if(arr[j-1]>arr[j]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
