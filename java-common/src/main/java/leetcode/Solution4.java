package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author yitian
 * @date 2020/6/20 14:51
 */
public class Solution4 {

    public static void main(String[] args) {
        int[] nums = new int[]{11, 2, 7, 15};
        int target = 9;
        int[] s = twoSum3(nums,target);
        System.out.println(s);
    }


    /**
     * 暴力法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int a =0;
        for(int i=0;i<nums.length;i++){
            a = target-nums[i];
            int j= i+1;
            for(;j<nums.length;j++){
                if(a==nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>(nums.length+1);
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int c = target - nums[i];
            if(map.containsKey(c)){
                return new int[]{i,map.get(c)};
            }
        }
        return null;
    }


    public static int[] twoSum3(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>(nums.length+1);
        for(int i=0;i<nums.length;i++){
            int c = target - nums[i];
            if(map.containsKey(c)){
                return new int[]{i,map.get(c)};
            }
            map.put(nums[i],i);
        }
        return null;
    }


}
