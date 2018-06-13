package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Problem846 {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int aHand : hand) {
            if (treeMap.containsKey(aHand)) {
                treeMap.put(aHand, treeMap.get(aHand) + 1);
            } else {
                treeMap.put(aHand, 1);
            }
        }
        while (true) {
            if (treeMap.isEmpty()) break;
            Map.Entry<Integer, Integer> e = treeMap.firstEntry();
            int count = 1;
            if (e.getValue() == 1) {
                treeMap.remove(e.getKey());
            } else {
                treeMap.put(e.getKey(), e.getValue() - 1);
            }
            Integer value = e.getKey();
            while (count < W) {
                Integer higher = treeMap.higherKey(value);
                if (higher == null) return false;
                if (higher - value != 1) return false;
                if (treeMap.get(higher) == 1) {
                    treeMap.remove(higher);
                } else {
                    treeMap.put(higher, treeMap.get(higher) - 1);
                }
                value = higher;
                count++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem846 problem846 = new Problem846();
        System.out.println(problem846.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3) == true);
        System.out.println(problem846.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4) == false);
        System.out.println(problem846.isNStraightHand(new int[]{1, 2, 3, 4, 5, 6}, 2) == true);
        System.out.println(problem846.isNStraightHand(new int[]{5, 1}, 2) == false);
    }
}
