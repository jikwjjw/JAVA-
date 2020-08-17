package letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 */
public class Subsets {

    static List<List<Integer>> res = new ArrayList<>();

    /**
     *
     * @param nums 输入: [1,2,2]
 
     * @return 输出:
     * [
     *   [2],
     *   [1],
     *   [1,2,2],
     *   [2,2],
     *   [1,2],
     *   []
     * ]
     */
    public static List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return res;
        }
        Arrays.sort(nums);
        Stack<Integer> path = new Stack<>();
        dfs(nums, path, 0);
        return res;
    }

    private static void dfs(int[] nums, Stack path, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(Subsets.subsets(nums));
    }
}
