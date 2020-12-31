package binary_search;
public class BinarySearch {
    private BinarySearch() {}
    
    private static int indexOf(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num < arr[mid]) right = mid - 1;
            else if(num > arr[mid]) left = mid + 1;
            else return mid;
        }
        // Not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 9, 10, 12, 16};
        System.out.println(BinarySearch.indexOf(arr, 10));
    }
}