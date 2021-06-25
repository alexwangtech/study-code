import java.util.Arrays;

public class BookSolution {

    // Check Permutation: Given two strings, write a method to decide if one
    // is a permutation of the other.


    // A permutation is the same string, but simply in a different order. By 
    // this definition, we can just sort the two strings and then compare
    // them to each other.

    public static String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public static boolean isPerm(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        return sortString(s1).equals(sortString(s2));
    }



    // The second solution proposed by the book is to define a permutation
    // as two strings with the same character counts. Assuming that we are
    // using ASCII, we can use the character codes to correspond to indexes
    // in an array.

    public static boolean isPerm2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        // Assume there are 128 characters (ASCII)
        int[] counts = new int[128];

        // Using the first string, we populate the integer array with the
        // number of occurrences of each characters.
        for (int i = 0; i < s1.length(); i++) {
            int c = (int) s1.charAt(i);
            ++counts[c];
        }

        // Then we iterate through the second array and remove the occurences
        // one by one.
        for (int i = 0; i < s2.length(); i++) {
            int c = (int) s2.charAt(i);
            --counts[c];

            if (counts[c] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "edcba";

        String s3 = "aaa";
        String s4 = "bbb";

        // Using the sort string method
        System.out.println(isPerm(s1, s2)); // expected true
        System.out.println(isPerm(s3, s4)); // expected false

        // Using the character count method
        System.out.println(isPerm2(s1, s2)); // expected true
        System.out.println(isPerm2(s3, s4)); // expected false
    }
}
