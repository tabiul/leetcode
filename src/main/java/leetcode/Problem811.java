package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null) return null;
        Map<String, Integer> countMap = new HashMap<>();
        for (String domain : cpdomains) {
            String[] arr = domain.split(" ");
            String count = arr[0];
            String domainName = arr[1];
            String[] split = domainName.split("\\.");
            if (countMap.containsKey(domainName)) {
                countMap.put(domainName, Integer.parseInt(count) +  countMap.get(domainName));
            } else {
                countMap.put(domainName, Integer.parseInt(count));
            }
            for(int i = 0 ; i < split.length; i++) {
                if(i != 0 ) {
                    StringBuilder builder = new StringBuilder();
                    for(int j = i ; j < split.length; j++) {
                        builder.append(split[j]);
                        builder.append(".");
                    }
                    String d = builder.deleteCharAt(builder.length() - 1).toString();
                    if (countMap.containsKey(d)) {
                        countMap.put(d, Integer.parseInt(count) + countMap.get(d));
                    } else {
                        countMap.put(d, Integer.parseInt(count));
                    }
                }
            }
        }

        List<String> solution = new ArrayList<>();
        for(Map.Entry<String, Integer> e : countMap.entrySet()) {
            solution.add(e.getValue() + " " + e.getKey());
        }

        return solution;
    }

    public static void main(String[] args) {
        Problem811 problem811 = new Problem811();
        System.out.println(problem811.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
        System.out.println("[\"901 mail.com\",\"50 yahoo.com\",\"900 google.mail.com\",\"5 wiki.org\",\"5 org\",\"1 intel.mail.com\",\"951 com\"]");
    }
}
