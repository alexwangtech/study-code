import java.util.ArrayList;

public class Solution {

    // Given a string, checkw whether it is a permutation of a palindrome.


    public static boolean isPermuPal(String s) {

        ArrayList<Character> charList = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();

        // The first step would be to record all occurences of characters.
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

    // Main method
    public static void main(String[] args) {
        String s = "tact coa";

        System.out.println("Is permutation of palindrome: " + isPermuPal(s));
    }
}
