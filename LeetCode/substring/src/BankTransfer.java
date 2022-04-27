import java.util.Map;

public class BankTransfer {
    private int count = 0;
    BankTransfer(int count) {
        this.count = count;
    }

    public synchronized int getCount() {
        return count;
    }

    public synchronized void setCount(int count) {
        this.count = count;
    }

    class Test implements Runnable {
        private int count = 0;
        private BankTransfer bank = new BankTransfer(0);
        Test(int count) {
            this.count = count;
        }
        @Override
        public void run() {
            bank.setCount(count);
        } 
    }

    public static void main(String[] args) {
        
    }
}