public class MSteps {
    // private int last = -1;
    // private int lastlast = -2;
    int mSteps(int n, int m) {

        return count(n, m, -1, -2, -3);
    }

    int count(int n, int m, int last, int lastlast,int lastlastlast) {
        int count = 0;
        if (n == 0 && last != lastlast && last != lastlastlast && lastlast != lastlastlast) {
            return 1;
        }
        if (n >= m) {
            for (int i = 1; i <= m; i++) {
                if (last != lastlast && last != i && lastlast != i) {
                    // lastlast = last;
                    // last = i;
                    count += count(n - i, m, i, last, lastlast);
                }
                
            }
        } else {
            count = count(n, n, last, lastlast, lastlastlast);
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        MSteps l = new MSteps();
        int a = l.mSteps(n, m);
        System.out.println(a);
    }
}
