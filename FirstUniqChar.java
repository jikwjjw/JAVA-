https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/submissions/
package letcode;

/**
 * 第一个只出现一次的字符
 */
public class FirstUniqChar {
    /**
     * @param s ="abaccdeff"
     * @return b
     * <p>
     * ASIIC字符编码记录
     */
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        int[] target = new int[26];
        for (int i = 0; i < s.length(); i++) {
            target[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (target[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }
        return ' ';
    }
}
