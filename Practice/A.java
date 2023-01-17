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

class A {
    public int solution(int[] a) {
        int k = 0;

        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                if (m.containsKey(a[i])) {
                    m.put(a[i], m.get(a[i]) + 1);
                } else {
                    m.put(a[i], 1);
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                if (m.containsKey(-a[i])) {
                    k = Math.max(k, Math.abs(a[i]));
                }
            }
        }

        return k;
    }


    public static void main(String[] args) {
        A d = new A();

        int[] a1 = {3, 2, -2, 5, -3};
        System.out.printf("%s -> %s\n", Arrays.toString(a1), d.solution(a1));

        int[] a2 = {1, 1, 2, -1, 2, -1};
        System.out.printf("%s -> %s\n", Arrays.toString(a1), d.solution(a2));

        int[] a3 = {1, 2, 3, -4};
        System.out.printf("%s -> %s\n", Arrays.toString(a1), d.solution(a3));

    }



    
}

class HealthCheck {
    String status;
    String currentTime;
    public HealthCheck(String status, String currentTime) {
        this.status = status;
        this.currentTime = currentTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
    // @Override
    // public String toString() {
    //     return "HealthCheck [status=" + status + ", currentTime=" + currentTime + "]";
    // }

    @Override
    public String toString() {
        if (currentTime == null) {
            return "{\"status\": \"" + status + "\"}";
        }
        return "{\"currentTime\": \"" + currentTime + "\", \"status\": \"" + status + "\"}";
    }
}