import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class DivideWeight {
    /**另一道题 */
    public int[] devideWeight(int n, int[] weights, int[] order) {
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            
        }

        return null;
    }

    // public int[] maxWeight(int[] weights, int k, int left, int right) {
    //     if (k < left || k > right) {

    //     }
    // }

    public int maxInterest(int n, int[] A, int right) {
        int result = 0;
        if (right < 0) {
            return 0;
        } else {
            int newRight;
            if (n >= A[right]) {
                newRight = right - A[right];
                result = result + 1 + A[right] + maxInterest(newRight + 1, A, newRight);
            } else {
                newRight = right - 1;
                result = result + 1 + maxInterest(n - 1, A, newRight);
            }
        }        
        return result;
    }

    /** n个员工分组 A[i]为每个员工所在的组人数至少为多少能提供一点收益 每个小组都有一点基础收益 怎么分组收益最大 */
    public int max(int n, int[] A) {
        Arrays.sort(A);
        return maxInterest(n, A, A.length - 1);
        
    }

    public static void main(String[] args) {
        int[] weights = {3,2,4,4,5};
        int[] order = {4,3,5,2,1};
        int n = 5;
        int[] A = {1,3,3,3,3};
        DivideWeight l = new DivideWeight();
        int t = l.max(n, A);
        int[] a = l.devideWeight(5, weights, order);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + '\n');
        }
    }
}