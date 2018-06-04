package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Problem826 {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        TreeMap<Integer, Integer> difficultyMap = new TreeMap<>();
        for(int i = 0 ; i < difficulty.length ; i++) {
            if(difficultyMap.containsKey(difficulty[i])) {
                if(profit[i] > difficultyMap.get(difficulty[i])) {
                    difficultyMap.put(difficulty[i], profit[i]);
                }
            } else {
                difficultyMap.put(difficulty[i], profit[i]);
            }
        }

        int sum = 0;
        Arrays.sort(worker);
        TreeMap<Integer, Integer> maxProfit = new TreeMap<>();
        for(int w : worker) {
            int max = 0;
            if(maxProfit.containsKey(w)){
                max = maxProfit.get(w);
            } else {
                Map.Entry<Integer, Integer> lowerEntry = maxProfit.lowerEntry(w);
                if(lowerEntry != null) {
                    max = lowerEntry.getValue();
                    Map<Integer, Integer> map = difficultyMap.subMap(lowerEntry.getKey(), true, w, true);
                    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                        max = Math.max(max, e.getValue());
                    }
                } else {
                    Map<Integer, Integer> map = difficultyMap.headMap(w, true);
                    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                        max = Math.max(max, e.getValue());
                    }
                }
                maxProfit.put(w, max);
            }
            sum += max;
        }

        return sum;
    }

    public static void main(String[] args) {
        Problem826 problem826 = new Problem826();
        //System.out.println(problem826.maxProfitAssignment(new int[]{2,4,6,8,10}, new int[] {10,20,30,40,50}, new int[] {4,5,6,7}) == 100);
        //System.out.println(problem826.maxProfitAssignment(new int[]{68,35,52,47,86}, new int[] {67,17,1,81,3}, new int[] {92,10,85,84,82}) == 324); //324
//        66 -> 66
//        1 20
//        28 84
//        73 81
//        53 56
//        35 40
//        45 37
//        60 82
//        100 53
//        44 45
//        59 43
//        94 96
//        27 67
//        88 27
//        7 12
//        18 54
//        83 98
//        18 19
//        72 47
//        63 77
        System.out.println(problem826.maxProfitAssignment(new int[]{66,1,28,73,53,35,45,60,100,44,59,94,27,88,7,18,83,18,72,63},
                                                          new int[]{66,20,84,81,56,40,37,82,53,45,43,96,67,27,12,54,98,19,47,77},
            new int[] {61,33,68,38,63,45,1,10,53,23,66,70,14,51,94,18,28,78,100,16}) == 1392); //1324
    }
}
