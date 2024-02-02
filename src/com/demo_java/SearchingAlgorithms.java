package com.demo_java;

public class SearchingAlgorithms {
    public int linearSearch(int[] items, int target){
        for(int i=0;i<items.length;i++){
            if(items[i] == target){
                return i;
            }
        }
        return -1;
    }
    public int binarySearchRecursion(int[] items,int target){
        return binarySearchRecursion(items,0,items.length-1,target);
    }
    private int binarySearchRecursion(int[] items,int left,int right,int target){
        if (right < left){
            return -1;
        }
        int mid = (left + right) / 2;
        if (items[mid] == target){
            return mid;
        } else if (target < items[mid]) {
            return binarySearchRecursion(items,left,mid-1,target);
        }
        return binarySearchRecursion(items,mid+1,right,target);
    }
    public int binarySearchIterative(int[] items,int target){
        int left = 0;
        int right = items.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right)/2;
            if (items[mid] == target){
                return mid;
            } else if (target < items[mid]) {
                right = mid -1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public int ternarySearch(int[] items, int target){
        return ternarySearch(items,0,items.length-1,target);
    }
    private int ternarySearch(int[] items,int left,int right,int target){
        if (left > right){
            return -1;
        }
        int partitionSize = (right - left)/3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (items[mid1] == target){
            return mid1;
        }
        if (items[mid2] == target){
            return mid2;
        }
        if (target < items[mid1]){
            return ternarySearch(items,left,mid1-1,target);
        }
        if (target > items[mid2]){
            return ternarySearch(items,mid2+1,right,target);
        }
        return ternarySearch(items,mid1+1,mid2-1,target);
    }

    public int jumpSearch(int[] items, int target){
        int blockSize = (int) Math.sqrt(items.length);
        int start = 0;
        int next = blockSize;
        while (start < items.length && items[next-1] < target){
            start = next;
            next += blockSize;
            if (next >= items.length){
                next = items.length;
            }
        }
        for(int i = start;i<next;i++){
            if (items[i] == target){
                return i;
            }
        }
        return -1;
    }
    public int ExponentialSearch(int[] items,int target){
        int bound = 1;
        while (bound < items.length && items[bound] < target){
            bound *= 2;
        }
        return binarySearchRecursion(items,bound/2,Math.min(bound,items.length-1),target);
    }
}
