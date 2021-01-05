import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

public class RingQueue<T> {
    private static final int DEFAULT_SIZE = 2; 
    private int bufferSize;
    private Object[] buffer;
    private int front;
    private int rear;
    private int size;

    /** */
    public RingQueue() {
        this(DEFAULT_SIZE);
    }

    /**
     * 
     * @param bufferSize 最大缓冲长度
     */
    public RingQueue(int bufferSize) {
        this(bufferSize, false);
    }

        /**
     * 
     * @param bufferSize 最大缓冲长度
     */
    private RingQueue(int bufferSize, boolean fair) {
        if (bufferSize <= 0)
            throw new IllegalArgumentException();
        setBufferSize(bufferSize);
        buffer = new Object[bufferSize + 1];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    /**
     * 
     * @return 所有缓冲全空 true，否则 false
     */
    public synchronized boolean isEmpty() {
        return front == rear;
    }

    /**
     * 
     * @return 所有缓冲全满 true, 否则 false
     */
    public synchronized boolean isFull() {
        return (rear + 1) % bufferSize == front;
    }

    /**
     * 末尾添加
     * @param item
     */
    public synchronized boolean offer(T item) {
        if (isFull()) {
            return false;        
        }
        buffer[rear] = item;
        rear = (rear + 1) % bufferSize;
        size++;
        return true;
    }

    /**
     * 末尾添加
     * @param item
     */
    public synchronized boolean add(T item) {
        if (offer(item))
            return true;
        else
            throw new IllegalStateException("Queue full");
    }

    /**
     * 
     * @return remove and return the first element, null when the list is empty
     */
    public synchronized T poll() {
        if (isEmpty()) {
            return null;
        }
        T result = (T) buffer[front];
        front = (front + 1) % bufferSize;
        size--;
        return result;
    }

    /**
     * 
     * @return remove and return the first element, null when the list is empty
     */
    public synchronized T remove() {
        T x = poll();
        if (x != null)
            return x;
        else
            throw new NoSuchElementException();
    }

    /**
     * return the first element, null when the list is empty
     * @return
     */
    public synchronized T peek() {
        if (isEmpty()) {
            return null;
        }
        T result = (T) buffer[front];
        return result; 
    }

    /**
     * return the first element, null when the list is empty
     * @return
     */
    public synchronized T element() {
        T x = peek();
        if (x != null)
            return x;
        else
            throw new NoSuchElementException();
    }

    /**
     * 
     * @param c
     * @return
     */
    public synchronized boolean addAll(Collection<? extends T> c) {
        if (c == null)
            throw new NullPointerException();
        if (c == this)
            throw new IllegalArgumentException();
        boolean modified = false;
        for (T e : c)
            if (add(e))
                modified = true;
        return modified;
    }

    public boolean offerAll(Collection<? extends T> c) {
        if (c == null)
            return false;
        if (c == this)
            return false;
        boolean modified = false;
        for (T e : c)
            if (offer(e))
                modified = true;
        return modified;
    }

    /**
     * 
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 
     * @return maxSize
     */
    private int getBufferSize() {
        return this.bufferSize - 1;
    }

    /**
     * set bufferSize
     * @param bufferSize
     */
    private void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize + 1;
    }

    /**clear all */
    public synchronized void clear() {
        Arrays.fill(buffer, null);
        this.front = 0;
        this.rear = 0;
    }
    
}