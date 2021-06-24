import java.util.HashSet;

public class Attempt {

    // Implement an algorithm to determine if a string has all unique characters.
    // What if you cannot use additional data structures?

    public static boolean isAllUnique(String string) {

        // Let's create a new HashSet to cache the characters.
        HashSet<Character> set = new HashSet<>();

        for (char c : string.toCharArray()) {
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {

        String isUnique = "abcdef";
        String notUnique = "aaaaaa";

        System.out.println("Unique: " + isAllUnique(isUnique));

        System.out.println("Unique: " + isAllUnique(notUnique));
    }
}