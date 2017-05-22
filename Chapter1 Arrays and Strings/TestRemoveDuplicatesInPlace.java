package com.company;

/**
 * Created by qulain on 5/8/2017.
 */
public class TestRemoveDuplicatesInPlace {
    public static void main(String[] args) {

        String testCase1 = "abcbaadfhjkl";
        String testCase2 = "aaaaa";
        String testCase3 = "ab";
        String testCase4 = "a";
        String testCase5 = "";

        char[] str1 = testCase1.toCharArray();
        removeDuplicate(str1);
        printArray(str1);


        char[] str2 = testCase2.toCharArray();
        removeDuplicate(str2);
        printArray(str2);

        char[] str3 = testCase3.toCharArray();
        removeDuplicate(str3);
        printArray(str3);

        char[] str4 = testCase4.toCharArray();
        removeDuplicate(str4);
        printArray(str4);

        char[] str5 = testCase5.toCharArray();
        removeDuplicate(str5);
        printArray(str5);
    }

    public static void removeDuplicate(char[] str){
        /* Invariant: Evereything till tail - 1 is Unique
        * 1. If element at j is present in the list of unique elements (o to tail - 1): do nothing
        * 2. If element at j is not present in the list of unique elements (o to tail - 1):
        *                   a. put element at j in place of element at tail
        *                   b. increment tail, to maintain variant(everything before tail - 1 is unique)*/

        // check boundary conditions
        if(str == null) return;
        if(str.length < 2 ) return;

        // start the loop from second element because first(at 0th index) will be considered as unique
        int tail = 1;
        for (int j = 1; j < str.length; ++j) {
            // if character is seen for the first time in array
            if(!isPresentInAlreadySeenArray(str, tail, str[j])){
                    str[tail] = str[j];
                    ++tail;
            }
        }

        // Clip the remaining(duplicate characters) elements from array
        for(int k = tail; k < str.length; ++k) {
            str[k] = 0;
        }

    }

    public static boolean isPresentInAlreadySeenArray(char[] str, int tail, char valueToCheck) {
        for(int k =0; k < tail; ++k) {
            if(str[k] == valueToCheck) {
                return true;
            }
        }
        return false;
    }

    public static void printArray(char[] ch){
        for(int i = 0; i < ch.length; ++i) {
            System.out.print(ch[i]+" ");
        }
        System.out.println("");
    }
}
