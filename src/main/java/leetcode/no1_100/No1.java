package leetcode.no1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xc
 * @Date: 2020/10/20
 * 1.两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 思路:遍历数组判断target-nums[i],有数据就说明成功返回数组,无匹配就将将nums[i]值记录到hashMap中<nums[i],i>
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 **/
public class No1 {
    public static void main(String[] args) {
        int[] nums = new int[] {-3,4,3,90};
        int[] ints = twoSum(nums, 0);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
