public class RotateMatrix {

    // #######################################################################
    // Rotate Matrix: Given an image represented by an NxN matrix, where each
    // pixel in the image is 4 bytes, write a method to rotate the image by 90
    // degrees. Can you do this in place?
    // #######################################################################

    public static void rotateMatrix(int[][] matrix) {

        // This is the length of the NxN matrix.
        int n = matrix.length;

        // Start from outer layer, stop at n / 2 (integer division rounds it down).
        // For example, if N = 4, then there would be layers 0 and 1 (2 out of 4).
        // If N = 3, then there would still be layers 0 and 1, because the innermost
        // layer of the cube would just be a 1x1 cube.
        for (int layer = 0; layer < n / 2; layer++) {

            // First and last represent the starting and ending positions
            // of the current layer.
            // The first last represent the ROW.
            int firstRowIndex = layer;
            int lastRowIndex = n - 1 - layer;

            // Iterate the COL value.
            for (int currColIndex = firstRowIndex; currColIndex < lastRowIndex; currColIndex++) {
                // The offset is used for moving through the indexes that start from the end.
                int offset = currColIndex - firstRowIndex;

                // Save the top piece.
                int top = matrix[firstRowIndex][currColIndex];

                // Move the left piece to the top piece.
                matrix[firstRowIndex][currColIndex] = matrix[lastRowIndex - offset][currColIndex];

                // Move the bottom piece to the left piece.
                matrix[lastRowIndex - offset][currColIndex] = matrix[lastRowIndex][lastRowIndex - offset];

                // Move the right piece to the bottom piece.
                matrix[lastRowIndex][lastRowIndex - offset] = matrix[lastRowIndex][cu]

                // Move the top piece to the right piece.

            }
        }
    }


    public static void main(String[] args) {
        System.out.println("I hate niggers.");
    }
}