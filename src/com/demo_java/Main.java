package com.demo_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static int product(int[] arr){
        Arrays.sort(arr);
        for (int i= arr.length-1;i >= 1; i--){
            if (arr[i] != arr[i-1]){
                return (arr[i] * arr[i-1]);
            }
        }
        return 0;
    }
    public static void rotate(int[] arr,int k){
        ArrayList<Integer> al = new ArrayList<>();
        for (int j : arr) {
            al.add(j);
        }
        Collections.rotate(al,k);
        System.out.println(al);
    }
    public static void main(String[] args) {
        String s1 = "jsh   sh";
        s1 += '/';
        int count = 1;
        char[] arr;
        arr = s1.toCharArray();
        int i = 0;
        while(arr[i] != '/'){
            if (arr[i] == ' ' && arr[i+1] != ' '){
                count++;
            }
            i++;
        }
        System.out.println(count);
    }
}