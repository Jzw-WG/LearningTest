import java.util.HashMap;

public class IntegerLRU {
    private int capacity;
    private Node head = new Node(-1,0);
    private Node tail = new Node(-1,0);;
    private HashMap<Integer, Node> map;

    private class Node {
        Node pre;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public IntegerLRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap(capacity * 4 / 3);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        addFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addFirst(node);
        if (map.size() > capacity) {
            map.remove(removeLast().key);
        }
    }

    public void addFirst(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.pre = node;
        node.pre = head;
    }

    public void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.next = null;
        node.pre = null;
    }

    public Node removeLast() {
        Node last = tail.pre;
        remove(last);
        return last;
    }

    public static void main(String[] args) {
        IntegerLRU lru = new IntegerLRU(2);
        lru.put(1, 1); // 缓存是 {1=1}
        lru.put(2, 2); // 缓存是 {1=1, 2=2}
        lru.get(1);    // 返回 1
        lru.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lru.get(2);    // 返回 -1 (未找到)
        lru.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lru.get(1);    // 返回 -1 (未找到)
        lru.get(3);    // 返回 3
        lru.get(4);    // 返回 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */