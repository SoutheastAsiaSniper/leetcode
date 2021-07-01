package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 示例：
 输入：nums = [-1,2,1,-4], target = 1
 输出：2
 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

 提示：
 3 <= nums.length <= 10^3
 -10^3 <= nums[i] <= 10^3
 -10^4 <= target <= 10^4
 */
public class Solution0016 {
    public static void main(String[] args) {
        int target = 82;
        int[] nums = new int[]{1,2,4,8,16,32,64,128};
        System.out.println(threeSumClosest1(nums,target));
    }

    //暴力
    public static int threeSumClosest(int[] nums, int target) {
        int num = 0;
        List<Integer> newNums = new ArrayList<Integer>();
        for (int k = 0; k < nums.length - 2; k++){
            for (int i = k + 1; i < nums.length - 1; i++) {
                int j = nums.length - 1;
                while (i < j){
                    int sum = nums[i] + nums[j] + nums[k] - target;
                    newNums.add(sum);
                    j--;
                }
            }
        }
        Collections.sort(newNums);
        if (newNums.get(0) >= 0){
            num = newNums.get(0) + target;
        }
        if (newNums.get(newNums.size() - 1) <= 0){
            num = newNums.get(newNums.size() - 1) + target;
        }
        for (int i = 0; i < newNums.size() - 1; i++) {
            if (newNums.get(i) < 0 && newNums.get(i + 1) >= 0){
                if (Math.abs(newNums.get(i)) >= newNums.get(i + 1) || newNums.get(i + 1) == 0){
                    num = newNums.get(i + 1 ) + target;
                    break;
                }else {
                    num = newNums.get(i) + target;
                    break;
                }
            }
        }
        return num;
    }

    //双指针
    public static int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

}
