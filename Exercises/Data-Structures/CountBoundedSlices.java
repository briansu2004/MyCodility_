import java.util.Arrays;

/*
An integer K and a non-empty array A consisting of N integers are given.

A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.

A bounded slice is a slice in which the difference between the maximum and minimum values in the slice is less than or equal to K. More precisely it is a slice, such that max(A[P], A[P + 1], ..., A[Q]) − min(A[P], A[P + 1], ..., A[Q]) ≤ K.

The goal is to calculate the number of bounded slices.

For example, consider K = 2 and array A such that:

    A[0] = 3
    A[1] = 5
    A[2] = 7
    A[3] = 6
    A[4] = 3
There are exactly nine bounded slices: (0, 0), (0, 1), (1, 1), (1, 2), (1, 3), (2, 2), (2, 3), (3, 3), (4, 4).

Write a function:

class Solution { public int solution(int K, int[] A); }

that, given an integer K and a non-empty array A of N integers, returns the number of bounded slices of array A.

If the number of bounded slices is greater than 1,000,000,000, the function should return 1,000,000,000.

For example, given:

    A[0] = 3
    A[1] = 5
    A[2] = 7
    A[3] = 6
    A[4] = 3
the function should return 9, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
K is an integer within the range [0..1,000,000,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
*/

// https://codility.com/media/train/solution-count-bounded-slices.pdf

public class CountBoundedSlices {
    public int solution(int k, int[] a) {
        int len = a.length;

        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int max = a[i];
            for (int j = i + 1; j < a.length; j++) {
                min = Math.min(min, a[j]);
                max = Math.max(max, a[j]);
                if (max - min <= k) {
                    len++;
                }
            }
        }

        return len;
    }

    public static void main(String[] args) {
        CountBoundedSlices cbs = new CountBoundedSlices();

        int k = 2;
        int[] arr1 = new int[5];
        arr1[0] = 3;
        arr1[1] = 5;
        arr1[2] = 7;
        arr1[3] = 6;
        arr1[4] = 3;
        System.out.printf("The CountBoundedSlices of %s & %s is: %s\n", k, Arrays.toString(arr1), cbs.solution(k, arr1));
    }
}
