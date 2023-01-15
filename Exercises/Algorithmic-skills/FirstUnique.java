import java.util.HashMap;
import java.util.Map;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;
// import java.util.Set;
// import java.util.stream.Collectors;

/*
 * A non-empty array A consisting of N integers is given. The unique number is the number that
 * occurs exactly once in array A.
 * 
 * For example, the following array A:
 * 
 * A[0] = 4 A[1] = 10 A[2] = 5 A[3] = 4 A[4] = 2 A[5] = 10 contains two unique numbers (5 and 2).
 * 
 * You should find the first unique number in A. In other words, find the unique number with the
 * lowest position in A.
 * 
 * For above example, 5 is in second position (because A[2] = 5) and 2 is in fourth position
 * (because A[4] = 2). So, the first unique number is 5.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A of N integers, returns the first unique number in A. The function
 * should return −1 if there are no unique numbers in A.
 * 
 * For example, given:
 * 
 * A[0] = 1 A[1] = 4 A[2] = 3 A[3] = 3 A[4] = 1 A[5] = 2 the function should return 4. There are two
 * unique numbers (4 and 2 occur exactly once). The first one is 4 in position 1 and the second one
 * is 2 in position 5. The function should return 4 bacause it is unique number with the lowest
 * position.
 * 
 * Given array A such that:
 * 
 * A[0] = 6 A[1] = 4 A[2] = 4 A[3] = 6 the function should return −1. There is no unique number in A
 * (4 and 6 occur more than once).
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an integer within the
 * range [0..1,000,000,000].
 */

class FirstUnique {
    // public static int solutionBad(int[] a) {
    // Set<Integer> aSet = Arrays.stream(a).boxed().collect(Collectors.toSet());

    // List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());

    // for (int i = 0; i < a.length; i++) {
    // if (Collections.frequency(aList, a[i]) == 1) {
    // return a[i];
    // }
    // }

    // return -1;
    // }

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

        System.out.println(FirstUnique.solution(intArray));
    }
}
