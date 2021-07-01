package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 */
public class Solution0018 {

    public static void main(String[] args) {
        int[] nums = {2,0,-1,1};
        List<List<Integer>> list = fourSum(nums, 2);
        for (List<Integer> list1 : list){
            for (int i : list1){
                System.out.print(i);
            }
        }
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4){
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++){
            // 与上一个元素相同则跳过
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // 最小的四个数相加大于target，则没有满足条件的，跳出循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                break;
            }
            // 在确定第一个数之后，如果 nums[i]+nums[n-3]+nums[n-2]+nums[n-1]<target，说明此时剩下的三个数无论取什么值，四数之和一定小于target，
            // 因此第一重循环直接进入下一轮，枚举nums[i+1]nums[i+1]；
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                // 确认前两个数后
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target){
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target){
                    continue;
                }
                // 左指针
                int left = j + 1;
                // 又指针
                int right = length - 1;
                //如果和等于target，则将枚举到的四个数加到答案中，然后将左指针右移直到遇到不同的数，将右指针左移直到遇到不同的数；
                //如果和小于target，则将左指针右移一位；如果和大于target，则将右指针左移一位。
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }else if (sum < target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}
