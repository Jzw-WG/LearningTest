import java.util.Arrays;
import java.util.HashSet;

/**
 * 题目描述
小多有 N 个空纸箱，每个纸箱是一个边长为 Ai 的正方体。第 i 个纸箱可以装进第 j 个纸箱里当且仅当以下3个条件同时满足：
1. 纸箱 j 中没有装其他纸箱
2. 纸箱 i 没有被装到其他纸箱中
3. 纸箱 i 的边长小于纸箱 j，即 Ai < Aj。
现在小多希望将一些纸箱装进其他纸箱中，使得肉眼可见的纸箱个数最少(被装到纸箱里的纸箱肉眼不可见)。
 */
public class Box {

    public int minBox(int[] As, int count) {
        Arrays.sort(As);
        if (As[As.length - 1] == 0) {
            return count;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<As.length;i++) {
            if (As[i] != 0 && set.add(As[i])) {
                As[i] = 0;
            }
        }
        return minBox(As, count + 1);
    }

    public static void main(String[] args) {
        int[] As = {1,1,1,1,1,1,5};
        Box b = new Box();
        System.out.println(b.minBox(As, 0));
        return;
    }
}