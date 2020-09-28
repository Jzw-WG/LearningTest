/**LeetCode 617 */
class MergeTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode t = null;
        if (t1 ==null && t2 ==null) {
            return t;
        }
        t = new TreeNode(0); 
        dfs(t1, t2, t);
        return t;
    }

    public static void dfs(TreeNode t1, TreeNode t2, TreeNode t) {
        boolean is1null = t1 == null;
        boolean is2null = t2 == null;
        if (is1null && is2null) {
            return;
        } else {           
            t.val = (is1null?0:t1.val) + (is2null?0:t2.val);
            if ((!is1null && t1.left != null) || (!is2null && t2.left != null)) {
                t.left = new TreeNode(0);
            }
            if ((!is1null && t1.right != null) || (!is2null && t2.right != null)) {
                t.right = new TreeNode(0);
            }
            dfs(is1null?null:t1.left, is2null?null:t2.left, t.left);
            dfs(is1null?null:t1.right, is2null?null:t2.right, t.right);
        }
    }
    
    public static void main(String[] args) {
        TreeNode t = null;

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.left = null;
        t2.left.right = new TreeNode(4);
        t2.right.left = null;
        t2.right.right = new TreeNode(7);


        MergeTree o = new MergeTree();
        t = o.mergeTrees(t1, t2);
        System.out.println(t);
    }
}