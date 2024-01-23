package com.demo_java;

public class Array {
    private int[] items;
    private int count;

    public Array(int length){
        items = new int[length];
    }
    public void insert(int item){
        if (items.length == count){
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = item;
    }

    public void removeAt(int index){
        if (index < 0 || index >= count){
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            items[i] = items[i+1];
        }

        count--;
    }

    public int indexOf(int item){
        for (int i = 0; i < count; i++) {
            if (items[i] == item){
                return i;
            }
        }
        return -1;
    }
    public int max(){
        int m = -1;
        for (int i = 0; i < count;i++){
            if (m < items[i]){
                m = items[i];
            }
        }
        return m;
    }
    public void reverse(){
        int temp;
        int mn = count;
        for (int i = 0; i < mn; i++) {
            temp = items[i];
            items[i] = items[mn-1];
            items[mn-1] = temp;
            items[mn-1] = temp;
            mn--;
        }
    }
    public void insertAt(int index,int number){
//        if (index < 0 || index >= count){
//            throw new IllegalArgumentException();
//        }
        int[] newItems = new int[count * 2];
        for (int i = 0; i < count; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
        int mn = count-1;
        while (mn > index){
            items[mn + 1] = items[mn];
            mn--;
        }
        items[mn] = number;
    }
    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
