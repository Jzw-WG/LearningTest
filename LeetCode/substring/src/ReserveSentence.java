import org.graalvm.compiler.nodes.calc.RightShiftNode;

public class ReserveSentence {

    public void reserveSentence(char[] str) {
        int left = 0;
        int right = str.length - 1;
        reserveString(str, left, right);
        int lastSpace = -1;
        for (int i = 0; i < str.length; i++) {
            
            if (str[i] == ' ') {
                reserveString(str, lastSpace + 1, i - 1);
                lastSpace = i;
            }
        }
        reserveString(str, lastSpace + 1, str.length - 1);

        
    }

    public void reserveString(char[] str, int left, int right) {

        for (int i = 0; i < (right - left + 1)/2; i++) {
            char a = str[left + i];
            str[left + i] = str[right - i];
            str[right - i] = a;
        }
        // while (left < right) {
        //     char a = str[left];
        //     str[left] = str[right];
        //     str[right] = a;
        //     left++;
        //     right--;
        // }
    }
    
    public static void main(String[] args) {
        char[] str = new String("the sky is blue").toCharArray();
        ReserveSentence a = new ReserveSentence();
        a.reserveSentence(str);
        System.out.println(str);
    }
    
}