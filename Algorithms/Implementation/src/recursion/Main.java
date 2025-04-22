import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    /*
    recursive sum
    static int sum(int[] arr){
        int sum=0;
        if(arr.length==0){
            return 0;
        }
        else {
            return arr[0]+sum(Arrays.copyOfRange(arr,1,arr.length));
        }
    }
     */
    /*recursive count
    static int count(int[] arr){
        if(arr.length==0){
            return 0;
        }
        else{
            return 1+count(Arrays.copyOfRange(arr,1,arr.length));
        }
    }
     */
    /*recursive max
    static int max(int[] arr){
        if(arr.length==2){
            return arr[0]>arr[1] ? arr[0] : arr[1];
        }
        int submax = max(Arrays.copyOfRange(arr,1,arr.length));
        return arr[0] > submax ? arr[0] : submax;
    }
    */
    public static void main(String[] args) {
        System.out.println((new int[]{9,3,8,5,1}));
    }
}