package com.company;

/**
 * Created by qulain on 5/5/2017.
 */
public class ReverseAString {
    public static void main(String[] args) {
        String input = "abcdefg";
        System.out.println(input.length());
        System.out.println(reverse(input));
    }
    public static String reverse(String input) {
        char[] charArrayOfInput = input.toCharArray();

        int counter = 0;
        for(int i = charArrayOfInput.length- 1; i>0; --i) {
            if(counter < i) {
                char temp = charArrayOfInput[i];
                charArrayOfInput[i] = charArrayOfInput[counter];
                charArrayOfInput[counter] = temp;
                ++counter;
            }else {
                break;
            }
        }
        return new String(charArrayOfInput);
    }

}
