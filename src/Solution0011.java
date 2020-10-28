/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 */
public class Solution0011 {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea1(height));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++){
            for (int j = 1 + i; j < height.length; j++) {
                int x = Math.min(height[i],height[j]);
                int area = x * (j - i);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    /**
     * 通过双指针的方式，将两个指针放置两端，然后移动值较小一边的指针
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r){
            int area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(area,max);
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }

}
