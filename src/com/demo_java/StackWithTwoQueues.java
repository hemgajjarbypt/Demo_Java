package com.demo_java;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    // [10 -> 20 -> 30]
    // []

    public void push(int item){
        q1.add(item);
    }
    public int pop(){
        int count = 0;
        if (q2.isEmpty()) {
            while (count != q1.size() - 1) {
                q2.add(q1.remove());
            }
            return q1.remove();
        }
        else {
            while (count != q2.size() - 1) {
                q1.add(q2.remove());
            }
            return q2.remove();
        }
    }
    public int peek(){
        int count = 0;
        int temp;
        if (q2.isEmpty()) {
            while (count != q1.size() - 1) {
                q2.add(q1.remove());
            }
            temp = q1.peek();
            q2.add(q1.remove());
            return temp;
        }
        else if (q1.isEmpty()){
            while (count != q2.size() - 1) {
                q1.add(q2.remove());
            }
            temp = q2.peek();
            q1.add(q2.remove());
            return temp;
        }
        else {
            throw new IllegalStateException();
        }
    }
    public void print(){
        if (!q1.isEmpty()){
            while (!q1.isEmpty()){
                System.out.println(q1.remove());
            }
        }
        else{
            while (!q2.isEmpty()){
                System.out.println(q2.remove());
            }
        }
    }
    public boolean isEmpty(){
        return (q1.isEmpty() && q2.isEmpty());
    }
}
