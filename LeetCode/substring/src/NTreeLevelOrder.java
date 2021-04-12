import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class NTreeLevelOrder {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < q.size(); i++) {
                Node node = q.poll();
                level.add(node.val);
                int size = node.children.size();
                for (int j = 0; j < size; j++) {
                    if (node.children.get(j) != null) {
                        q.offer(node.children.get(j));
                    }
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        NTreeLevelOrder n = new NTreeLevelOrder();

    }
}