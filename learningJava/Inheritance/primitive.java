import java.util.Arrays;
import java.util.Scanner;

public class primitive {
        public static int[] twoSum(int[] nums, int target) {
            for(int i=0; i<nums.length; i++){
                for(int j=i+1; j<nums.length; j++){
                    if(nums[j] == target - nums[i] ){
                         return new int[] {i , j };
                    }
                }
            }
            return null;

        }
        public static void main(String[] args){
            int[] x={1,5,3,2,7};
            System.out.print(Arrays.toString(twoSum(x,9)));
        }
    }
