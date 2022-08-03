package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2022/8/3
 * Time: 10:35
 * Description:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */
public class Solution0035 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 5));;
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        int length = nums.length;
        int l = 0, r = length - 1;
        int re = length;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] >= target){
                re = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return re;
    }
}
