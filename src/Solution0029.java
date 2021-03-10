/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2021/3/10
 * Time: 下午2:53
 * Description:
 * 	给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 	返回被除数 dividend 除以除数 divisor 得到的商。
 * 	整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 	示例 1:
 * 		输入: dividend = 10, divisor = 3
 * 		输出: 3
 * 		解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 * 	示例 2:
 * 		输入: dividend = 7, divisor = -3
 * 		输出: -2
 * 		解释: 7/-3 = truncate(-2.33333..) = -2
 *
 * 	提示：
 * 		被除数和除数均为 32 位有符号整数。
 * 		除数不为 0。
 * 		假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 */
public class Solution0029 {

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println(divide2(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? false : true;  // 是否为负数  true:负数   false:正数
        int res = 0;

        // 边界情况
        if(dividend == Integer.MAX_VALUE && divisor == 1) return dividend;
        if(dividend == Integer.MAX_VALUE && divisor == -1) return -dividend;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return -dividend;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = Math.abs((long) dividend), b = Math.abs((long) divisor);
        while (a >= b){
            res++;
            a -= b;
        }
        return flag ? -res : res;
    }

    /**
     * 通过位移的方式
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide2(int dividend, int divisor) {
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? false : true;  // 是否为负数  true:负数   false:正数
        int res = 0;

        // 边界情况
        if(dividend == Integer.MAX_VALUE && divisor == 1) return dividend;
        if(dividend == Integer.MAX_VALUE && divisor == -1) return -dividend;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return -dividend;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = Math.abs((long) dividend), b = Math.abs((long) divisor);

        int i = 0;
        long temp = b;
        while (a >= b){
            //左移，相当于b*2
            b = b << 1;
            //a<b情况说明到达临界点了
            if(a < b){
                //计算result的值 2 << (i - 1)等价与Math.pow(2,i),如果是i=0的情况说明Math.pow(2,0)就是1
                res = res + (i > 0 ? 2 << (i - 1) : 1);
                //获取差值
                a = a - (b >> 1);
                //重新开始计算
                b = temp;
                i = 0;
            }else{
                //累计乘2的次数
                i++;
            }
        }
        return flag ? -res : res;
    }

}

