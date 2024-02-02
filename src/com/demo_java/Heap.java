package com.demo_java;

public class Heap {
    private int[] items = new int[10];
    private int size = 0;

    public void insert(int value){
        if (size == items.length){
            throw new IllegalStateException();
        }
        items[size++] = value;

        int index = size - 1;
        int parentIndex = (index - 1)/2;
        while (index > 0 && items[index] > items[parentIndex]){
            swap(index , parentIndex);
            index = (index - 1)/2;
        }
    }

    public int remove(){
        if (size == 0){
            throw new IllegalStateException();
        }
        var root = items[0];
        items[0] = items[--size];

        int index = 0;
        while (index <= size && !isValidParent(index)) {
            int largerChildIndex = (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
        }
        swap(index, leftChildIndex(index));
        index = leftChildIndex(index);
        return root;
    }

    private int largerChildIndex(int index){
        if (!hasLeftChild(index)){
            return index;
        }
        if (!hasRightChild(index)){
            return leftChildIndex(index);
        }
        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index) <= size;
    }
    private boolean hasRightChild(int index){
        return rightChildIndex(index) <= size;
    }

    private boolean isValidParent(int index){
        if(!hasLeftChild(index)){
            return true;
        }
        var isValid = items[index] >= leftChild(index);
        if (hasRightChild(index)){
            isValid &= items[index] >= rightChild(index);
        }
        return isValid;
    }

    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }
    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index){
        return index * 2 + 1;
    }
    private int rightChildIndex(int index){
        return index * 2 + 2;
    }

    private void swap(int first, int second){
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
}
