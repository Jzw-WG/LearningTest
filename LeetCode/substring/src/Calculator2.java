import java.util.Stack;

/** LeetCode 227 */
public class Calculator2 {
    public int calculate(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '*') {
                ops.push('*');
                i++;
            } else if (s.charAt(i) == '/') {
                ops.push('/');
                i++;
            } else if (s.charAt(i) == '+') {
                ops.push('+');
                i++;
            } else if (s.charAt(i) == '-') {
                ops.push('-');
                i++;
            } else {
                int num = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num*10 + s.charAt(i) - '0';
                    i++;
                }
                if (ops.isEmpty()) {
                    nums.push(num);
                    continue;
                }
                if (ops.peek() == '*' || ops.peek() == '/') {
                    if (ops.pop() == '*') {
                        nums.push(nums.pop() * num);
                    } else {
                        nums.push(nums.pop() / num);
                    }
                } else if (ops.peek() == '+' || ops.peek() == '-') {
                    if (ops.pop() == '+') {
                        nums.push(num);
                    } else {
                        nums.push(-num);
                    }
                }
            }
        }
        int sum = 0;
        while(!nums.isEmpty()) {
            sum += nums.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        String str = "1+32*4/2+1";
        Calculator2 c = new Calculator2();
        int t = c.calculate(str);
        System.out.println(t);
    }
}