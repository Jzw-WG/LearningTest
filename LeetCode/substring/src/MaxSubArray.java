import java.util.Scanner;

public class MaxSubArray {
    public static int maxFromStart = 0;
    public static int valueFromStart = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int n = Integer.valueOf(strings[0]);
        int m = Integer.valueOf(strings[1]);
        strings = sc.nextLine().split(" ");
        int[] nums = new int[n];
        int sumOfGroup = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.valueOf(strings[i]);
            sumOfGroup += num;
            nums[i] = num;
        }
        int[] mNums = new int[n*m];
        for (int i = 0; i < m; i++) {
            System.arraycopy(nums, 0, mNums, i*n, nums.length);
        }
        int res = getMaxSubArray(mNums);

        
        // int tmp = sumOfGroup * (m - 1);
        // if (tmp > maxFromStart) {
        //     res = tmp > 0 ? tmp + res : res;
        // } else {
        //     res = maxFromStart > 0 ? maxFromStart + res : res;
        // }
        System.out.println(res);
    }

    public static int getMaxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
            valueFromStart += nums[i - 1];
            maxFromStart = Math.max(maxFromStart, valueFromStart);

        }
        return res;
    }
}
