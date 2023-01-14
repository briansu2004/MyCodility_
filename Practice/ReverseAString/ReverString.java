package Practice.ReverseAString;

public class ReverString {
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("BrianAwesome"));
    }
}
