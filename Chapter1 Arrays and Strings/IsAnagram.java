

package com.company;

/**
 * Created by qulain on 5/8/2017.
 */
public class IsAnagram {
    public static void main(String[] args) {
        String testCase1a = "CAT";
        String testCase1b = "ACT";

        String testCase2a = "anagramm";
        String testCase2b = "marganaa";

        String testCase3a = "Hello";
        String testCase3b = "hello";


        boolean ret1 = isAnagram(testCase1a, testCase1b);
        System.out.println( (ret1) ? "Anagrams" : "Not Anagrams" );

        boolean ret2 = isAnagram(testCase2a, testCase2b);
        System.out.println( (ret2) ? "Anagrams" : "Not Anagrams" );

        boolean ret3 = isAnagram(testCase3a, testCase3b);
        System.out.println( (ret3) ? "Anagrams" : "Not Anagrams" );

    }

    static boolean isAnagram(String a, String b) {

       /* ALGORITHM:
       Step 1:
       convert both string sto either lowerCase or uppercase letters
       convert string to characterArray as string are immutable

       Step 2:
       scan one string and update asciCharArray
            a. declare numberOfUniqueElements

        Step 3:
        scan second array and decrement asciCharArray
            a. maintain count of totalUniqueCompleted
            b. if totalUniqueCompleted == numberOfUnique && array is at the end then true

       */
        if(a.length() != b.length()) {
            return false;
        }

        //// to make 'a' and 'A' same
        char[] a_array = a.toLowerCase().toCharArray();
        char[] b_array = b.toLowerCase().toCharArray();

        int[] asciCharArray = new int[256];
        int numberOfUniqueElements = 0;
        int totalUniqueCompleted = 0;

        // scan first array, if unique element comes, then increment numberOfUnique elemenets
        // also increment the numberOfOccurrence at that point in ascii array
        for(int i = 0; i < a_array.length; ++i) {
            int value = a_array[i];
            if(asciCharArray[value] == 0) {
                ++numberOfUniqueElements;
            }
            asciCharArray[value] = asciCharArray[value] + 1;
        }

        //scan second array
           // if numberOfOccurrenceInAscii array is zero: it means there is some new element which does not present in first array
           // if numberOfOccurrenceInAscii is not zero: decrement the numberOfOccurrenceInAscii
           // if after decrement, value at that point becomes zero, numberOfOccurrenceInAscii of that char in bot array is same & totalUniqueCompleted for that element i scomplete
                // if you are at last point of array and condition hits then evereything matches and return true


        for(int j = 0; j < b_array.length ; ++j) {
            int valueInSecondString = b_array[j];
            if(asciCharArray[valueInSecondString] == 0) {
                return false;
            } else {
                --asciCharArray[valueInSecondString];

                if(asciCharArray[valueInSecondString] == 0) {
                ++totalUniqueCompleted;
                }

                if( (totalUniqueCompleted == numberOfUniqueElements) && (j == b.length() - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

}
