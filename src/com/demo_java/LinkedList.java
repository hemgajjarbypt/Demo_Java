package com.demo_java;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size;
    public void addFirst(int item){
        Node node = new Node(item);
        if (isEmpty()){
            first = last = node;
        }
        else {
            node.next = first;
            first = node;
        }
        size++;
    }
    public void addLast(int item){
        Node node = new Node(item);

        if (isEmpty()){
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }
        size++;
    }
    public void removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        } else if (first == last) {
            first = last = null;
            Node second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }
    public void removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }else if (first == last) {
            first = last = null;
        }
        else {
            last = getPrevious(last);
            last.next = null;

        }
        size--;
    }
    private Node getPrevious(Node node){
        Node current = first;
        while (current != null){
            if (current.next == last){
                return current;
            }else {
                current = current.next;
            }
        }
        return null;
    }
    public void reverse(){
        if (isEmpty()){
            return;
        }
        Node previous = first;
        Node current = first.next;
        while (current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;

    }
    public int indexOf(int item){
        int index = 0;
        Node current = first;
        while (current != null){
            if (current.value == item){
                return index;
            }
            else {
                current = current.next;
                index++;
            }
        }
        return -1;
    }
    public boolean contains(int item){
        Node current = first;
        while (current != null){
            if (current.value == item){
                return true;
            }
            else{
                current = current.next;
            }
        }
        return false;
    }
    public int size(){
        return size;
    }
    private boolean isEmpty(){
        return first == null;
    }

    public int[] toArray(){
        int[] arr = new int[size];
        int i = 0;
        Node current = first;
        while(current != null){
            arr[i++] = current.value;
            current = current.next;
        }
        return arr;
    }
    public int getKthFromTheEnd(int k){
        Node a = first;
        Node b = first;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null){
                throw new IllegalArgumentException();
            }
        }
        while (b != last){
            a = a.next;
            b = b.next;
        }
        return a.value;
    }
    public void printMiddle(){
        Node a = first;
        Node b = first;

        while(b != last && b.next != last){
            b = b.next.next;
            a = a.next;
        }

        if (b == last){
            System.out.println(a.value);
        }
        else {
            System.out.println(a.value +"  , "+a.next.value);
        }
    }
    public boolean hasLoop(){
        Node slow = first;
        Node fast = first;
        while (slow != last && fast != last){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
