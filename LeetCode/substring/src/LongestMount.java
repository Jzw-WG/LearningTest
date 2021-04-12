public class LongestMount {
    public int longestMount(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int max = 0;
        int i = 1;
        while (i < n) {
            if (nums[i - 1] >= nums[i]) {
                i++;
                continue;
            }
            int upBegin = i - 1;
            while (i < n && nums[i - 1] < nums[i]) {
                i++;
            }
            int upEnd = i - 1;
            int downBegin = i - 1;
            while (i < n && nums[i - 1] > nums[i]) {
                i++;
            }
            int downEnd = i - 1;
            if (upBegin < upEnd && downBegin < downEnd) {
                max = Math.max(max, downEnd - upBegin + 1);
                continue;
            }
            i++;
        }
        
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,1};
        LongestMount l = new LongestMount();
        int a = l.longestMount(nums);
        System.out.println(a);
    }
}