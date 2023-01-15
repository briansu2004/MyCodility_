/*
 * A string S containing only the letters "A", "B" and "C" is given. The string can be transformed
 * by removing one occurrence of "AA", "BB" or "CC".
 * 
 * Transformation of the string is the process of removing letters from it, based on the rules
 * described above. As long as at least one rule can be applied, the process should be repeated. If
 * more than one rule can be used, any one of them could be chosen.
 * 
 * Write a function:
 * 
 * class Solution { public String solution(String S); }
 * 
 * that, given a string S consisting of N characters, returns any string that can result from a
 * sequence of transformations as described above.
 * 
 * For example, given string S = "ACCAABBC" the function may return "AC", because one of the
 * possible sequences of transformations is as follows:
 * 
 * Also, given string S = "ABCBBCBA" the function may return "", because one possible sequence of
 * transformations is:
 * 
 * Finally, for string S = "BABABA" the function must return "BABABA", because no rules can be
 * applied to string S.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * the length of string S is within the range [0..50,000]; string S is made only of the following
 * characters: "A", "B" and/or "C".
 */

public class DisappearingPairs {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        DisappearingPairs dp = new DisappearingPairs();

        String s = "ACCAABBC";
        System.out.printf("%s -> %s\n", s, dp.solution(s));
        s = "ABCBBCBA";
        System.out.printf("%s -> %s\n", s, dp.solution(s));
        s = "BABABA";
        System.out.printf("%s -> %s\n", s, dp.solution(s));
    }
}
