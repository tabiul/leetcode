package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem953 {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            m.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            Boolean isSorted = isSorted(words[i - 1], words[i], m);
            if (!isSorted) return false;
        }

        return true;
    }

    private Boolean isSorted(String word1, String word2, Map<Character, Integer> order) {
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();


        int size = Integer.min(word1Chars.length, word2Chars.length);

        for (int i = 0; i < size; i++) {
            if (order.get(word1Chars[i]) > order.get(word2Chars[i])) {
                return false;
            } else if (order.get(word1Chars[i]) < order.get(word2Chars[i])) {
                return true;
            }
        }

        return word1Chars.length <= word2Chars.length;
    }

    public static void main(String[] args) {
        Problem953 problem953 = new Problem953();
        System.out.println(problem953.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(problem953.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
