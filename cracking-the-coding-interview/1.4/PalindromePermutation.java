import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class PalindromePermutation {

    // Given a string, check whether it is a permutation of a palindrome.


    public static boolean isPermuPal(String s) {

        ArrayList<Character> charList = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();

        // The first step would be to record all occurrences of characters.
        for (char c : s.toCharArray()) {

            // If the character is already recorded, then just update the counter.
            if (charList.contains(c)) {
                int index = charList.indexOf((Character) c);
                numList.set(index, numList.get(index) + 1);
            }
            
            // If the character is not already recorded, add a new record of it.
            else {
                charList.add((Character) c);
                numList.add(1);
            }
        }

        // The next step would be to find the number of odds.
        int numOdds = 0;

        for (int i = 0; i < numList.size(); i++) {
            if (charList.get(i) != ' ') { // Get rid of white spaces
                if (numList.get(i) % 2 == 1) {
                    ++numOdds;
                }
            }
        }

        // There should only be one odd, and all the rest are evens.
        return numOdds == 1;
    }

    // We can optimize the counting by using a HashMap instead.

    public static boolean isPermPal1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Start off by populating the map with char : int pairs.
        // Whitespace characters don't count.
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }

        // Search for occurrences. of odd values.
        int numOdds = 0;
        for (int i : map.values()) {
            if (i % 2 == 1) {
                ++numOdds;
            }
        }

        // There should only be one odd number
        return numOdds == 1;
    }

    // Main method
    public static void main(String[] args) {
        String s = "tact coa";

        System.out.println("Is permutation of palindrome: " + isPermuPal(s));
        System.out.println("Is permutation of palindrome: " + isPermPal1(s));
    }
}
