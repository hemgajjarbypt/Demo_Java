package com.demo_java;

import java.util.Arrays;

public class ArrayQueue {
    private int[] queue;

    private int front = 0;
    private int rear = 0;

    private int count = 0;

    public ArrayQueue(int num){
        queue = new int[num];
    }

    public void enQueue(int num){
        if (count == queue.length) {
            throw new IllegalStateException();
        }
        queue[rear] = num;
        rear = (rear + 1) % queue.length;
        count++;
    }

    public int deQueue(){
        if (front == queue.length-1){
            throw new IllegalStateException();
        }
        int temp = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;
        return temp;
    }

    public boolean isEmpty(){
        return rear == 0;
    }

    public boolean isFull(){
        return rear == queue.length;
    }
    @Override
    public String toString(){
        return Arrays.toString(queue);
    }
}
