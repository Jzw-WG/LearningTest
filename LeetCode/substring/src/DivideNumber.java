public class DivideNumber {
    
    public int maxDivide(int num) {
        int a = num/2;
        int b = num - a;
        int c = 0;
        int MidOffset = 0;
        int CCount = 0;
        boolean flag = true;
        while (flag) {
            if (a % 10 == 9 || b % 10 == 9) {
                flag = false;
                break;
            }
            while (a != 0 || b != 0) {
                if (a % 10 + b % 10 + c >= 10) {
                    c = 1;
                    CCount++;
                    if (a > 10) {
                    a /= 10; 
                    } else {
                        a = 0;
                    }
                    if (b > 10) {
                        b /= 10;
                    } else {
                        b = 0;
                    }
                } else {
                    c = 0;
                    if (CCount == numOfANum(num) - 1) {
                        flag = false;
                    }
                    CCount = 0;
                    a = num/2 - MidOffset;
                    b = num - a;
                    break;
                }                               
            }
            MidOffset++;
            if (CCount == numOfANum(num) - 1) {
                flag = false;
            }
            
        }
        return sumOfNums(num/2 - MidOffset) + sumOfNums(num - (num/2 - MidOffset));
    }

    public int sumOfNums(int num) {
        int sum = 0;
        while (num >= 10) {
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        return sum;
    }

    public int numOfANum(int num) {
        int sum = 0;
        while (num >= 10) {
            num /= 10;
            sum += 1;
        }
        sum += 1;
        return sum;
    }
    
    public static void main(String[] args) {
        int num = 1232;
        DivideNumber l = new DivideNumber();
        int t = l.maxDivide(num);
        System.out.println(t);
    }
}

