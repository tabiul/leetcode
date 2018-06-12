package leetcode;

public class Problem845 {

    class Solution {
        public int longestMountain(int[] A) {
            if (A.length < 3) return 0;
            int max = 0;
            int size = 0;
            boolean isIncreasing = false;
            boolean isDecreasing = false;
            for (int i = 1; i < A.length; i++) {
                if (A[i] > A[i - 1]) { //increasing
                    if (isDecreasing) {
                        isDecreasing = false;
                        if (size > 0) {
                            max = Math.max(max, size + 1);
                        }
                        size = 0;
                    }
                    size++;
                    isIncreasing = true;
                } else if (A[i] < A[i - 1]) { //decreasing
                    if (isIncreasing) {
                        size++;
                        isDecreasing = true;
                    }

                } else { // same
                    if (size > 0 && isDecreasing) {
                        max = Math.max(max, size + 1);
                    }
                    isIncreasing = false;
                    isDecreasing = false;
                    size = 0;
                }
            }

            if (isDecreasing) {
                if (size > 0) {
                    max = Math.max(max, size + 1);
                }
            }

            return max;
        }
    }

}
