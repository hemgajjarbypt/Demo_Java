package com.demo_java;

import java.util.Arrays;

public class LinkedListQueue {

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }
    private boolean isEmpty(){
        return first == null;
    }
    private Node first;
    private Node last;

    private int size;

    public void enQueue(int item){
        Node newNode = new Node(item);
        if (isEmpty()){
            first = last = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    public int deQueue(){
        int temp;
        if (isEmpty()){
            throw new IllegalStateException();
        }
        else{
            temp = first.value;
            first = first.next;
        }
        size--;
        return temp;
    }
    public int peek(){
        int temp;
        if (isEmpty()){
            throw new IllegalStateException();
        }
        else {
            temp = first.value;
        }
        return temp;
    }
    public int size(){
        return size;
    }
    public void print(){
        if (isEmpty()){
            throw new IllegalStateException();
        }
        Node current = first;
        while (current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }
}
