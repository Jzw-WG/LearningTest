public class FirstBadVersion {
    boolean isBadVersion(int version) {
        if (version >= 1702766719) {
            return true;
        } else {
            return false;
        }       
    }

    public int firstBadVersion(int n) {
        return getk(1, n);
    }

    public int getk(long l, long r) {
        long k = (l + r)/2;
        if (l == r) {
            return (int) k;
        } 
        if (l + 1 == r) {
            return (int) (isBadVersion((int) k)?l:r);
        } else if (!isBadVersion((int) k)) {
            {return getk(k, r);}
        } else {
            {return getk(l, k);}
        }  
    }

    public static void main(String[] args) {
        int n = 2126753390;
        FirstBadVersion l = new FirstBadVersion();
        int a = l.firstBadVersion(n);
        System.out.println(a);
    }
}