package letcode.String;

/**
 * 对于 10 进制转 26 进制的话是一样的道理，只不过每次采用模 26 和除以 26。
 * <p>
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * <p>
 * 输入: 28
 * 输出: "AB"
 * <p>
 * 输入: 701
 * 输出: "ZY"
 */
public class ConvertToTitle {
    public static String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n = n - 1;
            // 获得当前数字对应的字符 并加入到 StringBuffer中
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
