import java.util.Arrays;

/**
 * 2007. 从双倍数组中还原原数组
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
 * 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回
 */
public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[]{};
        }
        Arrays.sort(changed);
        // 标记元素是否被访问过
        boolean[] flags = new boolean[changed.length];
        int[] ans = new int[changed.length / 2];
        int indexOfOriginal = 0;
        int indexOfDouble = 1;
        outer:
        for (int i = 0; i < changed.length; i++) {
            if (flags[i]) {continue;}
            for (int j = indexOfDouble; j < changed.length; j++) {
                if (i == j) {continue;}
                if (changed[i] << 1 == changed[j]) {
                    flags[i] = true;
                    flags[j] = true;
                    ans[indexOfOriginal] = changed[i];
                    indexOfOriginal++;
                    indexOfDouble = j + 1;
                    continue outer;
                }
            }
            return new int[]{};
        }
        return ans;
    }

    public static void main(String[] args) {
        FindOriginalArrayFromDoubledArray findOriginalArrayFromDoubledArray = new FindOriginalArrayFromDoubledArray();
        int[] originalArray = findOriginalArrayFromDoubledArray.findOriginalArray(new int[]{0, 0, 0, 0});
        System.out.println(originalArray);
    }
}
