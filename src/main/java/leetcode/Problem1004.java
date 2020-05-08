package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1004 {

    public int longestOnes(int[] A, int K) {
        int i,j = 0;
        int max = 0;
        for(i = 0 ; i < A.length; i++) {
            if(A[i] == 0) K--;
            if(K < 0 && A[++j] == 0) K++;
            if(K < 0 && A[i] == 1) max = Math.max(max, i - j);
            if(K < 0 && A[i] == 0) {
                max = Math.max(max, i - j);
                j++;
            }
        }

        return max;
    }

//    public int longestOnes(int[] A, int K) {
//        class Indexes {
//            int start;
//            int end;
//        }
//
//        List<Indexes> l = new ArrayList<>();
//        Map<Integer, Indexes> m = new HashMap<>();
//
//        Indexes indexes = null;
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] == 1 && indexes == null) {
//                indexes = new Indexes();
//                indexes.start = i;
//                l.add(indexes);
//                m.put(indexes.start, indexes);
//            }
//
//            if (A[i] == 0 && indexes != null) {
//                indexes.end = i - 1;
//                m.put(indexes.end, indexes);
//                indexes = null;
//            }
//        }
//
//        if (indexes != null) {
//            indexes.end = A.length - 1;
//        }
//
//        int max = 0;
//
//        for (Indexes index : l) {
//            int start = index.start;
//            int end = index.end;
//
//            int left = K;
//            int size = (end - start) + 1;
//            int i = start - 1;
//            while (left > 0 && i >= 0) {
//                if (A[i] == 0) {
//                    left--;
//                    size++;
//                    i--;
//                } else {
//                    if (m.containsKey(i)) {
//                        size += (m.get(i).end - m.get(i).start) + 1;
//                        i = m.get(i).start - 1;
//                    }
//                }
//            }
//
//            if (m.containsKey(i)) {
//                size += (m.get(i).end - m.get(i).start) + 1;
//            }
//
//            i = end + 1;
//            while (left > 0 && i < A.length) {
//                if (A[i] == 0) {
//                    left--;
//                    size++;
//                    i++;
//                } else {
//                    if (m.containsKey(i)) {
//                        size += (m.get(i).end - m.get(i).start) + 1;
//                        i = m.get(i).end + 1;
//                    }
//                }
//            }
//
//            if (m.containsKey(i)) {
//                size += (m.get(i).end - m.get(i).start) + 1;
//            }
//
//
//            max = Math.max(max, size);
//        }
//
//        return max;
//    }

    public static void main(String[] args) {
        Problem1004 problem1004 = new Problem1004();
        System.out.println(problem1004.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 0));
    }
}
