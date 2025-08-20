package com.example.demo;

import java.util.Arrays;

public class SortingMethods {
   public int[] ascendingSort(int arr[]){
       int n=arr.length;
       for(int i=1;i<n;i++){
           for(int j=1;j<n-i;j++){
               if(arr[j-1]>arr[j]){
                   int temp=arr[j-1];
                   arr[j-1]=arr[j];
                   arr[j]=temp;
               }
           }
       }
       return arr;
   }

    public int[] descendingSort(int arr[]){
        int n=arr.length;
        for(int i=1;i<n;i++){
            for(int j=1;j<n-i+1;j++){
                if(arr[j-1]<arr[j]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}
