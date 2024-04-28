import java.beans.PropertyEditorManager;

/**
 * 1017. 负二进制转换
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 */
public class ConvertToBase2 {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        int k = 1;
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            if (n % 2 != 0) {
                ans.append(1);
                n -= k;
            }
            else {
                ans.append(0);
            }
            k *= -1;
            n >>= 1;
        }
        return ans.reverse().toString();
    }
}
