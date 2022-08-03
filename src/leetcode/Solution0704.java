package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2022/8/2
 * Time: 17:07
 * Description:
 * 给定一个个元素有序的（升序）整型数组nums 和一个目标值target，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 * 	输入: nums = [-1,0,3,5,9,12], target = 9
 * 	输出: 4
 * 	解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例 2:
 * 	输入: nums = [-1,0,3,5,9,12], target = 2
 * 	输出: -1
 * 	解释: 2 不存在 nums 中因此返回 -1
 */
public class Solution0704 {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        search(nums, 9);
    }

    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return  -1;
        }
        int length = nums.length;
        if (length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
