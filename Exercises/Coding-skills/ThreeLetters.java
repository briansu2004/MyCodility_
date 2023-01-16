public class ThreeLetters {
    public String solution(int n1, int n2) {
        int a = n1;
        int b = n2;

        char c1 = 'a';
        char c2 = 'b';

        StringBuilder sb = new StringBuilder();
        while (a > 0 && b > 0) {
            if (a > b) {
                sb.append(c1);
                a--;
            } else {
                sb.append(c2);
                b--;
            }

            if (a > b) {
                sb.append(c1);
                a--;
            } else {
                sb.append(c2);
                b--;
            }

            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 1) == sb.charAt(len - 2)) {
                char c = sb.charAt(len - 1);

                if (c1 == c) {
                    sb.append(c2);
                    b--;
                } else {
                    sb.append(c1);
                    a--;
                }
            }
        }

        if (a == 0) {
            for (int i = 0; i < b; i++) {
                sb.append(c2);
            }
        } else if (b == 0) {
            for (int i = 0; i < a; i++) {
                sb.append(c1);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ThreeLetters tl = new ThreeLetters();
    
        int a = 5;
        int b = 3;
        System.out.printf(" %s , %s -> %s\n", a, b, tl.solution(a, b));

        a = 3;
        b = 3;
        System.out.printf(" %s , %s -> %s\n", a, b, tl.solution(a, b));

        a = 1;
        b = 4;
        System.out.printf(" %s , %s -> %s\n", a, b, tl.solution(a, b));
    }
}
