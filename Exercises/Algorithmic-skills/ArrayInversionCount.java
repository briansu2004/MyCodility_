import java.util.Arrays;

/*
 * An array A consisting of N integers is given. An inversion is a pair of indexes (P, Q) such that
 * P < Q and A[Q] < A[P].
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that computes the number of inversions in A, or returns −1 if it exceeds 1,000,000,000.
 * 
 * For example, in the following array:
 * 
 * A[0] = -1 A[1] = 6 A[2] = 3 A[3] = 4 A[4] = 7 A[5] = 4 there are four inversions:
 * 
 * (1,2) (1,3) (1,5) (4,5) so the function should return 4.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an integer within the
 * range [−2,147,483,648..2,147,483,647].
 */


public class ArrayInversionCount {
    private final int LIMIT = 1000000000;

    int getArrayInversionCount(int[] a) {
        if (a.length <= 1) {
            return 0;
        }

        int index = a.length / 2;

        int[] left = Arrays.copyOfRange(a, 0, index);
        int[] right = Arrays.copyOfRange(a, index, a.length);
    
        int cnt = getArrayInversionCount(left) + getArrayInversionCount(right) + mergeIt(a, left, right);

        return (cnt > LIMIT) ? -1 : cnt;
    }

    int mergeIt(int arr[], int[] left, int[] right) {
        int l = 0, r = 0, inv = 0;
        while (l < left.length || r < right.length) {
            if (l == left.length) {
                arr[l + r] = right[r];
                r++;
            } else if (r == right.length) {
                arr[l + r] = left[l];
                l++;
            } else if (left[l] > right[r]) {
                arr[l + r] = right[r];
                inv += left.length - l;
                r++;
            } else if (left[l] <= right[r]) {
                arr[l + r] = left[l];
                l++;
            }
        }
        return inv;
    }


    private long s = 0;

    public int getArrayInversionCount2(int[] a) {
        sort(a, 0, a.length);
        if (s > 1000000000) {
            return -1;
        }
        return (int) s;
    }

    private int[] sort(final int[] a, final int from, final int to) {
        if (to == from) {
            return new int[0];
        }
        if (to - from == 1) {
            return new int[] {a[from]};
        }
        final int[] left = sort(a, from, (from + to) / 2);
        final int[] right = sort(a, (from + to) / 2, to);
        return merge(left, right);
    }

    private int[] merge(final int[] a, final int[] b) {
        final int[] out = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        int count = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                out[k++] = a[i++];
                this.s += count;
            } else {
                out[k++] = b[j++];
                count++;
            }
        }
        while (i < a.length) {
            out[k++] = a[i++];
            this.s += count;
        }
        while (j < b.length) {
            out[k++] = b[j++];
        }
        return out;
    }

    // O(N**2)
    // 63%
    public int getArrayInversionCount1(int[] a) {
        if (a == null || a.length <= 1) {
            return 0;
        }

        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[6];
        arr1[0] = -1;
        arr1[1] = 6;
        arr1[2] = 3;
        arr1[3] = 4;
        arr1[4] = 7;
        arr1[5] = 4;
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        ArrayInversionCount a = new ArrayInversionCount();

        System.out.printf("The ArrayInversionCount of %s is %s\n", arr1,
                a.getArrayInversionCount(arr1));
        System.out.printf("The ArrayInversionCount of %s is %s\n", arr2,
                a.getArrayInversionCount1(arr2));
        System.out.printf("The ArrayInversionCount of %s is %s\n", arr3,
                a.getArrayInversionCount2(arr3));
    }
}
