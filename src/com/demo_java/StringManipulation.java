package com.demo_java;

import java.util.*;

public class StringManipulation {
    public static int findVowels(String str){
        int count = 0;
        for(var s : str.toLowerCase().toCharArray()){
            if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u' ){
                count++;
            }
        }
        return count;
    }
    public static String reverse(String str){
        String rev = "";
        for(int i=str.length()-1;i>=0;i--){
            rev += str.charAt(i);
        }
        return rev;
    }
    public static String revWord(String str){

        String[] result = str.trim().split(" ");
        Collections.reverse(Arrays.asList(result));
        return String.join(" ",result);
    }
    public static boolean rot(String s1, String s2){
        StringBuilder s3 = new StringBuilder(s2);
        for (int i=0;i<s1.length();i++){
            s3.append(s3.charAt(0));
            s3.deleteCharAt(0);
            if (s1.equals(s3.toString())){
                return true;
            }
        }
        return false;
    }

    public static String removeDuplicate(String str){
        StringBuilder sb = new StringBuilder();
        for (var s :str.toCharArray()){
            if (sb.indexOf(String.valueOf(s)) == -1){
                sb.append(s);
            }
        }
        return sb.toString();
    }
    public static Character mostRepeated(String str){
        Map<Character,Integer> map = new HashMap<>();
        for (var s : str.toCharArray()){
            if (!map.containsKey(s)){
                map.put(s,1);
            }
            else {
                map.put(s,map.get(s)+1);
            }
        }
        int max = -1;
        char maxChar = 'A';
        for(var mapEntry : map.entrySet()){
            if (mapEntry.getValue() > max){
                max = mapEntry.getValue();
                maxChar = mapEntry.getKey();

            }
        }
        return maxChar;
    }
    public static String capitalize(String str){
        String[] words = str.trim().replaceAll(" +"," ").split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return String.join(" ",words);
    }
    public static boolean areAnagram(String s1, String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        for (var s : s1.toCharArray()){
            if(s2.indexOf(s) == -1){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(String s1){
        StringBuilder s3 = new StringBuilder(s1);
        s3.reverse();
        return s1.equals(s3.toString());
    }

}
