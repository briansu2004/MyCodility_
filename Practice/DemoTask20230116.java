/*
 * This is a demo task.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that
 * does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an integer within the
 * range [−1,000,000..1,000,000].
 */

import java.util.*;

class DemoTask20230116 {
    public int solution(int[] a) {
        int n = 1000001;

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                if (m.containsKey(a[i])) {
                    m.put(a[i], m.get(a[i]) + 1);
                } else {
                    m.put(a[i], 1);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (!m.containsKey(i)) {
                return i;
            }
        }

        return n;
    }


    public static void main(String[] args) {
        DemoTask20230116 d = new DemoTask20230116();

        int[] a1 = {1, 3, 6, 4, 1, 2};
        System.out.printf("%s -> %s\n", Arrays.toString(a1), d.solution(a1));

        int[] a2 = {1, 2, 3};
        System.out.printf("%s -> %s\n", Arrays.toString(a1), d.solution(a2));

        int[] a3 = {-1, -3};
        System.out.printf("%s -> %s\n", Arrays.toString(a1), d.solution(a3));

    }
}
