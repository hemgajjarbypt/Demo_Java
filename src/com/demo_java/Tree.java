package com.demo_java;

import java.util.ArrayList;

public class Tree {
    private class Node {
        private int value;

        private Node leftChild;

        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }
    private Node root;

    public void insert(int value){
        if (root == null){
            root = new Node(value);
            return;
        }
        Node current = root;
        while (true){
            if (value < current.value){
                if (current.leftChild == null){
                    current.leftChild = new Node(value);
                    break;
                }
                current = current.leftChild;
            }
            else {
                if (current.rightChild == null){
                    current.rightChild = new Node(value);
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find (int value){
        Node current = root;
        while (current != null){
            if (current.value == value){
                return true;
            }
            else if (current.value < value){
                current = current.rightChild;
            }
            else {
                current = current.leftChild;
            }
        }
        return false;
    }
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.value);
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }
    public void postOrder() {
        preOrder(root);
    }
    private void postOrder(Node root){
        if (root == null){
            return;
        }
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.println(root.value);
    }
    public void inOrder() {
        preOrder(root);
    }
    private void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.leftChild);
        System.out.println(root.value);
        inOrder(root.rightChild);
    }
    public int height(){
        return height(root);
    }
    private int height(Node root){
        if (root.leftChild == null && root.rightChild == null){
            return 0;
        }
        return 1 + Math.max(height(root.leftChild),height(root.rightChild));
    }
    public int minValue(){
        return minValue(root);
    }

    private int minValue(Node root){
        if (root.leftChild == null && root.rightChild == null){
            return root.value;
        }
        var left = minValue(root.leftChild);
        var right = minValue(root.rightChild);
        return Math.min(Math.min(left,right),root.value);
    }

    public boolean equal(Tree other){
        return equal(root, other.root);
    }

    private boolean equal(Node first, Node second){
        if (first == null && second == null){
            return true;
        }
        if (first != null && second != null){
            return first.value == second.value && equal(first.leftChild, second.leftChild) && equal(first.rightChild, second.rightChild);
        }
        return false;
    }

    public boolean isBST(){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBST(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if (root.value < min || root.value > max){
            return false;
        }
        return (isBST(root.leftChild, min, root.value - 1) && (isBST(root.leftChild, root.value + 1, max)));

    }
    public ArrayList<Integer> printNodeAtDistance(int distance){
        ArrayList<Integer> list = new ArrayList<>();
        printNodeAtDistance(distance,root,list);
        return list;
    }

    private void printNodeAtDistance(int distance, Node root, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        if (distance == 0){
            list.add(root.value);
        }
        printNodeAtDistance(distance-1, root.leftChild,list);
        printNodeAtDistance(distance-1, root.rightChild,list);
    }
    public void levelOrderTraversal(){
        if (root == null){
            throw new IllegalStateException();
        }
        for (int i = 0; i <= height(); i++) {
            for(var item: printNodeAtDistance(i)){
                System.out.println(item);
            }
        }
    }
    public int size(){
        if (root == null){
            return 0;
        }
        int size = 0;
        for (int i = 0; i <= height(); i++) {
            for(var item: printNodeAtDistance(i)){
                size++;
            }
        }
        return size;
    }
    public int countLeaves(){
        ArrayList<Integer> leaves = new ArrayList<>();
        countLeaves(root, leaves);
        return leaves.size();
    }

    private void countLeaves(Node root,ArrayList<Integer> leaves){
        if (root == null){
            return;
        }
        if (height(root) == 0){
            leaves.add(root.value);
        }
        countLeaves(root.leftChild, leaves);
        countLeaves(root.rightChild, leaves);
    }
    public int maxValue(){
        return maxValue(root);
    }

    private int maxValue(Node root){
        if (root.leftChild == null && root.rightChild == null){
            return root.value;
        }
        var left = maxValue(root.leftChild);
        var right = maxValue(root.rightChild);
        return Math.max(Math.max(left,right),root.value);
    }

    public boolean contains(int value){
        return contains(root, value);
    }

    private boolean contains(Node root,int value){
        if (root == null){
            return false;
        }
        if (root.value == value){
            return true;
        } else if (value > root.value) {
            return contains(root.rightChild, value);
        }
        else {
            return contains(root.leftChild, value);
        }
    }
    public boolean areSibling(int first,int second){
        if (areSibling(root.leftChild, root.rightChild, first, second)){
            return true;
        }
        return areSibling(root.leftChild, root.rightChild, first, second);
    }
    private boolean areSibling(Node left,Node right, int first, int second){
        if (left == null || right == null){
            return false;
        }
        if ((left.value == first && right.value == second) || (left.value == second && right.value == first)){
            return true;
        }
        areSibling(left.leftChild,left.rightChild,first,second);
        areSibling(right.leftChild,right.rightChild,first,second);
        return false;
    }
    public void getChild(int value){
        if (!find(value)){
            throw new IllegalStateException();
        }
        getChild(root,value);
    }
    private void getChild(Node root,int value){
        Node current = root;
        while (current.value != value){
            if (value > current.value){
                current = current.rightChild;
            }
            else {
                current = current.leftChild;
            }
        }
        postOrder(current.leftChild);
        postOrder(current.rightChild);
    }
    public ArrayList<Integer> getAncestor(int value){
        if (!find(value)){
            throw new IllegalStateException();
        }
        ArrayList<Integer> list = new ArrayList<>();
        Node current = root;
        while (current.value != value){
            list.add(current.value);
            if (value > current.value){
                current = current.rightChild;
            }
            else {
                current = current.leftChild;
            }
        }
        return list;
    }

    public boolean isPerfect(){
        return size() == (int) Math.pow(2,height(root) + 1) - 1;
    }

}
