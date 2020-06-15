import java.util.Arrays;

public class QuickSort {

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.println(Arrays.toString(arr));
            }
        }
        int temp = arr[i+1];
        arr[i+1]=arr[high];
        arr[high] = temp;
        System.out.println(Arrays.toString(arr));
        return i +1;
    }

    static void quicksort(int[] arr, int low, int high){
        if (low < high) {
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi-1);
            quicksort(arr, pi +1, high);
        }
    }

    public static void main(String[] args){
        int arr[] = {2,5,9,1};
        quicksort(arr,0, arr.length-1);
        //System.out.println(Arrays.toString(arr));
    }
}
