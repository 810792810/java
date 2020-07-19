package leetcode;

/**
 * @Author: xc
 * @Date: 2020/7/19
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 考虑 0的情况
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class No238 {
    public static void main(String[] args) {
        int [] nums = {2,3,5,0};
        //输出[0,0,0,30]
//        int [] nums = {1, 2, 3, 4};
        int[] output = productExceptSelf(nums);
        for (int i : output){
            System.out.print(i +", ");
        }
    }
    // left左边开始累积，  right右边开始累积
    public static int[] productExceptSelf(int[] nums) {
        int output[] = new int[nums.length] ;
        for (int i =0;i<nums.length;i++){
            output[i] = 1;
        }
        int left =1;
        int right =1;
        for (int i = 0; i <= nums.length-1 ; i++){
            if (i>0){
                left *= nums[i-1];
            }
            output[i] *=left;

            if (nums[nums.length-1-i]!=0 && output[nums.length-1-i] ==0){
                output[nums.length-1-i]  =1 ;
            }
            if (i>0){
                right *=  nums[nums.length-i];
            }
            output[nums.length-i-1] *= right;
        }
        return output;
    }
}
