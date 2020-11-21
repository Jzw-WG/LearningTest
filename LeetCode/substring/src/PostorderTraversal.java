import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// class PostoderTraversal {
//     List<Integer> resultList = new ArrayList<>();
//     public List<Integer> postorderTraversal(TreeNode root) {
//         dfs(root);
//         return resultList;
//     }

//     public void dfs(TreeNode root) {
//         if (root == null) {
//             return;
//         }

//         dfs(root.left);
//         dfs(root.right);
//         resultList.add(root.val);
//     }
// }
class PostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> res = new ArrayList();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
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

        List<Integer> res = new ArrayList<>(); 
        PostorderTraversal l = new PostorderTraversal();
        res = l.postorderTraversal(t2);
        System.out.println(res);
    }
}