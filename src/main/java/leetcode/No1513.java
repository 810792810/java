package leetcode;

/**
 * @Author: xc
 * @Date: 2020/7/19
 *
 * 1513. 仅含 1 的子串数
 * 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
 * 返回所有字符都为 1 的子字符串的数目。
 * 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 *
 * 示例：
 * 输入：s = "0110111"
 * 输出：9
 * 解释：共有 9 个子字符串仅由 '1' 组成
 * "1" -> 5 次
 * "11" -> 3 次
 * "111" -> 1 次
 */
public class No1513 {
    public static void main(String[] args) {
        String s= "0110111";
        int sum = numSub(s);
        System.out.println(sum);
    }
    static public int numSub(String s) {
        final int MODULO = 1000000007;
        long sum =0;
        long t = 0;
        int size = s.length();
        for (int i =0; i< size; i++){
            if ('1' == s.charAt(i)){
                t++;
                sum +=t;
            }else{
                t=0;
            }
        }
        return  (int)(sum%MODULO);
    }

}
