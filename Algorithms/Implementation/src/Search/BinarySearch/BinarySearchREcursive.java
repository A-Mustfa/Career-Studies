package Search.BinarySearch;

public class BinarySearchREcursive {

    public static int recBinary(int[] arr, int low, int high, int target) {
        int mid = (low + high) / 2;
        if (low > high) {
            return -1;
        }
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                return recBinary(arr, low, mid - 1, target);
            } else {
                return recBinary(arr, low, mid + 1, target);
            }
        }
    }
    /*
    public static int recBinary(int[] arr,int low,int high, int target){
        int mid = (low+high) / 2;
        if(low > high){
            return -1;
        }
        if(target == arr[mid]){
            return mid;
        } else if (target < arr[mid]) {
            return recBinary(arr,low,mid-1,target);
        } else {
            return recBinary(arr,mid+1,high,target);
        }
    }*/
