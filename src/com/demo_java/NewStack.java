package com.demo_java;

import java.util.Arrays;
import java.util.Stack;

public class NewStack {
    private int[] numbers = new int[5];
    private int count = 0;

    private int[] twoInOne = new int[11];
    private int a = 0;
    private int b = 1;

    public void push1(int item){
        twoInOne[a] = item;
        a += 2;
    }
    public void push2(int item){
        twoInOne[b] = item;
        b += 2;
    }
    public int pop1(){
        a -= 2;
        return twoInOne[a];
    }
    public int pop2(){
        b -= 2;
        return twoInOne[b];
    }
    public boolean isEmpty1(){
        return a == 0;
    }
    public boolean isEmpty2(){
        return b == 1;
    }
    public boolean isFull1(){
        return a == numbers.length-1;
    }
    public boolean isFull2(){
        return b == numbers.length;
    }
    public String stackReverse(String input){
        if (input == null){
            throw new IllegalArgumentException();
        }
        Stack<Character> s1 = new Stack<>();

        for(char ch : input.toCharArray()){
            s1.push(ch);
        }

        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            newStr.append(s1.pop());
        }
        return newStr.toString();
    }
    public boolean isBalanced(String input){
        Stack<Character> s1 = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[' || ch == '<'){
                s1.push(ch);
            }
            if (ch == ')'|| ch == '}' || ch == ']' || ch == '>'){
                if (s1.empty()){
                    return false;
                }else if (ch == ')') {
                    if (s1.peek() == '('){
                        s1.pop();
                    }
                    else {
                        return false;
                    }
                }else if (ch == '}') {
                    if (s1.peek() == '{'){
                        s1.pop();
                    }
                    else {
                        return false;
                    }
                }else if (ch == ']') {
                    if (s1.peek() == '['){
                        s1.pop();
                    }
                    else {
                        return false;
                    }
                }
                else {
                    if (s1.peek() == '<'){
                        s1.pop();
                    }
                    else {
                        return false;
                    }
                }

            }
        }
        return s1.empty();
    }
    public void push(int item){
        if (count == numbers.length-1){
            int i = 0;
            int[] newNumbers = new int[numbers.length * 2];
            for (int num : numbers){
                newNumbers[i++] = num;
            }
            numbers = newNumbers;
        }
        numbers[count++] = item;
    }
    public int pop(){
        if (count == 0){
            throw new IllegalStateException();
        }
        return numbers[--count];
    }
    public int peek(){
        if (count == 0){
            throw new IllegalStateException();
        }
        return numbers[count-1];
    }
    public String print(){
        int[] result = Arrays.copyOfRange(numbers, 0, count);
        return Arrays.toString(result);
    }
}
