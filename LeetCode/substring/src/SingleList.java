public class SingleList {
    Node head;
    int size;

    class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            ....
        }

        Node() {
            value = 0;
            next = null;
        }

        
    }

    SingleList() {
        size = 0;
    }


    public void addLast(int value) {
        Node last = getLast();
        Node node = new Node(int value);
        last.next = node;
        node.next = null;
        size++;
    }

    public void insert(int value, int index) {
        Node cur = getCur(index);
        Node node = new Node(int value);
        Node curNext = cur.next;
        cur.next = node;
        node.next = curNext;
        size++;
    }

    public int removeLast() {

    }
}

// class SingleInstance {
//     private static SingleInstance instance = new SingleInstance();
//     private SingleInstance() {}
//     public static SingleInstance getInstance() {
//         return instance;
//     }
// }

class SingleInstance {
    private volatile SingleInstance instance = null;
    private SingleInstance() {};
    public SingleInstance getInstance() {
        if (instance == null) {
            synchronized(SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }
}