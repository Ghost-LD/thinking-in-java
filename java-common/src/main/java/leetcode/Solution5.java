package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 * @author yitian
 * @date 2020/6/20 16:37
 */
public class Solution5 {


    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            int index = map.getOrDefault(cur, -1);
            if (start <= index) {
                int curMax = i - start;
                max = max > curMax ? max : curMax;
                start = index + 1;
            }
            map.put(cur, i);
        }
        int endMax = s.length() - start;
        max = max > endMax ? max : endMax;
        return max;
    }

    public static Long reverse(Long bi) {
        Long rs = 0L;
        while (bi != 0){
            Long temp = bi %10+ rs*10;
            if((temp-bi%10) != rs){
                return 0L;
            }
            rs = temp;
            bi /=10;
        }
        return rs;
    }
}
