package leetcode;

import java.util.Map;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 */
public class Solution0004 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,5,7};
        int[] mums2 = new int[]{3,4,8,11,12};
        System.out.println(5 / 2.0);
        System.out.println(findMedianSortedArrays(nums1,mums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        //保证分割线左边的元素如果为偶数则与右边元素个数相等，为基数则比右边元素多一个 m+(n-m+1)/2
        int totalLeft = m + (n - m + 1) / 2;

        //使用二分查找法
        int left = 0;
        int right = m;
        while (right > left){
            int i = (right + left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]){
                right = i - 1;
            }else{
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - i;
        int nums1left = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1right = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2right = j == n ? Integer.MAX_VALUE : nums2[j];
        if ((m + n) % 2 == 1) {
            return Math.max(nums1left,nums2left);
        }else {
            int a = Math.max(nums1left,nums2left) + Math.min(nums1right, nums2right);
            return a / 2.0;
        }
    }

}
