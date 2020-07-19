package leetcode;

/**
 * @Author: xc
 * @Date: 2020/7/19
 * 693. 交替位二进制数
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 *
 * 示例 2:
 *
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 */
public class No693 {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(7));
    }
    public static boolean hasAlternatingBits(int n) {
        int m =2;
        for(;n>0;){
            if (m == n%2){
                return false;
            }
            m =n%2;
            n = n/2;
        }
        return true;
    }
}
