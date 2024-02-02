package com.demo_java;

import java.util.*;

public class SortingAlgorithms {
    public void bubbleSort(int[] items){
        for (int i = 0; i < items.length-1; i++) {
            for (int j = 0; j < items.length-i-1; j++) {
                if (items[j] > items[j+1]){
                    swap(j,j+1,items);
                }
            }
        }
    }
    private void swap(int index1,int index2, int[] items){
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
    public void print(int[] items){
        System.out.println(Arrays.toString(items));
    }
    public void selectionSort(int[] items){
        for (int i = 0; i < items.length-1; i++) {
            int min = i;
            for (int j = i; j < items.length; j++) {
                min = (items[j] < items[min]) ? j : min;
            }
            swap(i, min, items);
        }
    }
    public void insertionSort(int[] items){
        int j;
        for(int i = 1; i<items.length; i++){
            int current = items[i];
            j = i - 1;
            while ( j >= 0 && items[j] > current){
                items[j+1] = items[j];
                j--;
            }
            items[j+1] = current;
        }
    }
    public void mergeSort(int[] items){
        if (items.length < 2){
            return;
        }
        var mid = items.length/2;
        int[] left = new int[mid];
        for(int i=0; i<mid ;i++){
            left[i] = items[i];
        }
        int[] right = new int[items.length-mid];
        for(int i = mid; i<items.length;i++){
            right[i-mid] = items[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,items);

    }
    private void merge(int[] left, int[] right,int[] result){
        int i = 0,j = 0, k = 0;
        while (i < left.length && j < right.length){
            if (left[i] <= right[j]){
                result[k++] = left[i++];
            } else{
                result[k++] = right[j++];
            }
        }
        while (i < left.length){
            result[k++] = left[i++];
        }
        while (j < right.length){
            result[k++] = right[j++];
        }
    }
    public void quickSort(int[] items){
        quickSort(items,0,items.length-1);
    }

    private void quickSort(int[] items,int start,int end){
        if (start >= end){
            return;
        }
        int b = partition(items,start,end);
        int pivot = items[items.length-1];
        quickSort(items,start,b-1);
        quickSort(items,b+1,end);
    }
    private int partition(int[] items,int start, int end){
        int b = start-1;
        int pivot = items[end];
        for (int i = start; i <= end; i++) {
            if (items[i] <= pivot){
                b++;
                swap(i,b,items);
            }
        }
        return b;
    }
    public void countingSort(int[] items){
        int max = items[0];
        for (int item : items) {
            max = Math.max(item, max);
        }
        int[] count = new int[max+1];
        for (int item : items) {
            count[item]++;
        }
        int j=0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0){
                items[j++] = i;
                count[i]--;
            }
        }
    }
    public void bucketSort(int[] items,int noOfBucket){
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < noOfBucket; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int item : items) {
            buckets.get(item/noOfBucket).add(item);
        }
        var k = 0;
        for (var bucket : buckets){
            Collections.sort(bucket);
            for (var item : bucket){
                items[k++] = item;
            }
        }
    }
}
