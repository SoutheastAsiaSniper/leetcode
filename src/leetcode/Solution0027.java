package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2021/3/9
 * Time: 上午10:47
 * Description:
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *  
 * 示例 1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 *
 * 示例 2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution0027 {

    public static void main(String[] args) {
        int[] nums = {1,1};
        int val = 1;
        int i = removeElement(nums, val);
        System.out.println(i);
        for(int n : nums){
            System.out.print(n + ",");
        }
    }

    // 方法一
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int pre = 0;
        int length = nums.length;
        int end = nums.length - 1;
        if (length == 1 && nums[end] == val){
            return 0;
        }
        while (pre < end) {
            // 如果end指向的值等于val，则end向前移，保证end指向的值不等于val
            while (end >= 0 && nums[end] == val){
                i++;
                end--;
            }
            // 如果相等，将值与end指向的值调换，end向前移
            if (nums[pre] == val && end > 0){
                i++;
                nums[pre] = nums[end];
                nums[end] = val;
                end--;
                // 判断end向前移之后指向值值是否等于val，如果等于，则end继续向前移
                while (end >= 0 && nums[end] == val){
                    i++;
                    end--;
                }
            }
            pre++;
        }
        return length - i;
    }

    // 方法二
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // 遍历nums，如果碰到与val相等的值就跳过
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
