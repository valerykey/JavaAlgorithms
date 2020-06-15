import java.util.Arrays;

public class Recursion {
    static int summa(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else {
            return arr[0] + summa(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }
    static int maxi;
    static int max(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else {
            if (maxi<arr[0]) maxi = arr[0];
            return max(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }

    public static void main(String[] args){
        int[] a = {2,7,14,8};
        max(a);
        System.out.println(maxi);
    }
}
