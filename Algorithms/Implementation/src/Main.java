import Search.BinarySearch.BinarySearch;
import Sort.BubbleSort.BubbleSort;
import Sort.MergeSort2.MergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr[] = {16,17,9,6,4,20};
        BubbleSort.bubbleSort(arr);


        System.out.println(Arrays.toString(arr));

    }

//    static void mergeSort(int[] arr, int low, int high) {
//
//       if(low < high){
//           int mid = (high+low) / 2;
//           mergeSort(arr, low ,mid);
//           mergeSort(arr,mid+1,high);
//           merge(arr,low , mid , high);
//       }
//    }
//    static void merge(int[] arr , int low , int mid , int high){
//        int [] temp = new int[high-low + 1];
//        int i = low;
//        int j = mid+1;
//        int k=0;
//        while(i <= mid && j <= high){
//            if (arr[i] <= arr[j]){
//                temp[k] = arr[i];
//                i+=1;
//            }
//            else {
//                temp[k] = arr[j];
//                j +=1;
//            }
//            k+=1;
//        }
//        while (i <= mid){
//            temp[k]= arr[i];
//            k++;
//            i++;
//        }
//        while (j <= high){
//            temp[k]= arr[j];
//            k++;
//            j++;
//        }
//        k=0;
//        for (int l = low; l <= high ; l++) {
//            arr[l] = temp[k];
//            k+=1;
//        }
//    }



}