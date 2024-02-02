package com.demo_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private class Node{
        public static int ALPHABET_SIZE = 26;
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord ;

        public Node(char value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "value = " + value;
        }
        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }

        public void addChild(char ch){
            children.put(ch, new Node(ch));
        }
        public Node getChild(char ch){
            return children.get(ch);

        }

        public Node[] getChildren(){
            return children.values().toArray(new Node[0]);
        }
        public boolean hasChildren(){
            return !children.isEmpty();
        }
        public void removeChild(char ch){
            children.remove(ch);
        }
    }
    private Node root = new Node(' ');
    private int count = 0;

    public void insert(String word){
        var current = root;

        for (var ch : word.toCharArray()){
            var index = ch - 'a';
            if (!current.hasChild(ch)){
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
        count++;
    }
    public boolean contains(String str){
        if (str == null){
            return false;
        }
        var current = root;
        for (char ch : str.toCharArray()) {
            if (!current.hasChild(ch)){
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void travers(){
        travers(root);
    }
    private void travers(Node root){
        for (var child : root.getChildren()){
            travers(child);
        }
        System.out.println();
    }
    public void remove(String str){
        if (!contains(str)){
            return;
        }
        remove(root,str,0);
    }
    private void remove(Node root, String str,int index){
        if (index == str.length()){
            root.isEndOfWord = false;
            return;
        }
        var ch = str.charAt(index);
        var child = root.getChild(ch);

        remove(child,str,index+1);

        if (!child.hasChildren() && !child.isEndOfWord){

        }
    }
    public List<String> findWords(String prefix){
        List<String> words = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix);
        findWords(lastNode,prefix,words);
        return words;
    }

    private void findWords(Node root, String prefix, List<String> words){
        if (root == null){
            return;
        }
        if (root.isEndOfWord){
            words.add(prefix);

        }
        for(var child : root.getChildren()){
            findWords(child, prefix+child.value,words);
        }
    }

    private Node findLastNodeOf(String prefix){
        if (prefix == null){
            return null;
        }
        var current = root;
        for( var ch : prefix.toCharArray()){
            var child = current.getChild(ch);
            if (child == null){
                return null;
            }
            current = child;
        }
        return current;
    }

    public boolean containsRecursive(String str){
        if (str == null){
            return false;
        }
        return containsRecursive(root,str,0);
    }
    private boolean containsRecursive(Node current,String str,int index){
        if (index == str.length()){
            return current.isEndOfWord;
        }
        if (current == null){
            return false;
        }

        var ch = str.charAt(index);
        var child = current.getChild(ch);
        if (child == null)
            return false;

        return containsRecursive(child,str,index+1);
    }

    public int countWords(){
        return count;
    }

}
