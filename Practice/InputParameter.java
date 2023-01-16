public class InputParameter {
    
    public void solution(int n1, int n2) {
        int a = n1 - 1;
        int b = n2 - 1;

        System.out.printf("%s %s\n", a, b);
    }

    public static void main(String[] args) {
        InputParameter ip = new InputParameter();

        int a = 5;
        int b = 3;
        System.out.printf(" %s , %s \n", a, b);
        ip.solution(a, b);

        a = 3;
        b = 3;
        System.out.printf(" %s , %s \n", a, b);
        ip.solution(a, b);

        a = 1;
        b = 4;
        System.out.printf(" %s , %s \n", a, b);
        ip.solution(a, b);
    }
}
