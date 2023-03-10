/*
 * StrSymmetryPoint
 * 
 * Find a symmetry point of a string, if any.
 * 
 * Task description
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S, returns the index (counting from 0) of a character such that the part of
 * the string to the left of that character is a reversal of the part of the string to its right.
 * The function should return ?1 if no such index exists.
 * 
 * Note: reversing an empty string (i.e. a string whose length is zero) gives an empty string.
 * 
 * For example, given a string: "racecar"
 * 
 * the function should return 3, because the substring to the left of the character "e" at index 3
 * is "rac", and the one to the right is "car".
 * 
 * Given a string:
 * 
 * "x"
 * 
 * the function should return 0, because both substrings are empty.
 * 
 * Assume that:
 * 
 * the length of S is within the range [0..2,000,000].
 * 
 * Complexity:
 * 
 * expected worst-case time complexity is O(length(S));
 * 
 * expected worst-case space complexity is O(1) (not counting the storage required for input
 * arguments).
 */

public class FirstSymmetryPoint {
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static int Solution(String s) {
        if (s.length() % 2 == 0) {
            return -1;
        }

        int len = s.length();
        int mid = (len - len % 2) / 2;
        String left = s.substring(0, mid);
        String right = s.substring(mid + 1, len);

        if (left.equals(reverseString(right))) {
            return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Solution(""));
        System.out.println(Solution("x"));
        System.out.println(Solution("ab"));
        System.out.println(Solution("cbc"));
        System.out.println(Solution("racecar"));
        System.out.println(Solution("veryfunnyquestion"));
    }
}
