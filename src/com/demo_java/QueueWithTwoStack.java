package com.demo_java;

import java.util.Stack;

public class QueueWithTwoStack {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enQueue(int item){
        s1.push(item);
    }
    public int deQueue(){
        if (s1.empty() && s2.empty()){
            throw new IllegalStateException();
        }
        else if (s2.empty()){
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public boolean isEmpty(){
        return (s1.empty() && s2.empty());
    }
}
