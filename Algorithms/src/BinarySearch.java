public class BinarySearch {
    static int BinarySearch(int[] array,int item) {
        int low  = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(array[mid] == item)
                return mid;
            if (array[mid] > item)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

}
