package letcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Partition {
    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        int len = s.length();
        Deque<String> path = new ArrayDeque<>();
        dfs(s, 0, len, path, res);
        return res;
    }

    private static void dfs(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (!checkPalindrome(s, start, i)) {
                continue;
            }
            path.add(s.substring(start, i + 1));
            dfs(s, i + 1, len, path, res);
            path.removeLast();
        }
    }

    private static boolean checkPalindrome(String s, int start, int len) {
        if (start > len) return false;
        while (start < len) {
            if (s.charAt(start) != s.charAt(len)) {
                return false;
            }
            start++;
            len--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aaa"));
    }
}
