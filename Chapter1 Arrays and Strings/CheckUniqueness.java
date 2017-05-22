package com.company;

/**
 * Created by qulain on 5/5/2017.
 */
public class CheckUniqueness {
    public static void main(String[] args) {
        String input = "dsjkshkjdfhk mxczn,xmc";
        boolean result = isUniqueCharacters(input);
        if(isUniqueCharacters(input)) {
            System.out.println("String has unique characters");
        } else {
            System.out.println("String does not have unique characters");
        }

    }

    public static boolean isUniqueCharacters(String s) {
        boolean[] charSet = new boolean[256]; //array for ASCII characters
        //charSet.f
        for (int i = 0; i < s.length(); ++i) {
            int val = s.charAt(i);
            if(charSet[val]) {
                return false;
            } else {
                charSet[val] = true;
            }

        }
        return true;
    }
}
