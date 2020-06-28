package leetcode;

import java.util.*;

/**
 * 最小团队
 *
 * @author yitian
 * @date 2020/6/19 21:25
 */
public class Solution {


    public static void main(String[] args) {

        String[] req_skills = new String[3];
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("nodejs");
        list.add("reactjs");
        int i =0;
        for (String s : list){
            req_skills[i]=s;
            i++;
        }


        String[] people = new String[3];
        List<List<String>> listpeople = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("java");
        listpeople.add(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("nodejs");
        listpeople.add(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("nodejs");
        list3.add("reactjs");
        listpeople.add(list3);

        int[] ss = smallestSufficientTeam(req_skills,listpeople);
        System.out.println(ss.toString());
    }

    public static  int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> peoSkills) {
        if (reqSkills == null || reqSkills.length == 0) {
            return new int[0];
        }
        int n = reqSkills.length;
        Map<String, Integer> map = new HashMap<>(n);
        // 技能、序号映射
        for (int i = 0; i < reqSkills.length; i++) {
            map.put(reqSkills[i], i);
        }
        int[] dp = new int[(1 << n)];
        Arrays.fill(dp, -1);
        // 技能集合i所需的最小团队编号列表
        List<List<Integer>> team = new ArrayList<>(1 << n);
        for (int i = 0; i < (1 << n); i++) {
            team.add(new LinkedList<>());
        }
        // 集合0表示的技能的最小花费是0
        dp[0] = 0;
        for (int i = 0; i < peoSkills.size(); i++) {
            int now = 0;
            for (String s : peoSkills.get(i)) {
                int x = map.get(s);
                now |= (1 << x);
            }
            for (int j = 0; j < (1 << n); j++) {
                // 更新已经计算过的集合
                if (dp[j] >= 0) {
                    // 将要更新的集合x
                    int x = now | j;
                    // 如果集合没有计算过或者可以优化
                    if (dp[x] == -1 || dp[x] > dp[j] + 1) {
                        dp[x] = dp[j] + 1;
                        team.get(x).clear();
                        team.get(x).addAll(team.get(j));
                        team.get(x).add(i);
                    }
                }
            }
        }
        // team[(1<<n)-1]即最终团队
        int[] ans = new int[team.get((1 << n) - 1).size()];
        int i = 0;
        for (int idx : team.get((1 << n) - 1)) {
            ans[i++] = idx;
        }
        return ans;
    }

}
