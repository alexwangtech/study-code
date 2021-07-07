public class Solution {

    // Given two strings, write a function to check if they are one edit (or zero edits)
    // away.

    // Replacement means that the strings are different in only two places.

    // Insertion means that the strings are identical except for a shit at some point
    // in the strings.

    // Removal is just the inverse of insertion - the strings are identical except
    // for the removal of a character at some point.

    public static boolean oneEditAway(String s1, String s2) {
        // First check the length of the strings - that will tell us which
        // operation needs to be done.
        if (s1.length() == s2.length()) {
            return oneEditReplace(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return oneEditInsert(s2, s1);
        } else if (s1.length() - 1 == s2.length()) {
            return oneEditInsert(s1, s2);
        } else {
            return false;
        }
    }

    // This method assumes that the lengths of the strings are the same.
    public static boolean oneEditReplace(String s1, String s2) {
        boolean difference = false;

        // Compare characters.
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                // If difference is already true, return false.
                if (difference) {
                    return false;
                } else {
                    difference = true;
                }
            }
        }

        return true;
    }

    // Determines whether it's possible to add one char to s1 to make it the
    // same as s2.
    // The assumption is that s1.length() - 1 == s2.length().
    public static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        // Keep going while both indexes are within their respective string bounds.
        while (index1 < s1.length() && index2 < s2.length()) {
            char c1 = s1.charAt(index1);
            char c2 = s2.charAt(index2);

            if (c1 != c2) {
                // If the indexes are already different, return false.
                if (index1 != index2) {
                    return false;
                }

                // Increase index 1 to match index 2
                ++index1;
            } else {
                ++index1;
                ++index2;
            }
        }

       return true;
    }

    public static void main(String[] args) {

        // Expected output: true
        String s1 = "pale";
        String s2 = "ple";
        System.out.println(String.format("%s, %s: %s", s1, s2, oneEditAway(s1, s2)));

        // Expected output: true
        s1 = "pales";
        s2 = "pale";
        System.out.println(String.format("%s, %s: %s", s1, s2, oneEditAway(s1, s2)));

        // Expected output: true
        s1 = "pale";
        s2 = "bale";
        System.out.println(String.format("%s, %s: %s", s1, s2, oneEditAway(s1, s2)));

        // Expected output: false
        s1 = "pale";
        s2 = "bae";
        System.out.println(String.format("%s, %s: %s", s1, s2, oneEditAway(s1, s2)));
    }
}
