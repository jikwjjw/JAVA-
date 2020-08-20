package letcode.String;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    /**
     * 倒序遍历字符串 ss ，记录单词左右索引边界 ii , jj ；
     * 每确定一个单词的边界，则将其添加至单词列表 resres ；
     * 最终，将单词列表拼接为字符串，并返回即可。
     *
     * @param s
     * @return
     */
    public static String reverseWords1(String s) {
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;//搜索首个单词
            res.append(s.substring(i + 1, j + 1) + " "); //添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--; //跳过单词之间空格
            j = i;
        }
        return res.toString().trim();
    }


    public static void main(String[] args) {
        System.out.println(reverseWords1("the sky is blue"));
    }
}
