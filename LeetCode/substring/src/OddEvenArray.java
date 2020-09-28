import java.util.Arrays;

/**An array
 * Odd number left and ascending order
 * Even number right and descending order
 * No extra space
 */

public class OddEvenArray {
    public void oddeven(int[] nums) {
        Arrays.sort(nums);
    }

    public void ord(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,1,2,4,6,8,9,6,5,11,7};
        OddEvenArray o = new OddEvenArray();
        o.oddeven(nums);
        System.out.println(nums);
    }
}
