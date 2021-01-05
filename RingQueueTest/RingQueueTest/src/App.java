import org.junit.Test;
import org.junit.Assert;
import net.sourceforge.groboutils.*;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    @Test
    public void testOffer() {
        RingQueue<Integer> r = new RingQueue<>(10);
        Assert.assertTrue(r.offer(1));
        Assert.assertEquals(1, r.size());
        Assert.assertTrue(r.offer(2));
        Assert.assertEquals(2, r.size());
    }

    @Test
    public void testPoll() {
        RingQueue<Integer> r = new RingQueue<>(10);
        Assert.assertEquals(null, r.poll());
        Assert.assertEquals(0, r.size());
        Assert.assertTrue(r.offer(1));
        Assert.assertTrue(r.offer(2));
        Assert.assertEquals(Integer.valueOf(1), r.poll());
        Assert.assertEquals(1, r.size());
    }

    @Test
    public void testPeek() {
        RingQueue<Integer> r = new RingQueue<>(10);
        Assert.assertEquals(null, r.peek());
        Assert.assertEquals(0, r.size());
        Assert.assertTrue(r.offer(1));
        Assert.assertTrue(r.offer(2));
        Assert.assertEquals(Integer.valueOf(1), r.peek());
        Assert.assertEquals(2, r.size());
    }

    @Test
    public void testIsEmpty() {
        RingQueue<Integer> r = new RingQueue<>(10);
        Assert.assertTrue(r.isEmpty());
        Assert.assertTrue(r.offer(1));
        Assert.assertFalse(r.isEmpty());
    }

    @Test
    public void testIsFull() {
        RingQueue<Integer> r = new RingQueue<>(3);
        Assert.assertFalse(r.isFull());
        Assert.assertTrue(r.offer(1));
        Assert.assertFalse(r.isFull());
        Assert.assertTrue(r.offer(1));
        Assert.assertTrue(r.offer(1));
        Assert.assertTrue(r.isFull());
    }

    // @Test
    // public void testThreadJunit() {
    //     try {
    //         final int THREAD_COUNT = 2;
    //         // Runner数组，相当于并发多少个
    //         TestRunnable[] trs = new TestRunnable[THREAD_COUNT];
    //         for (int i = 0; i < THREAD_COUNT; i++) {
    //             trs[i] = new TestRunnable() {
    //                 @Override
    //                 public void runTest() throws Throwable {
    //                     commMethod();
    //                 }
    //             };
    //         }

    //         // 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
    //         MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
    //         // 并发执行数组里定义的内容
    //         mttr.runTestRunnables();
    //     } catch (Throwable e) {
    //         e.printStackTrace();
    //     }
    // }
}
