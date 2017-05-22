package com.company;

/**
 * Created by qulain on 5/8/2017.
 */
public class ReplaceAllSpaces {
    public static void main(String[] args) {
        String str = "This is a cat";
        replace(str);
    }

   public static void replace(String s1) {
         /* scan the array and count number of spaces to get newLength of newArray(charsNew)
        *  parse string from end
        *       if space encounter, replace with %20 and update newLengthy
        *       else store character to newly shifted location and update new length
        *       */

        char[] chars = s1.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }
        int newLength = chars.length + 2 * spaceCount;
        char[] charsNew = new char[newLength];
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                charsNew[newLength - 1] = '0';
                charsNew[newLength - 2] = '2';
                charsNew[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                charsNew[newLength - 1] = chars[i];
                newLength = newLength - 1;
            }
        }
        System.out.println("Output String : " + String.valueOf(charsNew));
    }

}
