import java.util.ArrayList;

public class Attempt {

    // Given two strings, write a method to decide if one is a permutation
    // of the other.


    public static boolean isPermutation(String s1, String s2) {

        // Speed up string manipulation by moving the first string argument
        // into an ArrayList
        ArrayList<Character> s1Array = new ArrayList<>(s1.length());
        for (char c : s1.toCharArray()) {
            s1Array.add(c);
        }

        // For ever character in our second string, remove it from the ArrayList
        // if it exists. If it does not exist, immediately return false.
        // If the ArrayList is preemptively empty, also return false.
        for (char c : s2.toCharArray()) {
            if (!s1Array.isEmpty()) {
                if (!s1Array.remove((Character) c)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        // If the strings are permutations, the list should be empty
        // at this point.
        return s1Array.isEmpty();
    }


    // Main method
    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "edcba";

        String s3 = "ababa";
        String s4 = "bbbbb";

        String s5 = "abc";
        String s6 = "d";

        String s7 = "cbade";
        String s8 = "cbad";

        System.out.println("isPermutation: " + isPermutation(s1, s2));
        System.out.println("isPermutation: " + isPermutation(s3, s4));
        System.out.println("isPermutation: " + isPermutation(s5, s6));
        System.out.println("isPermutation: " + isPermutation(s7, s8));

    }
}
