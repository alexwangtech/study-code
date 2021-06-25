public class BookSolution {
    
    // Is Unique: Implement an algorithm to determine if a string has all 
    // unique characters. What if you cannot use additional data structures?

    // The book assumes that we are using ASCII strings, in which the
    // character set is 128 -> this corresponds to the numbers 0-127.

    // This means that we can create an array of size 128, and map the
    // value of the characters to the corresponding codes, or indexes in the
    // array.

    public static boolean isUnique(String s) {

        // If the character set is ASCII, then a string cannot be longer
        // than 128 characters without duplicating a character.
        if (s.length() > 128) return false;

        // We can create a boolean array of size 128. By default, the values
        // start off as false.
        boolean[] duplicates = new boolean[128];

        // Iterate through the characters of the string and check the matching
        // index of the boolean array - set true if the value is false.
        // Otherwise, it means that index has already been visited, indicating
        // that there are duplicates.
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);

            if (duplicates[val]) return false;

            duplicates[val] = true;
        }

        return true;
    }


    // If we are not allowed to use additional data structures, we can
    // compare every char in the string to every other char in the string.
    // This is not optimal, but it would satisfy the rule of not using any
    // additional data structures.

    public static boolean isUnique2(String s) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length - 1; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String a = "abcde";
        String b = "aaaaa";

        System.out.println(a + ": " + isUnique(a)); // expected true
        System.out.println(b + ": " + isUnique(b)); // expected false

        System.out.println(a + ": " + isUnique2(a)); // expected true
        System.out.println(b + ": " + isUnique2(b)); // expected false
    }
}
