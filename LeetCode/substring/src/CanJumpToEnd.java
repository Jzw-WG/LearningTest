/**LeetCode 55 */
public class CanJumpToEnd {
    public boolean canJump(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int maxIndex = i;
            int next = i;
            if (maxIndex >= nums.length - 1) {
                return true;
            }
            if (nums[maxIndex] == 0) {               
                return false;
            }
            int end = i + nums[i] >= nums.length ? nums.length - 1 : i + nums[i];
            int j = i;
            while (j <= end) {
                if (maxIndex <= j + nums[j]) {
                    maxIndex = j + nums[j];
                    next = j;
                }
                j++;
            }
            if (maxIndex >= nums.length - 1) {
                return true;
            }
            // if (nums[maxIndex] == 0) {               
            //     return false;
            // }
            i = next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        CanJumpToEnd l = new CanJumpToEnd();
        boolean t = l.canJump(nums);
        System.out.println(t);
    }
}