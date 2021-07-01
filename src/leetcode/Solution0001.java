package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍
 *
 */
public class Solution0001 {

    public static void main(String[] args) {

        int[] nums = {2,5,8,9};
        int target = 14;
//        int[] resNums = twoSum(nums,target);
        int[] resNums = twoSum1(nums,target);
        System.out.println(Arrays.toString(resNums));
        for (int a:resNums){
            System.out.println(a);
        }

    }


    //暴力枚举法
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    //哈希表法
    public static int[] twoSum1(int[] nums, int target){
        Map<Integer,Integer> hashTable = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++){
            if (hashTable.containsKey(target - nums[i])){
                return new int[]{i,hashTable.get(target - nums[i])};
            }
            hashTable.put(nums[i],i);
        }
        return new int[0];
    }

}
