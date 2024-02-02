package com.demo_java;

import java.util.HashMap;
import java.util.Map;

public class DemoHashTable {
    public int mostFrequent(int[] arr){
        int count;
        int max = -1;
        Map<Integer,Integer> ht= new HashMap<>();
        for (int num : arr){
            if (!ht.containsKey(num)){
                ht.put(num,1);
            }
            else {
                ht.put(num,ht.get(num)+1);
            }
            if (max < ht.get(num)){
                max = ht.get(num);
            }
        }

        for (var item : ht.entrySet()){
            if (item.getValue() == max){
                return item.getKey();
            }
        }
        return -1;
    }

    public int countPairsWithDiff(int[] arr){
        Map<Integer,Integer> ht= new HashMap<>();
        for(int num : arr){
            ht.put(num, ((num+2)+(num-2)));
        }

        int count = 0;
        for (var item : ht.entrySet()){
            if (ht.containsValue(item.getValue()+4)){
                count++;
            }
        }
        return count;
    }
}
