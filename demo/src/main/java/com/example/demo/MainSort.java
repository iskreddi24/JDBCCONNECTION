package com.example.demo;
import java.util.Arrays;
public class MainSort {
    public static void main (String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        int arr1[]={9,8,7,6,5,4,3,2,1};
        SortingMethods sortingMethods=new SortingMethods();
        System.out.println("Ascending orderrr : " + Arrays.toString(sortingMethods.ascendingSort(arr)));
        System.out.println("Descending orderr : " + Arrays.toString(sortingMethods.descendingSort(arr1)));
    }
}
