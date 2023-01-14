import java.util.Arrays;
import java.util.List;

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


    public static int getArrayInversionCount(int[] a) {

        int result = 0;
        

        Arrays.sort(a);

        a.Sort();

        for (int i = 0; i < A.Length; i++){
        int idxFound = sortedA.BinarySearch(A[i]);
        // if duplicates, retrieve first occurence
        while (idxFound > 0 && sortedA[idxFound-1] == sortedA[idxFound]){
        idxFound--;
        }
        result += idxFound;
        if (result > 1000000000) return -1;
        sortedA.RemoveAt(idxFound);
        }

        return result;
    }

    // O(N**2)
    // 63%
    public static int getArrayInversionCount1(int[] a) {
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
        System.out.printf("The ArrayInversionCount of %s is %s\n", arr1,
                getArrayInversionCount(arr1));
    }
}
