package niuke;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: lwj
 * Date: 2021/7/1
 * Time: 10:35
 * Description: 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 *      set(key, value)：将记录(key, value)插入该结构
 *      get(key)：返回key对应的value值
 *      [要求]
 *      set和get方法的时间复杂度为O(1)
 *      某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 *      当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 *      若opt=1，接下来两个整数x, y，表示set(x, y)
 *      若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 *      对于每个操作2，输出一个答案
 *
 *
 *     输入：
 * 		[[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
 * 	   返回值：
 * 		[1,-1]
 * 	   说明：
 * 		第一次操作后：最常使用的记录为("1", 1)
 * 		第二次操作后：最常使用的记录为("2", 2)，("1", 1)变为最不常用的
 * 		第三次操作后：最常使用的记录为("3", 2)，("1", 1)还是最不常用的
 * 		第四次操作后：最常用的记录为("1", 1)，("2", 2)变为最不常用的
 * 		第五次操作后：大小超过了3，所以移除此时最不常使用的记录("2", 2)，加入记录("4", 4)，并且为最常使用的记录，然后("3", 2)变为最不常使用的记录
 */
public class SolutionNC093 {

    public static void main(String[] args) {
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int k = 3;
        int[] res = LRU(operators, k);

    }

    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public static int[] LRU(int[][] operators, int k) {
        // write code here
        // 计算get操作的次数
        int len = (int) Stream.of(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[len];
        int j = 0;
        // LinkedHashMap的put操作是顺序的
        Map<Integer, Integer> map = new LinkedHashMap<>();
        // 循环遍历operators
        for (int[] operator : operators){
            // 获取对应的key
            int key = operator[1];
            // 1-set 2-get
            switch (operator[0]){
                case 1:
                    // set的value
                    int value = operator[2];
                    // 没超过大小
                    if (map.size() < k){
                        map.put(key, value);
                    }else {
                        // 超过大小，将最开始set的移除
                        Iterator<Integer> it = map.keySet().iterator();
                        map.remove(it.next());
                        map.put(key, value);
                    }
                    break;
                case 2:
                    if (map.containsKey(key)){
                        int value1 = map.get(key);
                        res[j] = value1;
                        j++;
                        // 将这个key标记为最常使用
                        map.remove(key);
                        map.put(key, value1);
                    }else {
                        res[j] = -1;
                        j++;
                    }
                    break;
                default:
            }
        }
        return res;
    }

}
