import java.util.Arrays;

public class Sort2DArray {
    public static void main(String[] args) {
        String[] arr1D = {"Brian", "is", "awesome"};
        System.out.println(Arrays.toString(arr1D));

        double[][] arr2D = {{1, 5}, {13, 1.55}, {12, 100.6}, {12.1, .85}};
        System.out.printf("Before sort, %s\n", Arrays.deepToString(arr2D));

        Arrays.sort(arr2D, (a, b) -> Double.compare(a[0], b[0]));
        System.out.printf("After sort, %s\n", Arrays.deepToString(arr2D));

        int[][] points = {{-1, 3}, {1, 2}, {3, 1}, {0, -1}, {-2, 1}};
        System.out.printf("Before sort, %s\n", Arrays.deepToString(points));

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.printf("After sort, %s\n", Arrays.deepToString(points));

        int[][] pts2 = {{-1, 3}, {1, 2}, {-2, 2}, {0, -1}, {-2, 1}};
        System.out.printf("Before sort, %s\n", Arrays.deepToString(pts2));

        Arrays.sort(pts2, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.printf("After sort, %s\n", Arrays.deepToString(pts2));

        int[][] pts3 = {{-1, 3}, {1, 2}, {-2, 2}, {0, -1}, {-2, 1}};
        System.out.printf("Before sort, %s\n", Arrays.deepToString(pts3));

        Arrays.sort(pts3, (a, b) -> {
            if (a[0] == b[0]) {
                return (a[1] < b[1]) ? -1 : 1;
            }
            return (a[0] < b[0]) ? -1 : 1;
        });
        System.out.printf("After sort, %s\n", Arrays.deepToString(pts3));
    }
}
