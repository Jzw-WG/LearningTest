import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import sun.security.util.ArrayUtil;

/** LeetCode 501 */
class FindMode {
    Integer max = 0;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap();
        Set<Integer> set = new HashSet();
        dfs(root, set, map);
        Object[] obj = set.toArray();//先讲set集合转为Object对象数组（向上转型）
        int temp[] = new int[obj.length];
        for (int i = 0; i < obj.length; i++) {
            temp[i] = (int) obj[i];//将Object对象数组转为整型数组（强制向下转型）
        }
        return temp;
    }

    public void dfs(TreeNode t, Set<Integer> set, HashMap<Integer, Integer> map) {
        if (t == null) {
            return;
        }
        int v = map.getOrDefault(t.val, 0) + 1;
        map.put(t.val, v);
        if (max < v) {
            set.clear();
            max = new Integer(v);
            set.add(t.val);
        } else if (max == v) {
            set.add(t.val);
        }             
        dfs(t.left, set, map);
        dfs(t.right, set, map);
    }
    
    public static void main(String[] args) {
        int [] num;

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(1);
        // t1.right = new TreeNode(2);
        t1.right = new TreeNode(2);
        FindMode o = new FindMode();
        num = o.findMode(t1);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
        
    }
}