public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return getk(nums, 0, nums.length - 1, target);
    }

    public int getk(int[] nums, int start, int end, int target) {
        if (end < start) {
            return -1;
        }
        int k = (start + end)/2;
        if (nums[k] == target) {
            return k;
        }
        if (k == start) {
            return (nums[start] == target)?nums[start]:getk(nums, k + 1, end, target);
        }
        if (start == end) {
            return (nums[start] == target)?nums[start]:-1;
        }
        if (nums[start] < nums[end]) {
            if (nums[k] < target) {
                return getk(nums, k + 1, end, target);
            } else {
                return getk(nums, start, k - 1, target);
            }
        } else if ((nums[k] <= target && target >= nums[start] && nums[k] < nums[start]) || (nums[k] >= target && target >= nums[start]) || (nums[k] >= target && target <= nums[start]) && nums[k] < nums[start]) {
            return getk(nums, start, k, target);
        } else if ((nums[k] <= target && target >= nums[start] && nums[k] > nums[start]) || (nums[k] <= target && target <= nums[start]) || (nums[k] >= target && target <= nums[start]) && nums[k] > nums[start]) {
            return getk(nums, k, end, target);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        SearchRotatedArray l = new SearchRotatedArray();
        int a = l.search(nums, 1);
        System.out.println(a);
    }
}