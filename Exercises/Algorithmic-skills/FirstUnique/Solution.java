package Java.FirstUnique;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public static int solutionBad(int[] a) {
        Set<Integer> aSet = Arrays.stream(a).boxed().collect(Collectors.toSet());

        List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());

        for (int i = 0; i < a.length; i++) {
            if (Collections.frequency(aList, a[i]) == 1) {
                return a[i];
            }
        }

        return -1;
    }

    public static int solution(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (m.containsKey(a[i])) {
                m.put(a[i], m.get(a[i]) + 1);
            } else {
                m.put(a[i], 1);
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (m.get(a[i]) == 1) {
                return a[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] intArray = new int[5];
        intArray[0] = 3;
        intArray[1] = 12;
        intArray[2] = 45;
        intArray[3] = 23;
        intArray[4] = 11;

        System.out.println(Solution.solution(intArray));
    }
}
