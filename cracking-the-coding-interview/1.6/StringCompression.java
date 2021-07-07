public class StringCompression {
    // Implement a method to perform basic string compression using the
    // counts of repeated characters.

    public static String compressString(String s) {
        StringBuilder sBuilder = new StringBuilder();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            ++count;

            // Check if the next character will be different.
            // This also applies if we have reached the end of the string.
            if (i + 1 >= s.length() || s.charAt(i + 1) != s.charAt(i)) {
                sBuilder.append("" + s.charAt(i) + count);
                count = 0;
            }
        }

        // Return the original string if compression does not actually decrease
        // the length of the string.
        return sBuilder.toString().length() < s.length() ? sBuilder.toString() : s;
    }

    public static void main(String[] args) {

        // Expected output: a2b1c5a3
        String s = "aabcccccaaa";
        System.out.println(String.format("%s: %s", s, compressString(s)));
    }
}